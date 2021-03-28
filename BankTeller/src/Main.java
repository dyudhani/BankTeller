import java.util.Scanner;

public class Main {

    // Main dari beberapa file
    public static void main(String[] args) {
        Scanner ky = new Scanner(System.in);

        // Deklarasiin array Akun
        Akun banyakAkun [] = new Akun[10];
        int oo = 0;

        int pilihan;

        do {
            pilihan = menu(ky);
            System.out.println();

            if(pilihan == 1) {
                banyakAkun[oo++] = buatAkun(ky);
            } else if(pilihan == 2) {
                lakukanSetoran(banyakAkun, oo, ky);
            } else if(pilihan == 3) {
                lakukanPenarikan(banyakAkun, oo, ky);
            } else if(pilihan == 4) {
                terapkanSukuBunga(banyakAkun, oo, ky);
            } else {
                System.out.println("Terima Kasih telah menggunakan program ini");
                System.out.println("Selamat Tinggal!");
            }
            System.out.println();
        } while(pilihan != 5);
    }

    /*
    * Menu Akun
    *
    * @dicky ky
    * @return pilihan
    * */
    public static int menuAkun(Scanner ky) {
        System.out.println("Pilihlah Jenis Akun");
        System.out.println("1. Cek Akun");
        System.out.println("2. Simpan Akun");

        int pilihan;
        do {
            System.out.print("Masukkan pilihan: ");
            pilihan = ky.nextInt();
        }while(pilihan < 1 || pilihan > 2);

        return pilihan;
    }

    // Mencari akun
    public static int cariAkun(Akun banyakAkun [], int count, int noAkun) {

        for(int i=0; i<count; i++) {
            if(banyakAkun[i].getNoAkun() == noAkun) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Fungsi yang berguna untuk melakukan setoran bagi
     * akun yang sudah terdaftar
     */
    public static void lakukanSetoran(Akun banyakAkun [], int count, Scanner ky) {
        // Mendapatkan nomer akun
        System.out.print("\nSilahkan memasukkan nomor Akun : ");
        int noAkun = ky.nextInt();

        // Mencari akun
        int index = cariAkun(banyakAkun, count, noAkun);

        if(index >= 0) {
            // jumlah
            System.out.print("Silahkan memasukkan jumlah setoran : ");
            double jumlah = ky.nextDouble();

            banyakAkun[index].setoran(jumlah);
        } else {
            System.out.println("Tidak ada akun dengan nomer : " + noAkun);
        }
    }

    public static void lakukanPenarikan(Akun banyakAkun [], int count, Scanner ky) {
        // Mendapatkan nomer akun
        System.out.print("\nSilahkan memasukkan nomor Akun : ");
        int noAkun = ky.nextInt();

        // Mencari akun
        int index = cariAkun(banyakAkun, count, noAkun);

        if(index >= 0) {
            // jumlah
            System.out.print("Silahkan memasukkan jumlah penarikan: ");
            double jumlah = ky.nextDouble();
            banyakAkun[index].penarikan(jumlah);
        } else {
            System.out.println("Tidak ada akun dengan nomer : " + noAkun);
        }
    }

    public static void terapkanSukuBunga(Akun banyakAkun [], int count, Scanner ky) {
        // Mendapatkan nomer akun
        System.out.print("\nSilahkan memasukkan nomor Akun : ");
        int noAkun = ky.nextInt();

        // Mencari akun
        int index = cariAkun(banyakAkun, count, noAkun);

        if(index >= 0) {
            if(banyakAkun[index] instanceof SimpanAkun) {
                ((SimpanAkun)banyakAkun[index]).terapkanSukuBunga();
            }
        } else {
            System.out.println("Tidak ada akun dengan nomer : " + noAkun);
        }
    }

    /**
     * Fungsi untuk membuat akun
     */
    public static Akun buatAkun(Scanner ky) {

        Akun akun = null;
        int pilihan = menuAkun(ky);

        int noAkun;
        System.out.print("Silahkan memasukkan nomor Akun : ");
        noAkun = ky.nextInt();

        if(pilihan == 1)  { // chekcing account
            System.out.print("Masukkan biaya transaksi : ");
            double biaya = ky.nextDouble();
            akun = new CekAkun(noAkun, biaya);
        } else {
            // Simpan Akun

            System.out.print("Silahkan memasukkan suku bunga : ");
            double ir = ky.nextDouble();
            akun = new SimpanAkun(noAkun, ir);
        }
        return akun;
    }

    /*
     * Menu Bank Teller
     *
     * @dicky ky
     * @return pilihan
     * */
    public static int menu(Scanner ky) {
        System.out.println("\n");
        System.out.println("======================");
        System.out.println("Menu Bank Teller");
        System.out.println("======================");
        System.out.println("1. Buat Akun");
        System.out.println("2. Setoran");
        System.out.println("3. Penarikan");
        System.out.println("4. Suku Bunga");
        System.out.println("5. Keluar");
        System.out.println("======================");

        int pilihan;

        do {
            System.out.print("Masukkan pilihan: ");
            pilihan = ky.nextInt();
        } while(pilihan < 1 || pilihan > 5);

        return pilihan;
    }
}
