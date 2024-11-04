
public class HotelReservationSystem {

    public static void main(String[] args) {
        HotelModel model = new HotelModel();
        HotelView view = new HotelView();
        HotelController controller = new HotelController(model, view);

        view.setController(controller);

        view.start();
    }
}
