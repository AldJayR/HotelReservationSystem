
import java.util.Scanner;
import java.util.List;

public class HotelView {

    private Scanner scanner;
    private HotelController controller;

    public HotelView() {
        this.scanner = new Scanner(System.in);
    }

    public void setController(HotelController controller) {
        this.controller = controller;
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    handleMakeReservation();
                    break;
                case 2:
                    this.controller.viewAllReservations();
                    break;
                case 3:
                    handleViewAvailableRooms();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n=== Hotel Reservation System ===");
        System.out.println("1. Make a reservation");
        System.out.println("2. View all reservations");
        System.out.println("3. View available rooms");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getMenuChoice() {
        while (true) {
            try {
                return Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
        }

    }

    private void handleMakeReservation() {
        displayRoomTypes();
        int roomChoice = getMenuChoice();
        String roomType = getRoomTypeFromChoice(roomChoice);

        if (roomType == null) {
            System.out.println("Invalid room type selection.");
            return;
        }

        controller.showAvailableRooms(roomType);
        System.out.print("Select room number (or 0 to cancel): ");
        int roomNumber = getMenuChoice();

        if (roomNumber == 0) {
            return;
        }

        Guest guest = getGuestInfo();
        controller.makeReservation(roomType, roomNumber - 1, guest);
    }

    private void handleViewAvailableRooms() {
        displayRoomTypes();
        int choice = getMenuChoice();
        String roomType = getRoomTypeFromChoice(choice);

        if (roomType != null) {
            controller.showAvailableRooms(roomType);
        } else {
            System.out.println("Invalid room type selection.");
        }
    }

    private String getRoomTypeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "single room";
            case 2:
                return "double room";
            case 3:
                return "suite room";
            default:
                return null;
        }
    }

    private void displayRoomTypes() {
        System.out.println("\nAvailable Room Types:");
        System.out.println("1. Single Room");
        System.out.println("2. Double Room");
        System.out.println("3. Suite Room");
        System.out.print("Enter room type (1-3): ");
    }

    private Guest getGuestInfo() {
        System.out.println("\nEnter guest details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Contact number: ");
        String contact = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        return new Guest(name, contact, email);
    }

     void displayAvailableRooms(List<Room> rooms) {
        if (rooms.isEmpty()) {
            System.out.println("No available rooms of this type.");
            return;
        }
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.printf("%d. %s - Rate: P%.2f%n",
                    i + 1, room.getRoomType(), room.getRate());
        }
    }
    
    void displayReservations(List<Reservation> reservations) {
        if (reservations.isEmpty()) {
            System.out.println("\nNo current reservations.");
            return;
        }
        System.out.println("\n=== Current Reservations ===");
        for (Reservation reservation : reservations) {
            System.out.printf("Reservation ID: %d%n", reservation.getId());
            System.out.printf("Guest: %s%n", reservation.getGuest().getName());
            System.out.printf("Room Type: %s%n", reservation.getRoom().getRoomType());
            System.out.printf("Rate: P%.2f%n", reservation.getRoom().getRate());
            System.out.println("------------------------");
        }
    }

    void displayMessage(String message) {
        System.out.println(message);
    }
}
