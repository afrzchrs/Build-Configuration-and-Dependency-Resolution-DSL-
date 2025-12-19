package reservasihotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);
        
        system.addRoom(new StandardRoom(101));
        system.addRoom(new DeluxeRoom(102));
        system.addRoom(new SuiteRoom(103));
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Buat Reservasi");
            System.out.println("2. Batalkan Reservasi");
            System.out.println("3. Tampilkan Reservasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama tamu: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan email tamu: ");
                    String email = scanner.nextLine();
                    System.out.print("Masukkan nomor kamar: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan tanggal check-in (YYYY-MM-DD): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Masukkan tanggal check-out (YYYY-MM-DD): ");
                    String checkOut = scanner.nextLine();
                    
                    Person guest = new Guest(name, email);
                    system.makeReservation(guest, roomNumber, checkIn, checkOut);
                    break;
                
                case 2:
                    System.out.print("Masukkan nomor kamar yang akan dibatalkan: ");
                    int cancelRoom = scanner.nextInt();
                    scanner.nextLine();
                    system.cancelReservation(cancelRoom);
                    break;
                
                case 3:
                    system.displayReservations();;
                    break;
                
                case 4:
                    System.out.println("Keluar dari sistem reservasi.");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}