package com.saksham;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>(); //here static is the property of the class
	public static void main(String[] args) {
		Album album = new Album("Album1", "Arjit");
		album.addSong("Kesariya", 2.53);
		album.addSong("chhod diya", 5.20);
		album.addSong("Dil Shambhal ja Zara", 5.34);
		albums.add(album);
		
		album = new Album("Album2", "Darshan Raval");
		album.addSong("Baarishon Mein", 4.22);
		album.addSong("Tera Zikr", 3.44);
		album.addSong("Ek Tarfa", 4.12);
		albums.add(album);
		// now we have to create the linked list of the playList that we have to use this in playList
		LinkedList<Song> playList_1 = new LinkedList<>();
		albums.get(0).addToPlayList("Kesariya", playList_1); //at zero index kesariya song is there
		albums.get(0).addToPlayList("chhod diya", playList_1); 
		albums.get(1).addToPlayList("Baarishon Mein", playList_1);
		albums.get(1).addToPlayList("Tera Zikr", playList_1);
		
		//now we have to create the playList that will play this playList
		play(playList_1);

	}
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listiterator = playList.listIterator();
		if(playList.size()==0) 
		{
			System.out.println("This playList have no song");
		}
		else
		{
			System.out.println("Now Playing" + listiterator.next().toString());
			printMenu();
		}
		while(!quit) {     // this means if quit is false...
			int action = sc.nextInt();
			sc.nextLine();
			switch(action)
			{
			case 0:
				System.out.println("PlayList is Complete");
				quit = true;
				break;
			case 1:
				if(!forward) //this means if forward is false...
				{
					if(listiterator.hasNext()) {
						listiterator.next();
					} 
					forward = true;
				}
				if(listiterator.hasNext()) {
					System.out.println("Now playing" + listiterator.next().toString());
				}else {
					System.out.println("No song available, reached at the end of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward) {
					if(listiterator.hasPrevious()) {
						listiterator.previous();
					}
					forward = false;
				}
				if(listiterator.hasPrevious()) {
					System.out.println("Now playing "+ listiterator.previous().toString());
				}else {
					System.out.println("We are at the first song");
					forward = false;
				}
				break;
			case 3:
				if(forward) {
					if(listiterator.hasPrevious()) {
						System.out.println("Now Playing "+listiterator.previous().toString());
						forward = false; 	
					}else {
						System.out.println("we are at the Start of the list");
					}
				}else
				{
					if(listiterator.hasNext())
					{
						System.out.println("Now Playing "+ listiterator.next().toString());
						forward = true;
					}else {
						System.out.println("We have reached at the end of the list");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size() > 0) {
					listiterator.remove();
					if(listiterator.hasNext()) {
						System.out.println("Now Playing "+ listiterator.next().toString());
						
						
					}
					else {
						if(listiterator.hasPrevious())
						System.out.println("now playing "+listiterator.previous().toString() );
					}
				}
			 
			}
		}
		
	}
	//user interaction methods
	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to quit\n" +
		"1 - to play next Song\n" +
		"2 - to play Previous Song\n" +
		"3 - to replay the current Song\n"+
		"4 - List of All Songs\n"+
		"5 - print all available options\n"+
		"6-delete current song"	);
	}
	private static void printList(LinkedList<Song> playList)
	{
		Iterator<Song> iterator = playList.iterator();
		System.out.println("------------------");
		
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-------------------");
	}

}
