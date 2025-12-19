package reservasihotel;

public class DeluxeRoom extends Room {
    public DeluxeRoom(int number) {
        super(number);
    }
    @Override
    public String getRoomType() { return "Deluxe"; }
}