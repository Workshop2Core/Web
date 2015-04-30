package id.co.telkomsigma.web;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import id.co.telkomsigma.entity.User;
@Controller
public class LoginWebController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String form(Model model){
		User user = new User();

		user.setUsername("");
		user.setPassword(null);

		model.addAttribute("user",user);
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password){

		RestTemplate rt = new RestTemplate();

		User userlogin = rt.getForObject("http://localhost:9000/workshop2/user/findbyusernameandpassword/"+username+"/"+password, User.class, username,password);

		java.util.Date today = new java.util.Date();
		java.sql.Timestamp date = new java.sql.Timestamp(today.getTime());

		JSONObject obj = new JSONObject();
		obj.put("logintime", date);
		obj.put("user", "http://localhost:9000/workshop2/user/get/"+userlogin.getIduser());

		rt.postForLocation("http://localhost:9000/workshop2/loginHistory/insert", obj);

		if(userlogin!=null){
			model.addAttribute("userlogin",userlogin);
			return "home";
		}else{
			return "login";
		}

	}
	}
