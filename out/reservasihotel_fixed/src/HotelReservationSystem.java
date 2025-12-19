package reservasihotel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HotelReservationSystem implements Reservable {
    private List<Room> rooms = new ArrayList<>(List.of(
        new StandardRoom(101),
        new DeluxeRoom(102),
        new SuiteRoom(103)
    ));
    private Set<Guest> guests = new HashSet<>(Set.of());
    private Map<Integer, Reservation> reservations = new ConcurrentHashMap<>();
    private Queue<Reservation> waitlist = new LinkedList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void makeReservation(Person guest, int roomNumber, String checkIn, String checkOut) {
        Optional<Room> roomOpt = rooms.stream()
                .filter(room -> room.getNumber() == roomNumber && room.isAvailable())
                .findFirst();

        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            room.setAvailable(false);
            Reservation reservation = new Reservation(room.getNumber(), guest, checkIn, checkOut);
            reservations.put(reservation.roomNumber(), reservation);
            System.out.println("Reservasi berhasil untuk kamar " + room.getNumber() + " (" + room.getRoomType() + ")");
        } else {
            System.out.println("Kamar penuh! Menambahkan ke daftar tunggu.");
            waitlist.add(new Reservation(roomNumber, guest, checkIn, checkOut));
        }
    }

    @Override
    public void cancelReservation(int roomNumber) {
        if (reservations.containsKey(roomNumber)) {
            reservations.remove(roomNumber);
            rooms.stream().filter(room -> room.getNumber() == roomNumber)
                  .findFirst().ifPresent(room -> room.setAvailable(true));
            System.out.println("Reservasi untuk kamar " + roomNumber + " telah dibatalkan.");

            if (!waitlist.isEmpty()) {
                Reservation nextReservation = waitlist.poll();
                reservations.put(nextReservation.roomNumber(), nextReservation);
                rooms.stream().filter(room -> room.getNumber() == nextReservation.roomNumber())
                      .findFirst().ifPresent(room -> room.setAvailable(false));
                System.out.println("Reservasi daftar tunggu dipindahkan ke kamar " + nextReservation.roomNumber());
            }
        } else {
            System.out.println("Tidak ada reservasi untuk kamar ini.");
        }
    }
        
    public void displayReservations() {
        showReservation show = new showReservation(reservations);
        show.showReservations();
    }
}