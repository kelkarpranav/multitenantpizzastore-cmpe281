package com.sjsu.cmpe281;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe281.dao.OrderDao;
import com.sjsu.cmpe281.dao.SFDCDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//OrderDao odao = new OrderDao();
		//odao.getItemList();
		
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeURL(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//OrderDao odao = new OrderDao();
		//odao.getItemList();
		
		return "home";
	}
	
	@RequestMapping(value = "/dominos", method = RequestMethod.GET)
	public String dominosURL(Locale locale, Model model) throws Exception {
		logger.info("Welcome to Dominos! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		SFDCDao cdao = new SFDCDao();
		cdao.initStore("dominos");
		JSONObject catalogs = cdao.getItemList("dominos");
		org.json.JSONArray pizzas = (org.json.JSONArray) catalogs.get("Pizza");
		org.json.JSONArray sides = (org.json.JSONArray) catalogs.get("Side");
		org.json.JSONArray drinks = (org.json.JSONArray) catalogs.get("Drink");
	
		model.addAttribute("pizzas", pizzas.get(0));
		model.addAttribute("sides", sides.get(0));
		model.addAttribute("drinks", drinks.get(0));
		
		return "dominos";
	}
	
	@RequestMapping(value = "/pizzahut", method = RequestMethod.GET)
	public String pizzahutURL(Locale locale, Model model) throws Exception {
		logger.info("Welcome to Pizza Hut! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		SFDCDao cdao = new SFDCDao();
		cdao.initStore("pizzahut");
		JSONObject catalogs = cdao.getItemList("pizzahut");
		org.json.JSONArray pizzas = (org.json.JSONArray) catalogs.get("Pizza");
		org.json.JSONArray sides = (org.json.JSONArray) catalogs.get("Side");
		org.json.JSONArray drinks = (org.json.JSONArray) catalogs.get("Drink");
	
		model.addAttribute("pizzas", pizzas.get(0));
		model.addAttribute("sides", sides.get(0));
		model.addAttribute("drinks", drinks.get(0));
		
		//OrderDao odao = new OrderDao();
		//odao.getItemList();
		
		return "pizzahut";
	}
	
	@RequestMapping(value = "/pizzamyheart", method = RequestMethod.GET)
	public String pizzamyheartURL(Locale locale, Model model) throws Exception {
		logger.info("Welcome to Pizza My Heart! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		SFDCDao cdao = new SFDCDao();
		cdao.initStore("pizzamyheart");
		JSONObject catalogs = cdao.getItemList("pizzamyheart");
		org.json.JSONArray pizzas = (org.json.JSONArray) catalogs.get("Pizza");
		org.json.JSONArray sides = (org.json.JSONArray) catalogs.get("Side");
		org.json.JSONArray drinks = (org.json.JSONArray) catalogs.get("Drink");
	
		model.addAttribute("pizzas", pizzas.get(0));
		model.addAttribute("sides", sides.get(0));
		model.addAttribute("drinks", drinks.get(0));
		
		return "pizzamyheart";
	}
	
	@RequestMapping(value = "/papajohns", method = RequestMethod.GET)
	public String papajohnsURL(Locale locale, Model model) throws Exception {
		logger.info("Welcome to Papa Johns! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		SFDCDao cdao = new SFDCDao();
		
		cdao.initStore("papajohnspizza");
		JSONObject catalogs = cdao.getItemList("papajohnspizza");
		org.json.JSONArray pizzas = (org.json.JSONArray) catalogs.get("Pizza");
		org.json.JSONArray sides = (org.json.JSONArray) catalogs.get("Side");
		org.json.JSONArray drinks = (org.json.JSONArray) catalogs.get("Drink");
	
		model.addAttribute("pizzas", pizzas.get(0));
		model.addAttribute("sides", sides.get(0));
		model.addAttribute("drinks", drinks.get(0));
		
		return "papajohns";
	}
	
	@RequestMapping(value = "/roundtable", method = RequestMethod.GET)
	public String roundtableURL(Locale locale, Model model) throws Exception {
		logger.info("Welcome to Papa Johns! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		SFDCDao cdao = new SFDCDao();
		
		cdao.initStore("roundtablepizza");
		JSONObject catalogs = cdao.getItemList("roundtablepizza");
		org.json.JSONArray pizzas = (org.json.JSONArray) catalogs.get("Pizza");
		org.json.JSONArray sides = (org.json.JSONArray) catalogs.get("Side");
		org.json.JSONArray drinks = (org.json.JSONArray) catalogs.get("Drink");
	
		model.addAttribute("pizzas", pizzas.get(0));
		model.addAttribute("sides", sides.get(0));
		model.addAttribute("drinks", drinks.get(0));
		
		return "roundtablepizza";
	}
	
    @RequestMapping(value = "/submitorder" , method = RequestMethod.POST)
    public @ResponseBody String submitOrder(@RequestBody String jsonString, Model model) throws JSONException, SQLException {
 
    	JSONObject orderobject = new JSONObject(jsonString);
    	String storeID = orderobject.getString("storeID");
    	orderobject.remove("storeID");   	
    	OrderDao odao = new OrderDao();
    	int result = odao.insertOrder(storeID,orderobject.toString());
    	System.out.println("New Order ID:  "+result);
    	String orderID = Integer.toString(result);
    	return orderID;
    }
	
}
