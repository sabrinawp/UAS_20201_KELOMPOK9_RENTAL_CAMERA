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
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpelangganArrayList.size() ==0){
            loop = -1;//data kosong
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
        return daftarpelangganArrayList.get(index); //menampilkan data pelanggan
    }
    public void hapusPelangganModel(int index) {
        daftarpelangganArrayList.remove(daftarpelangganArrayList.get(index)); //mengapus data pelanggan
    }
    public void updateIsVerified(int index,DaftarPelangganEntity daftarpelanggan){
    daftarpelangganArrayList.set(index, daftarpelanggan); 
    }
    public ArrayList <DaftarPelangganEntity> alldatapelanggan(){
        return  daftarpelangganArrayList;
    }
}