package Entity;
import java.util.Date;
public class PelangganEntity extends RentalCamera {
    protected Date tgl_sewa,tgl_kembali; 
    public PelangganEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp,Date tgl_sewa,Date tgl_kembali){
        super(id,nama,alamat,noIdentitas,notelp);
        this.tgl_sewa=tgl_sewa;
        this.tgl_kembali=tgl_kembali;
}
    public PelangganEntity(){
    }
 @Override   
    public String getId() {
        return id;
    }

    public Date getTgl_sewa() {
        return tgl_sewa;
    }

    public Date getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_sewa(Date tgl_sewa) {
        this.tgl_sewa = tgl_sewa;
    }

    public void setTgl_kembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }
    
}
