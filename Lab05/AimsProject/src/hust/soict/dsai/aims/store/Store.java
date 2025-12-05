package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int qty = 0;

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        for (int i = 0; i < qty; i++) {
            if (itemsInStore.get(i).getTitle().equals(media.getTitle())) {
                itemsInStore.remove(i);
                qty--;
                break;
            }
        }
    }

    public void displayStore() {
        System.out.println("********* STORE *********");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
        System.out.println("**************************\n");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public int getNumberItemsInStore() {
        return itemsInStore.size();
    }
}
