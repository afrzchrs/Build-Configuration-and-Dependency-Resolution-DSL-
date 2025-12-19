// File: model/Room.java
package reservasihotel;

public abstract class Room {
    protected int number;
    protected boolean isAvailable = true;

    public Room(int number) {
        this.number = number;
    }

    public int getNumber() { return number; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public abstract String getRoomType();
}
