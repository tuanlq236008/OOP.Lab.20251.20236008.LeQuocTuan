package hust.soict.dsai.aims.media;
import java.util.Comparator;
public class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media( String title) {
		this.title = title;
       
	}
    public Media( String title, String category, float cost) {
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
        if (!(o instanceof Media)) return false;
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
        // Hợp đồng của Comparable.compareTo() nói rằng nó nên ném NullPointerException
        // nếu đối tượng được chỉ định là null.
        if (other == null) {
            throw new NullPointerException("Cannot compare Media with a null object.");
        }

        // So sánh theo tiêu đề (title) trước
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison; // Nếu tiêu đề khác nhau, trả về kết quả so sánh tiêu đề
        }

        // Nếu tiêu đề giống nhau, so sánh theo chi phí (cost)
        // Float.compare(float1, float2) trả về:
        // - số âm nếu float1 < float2
        // - 0 nếu float1 == float2
        // - số dương nếu float1 > float2
        return Float.compare(this.cost, other.cost);
    }
}
