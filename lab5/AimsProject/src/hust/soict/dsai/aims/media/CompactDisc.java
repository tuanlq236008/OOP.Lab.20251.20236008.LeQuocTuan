package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc( String title, String category, String director, String artist, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
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
    public ArrayList<Track> getTracks() {
        return tracks;
    }
    
    public int getLength() {
        int total = 0;
        for(Track t : tracks) total += t.getLength();
        return total;
    }
    @Override
    public void play() throws PlayerException {
        // 1. Kiểm tra thời lượng của toàn bộ CD
        if (this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD Length: " + this.getLength() + "s");
        System.out.println("Artist: " + this.getArtist());

        // Kiểm tra nếu CD không có tracks nào
        if (tracks.isEmpty()) {
            System.err.println("ERROR: CD has no tracks to play!");
            throw new PlayerException("ERROR: CD has no tracks to play!");
        }

        // 2. Lặp qua từng track và gọi play()
        Iterator<Track> iter = tracks.iterator();
        while (iter.hasNext()) {
            Track nextTrack = iter.next();
            try {
                nextTrack.play(); // Gọi phương thức play() của từng track
            } catch (PlayerException e) {
                // Nếu bất kỳ track nào không thể phát, ném lại PlayerException
                // Điều này có nghĩa là CD không thể phát hoàn chỉnh
                System.err.println("ERROR playing track '" + nextTrack.getTitle() + "': " + e.getMessage());
                throw e; // Ném lại ngoại lệ từ track
            }
        }
        System.out.println("Finished playing CD: " + this.getTitle());
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() +
            " - " + this.getArtist() +
            " - " + this.getLength() +
            ": " + this.getCost() + "$";
    }



}
