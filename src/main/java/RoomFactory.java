
public class RoomFactory {

    public Room createRoom(String roomType) {
        if (roomType.equalsIgnoreCase("single room")) {
            return new SingleRoom(1500);
        } else if (roomType.equalsIgnoreCase("double room")) {
            return new DoubleRoom(2800);
        } else if (roomType.equalsIgnoreCase("suite room")) {
            return new SuiteRoom(7500);
        }

        throw new IllegalArgumentException("Invalid room type");
    }
}
