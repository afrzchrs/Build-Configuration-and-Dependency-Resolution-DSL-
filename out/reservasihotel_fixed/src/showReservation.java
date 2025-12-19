package reservasihotel;

import java.util.Map;

public class showReservation {
    private Map<Integer, Reservation> reservations;

    // Constructor untuk menerima data reservasi dari HotelReservationSystem
    public showReservation(Map<Integer, Reservation> reservations) {
        this.reservations = reservations;
    }

    // Metode untuk menampilkan daftar reservasi
    public void showReservations() {
        System.out.println("Daftar Reservasi:");
        reservations.values().forEach(res -> System.out.println(
            "Kamar " + res.roomNumber() + ", Tamu: " + res.guest().getName() +
            ", Check-in: " + res.checkInDate() + ", Check-out: " + res.checkOutDate()
        ));
    }
}
