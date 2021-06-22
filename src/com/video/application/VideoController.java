package com.video.application;

import java.util.List;

import com.video.domain.*;

public class VideoController {
	private UserRepository repository= new UserRepository();
	protected User user;
	protected Video video;
	
	public VideoController() {
		
	}
	
	public void createUser(String name, String lastname, String password) {
		user = new User(name, lastname, password);
		repository.addUser(user);
		System.out.println("User created.");
	}
	
	public User getUser() {
		return user;
	}
	
	public String getUserName() {
		String txt = user.getName() + " " + user.getLastname();
		return txt;
	}
	
	public void createVideo(String titol) {
		video = new Video(titol);
		user.addVideo(video);
	}
	
	public void createTag(String txt) {
		try {
			checkTag(txt);
			Tag tag = new Tag(txt);
			video.addTags(tag);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void checkTag(String tag) throws Exception {
		//Looks for empty spaces
		for(int i = 0; i < tag.length(); i++) {
			if(tag.charAt(i) == ' ') {
				throw new Exception("Tags cannot contain empty spaces.");
			}
		}
	}
	
	public void showVideos() {
		//Get user video list
		List<Video> videos = user.getVideos();
		System.out.println("Videos from the user: " + user.getName() + " " + user.getLastname());
		for(Video i : videos) {
			System.out.println("\n- Title: " + i.getTitol() + ". \n- URL: " + i.getUrl() + "\n- Upload date: " + i.getUploadDate() + "\n- Status: " + i.getStatus() + "\n- Tags: ");
			//Get video tag list
			List<Tag> tags = i.getTags();
			for(Tag t : tags) {
				System.out.println("#" + t.getTag());
			}
		}
	}
	
	public void videoIndex() {
		System.out.println("Select video by index. \n0.- Exit.");
		for(int i = 0; i < user.getVideos().size(); i++) {
			System.out.println((i+1) + ".-" + user.getVideos().get(i).getTitol());
		}
	}
	
	public void selectVideo(int i) {
		video = user.getVideos().get(i-1);
	}
	
	public String getVideoTitol() {
		return video.getTitol();
	}
	
}
