/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    // Constructor for Cafe, must call the Building constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); // Call to the Building constructor
        this.nCoffeeOunces = nCoffeeOunces; // Initialize coffee ounces
        this.nSugarPackets = nSugarPackets; // Initialize sugar packets
        this.nCreams = nCreams; // Initialize creams
        this.nCups = nCups; // Initialize cups
    }

    // Method to sell coffee
    public void sellCoffee(int size, int nSugarPacketsSold, int nCreamsSold) {
        if (nCoffeeOunces >= size && nSugarPackets >= nSugarPacketsSold && nCreams >= nCreamsSold && nCups > 0) {
            nCoffeeOunces -= size; // Decrease coffee inventory
            nSugarPackets -= nSugarPacketsSold; // Decrease sugar packets inventory
            nCreams -= nCreamsSold; // Decrease cream inventory
            nCups--; // Decrease cups inventory
        } else {
            restock(size, nSugarPacketsSold, nCreamsSold, 1); // Restock if not enough ingredients
        }
    }

    // Private method to restock inventory
    private void restock(int nCoffeeOuncesRestock, int nSugarPacketsRestock, int nCreamsRestock, int nCupsRestock) {
        nCoffeeOunces += nCoffeeOuncesRestock;
        nSugarPackets += nSugarPacketsRestock;
        nCreams += nCreamsRestock;
        nCups += nCupsRestock;
    }

    // Main method to test the Cafe class
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "789 Coffee Ave", 1, 100, 50, 30, 20);
        myCafe.sellCoffee(12, 2, 3); // Attempt to sell a cup of coffee
        System.out.println("Coffee ounces remaining: " + myCafe.nCoffeeOunces);
        System.out.println("Sugar packets remaining: " + myCafe.nSugarPackets);
        System.out.println("Creams remaining: " + myCafe.nCreams);
        System.out.println("Cups remaining: " + myCafe.nCups);
    }
}
