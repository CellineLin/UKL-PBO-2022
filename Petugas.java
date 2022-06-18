
import java.util.ArrayList;

public class Petugas implements Admin {

    private ArrayList<String> namaPetugas = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public Petugas() {
        this.namaPetugas.add("Cimi");
        this.alamat.add("Kebalenan");
        this.telepon.add("082987582147");

        this.namaPetugas.add("Cimo");
        this.alamat.add("Ngunut");
        this.telepon.add("081642029852");

    }

    public int getJmlPetugas(int jumlah) {
        return this.namaPetugas.size();
    }

    @Override
    public void setNama(String nama) {
        this.namaPetugas.add(nama);
    }

    @Override
    public String getNama(int id) {
        return this.namaPetugas.get(0);
    }

    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    public String getAlamat(int idPetugas) {
        return this.alamat.get(idPetugas);
    }

    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    public String getTelepon(int idPetugas) {
        return this.telepon.get(idPetugas);
    }

    public void showPetugas() {
        int n = namaPetugas.size();
        for (int i = 0; i < n; i++) {
            System.out.println("=====================");
            System.out.println("Nama\t : " + getNama(i));
            System.out.println("Alamat\t : " + getAlamat(i));
            System.out.println("Telepon\t : " + getTelepon(i));
        }
    }

}
