// Simpan Akun
public class SimpanAkun extends Akun{

    // Suku Bunga
    private double sukuBunga;

    // penyusun awal
    public SimpanAkun() {
        super();
    }

    /**
     * parameter penyusun dari SimpanAkun terdiri dari nomer akun dan suku bunga
     */
    public SimpanAkun(int noAkun, double sukuBunga) {
        super(noAkun);
        this.sukuBunga = sukuBunga;
    }

    // getter function
    public double getSukuBunga() {
        return this.sukuBunga;
    }

    public void setSukuBunga(double sukuBunga) {
        this.sukuBunga = sukuBunga;
    }

    public double calcSukuBunga() {
        return saldo * sukuBunga;
    }

    public void terapkanSukuBunga() {
        double sukuBunga = calcSukuBunga();
        System.out.printf("Jumlah Bunga %.2f ditambahkan ke Saldo%n", sukuBunga);
        setoran(sukuBunga);
    }

    /**
     * Fungsi untuk penarikan
     *
     * @author dickyumardhani jumlah yang akan di setor
     */
    public void setoran(double jumlah) {

        // cek jumlah
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.printf("Jumlah yang di setor %.2f%n", jumlah);
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

        if (jumlah > 0) {

            if ((jumlah) <= saldo) {
                System.out.printf("Jumlah penarikan %.2f dari akun ini%n", jumlah);
                saldo -= jumlah;
                System.out.printf("Saldo saat ini : %.2f%n", saldo);
            }
        } else {
            System.out.println("Jumlah negatif tidak dapat melakukan penarikan!!");
        }
    }

}
