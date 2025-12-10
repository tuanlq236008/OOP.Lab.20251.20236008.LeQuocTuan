package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive!"); // Xuất thông báo lỗi ra console
            throw new PlayerException("ERROR: DVD length is non-positive!"); // Ném PlayerException
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD Length: " + this.getLength());
    }
    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() +
            " - " + this.getDirector() + " - " + this.getLength() +
            ": " + this.getCost() + "$";
    }


}