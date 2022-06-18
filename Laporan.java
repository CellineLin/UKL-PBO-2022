
import java.util.Collections;
import java.util.Scanner;

public class Laporan {

    static Masyarakat masyarakat = new Masyarakat();
    static Petugas petugas = new Petugas();
    static Barang barang = new Barang();
    static Lelang lelang = new Lelang();
    static Scanner input = new Scanner(System.in);
    static Lelang2 ok = new Lelang2();

    public static void showApp() {
        boolean program = true;

        System.out.println("=======SELAMAT DATANG========");
        System.out.print("Apakah anda memiliki akun? [y/n] ");
        String akun = input.next();
        if (akun.equalsIgnoreCase("y")) {
            login();
        } else {
            signUp();
        }

        while (program) {
            System.out.println("======= MENU =======");
            System.out.println("1. Identitas Petugas");
            System.out.println("2. Profil Anda");
            System.out.println("3. List Barang");
            System.out.println("4. Jual Barang");
            System.out.println("5. Ikuti Lelang");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu : ");
            int menu = input.nextInt();

            if (menu == 1) {
                petugas.showPetugas();
            } else if (menu == 2) {
                masyarakat.showMasyarakat();
            } else if (menu == 3) {
                barang.showBarang();
            } else if (menu == 4) {
                sell();
            } else if (menu == 5) {
                ok.prosesTransaksi(masyarakat, lelang, barang, petugas);
            } else if (menu == 6) {
                program = false;
            }
        }
    }

    public static void petugas() {

        System.out.println("ID Petugas : " + petugas.getNama(0));
        String nama = input.next();
        petugas.setNama(nama);
    }

    public static void lelang() {
        int max = 0;
        barang.showBarang();
        System.out.print("Masukan ID Barang : ");
        int idBarang = input.nextInt();

        if (barang.getStatus(idBarang)) {
            System.out.print("Harga Tawaran Anda : ");
            int tawar = input.nextInt();
            if (tawar > barang.getHargaAwal(idBarang)) {
                barang.gantiHarga(idBarang, tawar);
                System.out.println("Harga " + barang.getNamaBarang(idBarang)
                        + ": " + barang.getHargaAwal(idBarang));

                do {

                    System.out.print("ID Pelelang \t: ");
                    int id = input.nextInt();

                    if (id < 1 || id > 4) {
                        System.out.println("YOUR ID IS NOT REGISTERED \ninput ID");
                    } else {
                        ok.prosesTransaksi(masyarakat, lelang, barang, petugas);
                        System.out.println("Mulai Penawaran (Min. "
                                + barang.getHargaAwal(id - 1) + ") ");
                        System.out.println("Tawaran anda \t: ");
                        int tawarHarga = input.nextInt();

                        if (tawarHarga > barang.getHargaAwal(id - 1)) {
                            lelang.setHargaTawar(tawar);
                            lelang.setIdPenawar(id - 1);
                        } else if (tawar <= barang.getHargaAwal(id - 1)) {
                            System.out.println("HARGA KURANG");
                            max--;
                        }
                        max++;
                    }

                } while (max != 3);
                if (max == 3) {
                    barang.setStatus(false);

                }
                //win
                System.out.println("Selamat, anda menang lelang!");
                System.out.print("Press Y for purchase ");
                String confirm = input.next();
                if (confirm.equalsIgnoreCase("Y")) {
                    barang.removeBarang(idBarang);
                    System.out.println("Terima kasih telah mengikuti lelang");
                } else {
                    System.out.println("Barang kembali ke harga awal");
                }
            } else {
                System.out.println("Tawaran anda kurang");
            }
        } else {
            System.out.println("The item is already purchased");
        }
    }

    public static void sell() {
        boolean status = true;
        System.out.print("Barang  yang akan dijual : ");
        String nama = input.next();
        barang.setNamaBarang(nama);
        System.out.print("Harga barang yang akan dijual : ");
        int harga = input.nextInt();
        barang.setHargaAwal(harga);
        barang.setStatus(status);
        System.out.println("Selamat, barang sudah dapat diperjualbelikan");
    }

    public static void login() {
        System.out.print("ID anda : ");
        int id = input.nextInt();
        System.out.println("Halo, " + masyarakat.getNama(id - 1));
    }

    public static void signUp() {
        System.out.println("Register");
        System.out.println("1. Petugas");
        System.out.println("2. User");
        System.out.print("Pilih role anda: ");
        int answer = input.nextInt();

        if (answer == 1) {
            //nama
            System.out.println("Nama anda : ");
            String nama = input.next();
            petugas.setNama(nama);
            //alamat
            System.out.println("Alamat : ");
            String alamat = input.next();
            petugas.setAlamat(alamat);
            //telp
            System.out.println("No. Telp : ");
            String telp = input.next();
            petugas.setTelepon(telp);

            System.out.println("Selamat, anda sudah terdaftar sebagai Petugas");

        } else if (answer == 2) {
            //nama
            System.out.print("Nama anda : ");
            String nama = input.next();
            masyarakat.setNama(nama);
            //alamat
            System.out.print("Alamat : ");
            String alamat = input.next();
            masyarakat.setAlamat(alamat);
            //telp
            System.out.print("No. Telp : ");
            String telp = input.next();
            masyarakat.setTelepon(telp);

            System.out.println("Selamat, anda sudah terdaftar sebagai user");

        }
    }
}
