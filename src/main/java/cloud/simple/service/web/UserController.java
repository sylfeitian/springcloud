package cloud.simple.service.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.service.domain.UserService;
import cloud.simple.service.model.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		List<User> ls=userService.searchAll();		
		return ls;
	}
	@RequestMapping(value="/name",method=RequestMethod.GET)
	public String loadUserName(){
		return "Hello Tom！";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable int id){
		User user = userService.findById(id);
		return user;
		
	}
	
}
