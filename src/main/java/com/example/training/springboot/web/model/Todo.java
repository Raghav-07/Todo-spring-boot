package com.example.training.springboot.web.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}


public Date getTargetDate() {
	return targetDate;
}

public void setTargetDate(Date targetDate) {
	this.targetDate = targetDate;
}

public boolean isDone() {
	return done;
}

public void setDone(boolean done) {
	this.done = done;
}

@Override
public String toString() {
	return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", targerDate=" + targetDate + ", isDone=" + done
			+ "]";
}



}
