import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class ReservationSystem {
    private User user;

    public ReservationSystem(User user) {
        this.user = user;
    }

    public void showLoginForm() {
        System.out.println("Welcome to the Online Reservation System!");
        System.out.println("Please enter your username and password to login.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (user.authenticate(username, password)) {
            System.out.println("Login successful!");
            showReservationForm();
        } else {
            System.out.println("Invalid username or password. Exiting...");
        }
    }

    private void showReservationForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your basic details: ");
        String userDetails = scanner.nextLine();
        System.out.print("Enter the train number: ");
        int trainNumber = scanner.nextInt();
        // Get train name from the database based on train number
        String trainName = getTrainName(trainNumber);
        System.out.print("Enter the class type: ");
        String classType = scanner.next();
        System.out.print("Enter the date of journey: ");
        String dateOfJourney = scanner.next();
        System.out.print("Enter the source: ");
        String source = scanner.next();
        System.out.print("Enter the destination: ");
        String destination = scanner.next();

        // Save the reservation details in the central database
        saveReservationDetails(userDetails, trainNumber, trainName, classType, dateOfJourney, source, destination);

        System.out.println("Reservation successful! Thank you for using the Online Reservation System.");
    }

    private String getTrainName(int trainNumber) {
        // Retrieve the train name from the database based on train number
        // You can implement the database connectivity and query here
        // For simplicity, let's assume a static train name for demonstration
        return "Sample Train";
    }

    private void saveReservationDetails(String userDetails, int trainNumber, String trainName, String classType, String dateOfJourney, String source, String destination) {
        // Save the reservation details in the central database
        // You can implement the database connectivity and insert query here
        // For simplicity, let's assume the details are printed for demonstration
        System.out.println("\nReservation Details:");
        System.out.println("User Details: " + userDetails);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        User user = new User("username123", "password456");
        ReservationSystem reservationSystem = new ReservationSystem(user);
        reservationSystem.showLoginForm();
    }
}
