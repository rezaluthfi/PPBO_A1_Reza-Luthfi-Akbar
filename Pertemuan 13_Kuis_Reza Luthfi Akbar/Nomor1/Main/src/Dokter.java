import java.util.ArrayList;
import java.util.List;

public class Dokter extends Orang {
    private String idDokter;
    private String nomorSTR;
    private String spesialisasi;
    private List<Antrian> listAntrian;

    public Dokter(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin, String nomorSTR, String spesialisasi) {
        super(nama, tanggalLahir, jenisKelamin);
        this.nomorSTR = nomorSTR;
        this.spesialisasi = spesialisasi;
        this.listAntrian = new ArrayList<>();
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public String getNama() {
        return nama;
    }

    public void tambahAntrian(Antrian antrian) {
        listAntrian.add(antrian);
    }

    public List<Antrian> getListAntrian() {
        return listAntrian;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID Dokter: " + idDokter + ", Nomor STR: " + nomorSTR + ", Spesialisasi: " + spesialisasi;
    }
}
