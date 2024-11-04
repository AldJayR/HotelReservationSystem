
public class Staff implements Observer {
    String name;
    String position;
    
    public Staff(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    @Override
    public void update(String update) {
        System.out.println(update);
    }
}
