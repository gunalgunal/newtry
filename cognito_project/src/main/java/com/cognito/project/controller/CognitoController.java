package com.cognito.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognito.project.service.CognitoService;

@Controller
public class CognitoController {
	
	@Autowired
	private CognitoService service;
	
	@GetMapping("/home")
	public String homePage()
	{
		return "home";
	}
	
	@GetMapping("/balance")
	public ModelAndView balanceAmount()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bal");
		
		return mv;
	}
	@PostMapping("/balance")
	public ModelAndView balanceAmount1(@RequestParam("number") int number)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("balance");
		mv.addObject("balance",service.balance(number));
		return mv;
	}
	
	@RequestMapping(value="/withdraw",method=RequestMethod.GET)
	public ModelAndView withdrawAmount()
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("withdraw");
	
		return mv;
	}
	@RequestMapping(value="/withdraw",method=RequestMethod.POST)
	public ModelAndView withdrawAmount1(@RequestParam("amount") int amount,@RequestParam("number") int number)
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("balance");
		mv.addObject("balance",service.withdraw(amount,number));
	
		return mv;
	}
	@RequestMapping(value="/deposit",method=RequestMethod.GET)
	public ModelAndView depositAmount()
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("deposit");
	
		return mv;
	}
	@RequestMapping(value="/deposit",method=RequestMethod.POST)
	public ModelAndView depositAmount1(@RequestParam("amount") int amount,@RequestParam("number") int number)
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("balance");
		mv.addObject("balance",service.deposit(amount,number));
	
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView addAccount()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("add");
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addAccount1(@RequestParam("number") int number,@RequestParam long amount)
	{
		ModelAndView mv=new ModelAndView();
		service.add(number, amount);
		mv.setViewName("home");
		return mv;
		
	}

}
