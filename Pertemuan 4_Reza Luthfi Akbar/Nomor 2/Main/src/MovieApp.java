import java.util.ArrayList;

public class MovieApp {

    ArrayList<Film> listFilm;
    ArrayList<Booking> listBooking;
    int nextBookingId;

    MovieApp() {
        listFilm = new ArrayList<Film>();
        listBooking = new ArrayList<Booking>();
        nextBookingId = 1;
    }

    void addFilm(Film film) {
        listFilm.add(film);
    }

    void displayAllFilms() {
        System.out.println("List of Films:");
        for (Film film : this.listFilm) {
            System.out.println(film.judulFilm + " - " + film.genreFilm +
                    " - " + "Duration: " + film.durationFilm +
                    " mins" + " - " + "Available Seats: " + film.availableSeatsFilm);
        }
    }

    void searchFilm(String title) {
        boolean filmTersedia = false;
        for (Film film : listFilm) {
            if (film.getJudulFilm().equals(title)) {
                filmTersedia = true;
                break;
            }
        }
        if (filmTersedia) {
            System.out.println("Film Tersedia");
        } else {
            System.out.println("Film Tidak Tersedia");
        }
    }

    void bookFilm (String title, int numberOfTickets) {
        for (Film film : listFilm) {
            if (film.getJudulFilm().equals(title)) {
                if (film.availableSeatsFilm >= numberOfTickets) {
                    film.availableSeatsFilm -= numberOfTickets;
                    listBooking.add(new Booking(nextBookingId, title, numberOfTickets));
                    System.out.println("Pesanan berhasil dengan detail pesanan:");
                    System.out.println("Film: " + film.getJudulFilm());
                    System.out.println("Jumlah Tiket: " + numberOfTickets);
                    System.out.println("Booking ID: " + nextBookingId);
                    nextBookingId++;
                } else {
                    System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
                }
                return;
            }
        }
        System.out.println("Film tidak tersedia");
    }

    void searchBooking(int bookingId) {
        for (Booking booking : listBooking) {
            if (booking.getBookingId() == bookingId) {
                System.out.println("Pesanan Ditemukan");
                return;
            }
        }
        System.out.println("Pesanan Tidak Ditemukan");
    }

}
