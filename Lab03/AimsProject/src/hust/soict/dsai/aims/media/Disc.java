package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;
    public Disc( int id, String title, String category, String director, float cost) {
        super(id, title, category, cost);
        this.director = director;
    }
    public Disc( int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }


    
}
