
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
     
      public void view(){
        for (PetugasEntity PetugasEntity : PetugasEntityArrayList){
        System.out.print(PetugasEntity.getId());
        System.out.print(PetugasEntity.getnama());
        System.out.print(PetugasEntity.getalamat());
        System.out.print(PetugasEntity.getnoIdentitas());
        System.out.print(PetugasEntity.getnotelp());
        System.out.println();
        }
    }
    
    public int cekData(String id, String nama){
        int loop = 0;
        for(PetugasEntity aslabEntity : PetugasEntityArrayList){
            if(aslabEntity.getId().equals(id) && aslabEntity.getnama().equals(nama)){
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
