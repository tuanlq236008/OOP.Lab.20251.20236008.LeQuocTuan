package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<Media>();

        mediaList.add(new Book(1, "Harry Potter", "Fantasy", 50.5f));
        mediaList.add(new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Christopher Nolan", 148, 20.0f));
        mediaList.add(new CompactDisc(3, "Thriller", "Pop", "Michael Jackson", "9", 15.0f));
    
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
