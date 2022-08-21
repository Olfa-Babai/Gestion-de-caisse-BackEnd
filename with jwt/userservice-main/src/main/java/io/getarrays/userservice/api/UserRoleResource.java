package io.getarrays.userservice.api;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import io.getarrays.userservice.domain.*;
import io.getarrays.userservice.service.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class UserRoleResource {
	  private final UserProfileService userProfileService;
	 
	  @PostMapping("/user/role/add/{idp}/{idu}")
	  public AdmUserProfile addUserProfile(@PathVariable Long idp, @PathVariable Long idu){
		  return this.userProfileService.addUserProfile(idp, idu);
	  }
	  
	  @GetMapping("/user/role/all")
	  public Map<String, List<Role>> organizing(){
		  return userProfileService.organizing();
	  }
	  
	  @GetMapping("/user/role/nba")
	    public int nbAdmin(){
	    	return this.userProfileService.nbsAdmin();
	    }
	    
	    @GetMapping("/user/role/nbca")
	    public int nbCai(){
	    	return this.userProfileService.nbCaissiers();
	    }
	    
	    @GetMapping("/user/role/nottheirs/{id}")
	    public List<String> NotTheirRoles(@PathVariable Long id){
	    	return userProfileService.NotTheirRoles(id);
	    }
	    
	    @GetMapping("/user/role/roleD")
	    	public Role getDominantRole(@RequestParam String username){
	    	return this.userProfileService.findDominantRole(username);
	    }
	    
	    @GetMapping("/user/role/nbch")
	    public int nbCH(){
	    	return this.userProfileService.nbsCH();
	    }
	  
	  @GetMapping("/user/role/pdf")
	  public ResponseEntity<?> pdfGenerator() throws FileNotFoundException, DocumentException{
		  userProfileService.savetoPdf();
		  return ResponseEntity.noContent().build();
	  }
	  
	  @GetMapping("/user/role/extract")
	  public ResponseEntity<Map<String,List<Role>>> extracting(@RequestParam String profile){
		  return ResponseEntity.ok().body(userProfileService.extract(profile));
	  }
	  
	  @GetMapping("/user/role/search")
	  public Map<String,List<Role>> search(@RequestParam String matricule){
		  return this.userProfileService.searching(matricule);
	  }
	  
	  /*
	  @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
    
     @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
	   
	   */
	
}
