
import java.lang.*;
import java.util.*;

public class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    public Customer (String name){
        this.name = name;
    };

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName (){
        return name;
    };

    public String statement() {
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder builder = new StringBuilder();
        builder.append("Rental Record for ").append(this.getName()).append("\n");
        builder.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            //determine amounts for each line
            double amount = rental.getCharge();
            builder.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(amount).append("\n");
        }
        //add footer lines
        builder.append("Amount owed is ").append(getTotalCharge()).append("\n");
        builder.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return builder.toString();
    }


    private double getTotalCharge() {
        double charge = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            charge += rental.getCharge();
        }
        return charge;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            points += rental.getFrequentRenterPoints();
        }
        return points;
    }

}
    