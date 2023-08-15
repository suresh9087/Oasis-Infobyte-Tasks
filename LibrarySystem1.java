import java.util.Scanner;

// Admin class represents the admin module
class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void addBook(String bookTitle) {
        // Logic to add a book to the library
        System.out.println("Book added: " + bookTitle);
    }

    public void deleteBook(String bookTitle) {
        // Logic to delete a book from the library
        System.out.println("Book deleted: " + bookTitle);
    }

    // Other admin functionalities can be added here
}

// User class represents the users of the library
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void browseBooks() {
        // Logic to browse available books
        System.out.println("Browsing books...");
    }

    public void searchBook(String bookTitle) {
        // Logic to search for a specific book
        System.out.println("Searching for book: " + bookTitle);
    }

    public void issueBook(String bookTitle) {
        // Logic to issue a book to the user
        System.out.println("Issuing book: " + bookTitle);
    }

    public void returnBook(String bookTitle) {
        // Logic to return a book to the library
        System.out.println("Returning book: " + bookTitle);
    }

    public void sendQuery(String query) {
        // Logic to send an email query
        System.out.println("Sending query: " + query);
    }

    // Other user functionalities can be added here
}

public class LibrarySystem1 {
    public static void main(String[] args) {
        // Creating an admin
        Admin admin = new Admin("admin", "password");

        // Creating a user
        User user = new User("John Doe", "john@example.com");

        // Perform admin login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        if (admin.login(adminUsername, adminPassword)) {
            // Admin logged in
            System.out.println("Admin logged in successfully!");

            // Perform admin actions
            admin.addBook("Book 1");
            admin.deleteBook("Book 2");
        } else {
            // Admin login failed
            System.out.println("Invalid admin credentials!");
        }

        // Perform user actions
        user.browseBooks();
        user.searchBook("Book 3");
        user.issueBook("Book 4");
        user.returnBook("Book 5");
        user.sendQuery("How to renew a book?");

        scanner.close();
    }
}
