package org.example;
import java.util.*;

public class Main {
    private static ArrayList<Album> albums =new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album 1","Ac/dc");
        album.addSong("Tnt",4.5);
        album.addSong("H to H",3.5);
        album.addSong("Tt",4.0);
        album.addSong("Thunder",5.0);
        albums.add(album);

        album = new Album("Album 2","Eminem");
        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.0);
        albums.add(album);

        LinkedList<Song> playlist1 =new LinkedList<>();

        albums.getFirst().addToPlaylist("Tnt",playlist1);
        albums.get(1).addToPlaylist("H to h",playlist1);
        albums.get(1).addToPlaylist("Rap god",playlist1);
        play(playlist1);

    }
    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.isEmpty()){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("no song availa ble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached to the end of list");
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
                    if (!playList.isEmpty()) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("now playing " + listIterator.previous().toString());
                        }
                    }

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }
        }
    }

    private static void  printMenu(){
        System.out.println("Available options:");
        System.out.println("0 - to quit");
        System.out.println("1 - to play next song");
        System.out.println("2 - to play previous song");
        System.out.println("3 - to replay the current song");
        System.out.println("4 - list all songs");
        System.out.println("5 - print all options");
        System.out.println("6 - delete current song");

    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("-----------------------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------");

    }
}