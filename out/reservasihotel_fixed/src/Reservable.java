package reservasihotel;

public interface Reservable {
    void makeReservation(Person guest, int roomNumber, String checkIn, String checkOut);
    void cancelReservation(int roomNumber);
}
