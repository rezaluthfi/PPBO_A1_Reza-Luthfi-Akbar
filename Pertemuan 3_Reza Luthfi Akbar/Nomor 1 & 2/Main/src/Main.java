import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // nomor 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan size array: ");
        int arr_size = sc.nextInt();

        System.out.println("Masukkan element array: ");
        int[] array = new int[arr_size];
        for (int i = 0; i < arr_size; i++) {
            System.out.println("Element " + (i+1) + ":");
            array[i] = sc.nextInt();
        }

        System.out.println("Final array: ");
        for (int i = 0; i < arr_size; i++) {
            if (i == arr_size - 1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ",");
            }
        }

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Angka terbesar: " + max);

        sc.close();


        // nomor 2
         Scanner scan = new Scanner(System.in);

         System.out.println("Masukkan Ukuran Area");
         int sizeArea = scan.nextInt();
         System.out.println("Masukkan titik start X");
         int x1 = scan.nextInt();
         System.out.println("Masukkan titik start Y");
         int y1 = scan.nextInt();
         System.out.println("Masukkan titik finish X");
         int x2 = scan.nextInt();
         System.out.println("Masukkan titik finish Y");
         int y2 = scan.nextInt();

         System.out.println();
         System.out.println("Start = " + x1 + ", " + y1);
         System.out.println("Finish = " + x2 + ", " + y2);

         for (int i = 0; i < sizeArea; i++) {
             for (int j = 0; j < sizeArea; j++) {
                 if (i == x1 && j == y1) {
                     System.out.print("S" + " | ");
                 } else if (i == y2 && j == x2) {
                     System.out.print("F" + " | ");
                 } else {
                     System.out.print("x" + " | ");
                 }
             }
             System.out.println();

         }
         System.out.println();
         System.out.println("Jalan");
         while (x1 != x2 || y1 != y2 ) {
             if (x1 < x2) {
                 System.out.println("Posisi robot sekarang ada di titik " + (x1+1) + ", " + y1);
                 x1++;
             } else if (x1 > x2) {
                 System.out.println("Posisi robot sekarang ada di titik " + (x1-1) + ", " + y1);
                 x1--;
             } else if (y1 < y2) {
                 System.out.println("Posisi robot sekarang ada di titik " + x1 + ", " + (y1+1));
                 y1++;
             } else if (y1 > y2) {
                 System.out.println("Posisi robot sekarang ada di titik " + x1 + ", " + (y1-1));
                 y1--;
             }
         }
         scan.close();

    }
}