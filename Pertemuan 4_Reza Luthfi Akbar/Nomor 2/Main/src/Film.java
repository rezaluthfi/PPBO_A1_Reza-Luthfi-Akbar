public class Film {
    String judulFilm;
    String genreFilm;
    int durationFilm;
    int availableSeatsFilm;

    Film(String title, String genre, int duration, int availableSeats) {
        judulFilm = title;
        genreFilm = genre;
        durationFilm = duration;
        availableSeatsFilm = availableSeats;
    }

    String getJudulFilm() {
        return judulFilm;
    }

}
