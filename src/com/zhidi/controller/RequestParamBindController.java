package com.zhidi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhidi.entity.User;

@Controller
@RequestMapping("/param")
public class RequestParamBindController {

	@RequestMapping(value="/byRequest",params="username")
	public String byRequest(HttpServletRequest req,String username){
		req.setAttribute("aa", username);
		System.out.println(username);
		return "index";
	}
	
	@RequestMapping("/byResponse")
	public void byResponse(HttpServletResponse resp) throws IOException{
		PrintWriter writer=resp.getWriter();
		resp.setContentType("application/json");
		writer.println("{\"username\":\"ÀîËÄ\",\"age\":20,\"sex\":\"ÄÐ\"}");
		writer.flush();
		writer.close();
	}
	
	@RequestMapping("/bySession")
	public String bySession(HttpSession session){
		session.setAttribute("hobby", "³ª¸è");
		return "index";
	}
	
	@RequestMapping("/byModel")
	public String byModel(Model model){
		model.addAttribute("password", "1234");
		return "index";
	}
	
	@RequestMapping("/byModelMap")
	public String byModelMap(ModelMap map){
		map.addAttribute("salt", "12345");
		return "index";
	}
	
	@RequestMapping(value="/byString",method=RequestMethod.POST)
	public String bySimpleParam(String username){
		System.out.println(username);
		return "index";
	}
	
	@RequestMapping("/byEntity")
	public String byPOJO(User user,Integer age){
		System.out.println(user);
		System.out.println(age);
		return "index";
	}
	
	@RequestMapping("/byRequestParam")
	public String byDelete(@RequestParam(value="uuid",required=true,defaultValue="10") Integer id){
		System.out.println(id);
		return "index";
	}
	
	@RequestMapping("/toRegister")
	public String register(){
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(User user){
		System.out.println(user);
		return "index";
	}
	
	@RequestMapping("/date")
	public String getDate(@DateTimeFormat(pattern="yyyy-MM-dd") Date date){
		System.out.println(date);
		return "index";
	}
	
	@RequestMapping("{date}/{id}/urlParam/{name}")
	public String urlParam(@PathVariable("date") Date date,
			@PathVariable("name") String name,
			@PathVariable("id") Integer id
			){
		System.out.println(date);
		System.out.println(name);
		System.out.println(id);
		return "index";
	}
}
