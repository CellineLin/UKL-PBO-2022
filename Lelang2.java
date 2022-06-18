
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Lelang2 {

    Scanner input = new Scanner(System.in);

    private ArrayList<Integer> idPenawar = new ArrayList<Integer>();
    private ArrayList<Integer> idBarang = new ArrayList<Integer>();
    private ArrayList<Integer> hargaTawar = new ArrayList<Integer>();


    public int prosesTransaksi(Masyarakat masyarakat, Lelang lelang, Barang barang, Petugas staf) {

        System.out.println("==================================");
        System.out.println("SELAMAT DATANG DI APLIKASI LELANG");
        System.out.println("==================================");

        int option;
        do {
            System.out.println("Apakah anda yakin ingin melelang?"
                    + "\n 1. YES"
                    + "\n 2. NO");
            System.out.print("Jawaban anda \t : ");
            option = input.nextInt();
            Laporan lapor = new Laporan();
            

            if (option == 1) {
                System.out.println("Daftar barang yang akan dilelang : "
                        + "\n1. Lukisan"
                        + "\n2. Keramik" );
                System.out.print("Pilih barang \t: ");
                int idBarang = input.nextInt();

                System.out.println("Barang yang akan dilelang \t: "
                        + barang.getNamaBarang(idBarang - 1));
            
                if (barang.getStatus(idBarang - 1)) {
                    System.out.print("Apakah anda yakin [Y][N] \t: ");
                    String answer = input.next();
                        
                    System.out.println("==========================================");    
                    
                    if (answer.equalsIgnoreCase("Y")) {
                        barang.setStatus(true);
                        System.out.println("Nama Barang \t: " + barang.getNamaBarang(idBarang - 1));
                        System.out.println("Harga \t\t: " + barang.getHargaAwal(idBarang - 1));

                        if (barang.getStatus(idBarang - 1)) {
                            System.out.println("Barang boleh dilelang dengan maksimal 3x penawaran");
                            int max = 0;

                            do {
                                System.out.print("ID Pelelang \t : ");
                                int id = input.nextInt();

                                if (id < 1 || id > 3) {
                                    System.out.println("YOUR ID IS NOT REGISTERED");
                                    System.out.println("Input ID");
                                } else {
                                    System.out.println("Mulai Penawaran (Min. "
                                            + barang.getHargaAwal(idBarang - 1) + ")");
                                    System.out.print("Tawaran Anda \t: ");
                                    int tawar = input.nextInt();

                                    if (tawar > barang.getHargaAwal(id - 1)) {
                                        hargaTawar.add(tawar);
                                        idPenawar.add(id - 1);
                                    } else if (tawar < barang.getHargaAwal(id - 1)) {
                                        System.out.println("TIDAK MEMENUHI HARGA TAWAR");
                                        max--;
                                    }
                                    max++;
                                }
                            } while (max != 3);
                            if (max == 3) {
                                barang.setStatus(false);
                                int most = Collections.max(hargaTawar);
                                int index = hargaTawar.indexOf(most);
                                int win = idPenawar.get(index);

                                System.out.println(
                                        "===================================="
                                        + "\n Petugas Lelang \t\t: " + staf.getNama(0)
                                        + "\n Pemenang Lelang \t: " + masyarakat.getNama(win)
                                        + "\n Barang yang dilelang \t: " + barang.getNamaBarang(idBarang - 1)
                                        + "\n Harga Lelang \t: " + most
                                        + "\n ====================================");
                                
                            }

                        }
                    } else if (answer.equalsIgnoreCase("N")) {
                        System.out.println("CANCELLED");
                    } else {
                        System.out.println("ERROR \nWRONG INPUT \n");
                    
                    }
                }
            } else {
                System.out.println("LELANG SELESAI");
            }
        } while (option != 2);
        System.out.println("============================");
        System.out.println("THANK YOU FOR YOUR VISITING");
        System.out.println("============================");
        return 0;
    }


}
