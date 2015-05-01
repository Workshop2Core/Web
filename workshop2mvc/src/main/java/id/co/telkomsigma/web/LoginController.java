package id.co.telkomsigma.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import id.co.telkomsigma.entity.FloorPojo;
import id.co.telkomsigma.entity.LoginHistory;
import id.co.telkomsigma.entity.OrderHistory;
import id.co.telkomsigma.entity.PasswordHistory;
import id.co.telkomsigma.entity.User;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class LoginController {
	public static String camelport="7000";
	public static String camelip="http://localhost";
	public static String mappingUser = "/workshop2/User";
	public static String mappingLoginData = "/workshop2/loginHistory";
	public static String mappingPwdHistory = "/workshop2/pwdHistory";
	public static String mappingOrderHistory = "/workshop2/orderHistory";
	
	@RequestMapping(method = RequestMethod.GET)
	public String startUp(){
		return "redirect:/login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String form(){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String cekLogin(Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password, 
			HttpSession session) {

		RestTemplate rt = new RestTemplate();
		User userLogin = rt.getForObject(camelip + ":" + camelport + mappingUser + 
				"/findByUsernameAndPassword/" + username + "/" + 
				password, User.class, username, password);

		if(userLogin!=null){			
			LoginHistory loginHistory = new LoginHistory();
			
			loginHistory.setUser(camelip + ":" + camelport + mappingUser + "/findById/" + userLogin.getIduser());
			
			Date today = new java.util.Date();
			Timestamp date = new Timestamp(today.getTime());
			loginHistory.setLogintime(date);
						
			String response = rt.postForObject(camelip + ":" + camelport + mappingLoginData + "/insert"
					, loginHistory, String.class);
			System.out.println(response);
			
			session.setAttribute("userLogin", userLogin);
			return "redirect:/home";
		}else{
			model.addAttribute("msg","Invalid Username/password");
			return "login";
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String afterlogin(Model model, HttpSession session) {
		RestTemplate rt = new RestTemplate();
		User userLogin = (User) session.getAttribute("userLogin");
		
		if(userLogin==null){
			return "redirect:/login";
		}else{
			String url = camelip + ":" + camelport + mappingOrderHistory ;
			List<FloorPojo> stockList = (List<FloorPojo>) rt.getForObject(url + "/getAllDataFloorByIdSaham/1", List.class);
			model.addAttribute("stockList", stockList);

			List<OrderHistory> orderList = (List<OrderHistory>) rt.getForObject( url + "/getAll", List.class);
			model.addAttribute("orderList", orderList);

			return "home";
		}
	}
	
	@RequestMapping(value="/changePassword", method = RequestMethod.GET)
	public String changePassword(Model model, HttpSession session){
		
		User userLogin = (User) session.getAttribute("userLogin");
		
		if(userLogin==null){
			return "redirect:/login";
		}else{
			model.addAttribute("userLogin", userLogin);
			return "edit-user";
		}
	}
	
	//belum ada pengecekan password history dan password aktif user
	@RequestMapping(value="/changePassword/save", method = RequestMethod.POST)
	public String changePasswordSave(
			@RequestParam("iduser") long iduser,
			@RequestParam("username") String username,
			@RequestParam("password") String password, 
			Model model,
			HttpSession session){
		
		User userLogin = (User) session.getAttribute("userLogin");
		
		if(userLogin==null){
			return "redirect:/login";
		}else{						
			PasswordHistory newPasswordHistory = new PasswordHistory();		
			newPasswordHistory.setOldpwd(userLogin.getPassword());			
			Date today = new java.util.Date();
			Timestamp date = new Timestamp(today.getTime());
			newPasswordHistory.setTimechange(date);
			newPasswordHistory.setUser(camelip + ":" + camelport + mappingUser + "/findById/" + userLogin.getIduser());
						
			RestTemplate rt = new RestTemplate();
			userLogin.setPassword(password);
			String urlUpdateUser = camelip + ":" + camelport + mappingUser + "/update/" + userLogin.getIduser();			
			rt.put(urlUpdateUser, userLogin, User.class);			
			String urlUpdatePwdHistory = camelip + ":" + camelport + mappingPwdHistory + "/insert";
			rt.postForObject(urlUpdatePwdHistory, newPasswordHistory, PasswordHistory.class);
	
			session.setAttribute("userLogin", userLogin);
			model.addAttribute("userLogin", userLogin);
			return "edit-user";
		}

	}
	
	@RequestMapping(value="/logOut", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		User userLogin = (User) session.getAttribute("userLogin");
		
		if(userLogin==null){
			return "redirect:/login";
		}else{
			User user = null;
			session.setAttribute("userLogin", user);
			String urlDeleteLoginHistory =camelip + ":" + camelport + mappingLoginData + "/delete/" + userLogin.getIduser(); 
			RestTemplate rt = new RestTemplate();
			rt.delete(urlDeleteLoginHistory);

			return "redirect:/login";		
		}

	}
}
