package Model;
import Entity.CameraEntity;
import Entity.PelangganEntity;
import Model.DaftarPelangganModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class PelangganModel implements ModeIinterfaces { 
    private ArrayList<PelangganEntity> pelangganEntityArrayList;
     
     public PelangganModel(){
        pelangganEntityArrayList = new ArrayList<PelangganEntity>();
    }
public void insert(PelangganEntity pelangganEntity){ //menambah data pelanggan
    pelangganEntityArrayList.add(pelangganEntity);  
}
 public int size() {
        return pelangganEntityArrayList.size();
    }
 @Override
    public int cekData(String id, String nama){
        int loop = 0;
        while (!pelangganEntityArrayList.get(loop).getId().equals(id) && 
                !pelangganEntityArrayList.get(loop).getnama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public PelangganEntity getpelangganEntityArrayList(int index){ //
        return pelangganEntityArrayList.get(index);
    }
}