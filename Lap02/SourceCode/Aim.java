public class Aim {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc d2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc d3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc d4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 29.99f);
        DigitalVideoDisc d5 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 22.50f);
        DigitalVideoDisc d6 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f);
        anOrder.addDigitalVideoDisc(d1);
        anOrder.addDigitalVideoDisc(d2, d3);
        anOrder.addDigitalVideoDisc(d4, d5, d6);
        anOrder.display();
       
       //print total cost of the items in the cart
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(d2);
       

    }
    
}
