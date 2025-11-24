package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    private int qty = 0;
    public void addMedia(Media media) { itemsOrdered.add(media); }
    public void removeMedia(Media media) { 
        for (int i = 0; i < qty; i++) {
            if (itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
                itemsOrdered.remove(i);
                qty--;
                break;
            }
        }
    }
    public void displayStore() {
        System.out.println("********* STORE *********");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }
        System.out.println("**************************\n");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}
