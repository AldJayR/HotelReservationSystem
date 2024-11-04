
public class SingleRoom extends Room {
   public SingleRoom(double rate) {
       super(rate);
   }
   
   @Override
   public String getRoomType() {
       return "Single Room";
   }
}
