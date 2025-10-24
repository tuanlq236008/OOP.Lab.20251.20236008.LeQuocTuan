package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
    private int qty = 0;
    public void addDVD(DigitalVideoDisc dvd) { itemsInStore[qty++] = dvd; }
    public void removeDVD(DigitalVideoDisc dvd) { 
        for (int i = 0; i < qty; i++) {
            if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {
                for (int j = i; j < qty - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qty] = null;
                break;
            }
        }
    }
}
