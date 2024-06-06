import java.util.HashMap;
import java.util.Map;

public class Antrian {
    public enum tipePasiens {
        BPJS, MANDIRI
    }

    private static int globalCounter = 1;
    private static Map<String, Integer> counterBySpecialty = new HashMap<>();

    private String nomorAntrian;
    private Pasien pasien;
    private Dokter dokter;
    private String keluhan;
    private tipePasiens tipePasien;

    public Antrian(Dokter dokter, Pasien pasien, String keluhan, tipePasiens tipePasien) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.keluhan = keluhan;
        this.tipePasien = tipePasien;

        String specialty = dokter.getSpesialisasi().toUpperCase().replace(" ", "_");
        int specialtyCounter = counterBySpecialty.getOrDefault(specialty, 0) + 1;
        counterBySpecialty.put(specialty, specialtyCounter);

        this.nomorAntrian = "D_" + specialty + "_" + dokter.getIdDokter() + "_" + globalCounter++;
    }

    public Dokter getDokter() {
        return dokter;
    }

    @Override
    public String toString() {
        return "ID ANTRIAN: " + nomorAntrian + ", Atas nama : " + pasien.getNama();
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }
}
