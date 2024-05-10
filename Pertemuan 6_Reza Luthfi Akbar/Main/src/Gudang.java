import java.util.HashMap;

public class Gudang {

    public HashMap<Toko.tipeBarang, Integer> isiGudang;
    private HashMap<bahan, Integer> stokBahan;
    public enum bahan {
        KAYU,
        BAUT,
        CAT
    }

    public void cekStokBahan() {
        if (stokBahan == null || stokBahan.isEmpty()) {
            System.out.println("Stok bahan kosong");
            return;
        }

        // Mengambil stok bahan sebelumnya
        int stokBahanKayu = stokBahan.getOrDefault(bahan.KAYU, 0);
        int stokBahanBaut = stokBahan.getOrDefault(bahan.BAUT, 0);
        int stokBahanCat = stokBahan.getOrDefault(bahan.CAT, 0);

        System.out.println("STOK BAHAN: ");
        System.out.println("Jumlah : " + bahan.BAUT + " saat ini adalah : " + stokBahanBaut + " buah");
        System.out.println("Jumlah : " + bahan.KAYU + " saat ini adalah : " + stokBahanKayu + " buah");
        System.out.println("Jumlah : " + bahan.CAT + " saat ini adalah : " + stokBahanCat + " buah");
        System.out.println();
    }

    public void cekIsiGudang() {
        System.out.println("ISI GUDANG: ");
        if (isiGudang == null || isiGudang.isEmpty()) {
            System.out.println("Gudang kosong");
            return;
        }

        System.out.println("Jumlah : MEJA saat ini adalah " + isiGudang.getOrDefault(Toko.tipeBarang.MEJA, 0) + " buah");
        System.out.println("Jumlah : KURSI saat ini adalah " + isiGudang.getOrDefault(Toko.tipeBarang.KURSI, 0) + " buah");
        System.out.println("Jumlah : LEMARI saat ini adalah " + isiGudang.getOrDefault(Toko.tipeBarang.LEMARI, 0) + " buah");
        System.out.println();
    }

    public void tambahBahan(bahan bahan, int jumlah) {
        if (stokBahan == null) {
            stokBahan = new HashMap<>();
        }
        // Mengambil stok bahan sebelumnya
        int stokBahanKayu = stokBahan.getOrDefault(Gudang.bahan.KAYU, 0);
        int stokBahanBaut = stokBahan.getOrDefault(Gudang.bahan.BAUT, 0);
        int stokBahanCat = stokBahan.getOrDefault(Gudang.bahan.CAT, 0);

        // Menambahkan jumlah baru ke stok bahan
        stokBahanKayu += (bahan == Gudang.bahan.KAYU) ? jumlah : 0;
        stokBahanBaut += (bahan == Gudang.bahan.BAUT) ? jumlah : 0;
        stokBahanCat += (bahan == Gudang.bahan.CAT) ? jumlah : 0;

        // Memperbarui stok bahan di dalam HashMap
        stokBahan.put(Gudang.bahan.KAYU, stokBahanKayu);
        stokBahan.put(Gudang.bahan.BAUT, stokBahanBaut);
        stokBahan.put(Gudang.bahan.CAT, stokBahanCat);
    }

    public int kurangiBahan(bahan bahan, int jumlah) {
        if (stokBahan == null || !stokBahan.containsKey(bahan)) {
            return 0;
        }

        int stok = stokBahan.get(bahan);
        stokBahan.put(bahan, stok - jumlah);
        return stok - jumlah;
    }

