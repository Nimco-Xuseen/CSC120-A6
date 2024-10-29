import java.util.Hashtable;

public class Library extends Building {
    private Hashtable<String, Boolean> collection;

    // Constructor for Library, must call the Building constructor
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors); // Call to the Building constructor
        this.collection = new Hashtable<>(); // Initialize the Hashtable for the collection
    }

    public void addTitle(String title) {
        collection.put(title, true); // Adding the book as available
    }

    public String removeTitle(String title) {
        if (collection.remove(title) != null) {
            return title; // Return the title that was removed
        }
        return null; // Title not found
    }

    public void checkOut(String title) {
        if (containsTitle(title)) {
            collection.replace(title, false); // Mark the book as checked out
        }
    }

    public void returnBook(String title) {
        if (containsTitle(title)) {
            collection.replace(title, true); // Mark the book as available
        }
    }

    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    public boolean isAvailable(String title) {
        return collection.getOrDefault(title, false); // Returns true if the title is available
    }

    public void printCollection() {
        for (String title : collection.keySet()) {
            System.out.println(title + " - " + (collection.get(title) ? "Available" : "Checked Out"));
        }
    }

    public static void main(String[] args) {
        Library myLibrary = new Library("City Library", "456 Book St", 3);
        myLibrary.addTitle("The Lorax by Dr. Seuss");
        myLibrary.addTitle("1984 by George Orwell");
        myLibrary.printCollection(); // Print all titles

        myLibrary.checkOut("1984 by George Orwell");
        myLibrary.printCollection(); // Print updated status

        myLibrary.returnBook("1984 by George Orwell");
        myLibrary.printCollection(); // Print status after returning the book
    }
}
