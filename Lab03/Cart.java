public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	public int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered<=MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered]=disc;
			qtyOrdered+=1;
			System.out.println("The disc " + disc.getTitle() + " has been added!");
		}
		else if(qtyOrdered==MAX_NUMBER_ORDERED+1) {
			itemsOrdered[qtyOrdered]=disc;
			qtyOrdered+=1;
			System.out.println("The cart is almost full!");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... Discs) {
        for(DigitalVideoDisc Disc : Discs) {
            addDigitalVideoDisc(Disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered[i]==disc) {
				for(int j=i;j<qtyOrdered;j++) {
					itemsOrdered[j]=itemsOrdered[j+1];
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
			sumCost+=itemsOrdered[i].getCost();
		}
		return sumCost;
	}
	
	public void display() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.printf("%-10d %-30s %-10.3f\n",i+1,itemsOrdered[i].getTitle(),itemsOrdered[i].getCost());
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}
	
}