public abstract class Room {
    protected double rate;
    protected boolean isAvailable;

    public Room(double rate) {
        this.rate = rate;
        this.isAvailable = true;  
    }

    public abstract String getRoomType();

    public double getRate() {
        return this.rate;
    }

    public void bookRoom() {
        if (this.isAvailable) {
            this.isAvailable = false;
        } else {
            System.out.println("This room has already been booked!");
        }
    }

    public void releaseRoom() {
        if (!this.isAvailable) {
            this.isAvailable = true;
        } else {
            System.out.println("This room has no current guest/s staying over.");
        }
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
}
