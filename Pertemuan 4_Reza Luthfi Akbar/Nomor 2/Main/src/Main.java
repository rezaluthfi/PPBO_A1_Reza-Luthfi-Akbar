public class Main {
    public static void main(String[] args) {

        MovieApp movieApp = new MovieApp();

        //Add film
        Film avenger = new Film("Avengers: Endgame", "Action", 180, 50);
        Film joker = new Film("Joker", "Drama", 122, 60);
        movieApp.addFilm(avenger);
        movieApp.addFilm(joker);

        //Menampilkan semua list film
        movieApp.displayAllFilms();

        //Search film
        System.out.println();
        System.out.println("-----CEK KETERSEDIAAN FILM-----");
        movieApp.searchFilm("Joker");
        movieApp.searchFilm("Dune");

        //Membuat pesanan/book film
        //Judul film harus sama
        System.out.println();
        System.out.println("-----BOOKING FILM-----");
        movieApp.bookFilm("Joker", 2);
        movieApp.bookFilm("Avengers: Endgame", 100);
        movieApp.displayAllFilms();

        //Cek pesanan/search booking by booking id
        System.out.println();
        System.out.println("-----SEARCH BOOKING ID-----");
        movieApp.searchBooking(1);
        movieApp.searchBooking(000);

    }
}