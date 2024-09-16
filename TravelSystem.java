import java.util.ArrayList;
import java.util.Scanner;

// Class for managing bookings
class TravelBooking {
    private String serviceName;
    private String bookingDetails;

    public TravelBooking(String serviceName, String bookingDetails) {
        this.serviceName = serviceName;
        this.bookingDetails = bookingDetails;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public void displayBooking() {
        System.out.println("Service: " + serviceName);
        System.out.println("Details: " + bookingDetails);
    }
}

// Main class
public class TravelSystem {
    private static ArrayList<TravelBooking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Travel Booking System ---");
            System.out.println("1. Book a Flight");
            System.out.println("2. Book a Hotel");
            System.out.println("3. Book Transportation");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    bookFlight(scanner);
                    break;
                case 2:
                    bookHotel(scanner);
                    break;
                case 3:
                    bookTransportation(scanner);
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method to book a flight
    public static void bookFlight(Scanner scanner) {
        System.out.print("Enter flight details (e.g., Flight number, Date): ");
        String flightDetails = scanner.nextLine();
        bookings.add(new TravelBooking("Flight", flightDetails));
        System.out.println("Flight booked successfully!");
    }

    // Method to book a hotel
    public static void bookHotel(Scanner scanner) {
        System.out.print("Enter hotel details (e.g., Hotel name, Check-in date): ");
        String hotelDetails = scanner.nextLine();
        bookings.add(new TravelBooking("Hotel", hotelDetails));
        System.out.println("Hotel booked successfully!");
    }

    // Method to book transportation
    public static void bookTransportation(Scanner scanner) {
        System.out.print("Enter transportation details (e.g., Vehicle type, Date): ");
        String transportationDetails = scanner.nextLine();
        bookings.add(new TravelBooking("Transportation", transportationDetails));
        System.out.println("Transportation booked successfully!");
    }

    // Method to view all bookings
    public static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("\n----- Your Bookings -----");
            for (TravelBooking booking : bookings) {
                booking.displayBooking();
                System.out.println();
            }
        }
    }
}
