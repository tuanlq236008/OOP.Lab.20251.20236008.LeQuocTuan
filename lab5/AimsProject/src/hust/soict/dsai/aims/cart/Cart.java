package hust.soict.dsai.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.remove(media)) {
			System.out.println("The disc has been removed");
		} else {
			System.out.println("Cannot find the disc in the cart");
		}
	}

	public float totalCost() {
		float total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}

	public void searchById(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found media: " + media);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No media found with ID: " + id);
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Found media: " + media);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No media found with title: " + title);
		}
	}

	public String toString(DigitalVideoDisc disc) {
		return "Title: " + disc.getTitle() + ", Category: " + disc.getCategory() + ", Director: " + disc.getDirector()
				+ ", Length: " + disc.getLength() + ", Cost: " + disc.getCost() + " $";
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
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
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