package Model; 
import Entity.DaftarPelangganEntity;
import Entity.CameraEntity;
import Entity.PetugasEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class DaftarPelangganModel implements ModeIinterfaces { 
    private ArrayList<DaftarPelangganEntity> daftarpelangganArrayList;
    public DaftarPelangganModel(){
    daftarpelangganArrayList = new ArrayList<DaftarPelangganEntity>();
        }
    public void insertDataPelanggan(DaftarPelangganEntity daftarpelanggan){
        daftarpelangganArrayList.add(daftarpelanggan);
    }
    public ArrayList<DaftarPelangganEntity> getdaftarpelangganArrayList(){
        return daftarpelangganArrayList;
    }
    @Override
    public void view(){
        for(DaftarPelangganEntity daftarpelanggan : daftarpelangganArrayList){
        System.out.println("===========================================");
        System.out.print("ID : "+daftarpelanggan.getPelanggan().getId()+"\n Nama : "
        +daftarpelanggan.getPelanggan().getnama()+"\n Alamat "+daftarpelanggan.getPelanggan().getalamat()+
        "\n No Identitas "+daftarpelanggan.getPelanggan().getnoIdentitas()+
        "\n No Telepon "+daftarpelanggan.getPelanggan().getnotelp()+
        "\n Camera: "+CameraEntity.merk[daftarpelanggan.getIndexCamera()]+
        "\n Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(daftarpelanggan.getPelanggan().getTgl_sewa())+
         "\n Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(daftarpelanggan.getPelanggan().getTgl_kembali())+
        "\n IsVerified : ");
        if(daftarpelanggan.isIsVerified() == false){
        System.out.println("Belum Di Verifikasi Petugas");
        }else{
        System.out.println("Telah Di Verifikasi");
            }
        System.out.println("===========================================");
        }
    }
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpelangganArrayList.size() ==0){
            loop = -1;
        }else{
            for(int i = 0; i <daftarpelangganArrayList.size(); i++){
            if(daftarpelangganArrayList.get(i).getPelanggan().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public DaftarPelangganEntity showDaftarPelanggan(int index){
        return daftarpelangganArrayList.get(index);
    }
    public void updateIsVerified(int index,DaftarPelangganEntity daftarpelanggan){
    daftarpelangganArrayList.set(index, daftarpelanggan);
    }
}
