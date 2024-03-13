import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        nomor 1
        Scanner intValue = new Scanner(System.in);
        System.out.println("Masukkan angka pertama:");
        int firstNum = intValue.nextInt();

        System.out.println("Masukkan angka kedua:");
        int secondNum = intValue.nextInt();

//        bilangan pertama ganjil atau genap
        if (firstNum % 2 == 0) {
            System.out.println(firstNum + " adalah bilangan genap");
        } else {
            System.out.println(firstNum +" adalah bilangan ganjil");
        }

//        bilangan kedua ganjil atau genap
        if (secondNum % 2 == 0) {
            System.out.println(secondNum + " adalah bilangan genap");
        } else {
            System.out.println(secondNum +" adalah bilangan ganjil");
        }

//        bilangan pertama positif atau negatif
        if (firstNum > 0) {
            System.out.println(firstNum + " adalah bilangan positif");
        } else if (firstNum < 0) {
            System.out.println(firstNum +" adalah bilangan negatif");
        } else {
            System.out.println(firstNum +" adalah nol");
        }

//        bilangan kedua positif atau negatif
        if (secondNum > 0) {
            System.out.println(secondNum + " adalah bilangan positif");
        } else if (secondNum < 0) {
            System.out.println(secondNum +" adalah bilangan negatif");
        } else {
            System.out.println(secondNum +" adalah nol");
        }

//        jumlah digit angka pertama
        String digitFirstNum = Integer.toString(Math.abs(firstNum));
        int countFirstNum = digitFirstNum.length();
        System.out.println("Jumlah digit angka pertama: " + countFirstNum);

//        jumlah digit angka kedua
        String digitSecondNum = Integer.toString(Math.abs(secondNum));
        int countSecondNum = digitSecondNum.length();
        System.out.println("Jumlah digit angka kedua: " + countSecondNum);

//        selisih kedua angka (selalu positif)
        int selisih = firstNum - secondNum;
        System.out.println("Selisih kedua angka: " + Math.abs(selisih));

//        nomor 2
        Scanner nilaiSiswa = new Scanner(System.in);
        System.out.println("Nama Siswa");
        String name = nilaiSiswa.nextLine();

        System.out.println("Nilai Matematika");
        double nilaiMat = nilaiSiswa.nextDouble();

        System.out.println("Nilai IPA");
        double nilaiIPA = nilaiSiswa.nextDouble();

        System.out.println("Nilai Bahasa Indonesia");
        double nilaiBIndo = nilaiSiswa.nextDouble();

        System.out.println("Nilai Bahasa Inggris");
        double nilaiBIng = nilaiSiswa.nextDouble();

        double avgNilai = (nilaiMat + nilaiIPA + nilaiBIndo + nilaiBIng) / 4;

        if (avgNilai > 50) {
            System.out.println(name + " mendapatkan nilai rata-rata sebesar " + avgNilai + " dan dinyatakan lulus");
        } else {
            System.out.println(name + " mendapatkan nilai rata-rata sebesar " + avgNilai + " dan dinyatakan tidak lulus");
        }

    }
}