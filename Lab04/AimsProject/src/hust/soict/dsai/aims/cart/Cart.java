package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public int qtyOrdered=0;
	public void addMedia(Media media) {
		if(qtyOrdered<=MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			qtyOrdered+=1;
			System.out.println("The disc " + media.getTitle() + " has been added!");
		}
		else if(qtyOrdered==MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			qtyOrdered+=1;
			System.out.println("The cart is almost full!");
		}
	}
	
	public void removeMedia(Media media) {
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered.get(i) == media) {
				for(int j=i;j<qtyOrdered;j++) {
					itemsOrdered.set(j, itemsOrdered.get(j + 1));
				}
				qtyOrdered-=1;
				System.out.println("The disc has been removed!");
				return;
			}
		}
		System.out.println("The disc isn't in the cart");
	}
	public float totalCost() {
		float sumCost=0f;
		for(int i=0;i<qtyOrdered;i++) {
			sumCost+=itemsOrdered.get(i).getCost();
		}
		return sumCost;
	}
	
	public void searchByID(int ID) { 
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered.get(i).getId()==ID) {
				System.out.printf("Found DVD: %-30s %-10.3f\n",itemsOrdered.get(i).getTitle(),itemsOrdered.get(i).getCost());
				return;
			}
		}
		System.out.println("Cannot find the DVD with id: " + ID);
	}
	

	public void searchByTitle(String title) { 
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.printf("Found DVD: %-30s %-10.3f\n",itemsOrdered.get(i).getTitle(),itemsOrdered.get(i).getCost());
				return;
			}
		}
		System.out.println("Cannot find the DVD with title: " + title);
	}


	public String toString(DigitalVideoDisc disc) {
		return "Title: " + disc.getTitle() + ", Category: " + disc.getCategory() + ", Director: " + disc.getDirector() + ", Length: " + disc.getLength() + ", Cost: " + disc.getCost() + " $";
	}



	public void display() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}
	
}