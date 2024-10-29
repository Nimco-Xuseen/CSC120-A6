import java.util.ArrayList;

public class House extends Building {
    private ArrayList<String> residents;
    private boolean hasDiningRoom;

    // House constructor that calls the Building constructor
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors); // Calling the Building constructor
        this.residents = new ArrayList<>(); // Initialize the ArrayList of residents
        this.hasDiningRoom = hasDiningRoom; // Set the dining room status
        System.out.println("You have built a house: 🏠");
    }

    // Accessor for dining room
    public boolean hasDiningRoom() {
        return hasDiningRoom;
    }

    // Accessor for number of residents
    public int nResidents() {
        return residents.size();
    }

    // Method to move someone in
    public void moveIn(String name) {
        residents.add(name);
    }

    // Method to move someone out
    public String moveOut(String name) {
        if (residents.remove(name)) {
            return name; // Return the name of the person who moved out
        }
        return null; // Person was not a resident
    }

    // Check if a person is a resident
    public boolean isResident(String person) {
        return residents.contains(person);
    }

    // Main method to test the House class
    public static void main(String[] args) {
        House myHouse = new House("My House", "123 Main St", 2, true);
        myHouse.moveIn("Alice");
        myHouse.moveIn("Bob");
        System.out.println("Residents: " + myHouse.nResidents()); // Output: Residents: 2
        System.out.println("Is Bob a resident? " + myHouse.isResident("Bob")); // Output: true
        System.out.println("Moved out: " + myHouse.moveOut("Alice")); // Output: Moved out: Alice
        System.out.println("Residents: " + myHouse.nResidents()); // Output: Residents: 1
    }
}
