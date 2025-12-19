package reservasihotel;  // Pastikan ini ada di baris pertama

public record Reservation(int roomNumber, Person guest, String checkInDate, String checkOutDate) {}
