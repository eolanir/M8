package com.video.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class User {
	protected String name;
	protected String lastname;
	protected Date register;
	protected String password;
	protected GregorianCalendar calendar;
	protected List<Video> videos = new ArrayList<Video>();
	
	public User(String name, String lastname, String password) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		calendar = new GregorianCalendar();
		this.register = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getRegister() {
		return register;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addVideo(Video video) {
		videos.add(video);
	}
	
	public List<Video> getVideos(){
		return videos;
	}
}
