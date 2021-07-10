package com.hussein.java_project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hussein.java_project.models.Card;
import com.hussein.java_project.models.Flight;
import com.hussein.java_project.models.LoginUser;
import com.hussein.java_project.models.User;
import com.hussein.java_project.services.CardService;
import com.hussein.java_project.services.FlightService;
import com.hussein.java_project.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private FlightService flightService;
	
	@Autowired
	private CardService cardService;
	
	// Login and Register Page
	@GetMapping("/")
	public String index(Model model,
	@ModelAttribute("newUser") User newUser,
	@ModelAttribute("newLogin") LoginUser newLogin ) {
		System.out.println("Login & Register");
		return "login_register.jsp";
	}
						
	// Register Post
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
	BindingResult result, Model model, HttpSession session) {
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			model.addAttribute("newUser", newUser);
				return "login_register.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
					    
	// Login Post
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	BindingResult result, Model model, HttpSession session) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", newLogin);
			model.addAttribute("newUser", new User());
			return "login_register.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
						
	//Logout 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// Home 
	@GetMapping("/home")
	public String test(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("Not Logged In");
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		return "home.jsp";
	}
	
	// Render New Flight Page
	@GetMapping("/flights/new")
	public String newFlight(@ModelAttribute("flightObject")Flight flight,
	BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		System.out.println("New Flight Method");
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		return "new_flight.jsp";
	}
	
	// Create New Flight 
	@PostMapping("/flights/create")
	public String createFlight(@Valid @ModelAttribute("flightObject")Flight flight,
	BindingResult result, Model model, HttpSession session) {
		System.out.println("Create Method");
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		if(result.hasErrors()) {
			return "new_flight.jsp";
		}
		Flight myFlight = flightService.createFlight(flight);
		flightService.createFlight(myFlight);
		return "redirect:/flights";
	}
	
	// All flights
	@GetMapping("/flights")
	public String allFlights(@ModelAttribute("flight")Flight flight, 
	Model model,
	HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		List<Flight> allFlights = flightService.allFlights();
		model.addAttribute("allFlights", allFlights);
		return "all_flights.jsp";
		}
	
	// Book Flight
	@GetMapping("/flights/{id}/book")
	public String bookFlight(@PathVariable("id")Long id, HttpSession session, Model model) {
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Flight myFlight = flightService.findFlightById(id);
		currentUser.setBookedFlight(myFlight);
		flightService.updateFlight(myFlight);
		System.out.println("Flight Added");
//		System.out.println("${myFlight.flightName}");
		System.out.println(currentUser);
		return "redirect:/flights/myflights";
	}
	
	// My Flight
	@GetMapping("/flights/myflights")
	public String myFlight(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		Flight myFlight = currentUser.getBookedFlight();
		model.addAttribute("myFlight", myFlight);
		System.out.println(myFlight.getFlightName());
		System.out.println(currentUser);
		return "my_flight.jsp";
	}
	
	// New Card
	@GetMapping("/flights/checkout")
	public String newCard(@ModelAttribute("cardObject")Card card, Model model,
	HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		return "new_card.jsp";
	}
	
	// Create Card 
	@PostMapping("/flights/create/card")
	public String createCard(@Valid @ModelAttribute("cardObject")Card card, 
	BindingResult result, Model model, HttpSession session) {
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		if(result.hasErrors()) {
			model.addAttribute("currentUser", currentUser);
			return "new_card.jsp";
		}
		
		Card myCard = cardService.createCard(card);
		currentUser.setCard(myCard);
		cardService.createCard(myCard);
		return "redirect:/flights/checkoutconfirm";
	}
	
	// Checkout
	@GetMapping("/flights/checkoutconfirm")
	public String checkoutFligth(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		Card myCard = currentUser.getCard();
		model.addAttribute("myCard", myCard);
		Flight myFlight = currentUser.getBookedFlight();
		model.addAttribute("myFlight", myFlight);
		System.out.println(currentUser.getCard());
		System.out.println(currentUser.getFirstName());
		return "checkout.jsp";
	}
	
	// Confirmation Page
	@GetMapping("/flights/confirmpage")
	public String confirm(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userID = (Long) session.getAttribute("userId");
		User currentUser = userService.getUserById(userID);
		model.addAttribute("currentUser", currentUser);
		return "confirm.jsp";
	}
}
