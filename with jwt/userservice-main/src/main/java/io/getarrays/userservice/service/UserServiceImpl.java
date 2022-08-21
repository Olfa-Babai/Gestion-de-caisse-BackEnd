package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.*;
import io.getarrays.userservice.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final GenAgentRepo agentRepo;
    private final UserProfileRepo userPRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            // lahne nlawjou ala les roles 
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
          // lahne naaytou ll methode eli tkharjelna wahadha les roles
            getRolesOfUser(user.getUse_id()).forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
            });
            log.info("authorities are : {} ",authorities);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }
    
    public GenAgent getAgentUser(User u){
    	GenAgent au=new GenAgent();
    	for(GenAgent a : agentRepo.findAll()){
    		if(a.getAdmuser().getUse_id()==u.getUse_id()){
    			au=a;
    		}
    	}
    	if (au.getAge_id()==0){
    		au=null;
    	}
    	return au;
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getFname());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        GenAgent genagent=new GenAgent();
        genagent.setAge_login(user.getUsername());
        genagent.setAge_name(user.getFname()+" "+user.getLname());
        genagent.setAge_pwd(user.getPassword());
        user.setGenagent(genagent);
		genagent.setAdmuser(user);
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public AdmUserProfile addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username);
        //Role role = roleRepo.findByName(roleName);
        boolean test=this.getRolesOfUser(user.getUse_id()).stream().anyMatch(p-> p.getName().toString().equals(roleName));
        System.out.println("test = "+test);
        if(test==false){
        AdmUserProfile up=new AdmUserProfile();
        up.setUser_aff(user);
        Role role=new Role();
        for(Profile pr : Profile.values()){
        	if(pr.toString().equals(roleName)){
        		System.out.println("roleNAME= "+roleName);
        		System.out.println("roleNAME= "+pr);
        		role.setName(pr);
        	}
        }
       role.setPru_label(username);
       up.setProfile_aff(role);
       roleRepo.save(role);
       return this.userPRepo.save(up);
       }
       else return null;
       //
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
    
	@Override
	public User searchUser(String matricule) {
		List<User> all=(List<User>) userRepo.findAll();
		User finalu=new User();
		for(User u : all){
			if(u.getUsername().equals(matricule)){
				finalu=u;
			}
		}
		return finalu;
	}
	
	@Override
	public List<User> sortUsers(String s){
		List<User> list= (List<User>) userRepo.findAll();
		if(s.toLowerCase().equals("af")||s.toLowerCase().equals("fa")){
			return list.stream().sorted(Comparator.comparing(User::getFname))
					.collect(Collectors.toList());
		}
		else if(s.toLowerCase().equals("df")||s.toLowerCase().equals("fd")){
			return list.stream().sorted(Comparator.comparing(User::getFname).reversed())
					.collect(Collectors.toList());
		}
		else if(s.toLowerCase().equals("al")||s.toLowerCase().equals("la")){
			return list.stream().sorted(Comparator.comparing(User::getLname))
					.collect(Collectors.toList());
		}
		else {
			return list.stream().sorted(Comparator.comparing(User::getLname).reversed())
					.collect(Collectors.toList());
		}
	}
	
	@Override
	public User uexists(String login, String pwd) {
		User user=new User();
		System.out.println(" login : "+login+" pwd : "+pwd);
		for(User u : (List<User>) userRepo.findAll()){
			if(u.getUsername().equals(login) && u.getPassword().equals(pwd)){
				user=u;
			}
		}
		return user;
	}
	    	
    @Override
    public void deleteUser(Long id){
    	userRepo.deleteById(id);
    }

    // get les profiles du user
	@Override
	public List<Role> getRolesOfUser(Long id) {
		User user=userRepo.findById(id).get();
		List<Role> roles=new ArrayList<>();
		for(AdmUserProfile usp: userPRepo.findAll()){
			if(usp.getUser_aff().getUsername().equals(user.getUsername())){
				roles.add(usp.getProfile_aff());
			}
		}
		return roles;
	}

	@Override
	public void deleteRole(Long id) {
		this.roleRepo.deleteById(id);		
	}

	@Override
	public User updateUser(Long id, User userU) {
		User u=userRepo.findById(id).get();
		if(!u.equals(null)){
			u.setUse_matricule(userU.getUse_matricule());
			u.setFname(userU.getFname());
			u.setLname(userU.getLname());
			u.setUsername(userU.getUsername());
			u.setPassword(userU.getPassword());
			u.setUse_nbessai(userU.getUse_nbessai());
			u.setUse_type(userU.getUse_type());
		}
		GenAgent genagent=this.getAgentUser(u);
		if(!genagent.equals(null)){
		genagent.setAge_login(u.getUsername());
        genagent.setAge_name(u.getFname()+" "+u.getLname());
        genagent.setAge_pwd(u.getPassword());
		}
		return userRepo.save(u);
	}

	@Override
	public List<User> searching(String s) {
		List<User> liste=new ArrayList<User>();
		for(User u : this.userRepo.findAll()){
			if(u.getFname().contains(s)||u.getLname().contains(s)||u.getUse_matricule().contains(s)){
				liste.add(u);
			}
		}
		return liste;
	}

	@Override
	public boolean check(Long id, String s) {
		User u=this.userRepo.findById(id).get();
		boolean test=false;
		for(AdmUserProfile up: u.getUser_profile_aff()){
			if(up.getProfile_aff().getName().toString().equals(s)){
				test=true;
			}
		}
		return test;
	}
}
