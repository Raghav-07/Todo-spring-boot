package com.example.training.springboot.springbootSimple.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.training.springboot.web.model.Todo;
@Service
public class TodoService {
static List<Todo> todoArray=new ArrayList<>();

static {
	todoArray.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(),
	        false));
	todoArray.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));
	todoArray.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(),
              false));
	todoArray.add(new Todo(4, "Raghav", "Learn", new Date(),
            false));
}
public void addTodo(int id, String name, String desc, Date date, boolean isDone)  {
		
    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
//   Date date2=null;
//try {
//	date2 = formatter1.parse(date);
//} catch (ParseException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}  
    todoArray.add(new Todo(id,name,desc,date,isDone));
}

public List<Todo> getTodo(String user) {
	//model.put("todoArray", todoArray);
	List<Todo> filteredTodo =new ArrayList<>(); 
	for(Todo todoVar:todoArray) {
		if(todoVar.getUser().equals(user))
			filteredTodo.add(todoVar);
	}
		
	return filteredTodo;
}

public void deleteTodo(int id) {
//for(Todo delVar:todoArray)	{
//	if(delVar.getId()==(id) /*&& delVar.getUser().equals()*/)
//	{
//		todoArray.remove();
//	}
//		
//}
	
	 Iterator<Todo> iterator = todoArray.iterator();
     while (iterator.hasNext()) {
         Todo todo = iterator.next();
         if (todo.getId() == id) {
             iterator.remove();
         }
     }
}

public Todo retrieveTodo(int id) {

	Iterator<Todo> iterator = todoArray.iterator();
	for(Todo todo:todoArray) {
		if(todo.getId()==id)
			return todo;
			
	}
	return null;
}

public void updateTodo(int id, String name, String desc, Date date, boolean isDone)  {
	
    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
//   Date date2=null;
//try {
//	date2 = formatter1.parse(date);
//} catch (ParseException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}  
	Iterator<Todo> iterator = todoArray.iterator();
	for(Todo utodo:todoArray) {
		if(utodo.getId()==id) {
			todoArray.remove(utodo);

		    todoArray.add(new Todo(id,name,desc,date,isDone));
		}
			
	}
}

}
