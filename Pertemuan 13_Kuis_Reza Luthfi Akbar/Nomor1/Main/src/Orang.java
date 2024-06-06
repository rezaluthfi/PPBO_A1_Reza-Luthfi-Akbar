public abstract class Orang {
    public enum JENIS_KELAMIN {
        LAKI_LAKI, PEREMPUAN
    }

    protected String nama;
    protected String tanggalLahir;
    protected JENIS_KELAMIN jenisKelamin;

    public Orang(String nama, String tanggalLahir, JENIS_KELAMIN jenisKelamin) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Tanggal Lahir: " + tanggalLahir + ", Jenis Kelamin: " + jenisKelamin;
    }
}
