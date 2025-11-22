package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc( int id, String title, String category, String director, String artist, float cost) {
        super(id, title, category, director, cost);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " not found in the list.");
        }
    }
    public int getLength() {
        int total = 0;
        for(Track t : tracks) total += t.getLength();
        return total;
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " - length: " + this.getLength());
        for(Track t : tracks) t.play();
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() +
            " - " + this.getArtist() +
            " - " + this.getLength() +
            ": " + this.getCost() + "$";
    }



}
