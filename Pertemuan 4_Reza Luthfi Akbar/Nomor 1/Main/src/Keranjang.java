import java.util.ArrayList;

public class Keranjang {
    ArrayList<Barang> listBarang;

    Keranjang() {
        listBarang = new ArrayList<Barang>();
    }

    void tambahBarang(Barang barangBaru) {
        if (getTotalBarang() + barangBaru.jumlah <= 5) {
            listBarang.add(barangBaru);
            System.out.println("Berhasil memasukkan ke keranjang");
        } else {
            System.out.println("Wes too, Keranjange wes mbludhag!!");
        }
    }

    int getTotalBarang() {
        int totalBarang = 0;
        for (Barang barang : listBarang) {
            totalBarang += barang.jumlah;
        }
        return totalBarang;
    }

    void printHasil() {
        int totalHarga = 0;
        System.out.println("Jumlah Barang di Keranjang Saat ini: " + getTotalBarang());
        System.out.println("Barang Pada Keranjang: ");
        for (Barang barang : listBarang) {
            System.out.println("# " + barang.nama + ", Jumlah : " + barang.jumlah);
            totalHarga += barang.harga * barang.jumlah;
        }
        System.out.println("Total harga yang harus dibayar: " + totalHarga);
    }


}
