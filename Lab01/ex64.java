import java.util.*;
public class ex64{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name of Month: ");
        String month = scanner.nextLine().trim(); 
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        scanner.close();
        int days;
        switch (month) {
        case "January", "Jan.", "Jan", "1":
            days = 31; break;
        case "February", "Feb.", "Feb", "2":
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days = 29; // Leap year
            } else {
                days = 28;
            }
            break;
        case "March", "Mar.", "Mar", "3":
            days = 31; break;
        case "April", "Apr.", "Apr", "4":
            days = 30; break;
        case "May", "5":
            days = 31; break;
        case "June", "6", "Jun":
            days = 30; break;
        case "July", "Jul", "7":
            days = 31; break;
        case "August", "Aug.", "Aug", "8":
            days = 31; break;
        case "September", "Sep.", "Sep", "9":
            days = 30; break;
        case "October", "Oct.", "Oct", "10":
            days = 31; break;
        case "November", "Nov.", "Nov", "11":
            days = 30; break;
        case "December", "Dec.", "Dec", "12":
            days = 31; break;
        default:
            System.out.println("Invalid month input!");
            return; 
    }
    System.out.println(month + " of " + year + " has " + days + " days!");
}
}