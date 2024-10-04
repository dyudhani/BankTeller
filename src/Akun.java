
public abstract class Akun{

    // Nomer Akun
    private int noAkun;

    // saldo
    protected double saldo;

    // penyusun awal
    public Akun() {

    }

    public Akun(int noAkun) {
        this.noAkun = noAkun;
        saldo = 0;
    }

    // Getter methods
    public double getSaldo() {
        return this.saldo;
    }
    public int getNoAkun() {
        return this.noAkun;
    }

    // Abstract
    public abstract void setoran(double jumlah);
    public abstract void penarikan(double jumlah);
}