
import java.util.List;
import java.util.ArrayList;

public class ReservationManager {

    private static ReservationManager uniqueInstance = null;
    List<Reservation> reservations;
    private int reservationIdCounter;

    private ReservationManager() {
        this.reservations = new ArrayList<>();
        this.reservationIdCounter = 0;
    }

    public static ReservationManager getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ReservationManager();
        }

        return uniqueInstance;
    }

    public Reservation makeReservation(int id, Room room, Guest guest) {
        if (room.isAvailable()) {
            reservationIdCounter++;
            Reservation reservation = new Reservation(id, room, guest);
            reservations.add(reservation);
            room.bookRoom();
            return reservation;
        }

        return null;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    public List<Room> getAvailableRooms(String roomType) {
        List<Room> availableRooms = new ArrayList<>();

        for (Reservation r : reservations) {
            Room reservedRoom = r.getRoom();

            if (reservedRoom.getRoomType().equalsIgnoreCase(roomType) && reservedRoom.isAvailable()) {
                availableRooms.add(reservedRoom);
            }

        }
        return availableRooms;
    }
}
