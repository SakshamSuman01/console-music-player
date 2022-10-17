package com.saksham;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(String name, String artist)
	{
		this.name=name;
		this.artist=artist;
		this.songs=new ArrayList<Song>();
	}
	public Album()
	{
		
	}
	
	//method to find title
	public Song findSong(String title) 
	{
		for(Song checkedSong : songs) 
		{
			if(checkedSong.getTitle().equals(title)) return checkedSong;
		}
		return null;
	}
	//we have to return true/false here because to confirm if the songs is added or not
	public Boolean addSong(String title, double duration)
	{
		if(findSong(title)==null) {
			songs.add(new Song(title,duration));
//			System.out.println(title + " Succesfully added to the list");
			return true;
		}
		else {
//			System.out.println("Song with name "+title+" already exists in the list");
			return false;
			
		}
	}
	//Now we can add only those songs in the playlist which already exists in the list
	//we have to use linkedlist here, because we to keep track of the next song and previous song
	public boolean addToPlayList(int trackNumber,LinkedList<Song> PlayList) 
	{
		int index = trackNumber - 1; //for the track number to start with one not from zero
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
//		System.out.println("This album does not have a track " + trackNumber );
		return false;
		
	}
	//now we have to get title as a input
	public Boolean addToPlayList(String title, LinkedList<Song> PlayList)
	{
		for(Song checkedSong:this.songs)
		{
			if(checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
				return true;
			}
		}
//		System.out.println(title + " There is no such song");
		return false;
	}
	//Now after all this, i am going to create object of the album in the Main class
	


}
