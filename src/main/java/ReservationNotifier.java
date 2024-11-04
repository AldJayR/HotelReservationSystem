import java.util.List;
import java.util.ArrayList;

public class ReservationNotifier implements NotificationService {
    List<Observer> observers;
    
    public ReservationNotifier() {
        this.observers = new ArrayList<>();
    }
    
    public void addObserver(Observer observer) {
       this.observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
    
    @Override
    public void notifyReservation() {
        for (Observer observer : this.observers) {
            observer.update("Room successfully reserved");
        }
    }
    
    @Override
    public void notifyCancellation() {
        for (Observer observer : this.observers) {
            observer.update("Room canceled");
        }
    }
}
