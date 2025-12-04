package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title) {
        this.title = title;

    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;

    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media))
            return false;
        Media other = (Media) o;
        return this.title.equals(other.getTitle());
    }

    @Override
    public String toString() {
        return "Media: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }

    @Override
    public int compareTo(Media other) {
        return this.title.compareTo(other.getTitle());
    }
}
