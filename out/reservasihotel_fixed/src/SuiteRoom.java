package reservasihotel;

public class SuiteRoom extends Room {
    public SuiteRoom(int number) {
        super(number);
    }
    @Override
    public String getRoomType() { return "Suite"; }
}