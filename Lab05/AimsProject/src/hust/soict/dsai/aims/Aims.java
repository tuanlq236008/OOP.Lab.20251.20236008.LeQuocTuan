package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> viewStoreMenu();
                case 2 -> updateStoreMenu();
                case 3 -> cart.showCartMenu(scanner);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void viewStoreMenu() {
        int option;
        do {
            store.displayStore();
            storeMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> cart.showCartMenu(scanner);
                case 0 -> {}
                default -> System.out.println("Invalid choice.");
            }
        } while (option != 0);
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> cart.addMedia(media);
                case 2 -> {
                    if (media instanceof Playable playable) {
                        playable.play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                }
                case 0 -> {}
                default -> System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            if (media instanceof Playable playable) {
                playable.play();
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStoreMenu() {
        int option = -1;
    
        do {
            System.out.println("Update Store Options:");
            System.out.println("1. Add media");
            System.out.println("2. Remove media by title");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("Select media type:");
                        System.out.println("1. Digital Video Disc");
                        System.out.println("2. Book");
                        System.out.println("3. Compact Disc");
                        int type = Integer.parseInt(scanner.nextLine());
    
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Cost: ");
                        float cost = Float.parseFloat(scanner.nextLine());
    
                        Media media = null;
    
                        if (type == 1) {
                            System.out.print("Director: ");
                            String director = scanner.nextLine();
                            System.out.print("Length: ");
                            int length = Integer.parseInt(scanner.nextLine());
    
                            media = new DigitalVideoDisc(title, category, director, length, cost);
                        } else if (type == 2) {
                            media = new Book(title, category, cost);
                            System.out.print("Number of authors: ");
                            int numAuthors = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < numAuthors; i++) {
                                System.out.print("Author " + (i + 1) + ": ");
                                ((Book) media).addAuthor(scanner.nextLine());
                            }
                        } else if (type == 3) {
                            System.out.print("Director: ");
                            String director = scanner.nextLine();
                            System.out.print("Artist: ");
                            String artist = scanner.nextLine();
                            media = new CompactDisc(title, category, director, artist, cost);
    
                            System.out.print("Number of tracks: ");
                            int numTracks = Integer.parseInt(scanner.nextLine());
                            for (int i = 0; i < numTracks; i++) {
                                System.out.print("Track " + (i + 1) + " title: ");
                                String trackTitle = scanner.nextLine();
                                System.out.print("Track " + (i + 1) + " length: ");
                                int trackLength = Integer.parseInt(scanner.nextLine());
                                ((CompactDisc) media).addTrack(new Track(trackTitle, trackLength));
                            }
                        } else {
                            System.out.println("Invalid media type!");
                        }
    
                        if (media != null) {
                            store.addMedia(media);
                            System.out.println("Media added to store.");
                        }
    
                        break;
                    case 2:
                        System.out.print("Enter title of media to remove: ");
                        String removeTitle = scanner.nextLine();
                        Media toRemove = store.searchByTitle(removeTitle);
                        if (toRemove != null) {
                            store.removeMedia(toRemove);
                            System.out.println("Media removed from store.");
                        } else {
                            System.out.println("Media not found.");
                        }
                        break;
                    case 0:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        } while (option != 0);
    }
}