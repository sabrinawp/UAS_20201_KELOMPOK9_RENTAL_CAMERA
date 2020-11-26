package Entity;
public class DaftarPelangganEntity {
   private PelangganEntity pelanggan; 
    private boolean isVerified;
    private int indexCamera; 
    
     public DaftarPelangganEntity(int indexCamera,PelangganEntity pelanggan, boolean isVerified) { 
        this.indexCamera = indexCamera;
        this.pelanggan = pelanggan;
        this.isVerified = isVerified;
    }

    public PelangganEntity getPelanggan() {
        return pelanggan;
    }

    public boolean isIsVerified() {
        return isVerified;
    }


    public int getIndexCamera() {
        return indexCamera;
    }

    public void setPelanggan(PelangganEntity pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void setIndexCamera(int indexCamera) {
        this.indexCamera = indexCamera;
    }
     
}
