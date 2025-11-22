package hust.soict.dsai.aims.media;

public class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media( int id, String title) {
		this.title = title;
        this.id = id;
	}
    public Media( int id, String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
        this.id = id;
	}

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media)) return false;
        Media other = (Media) o;
        return this.title.equals(other.getTitle());
    }


}
