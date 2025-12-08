package hust.soict.dsai.aims.media;

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
    public void play() {
        if (length <= 0) {
            System.out.println("Cannot play track: " + title);
        } else {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        }
    }

    @Override
    public String toString() {
        return title + " - " + length;
    }

}
