package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    
    }
    public Book(String title, String category,  float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author " + authorName + " is already in the list.");
        } else {
            authors.add(authorName);
            System.out.println("Author " + authorName + " added.");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed.");
        } else {
            System.out.println("Author " + authorName + " not found in the list.");
        }
    }


    public ArrayList<String> getAuthors() {
        return authors;
    }
    
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() +
               " - " + this.getCost() + "$";
    }
    
    
}
