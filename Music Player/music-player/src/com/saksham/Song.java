package com.saksham;

public class Song {
	String title;
	Double duration;
	// now we have to create a constructor here
	public Song(String title, Double duration) {
		this.title = title;
		this.duration = duration;
	}
	// lets create an empty Constructor
	public Song() 
	{
				
	}
	// lets get something from the class
	public String getTitle() {
		return title;
	}
	public double getDuration() {
		return duration;
	}
	//using to string- it will return the property of the class that we have
	@Override
	public String toString() {
		return "Song [title=" + title + ", duration=" + duration + "]";
	}
	
	// This above methods will simply print the above things
	
	
	
	
	

	
	

}
