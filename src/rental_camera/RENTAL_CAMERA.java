package rental_camera;
import Entity.PetugasEntity;
import Entity.DaftarPelangganEntity;
import Entity.PelangganEntity;
import Entity.CameraEntity;
import Model.PetugasModel;
import Model.PelangganModel;
import Model.DaftarPelangganModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class RENTAL_CAMERA {
    private static PetugasModel petugasModel = new PetugasModel(); 
    private static PelangganModel pelangganModel = new PelangganModel(); 
    private static DaftarPelangganModel daftarPelangganmodel = new DaftarPelangganModel();
    private static Scanner input = new Scanner (System.in);
    private static int pilCamera;
    static int cekpelanggan;
    static int cekanggota;
    
    public static void main(String[] args) {
        RENTAL_CAMERA data = new RENTAL_CAMERA();
        data.viewMenu();
    }
    
    void viewMenu(){
        int loop = 0;
        do{
           int pilih;
           System.out.print("Selamat Datang Di RENTAL CAMERA !!" +
                            "\n 1. Login" +
                            "\n 2. Daftar Pelanggan" +
                            "\n 3. Lihat Data Petugas" +
                            "\n 4. Lihat Data Camera" +
                            "\n 0. Stop" +
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                        if(pilih == 1){
                            int pilLogin = 0;
            System.out.print("1. Login Petugas" + "\n2. Login Pelanggan" + "\n Pilih : ");
                pilLogin = input.nextInt();
                if(pilLogin == 1){
                    datapetugas();
                    loginAnggota();
                }else{
                    login();
                }
            }else if(pilih == 2){
                register();
            }else if(pilih == 3){
                petugasModel.view();
            }else if (pilih == 4){
               for(int i=0;i<CameraEntity.merk.length;i++){
                    System.out.println(i+". "+CameraEntity.merk[i]);
               }
            }else{
                break;
            }
        }while (loop != 1);
    }

        void datapetugas(){
        String id[] = {"01","02","03"};
        String nama[] = {"astrid","sabrina","alex"};
        String alamat[] = {"mojokerto" , "mojokerto" , "sidoarjo"};
        String noIdentitas[] = {"01","02","03"};
        String notelp[] = {"01","02","03"};
              for(int i=0;i<id.length;i++){
                petugasModel.insertPetugas(new PetugasEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
        void register(){
        System.out.print("Input ID = ");
        String id = input.next();
        System.out.print("Input nama = ");
        String nama = input.next();
        System.out.print("Input Alamat = ");
        String alamat = input.next();
        System.out.print("Input no Identitas = ");
        String noIdentitas =  input.next();
        System.out.print("Input no Telepon = ");
        String notelp =  input.next();
        System.out.print("Input Tgl sewa (dd/mm/yyyy) = ");
        Date Tgl_sewa = new Date(input.next());
        System.out.print("Input Tgl kembali (dd/mm/yyyy) = ");
        Date Tgl_kembali = new Date(input.next());
        pelangganModel.insert(new PelangganEntity(id,nama,alamat,noIdentitas,notelp,Tgl_sewa,Tgl_kembali));
    }
        void login(){
        System.out.print("ID : ");
        String id = input.next();
        System.out.print("Nama : ");
        String nama = input.next();
        cekpelanggan = pelangganModel.cekData(id, nama);
        System.out.println("Selamat datang "+pelangganModel.getpelangganEntityArrayList(cekpelanggan)
        .getnama());
        int cekpelanggan = daftarPelangganmodel.cekData(id, nama);
        if (cekpelanggan == -1){
            System.out.println("Anda belum memilih kamera");
                daftarcamera();
        }else if(cekpelanggan == -2){
            System.out.println("Anda belum memilih kamera");
                daftarcamera();
        }else{
        System.out.println("Nama = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnama());
        System.out.println("id = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getId());
        System.out.println("No identitas = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnoIdentitas());
        System.out.println("No telp = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnotelp());
        System.out.println("camera = "+CameraEntity.merk[daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getIndexCamera()]);
        System.out.println("Tgl sewa           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_sewa()));
        System.out.println("Tgl kembali           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_kembali()));
        System.out.println("isVerified = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).isIsVerified());
        
        }
    }
        void daftarcamera(){
        System.out.print("Pilih Camera = \n");
        for(int i=0;i<CameraEntity.merk.length;i++){
        System.out.println(i+". "+CameraEntity.merk[i]);
        }
        System.out.print("Pilih Camera = ");
            pilCamera = input.nextInt();
        daftarPelangganmodel.insertDataPelanggan(new DaftarPelangganEntity(pilCamera,
                pelangganModel.getpelangganEntityArrayList(cekpelanggan),false));
    }
        void loginAnggota(){
        System.out.print("id : ");
        String id = input.next();
        System.out.print("nama: ");
        String nama = input.next();
        cekanggota = petugasModel.cekData(id,nama);
        System.out.println("Selamat Datang "+petugasModel.showDataPetugas(cekanggota).getnama());
        pelangganModel.view();
        updateIsverified();
    }
        void updateIsverified(){
        System.out.print("id : ");
        String id = input.next();
        System.out.print("nama: ");
        String nama = input.next();
        System.out.println("========================================");
        int cekpelanggan = daftarPelangganmodel.cekData(id, nama);
        System.out.println("Nama = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnama());
        System.out.println("id = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getId());
        System.out.println("No identitas = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnoIdentitas());
        System.out.println("No telp = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getnotelp());
        System.out.println("camera = "+CameraEntity.merk[daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getIndexCamera()]);
        System.out.println("Tgl sewa           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_sewa()));
        System.out.println("Tgl kembali           : "+new SimpleDateFormat(" dd - MM - yyyy").format(daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).getPelanggan().getTgl_kembali()));
        System.out.println("isVerified = "+daftarPelangganmodel.showDaftarPelanggan(cekpelanggan).isIsVerified());
        daftarPelangganmodel.updateIsVerified(cekpelanggan, new DaftarPelangganEntity(pilCamera,
        pelangganModel.getpelangganEntityArrayList(cekpelanggan),true));
    }
}