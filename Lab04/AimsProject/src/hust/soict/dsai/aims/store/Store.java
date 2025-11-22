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
}
