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
public void insert(PelangganEntity pelangganEntity){
    pelangganEntityArrayList.add(pelangganEntity);  
}
 @Override
    public void view(){
        for(PelangganEntity pelangganEntity : pelangganEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" ID : "+pelangganEntity.getId()+"\n Nama : "
            +pelangganEntity.getnama()+"\n Alamat : "+pelangganEntity.getalamat()+
            "\n No Identitas: "+pelangganEntity.getnoIdentitas()+"\n No Telepon : "
            +pelangganEntity.getnotelp()
            +"\n tgl sewa : " +new SimpleDateFormat(" dd - MM - yyyy").format(pelangganEntity.getTgl_sewa())       
            +"\n tgl Kembali : " +new SimpleDateFormat(" dd - MM - yyyy").format(pelangganEntity.getTgl_kembali()));
                      
            System.out.println("===========================================");
        }
    }
    public int cekData(String Astrid07221_id, String Astrid07221_nama){
        int loop = 0;
        while (!pelangganEntityArrayList.get(loop).getId().equals(Astrid07221_id) && 
                !pelangganEntityArrayList.get(loop).getnama().equals(Astrid07221_nama)){
            loop++;
        }
        return loop;
    }
    public PelangganEntity getpelangganEntityArrayList(int index){
        return pelangganEntityArrayList.get(index);
    }
}
