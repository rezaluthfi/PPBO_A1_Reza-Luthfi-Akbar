public class Booking {

    int bookingId;
    String judulFilm;
    int jmlTickets;

    Booking(int bookingId, String judulFilm, int jmlTickets) {
        this.bookingId = bookingId;
        this.judulFilm = judulFilm;
        this.jmlTickets = jmlTickets;
    }

    int getBookingId() {
        return bookingId;
    }

}
