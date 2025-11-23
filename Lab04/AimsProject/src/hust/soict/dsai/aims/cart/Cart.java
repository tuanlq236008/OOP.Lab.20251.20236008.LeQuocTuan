package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
	
	public void searchByID(int id) { 
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered.get(i).getId()==id) {
				System.out.printf("Found DVD: %-30s %-10.3f\n",itemsOrdered.get(i).getTitle(),itemsOrdered.get(i).getCost());
				return;
			}
		}
		System.out.println("Cannot find the DVD with id: " + id);
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

	public void sortByTitleCost() {
    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
}

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}


	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}
	public void showCartMenu(Scanner sc) {
    int option = -1;

    do {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");

        try {
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Order placed successfully!");
                    itemsOrdered.clear();
                    qtyOrdered = 0;
                    break;
                case 0:
                    System.out.println("Going back...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter 0 to 5.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }

    } while (option != 0);
}
}