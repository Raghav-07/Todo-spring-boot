package com.example.training.springboot.web.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;

@Data
public class Todo {
private int id;
private String user;
@Size(min=5, message="Minimum 5 characters")
private String desc;
private Date targetDate;
private boolean done;

public Todo() {
	super();
}

public Todo(int id, String user, String desc, Date date, boolean isDone) {
	super();
	this.id = id;
	this.user = user;
	this.desc = desc;
	this.targetDate = date;
	this.done = isDone;
}











}
