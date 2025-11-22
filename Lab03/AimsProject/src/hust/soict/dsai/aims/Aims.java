package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Aims {
    public static void main(String[] args) {
        
        ArrayList<Media> mediaList = new ArrayList<Media>();

        mediaList.add(new Book(1, "Harry Potter", "Fantasy", 50.5f));
        mediaList.add(new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Christopher Nolan", 148, 20.0f));
        mediaList.add(new CompactDisc(3, "Thriller", "Pop", "Michael Jackson", "9", 15.0f));

        
        
       
       //print total cost of the items in the cart
		System.out.print("Total cost is: ");
        Cart cart = new Cart();
        for (Media media : mediaList) {
            cart.addMedia(media);
        }
        System.out.printf("%.2f$\n", cart.totalCost());

		
        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
        
    }
    
}
