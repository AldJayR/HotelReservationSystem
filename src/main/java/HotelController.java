import java.util.List;
import java.util.ArrayList;

public class HotelController {

    private HotelModel model;
    private HotelView view;
    private Staff staff;

    public HotelController(HotelModel model, HotelView view) {
        this.model = model;
        this.view = view;
        this.staff = new Staff("Hotel Staff", "Receptionist");
        this.model.getNotifier().addObserver(this.staff);
    }

    public void showAvailableRooms(String roomType) {
        List<Room> availableRooms = model.getAvailableRooms(roomType);
        this.view.displayAvailableRooms(availableRooms);
    }

    public void makeReservation(String roomType, int roomIndex, Guest guest) {
        List<Room> availableRooms = model.getAvailableRooms(roomType);

        if (roomIndex >= 0 && roomIndex < availableRooms.size()) {
            Room selectedRoom = availableRooms.get(roomIndex);
            Reservation reservation = model.makeReservation(selectedRoom, guest);

            if (reservation != null) {
                view.displayMessage("Reservation successfully created!");
                model.getNotifier().notifyReservation();
            } else {
                view.displayMessage("Failed to create reservation.");
            }
        } else {
            view.displayMessage("Invalid room selection.");
        }
    }

    public void viewAllReservations() {
        List<Reservation> reservations = model.getAllReservations();
        view.displayReservations(reservations);
    }
}
