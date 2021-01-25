package Model;
import Entity.PetugasEntity;
import java.util.ArrayList;
public class PetugasModel implements ModeIinterfaces{ 
    private  ArrayList <PetugasEntity> PetugasEntityArrayList;   
    public PetugasModel(){
    PetugasEntityArrayList = new ArrayList<PetugasEntity>();
    }
    public void insertPetugas(PetugasEntity petugas){
        PetugasEntityArrayList.add(petugas);
    }
     @Override   
    public int cekData(String id, String nama){
        int loop = 0;
        for(PetugasEntity petugasEntity : PetugasEntityArrayList){
            if(petugasEntity.getId().equals(id) && petugasEntity.getnama().equals(nama)){
            break;
            }else{
                loop++;
            }
        }
        return loop;
   }
    public PetugasEntity showDataPetugas(int index){
        return PetugasEntityArrayList.get(index);
    }
}