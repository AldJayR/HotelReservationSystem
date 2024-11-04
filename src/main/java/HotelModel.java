import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HotelModel {

    private ReservationManager reservationManager;
    private RoomFactory roomFactory;
    private ReservationNotifier notifier;
    private List<Room> allRooms;

    public HotelModel() {
        this.reservationManager = ReservationManager.getInstance();
        this.roomFactory = new RoomFactory();
        this.notifier = new ReservationNotifier();
        this.allRooms = new ArrayList<>();
        initializeRooms();
    }
    
    private void initializeRooms() {
        for (int i = 0; i < 5; i++) {
            allRooms.add(roomFactory.createRoom("single room"));
            allRooms.add(roomFactory.createRoom("double room"));
            allRooms.add(roomFactory.createRoom("suite room"));
        }
    }
    
    public List<Room> getAvailableRooms(String roomType) {
        return allRooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable())
                .collect(Collectors.toList());
    }
    
    public Reservation makeReservation(Room room, Guest guest) {
        return reservationManager.makeReservation(
            reservationManager.getReservations().size() + 1, room, guest);
    }
    
    public List<Reservation> getAllReservations() {
        return reservationManager.getReservations();
    }

    public ReservationNotifier getNotifier() {
        return notifier;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

}
