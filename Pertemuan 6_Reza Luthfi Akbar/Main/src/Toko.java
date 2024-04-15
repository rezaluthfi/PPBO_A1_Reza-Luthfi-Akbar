import java.util.ArrayList;

public class Toko {

    private ArrayList<Pembeli> antrian;
    private Gudang gudangBarang;

    public enum tipeBarang {
        MEJA,
        KURSI,
        LEMARI
    }

    public ArrayList<Pembeli> getAntrian() {
        return antrian;
    }

    public void setAntrian(ArrayList<Pembeli> antrian) {
        this.antrian = antrian;
    }

    public Gudang getGudangBarang() {
        return gudangBarang;
    }

    public void setGudangBarang(Gudang gudangBarang) {
        this.gudangBarang = gudangBarang;
    }

    public Toko() {
        gudangBarang = new Gudang();
    }

    public void tambahAntrian(Pembeli pembeli) {
        if (antrian == null) {
            antrian = new ArrayList<>();
        }
        if (!antrianPenuh()) {
            antrian.add(pembeli);
            System.out.println("Berhasil menambah antrian");
        } else {
            System.out.println("Antrian penuh");
        }
    }

    public void selesaikanAntrian() {
        if (!getAntrian().isEmpty()) {
            if (barangDibeliTersedia()) {
                getGudangBarang().keluarkanBarangDariGudang(getAntrian().getFirst().barangDiBeli(), getAntrian().getFirst().getJumlahBarang());
                System.out.println("Antrian terdepan berhasil diselesaikan");
                getAntrian().removeFirst();
            } else {
                System.out.println("Barang yang dibeli tidak tersedia");
            }
        } else {
            System.out.println("Tidak ada antrian");
        }
        System.out.println();
    }

    public void cekIsiAntrian() {
        if (!getAntrian().isEmpty()) {
            System.out.println("LIST ANTRIAN:");
            int i = 1;
            for (Pembeli pembeli : getAntrian()) {
                System.out.println("Antrian ke " + i + ", nama: " + pembeli.getNama() + ", barang dibeli "  + pembeli.barangDiBeli() + ", jumlah barang dibeli : " + pembeli.getJumlahBarang());
                i++;
            }
        } else {
            System.out.println("Tidak ada antrian");
        }
        System.out.println();
    }

    public boolean antrianPenuh() {
        return getAntrian().size() >= 10;
    }

    public boolean barangDibeliTersedia() {
        return gudangBarang.isiGudang.getOrDefault(getAntrian().getFirst().barangDiBeli(), 0) >= getAntrian().getFirst().getJumlahBarang();
    }

}