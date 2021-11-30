package com.example.training.springboot.springbootSimple.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.training.springboot.springbootSimple.serviceImpl.TodoService;
import com.example.training.springboot.web.model.Todo;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/showTodo", method=RequestMethod.GET)
	public  String todoShowPage( ModelMap model) {
		String name=getLoggedInUserName(model);
		model.put("output",todoService.getTodo(name));
		return "showTodo";
	}
	
	@RequestMapping(value="/addTodo", method=RequestMethod.GET)
	public  String todoGetPage( ModelMap model) {
model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), null, new Date(), false));
		return "addTodo";
	}
	
	
	@RequestMapping(value="/addTodo", method=RequestMethod.POST)
	public  String todoPostPage( ModelMap model, @Valid  Todo todo, BindingResult result) {	
	String name=getLoggedInUserName(model);


//	if(result.hasErrors()){
//		System.out.println(result);
//
//		return "addTodo";
//	}
		todoService.addTodo(todo.getId(),name,todo.getDesc(),todo.getTargetDate());
		return "redirect:/showTodo";
	}
	
	@RequestMapping(value="/deleteTodo", method=RequestMethod.GET)
	public  String todoDelete( ModelMap model, @RequestParam int id) {

		todoService.deleteTodo(id);
		return "redirect:/showTodo";
	}
	
	@RequestMapping(value="/updateTodo", method=RequestMethod.GET)
	public  String todoUpdateDisplay( ModelMap model, @RequestParam int id) {

		model.put("todo",todoService.retrieveTodo(id));
		return "addTodo";
	}
	
	@RequestMapping(value="/updateTodo", method=RequestMethod.POST)
	public  String todoUpdate( ModelMap model, @Valid  Todo todo, @RequestParam int id) {
		//Todo todo=todoService.retrieveTodo(id);
		String name=getLoggedInUserName(model);

		todoService.updateTodo(todo.getId(),name,todo.getDesc(),todo.getTargetDate());
		return "redirect:/showTodo";
	}

	private String getLoggedInUserName(ModelMap model) {
		return String.valueOf(model.get("name"));
	}
}
