
import java.util.ArrayList;

public class Masyarakat implements Admin {

    private ArrayList<String> namaMasyarakat = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public Masyarakat() {
        this.namaMasyarakat.add("Anton");
        this.alamat.add("Ijen");
        this.telepon.add("081999666333");

        this.namaMasyarakat.add("Kirana");
        this.alamat.add("Kawi");
        this.telepon.add("081222444888");

        this.namaMasyarakat.add("Angga");
        this.alamat.add("Semeru");
        this.telepon.add("082555101010");

    }


    public int getJmlMasyarakat(int jumlah) {
        return this.namaMasyarakat.size();
    }

    @Override
    public void setNama(String nama) {
        this.namaMasyarakat.add(nama);
    }

    @Override
    public String getNama(int id) {
        return this.namaMasyarakat.get(id);
    }

    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }
    
    public void showMasyarakat(){
        int n = namaMasyarakat.size();
        for(int i = 0; i < n; i++){
            System.out.println("========================");
            System.out.println("Nama\t : " + getNama(i));
            System.out.println("Alamat\t : " +getAlamat(i));
            System.out.println("Telepon\t : " +getTelepon(i));
        }
    }
}
