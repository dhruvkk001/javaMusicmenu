package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){}
    public Song findSong(String title) {
        for(Song checkedsong : songs){
            if(checkedsong.getTitle().equals(title)){
                return checkedsong;
            }

        }
        return null;
    }

    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Song(title,duration));
            System.out.println(title+" added to the list");
            return true;
        }
        else{
            System.out.println(title+" already exists in the list");
            return false;
        }
    }
    public  boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;
        if(index>0 && index<=this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have song with track number"+trackNumber);
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        for (Song chechedSong :this.songs){
            if(chechedSong.getTitle().equals(title)){
                playlist.add(chechedSong);
                return true;
            }

        }
        System.out.println(title+" does not exist in the list");
        return false;

    }


}
