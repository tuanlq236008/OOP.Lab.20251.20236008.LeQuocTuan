package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: Track length is non-positive!"); // Xuất thông báo lỗi ra console
            throw new PlayerException("ERROR: Track length is non-positive!"); // Ném PlayerException
        }
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track Length: " + this.getLength());
    }

    @Override
    public String toString() {
        return title + " - " + length;
    }

}
