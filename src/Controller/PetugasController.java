package Controller;
import Entity.PetugasEntity;
import Entity.DaftarPelangganEntity;
import Entity.PelangganEntity;
import java.util.Date;
import java.util.ArrayList;
public class PetugasController implements ControllerInterface{
    int indexLogin = 0;
    public PetugasController() {    
    }
    
    public void datapetugas(){
        String id[] = {"01","02","03"};
        String nama [] = {"astrid","sabrina","alex"};
        String alamat [] = {"mojokerto","mojokerto","sidoarjo"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"01","02","03"};
              for(int i=0;i<id.length;i++){
                AllObjectModel.petugasModel.insertPetugas(new 
                PetugasEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin =  AllObjectModel.petugasModel.cekData(id, nama);
    }
    
    public PetugasEntity Astrid07221_PetugasEntity() {
        return AllObjectModel.petugasModel.showDataPetugas(indexLogin);
    }
    
    public void updateIsVerified(int index,int indexCamera,PelangganEntity pelanggan ) {
        AllObjectModel.daftarPelangganmodel.updateIsVerified(index, new 
        DaftarPelangganEntity(indexCamera, pelanggan,true));
    }
    
    public ArrayList<DaftarPelangganEntity> cekDaftarPelangganModel() {
        return AllObjectModel.daftarPelangganmodel.getdaftarpelangganArrayList();
    }
}