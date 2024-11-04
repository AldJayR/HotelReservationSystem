
public class Reservation {

    private int id;
    private Room room;
    private Guest guest;

    public Reservation(int id, Room room, Guest guest) {
        this.id = id;
        this.room = room;
        this.guest = guest;
    }

    public int getId() {
        return this.id;
    }

    public Room getRoom() {
        return this.room;
    }

    public Guest getGuest() {
        return this.guest;
    }
}