    public void buatBarang(Toko.tipeBarang barang, int jumlah) {
        // Memeriksa apakah isiGudang telah diinisialisasi
        if (isiGudang == null) {
            masukkanBarangKeGudang();
        }

        // Menghitung jumlah bahan yang dibutuhkan untuk membuat barang
        int bahanKayu = 0, bahanBaut = 0, bahanCat = 0;
        if (barang == Toko.tipeBarang.MEJA) {
            bahanKayu = 3 * jumlah;
            bahanBaut = 20 * jumlah;
            bahanCat = 2 * jumlah;
        } else if (barang == Toko.tipeBarang.KURSI) {
            bahanKayu = 2 * jumlah;
            bahanBaut = 10 * jumlah;
            bahanCat = jumlah;
        } else if (barang == Toko.tipeBarang.LEMARI) {
            bahanKayu = 5 * jumlah;
            bahanBaut = 30 * jumlah;
            bahanCat = 3 * jumlah;
        }

        // Memeriksa ketersediaan bahan sebelum menambahkan barang ke gudang
        if (!bahanPembuatanMencukupi(barang, jumlah)) {
            System.out.println("Bahan tidak cukup");
            return;
        }

        if (slotTersedia(barang)) {
            if (isiGudang.containsKey(barang)) {
                int jumlahBarang = isiGudang.get(barang);
                isiGudang.put(barang, jumlahBarang + jumlah);
            } else {
                isiGudang.put(barang, jumlah);
            }

            stokBahan.put(bahan.KAYU, kurangiBahan(bahan.KAYU, bahanKayu));
            stokBahan.put(bahan.BAUT, kurangiBahan(bahan.BAUT, bahanBaut));
            stokBahan.put(bahan.CAT, kurangiBahan(bahan.CAT, bahanCat));
            System.out.println(jumlah + " " + barang + " berhasil ditambahkan ke gudang");
        } else {
            System.out.println("Slot tidak tersedia untuk menambahkan barang " + barang);
        }
    }

    public boolean slotTersedia(Toko.tipeBarang barang) {
        int maksKursi = 20;
        int maksMeja = 10;
        int maksLemari = 5;

        int jumlahBarang = isiGudang.getOrDefault(barang, 0);

        switch (barang) {
            case KURSI:
                return jumlahBarang < maksKursi;
            case MEJA:
                return jumlahBarang < maksMeja;
            case LEMARI:
                return jumlahBarang < maksLemari;
            default:
                return false; // Barang selain kursi, meja, atau lemari tidak bisa disimpan
        }
    }

    public void masukkanBarangKeGudang() {
        isiGudang = new HashMap<>();
        isiGudang.put(Toko.tipeBarang.MEJA, 0);
        isiGudang.put(Toko.tipeBarang.KURSI, 0);
        isiGudang.put(Toko.tipeBarang.LEMARI, 0);
    }

    public void keluarkanBarangDariGudang(Toko.tipeBarang barang, int jumlahBarang) {
        if (isiGudang != null && isiGudang.containsKey(barang)) {
            int jumlah = isiGudang.get(barang);
            if (jumlah >= jumlahBarang) {
                isiGudang.put(barang, jumlah - jumlahBarang);
                System.out.println(jumlahBarang + " " + barang + " berhasil dikeluarkan dari gudang");
            } else {
                System.out.println("Jumlah barang tidak mencukupi");
            }
        }
    }

    public boolean bahanPembuatanMencukupi (Toko.tipeBarang barang, int jumlah) {
        int bahanKayu = 0, bahanBaut = 0, bahanCat = 0;
        if (barang == Toko.tipeBarang.MEJA) {
            bahanKayu = 3 * jumlah;
            bahanBaut = 20 * jumlah;
            bahanCat = 2 * jumlah;
        } else if (barang == Toko.tipeBarang.KURSI) {
            bahanKayu = 2 * jumlah;
            bahanBaut = 10 * jumlah;
            bahanCat = jumlah;
        } else if (barang == Toko.tipeBarang.LEMARI) {
            bahanKayu = 5 * jumlah;
            bahanBaut = 30 * jumlah;
            bahanCat = 3 * jumlah;
        }

        return stokBahan.getOrDefault(bahan.KAYU, 0) >= bahanKayu &&
                stokBahan.getOrDefault(bahan.BAUT, 0) >= bahanBaut &&
                stokBahan.getOrDefault(bahan.CAT, 0) >= bahanCat;
    }

}