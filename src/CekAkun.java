// Cek Akun
public class CekAkun extends Akun{

    // Biaya transaksi
    private static double Biaya = 2.5;

    // penyusun
    public CekAkun() {
        super();
    }

    /**
     * Parameter penyusun untuk inisiasi nomer akun dengan random nomer
     * dan random biaya transaksi pelanggan
     */
    public CekAkun(int noAkun, double biaya) {
        super(noAkun);
        Biaya = biaya;
    }

    /**
     * Fungsi untuk penarikan
     *
     * @author dickyumardhani jumlah yang akan di setor
     */
    public void setoran(double jumlah) {

        // cek jumlah
        if( jumlah > 0) {
            saldo += jumlah;
            System.out.printf("jumlah yang di setor %.2f %n", jumlah);

            // Biaya transaksi
            saldo -= Biaya;
            System.out.printf("Biaya transaksi %.2f %n", Biaya);
            System.out.printf("Saldo saat ini : %.2f%n", saldo);

        } else {
            System.out.println("Jumlah negatif tidak dapat melakukan setoran!");
        }
    }

    /**
     * Fungsi untuk penarikan
     *
     * @author dickyumardhani jumlah yang akan di tarik
     */
    public void penarikan(double jumlah) {

        if(jumlah > 0) {
            if((jumlah+Biaya) <= saldo) {

                System.out.printf("Jumlah Penarikan %.2f dari Akun ini%n", jumlah);
                saldo -= jumlah;
                saldo -= Biaya;
                System.out.printf("Biaya transaksi : %.2f%n", Biaya);
                System.out.printf("Saldo saat ini : %.2f%n", saldo);
            }
        } else {
            System.out.println("Jumlah negatif tidak dapat melakukan penarikan!");
        }
    }
}
