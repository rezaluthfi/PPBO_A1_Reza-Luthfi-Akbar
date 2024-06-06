public class Pasien extends Orang {
    private String pekerjaan;
    private String domisili;
    private Antrian antrian;

    public Pasien(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin, String pekerjaan, String domisili) {
        super(nama, tanggalLahir, jenisKelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }



    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        Dokter dokter = rumahSakit.getDokterByName(namaDokter);
        if (rumahSakit.isPasienTerdaftar(this)) {
            System.out.println("PASIEN SUDAH TERDAFTAR");
            return;
        }
        if (dokter != null) {
            this.antrian = new Antrian(dokter, this, keluhan, tipePasien);
            rumahSakit.tambahAntrian(antrian);
            dokter.tambahAntrian(antrian);
            System.out.println("SUKSES");
        } else {
            System.out.println("DOKTER TERSEBUT TIDAK TERSEDIA");
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        if (!rumahSakit.isPasienTerdaftar(this)) {
            System.out.println("BELUM DAFTAR");
            return;
        }
        if (rumahSakit.selesaikanAntrian(antrian)) {
            System.out.println("SUKSES");
        } else {
            System.out.println("BELUM SAATNYA DIPERIKSA");
        }
    }
}
