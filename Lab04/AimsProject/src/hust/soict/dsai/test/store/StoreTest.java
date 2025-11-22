package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Tạo vài đĩa mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 29.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f);

        // Thêm vào store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Xóa 1 DVD
        store.removeDVD(dvd2);

        System.out.println("Store update completed!");
    }
}

