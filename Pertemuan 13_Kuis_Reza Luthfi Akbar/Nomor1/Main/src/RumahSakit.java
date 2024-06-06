import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> listDokter;
    private List<Antrian> listAntrianPasien;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrianPasien = new ArrayList<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (!listDokter.contains(dokter)) {
            dokter.setIdDokter(String.valueOf(listDokter.size() + 1));
            listDokter.add(dokter);
            System.out.println("SUKSES");
        } else {
            System.out.println("DOKTER SUDAH TERDAFTAR");
        }
    }

    public void cekListDokter() {
        if (listDokter.isEmpty()) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
        } else {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            System.out.println("============================================");
            for (Dokter dokter : listDokter) {
                System.out.println("Nama Dokter : " + dokter.getNama() + ", Dokter spesialis : " + dokter.getSpesialisasi());
            }
        }
    }

    public void tambahAntrian(Antrian antrian) {
        listAntrianPasien.add(antrian);
    }

    public void cekAntrianPasien() {
        System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
        System.out.println("============================================");
        for (Dokter dokter : listDokter) {
            System.out.println("DR. " + dokter.getNama().toUpperCase());
            if (dokter.getListAntrian().isEmpty()) {
                System.out.println("ANTRIAN KOSONG");
                System.out.println("=================");
            } else {
                for (Antrian antrian : dokter.getListAntrian()) {
                    System.out.println(antrian);
                }
                System.out.println("=================");
            }
        }
    }

    public boolean selesaikanAntrian(Antrian antrian) {
        if (listAntrianPasien.contains(antrian)) {
            listAntrianPasien.remove(antrian);
            antrian.getDokter().getListAntrian().remove(antrian);
            return true;
        }
        return false;
    }

    public Dokter getDokterByName(String nama) {
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equalsIgnoreCase(nama)) {
                return dokter;
            }
        }
        return null;
    }

    public boolean isPasienTerdaftar(Pasien pasien) {
        for (Antrian antrian : listAntrianPasien) {
            if (antrian.getPasien().equals(pasien)) {
                return true;
            }
        }
        return false;
    }
}
