package reservasihotel;

public class StandardRoom extends Room {
    public StandardRoom(int number) {
        super(number);
    }
    @Override
    public String getRoomType() { return "Standard"; }
}