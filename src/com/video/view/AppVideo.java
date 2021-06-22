package com.video.view;

import java.util.Scanner;
import com.video.application.VideoController;

public class AppVideo {
	
	static Scanner sc = new Scanner(System.in);
	private static VideoController controller = new VideoController();

	public static void main(String[] args) {
		
		String option = "";
		
		System.out.println("Welcome to the VideoApp.");
		while(option != "0") {
			if(controller.getUser() == null) {
				//If there is no active user, it creates one
				System.out.println("Create new user.");
				createUser();
			} else {
				//If there is an active user, it shows the user and the menu
				System.out.println("User: " + controller.getUserName());
				System.out.println("1.-Create video. \n2.-Show videos. \n0.-Exit.");
				option = sc.nextLine();
				switch(option) {
				case "1":
					createVideo();
					break;
				case "2":
					controller.showVideos();	//Shows a list with title, URL and tags of the active user's videos
					break;
				/*case "3":
					controller.videoIndex();	//Shows an index of videos of the current user
					int sel = intInput();		//Function to parse string to int
					if(sel == 0) {
						break;
					}
					controller.selectVideo(sel);	//Set the selected video at the controller
					while(option != "0") {
						System.out.println("Video: " + controller.getVideoTitol() + "\n1.-Play. \n2.-Pause. \n3.-Stop. \n0.-Exit.");
						option = sc.nextLine();
						switch(option) {
						case "1":
							
						}
					}
					break;*/
					
				case "0":
					option = "0";
					break;
				default:
					System.out.println("Insert a valid option.");
				}
			}
		}
		
		sc.close();

	}
	
	static void createUser() {
		System.out.println("User name: ");
		String name = sc.nextLine();
		System.out.println("User lastname: ");
		String lastname = sc.nextLine();
		System.out.println("User password: ");
		String password = sc.nextLine();
		
		controller.createUser(name, lastname, password);	//Creates a new user and adds it to the user repository
	}
	
	static void createVideo() {
		System.out.println("Insert video name:");
		String videoName = sc.nextLine();
		controller.createVideo(videoName); 	//Creates a new video and it's added to the List of the active user
		
		System.out.println("Video created. Do you want to add tags? Y/N");	//Ask for tags
		String option = sc.nextLine();
		while(option.equalsIgnoreCase("Y")) {
			System.out.println("Insert the new tag.");
			String t = sc.nextLine();
			controller.createTag(t);	//Creates a new tag and adds it to the video tag List if it's not null
			System.out.println("Do you want to add another tag? Y/N");
			option = sc.nextLine();
		}
	}
	
	static int intInput() {
		String t = sc.nextLine();
		int i = 0;
		try {
			i = Integer.parseInt(t);
		} catch (NumberFormatException e) {
			System.out.println("Only numbers allowed.");
			i = intInput();
		}
		return i;
	}
	


}
