package io.getarrays.userservice.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.getarrays.userservice.domain.*;
import io.getarrays.userservice.service.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins="*")
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
     @GetMapping("/uexists/")
	@ResponseBody
	public ResponseEntity<User> uexists(@RequestParam String login, @RequestParam String pwd) {
		return ResponseEntity.ok().body(userService.uexists(login,pwd));
     }
     
     @GetMapping("/user/profiles/{id}")
     public ResponseEntity<List<Role>> getRoles(@PathVariable Long id)
     {
    	return ResponseEntity.ok().body(userService.getRolesOfUser(id));
     }
     
     @PostMapping("/user/add")
     @ResponseBody
     public User updateUser(@RequestBody User user)
     {
    	return userService.saveUser(user);
     }
     
     @PutMapping("/user/update/{id}")
     public User updateUser(@PathVariable Long id, @RequestBody User user)
     {
    	return (userService.updateUser(id, user));
     }
     
     @DeleteMapping("/user/delete")
     public void deleteU(@RequestParam String username)
     {
    	 User u=this.userService.getUser(username);
    	userService.deleteUser(u.getUse_id());
     }
     
     @GetMapping("/user/sort")
     public ResponseEntity<List<User>> sorting(@RequestParam String s)
     {
    	return ResponseEntity.ok().body(userService.sortUsers(s));
     }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
       return userService.saveUser(user);
    }
    
    @GetMapping("/user/get")
    public User getUser(@RequestParam String username){
    	return userService.getUser(username);
    }
    
    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam String matricule){
    	return userService.searching(matricule);
    }
    
    @GetMapping("/user/check/{id}")
    public boolean checkUser(@PathVariable Long id,@RequestParam String role){
    	return userService.check(id , role);
    }
    
    @PostMapping("user/role/save")
    @ResponseBody
    public Role saveRole(@RequestBody Role role) {
        return userService.saveRole(role);
    }
    
   /* @DeleteMapping("/role/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
      userService.deleteRole(id);
    } */

    @PostMapping("/role/addtouser")
    public AdmUserProfile addRoleToUser(@RequestBody RoleToUserForm form) {
    	log.info("Usernam : {} | rolename : {}", form.getUsername(),form.getRolename());
        return userService.addRoleToUser(form.getUsername(), form.getRolename());
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userService.getRolesOfUser(user.getUse_id()).stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String rolename;
}
