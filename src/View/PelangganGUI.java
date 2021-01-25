package View;
import Entity.CameraEntity;
import Entity.DaftarPelangganEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class PelangganGUI extends JFrame{
    JLabel datadiri = new JLabel("Data Pelanggan");
    JTextArea area = new JTextArea();
    JLabel daftarcamera = new JLabel("Daftar Camera");
    JComboBox pilcamera = new JComboBox(CameraEntity.merk);
    JButton daftarbtn = new JButton("Daftar");
    JButton back = new JButton("Back");
    Font font = new Font("Times New Roman",Font.BOLD,30);
    int cek = Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Allobjctrl.Pelanggan.getData().getId());
    
    public PelangganGUI(){
        setSize(800, 700);
        setLayout(null);
         setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.ORANGE);
        
        datadiri.setFont(font);
        datadiri.setBounds(30, 40, 400, 40);
        add(datadiri);
        area.setBounds(30, 90, 400, 300);
        add(area);
        
        daftarcamera.setBounds(450, 40, 400, 40);
        daftarcamera.setFont(font);
        add(daftarcamera);
        pilcamera.setBounds(450, 90, 230, 30);
        add(pilcamera);
        
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        add(daftarbtn);
        
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        add(back);
        
       
        if(cek==-1){ //cek data, apabila kita belum daftar camera
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Camera", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Daftar Camera", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapelanggan());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexcamera = pilcamera.getSelectedIndex();
            Allobjctrl.Pelanggan.Astrid07221_DaftarCamera
            (indexcamera,Allobjctrl.Pelanggan.getData(), false);
            area.setText(datapelanggan());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                dispose();
                GUI men = new GUI(); //nama objek menu
            }
        });
    }
    
    String datapelanggan(){
        int cek = Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Allobjctrl.Pelanggan.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Allobjctrl.Pelanggan.showDaftarPelanggan(cek).isIsVerified()==false){
            cekverif = "belum diverifikasi";
        }else{
            cekverif = "sudah diverifikasi";
        }
         String text = "Id = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getId()+"\n"
                +"Nama = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnama()+"\n"
                +"Alamat = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getalamat()+"\n"
                +"No Identitas = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnoIdentitas()+"\n"
                +"No Telp = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnotelp()+"\n"
                +"Tanggal Sewa = "+new SimpleDateFormat("dd-MM-yyyy").format(Allobjctrl.Pelanggan.
                        showDaftarPelanggan(cek).getPelanggan().getTgl_sewa())+"\n"
                +"Tanggal Kembali = "+new SimpleDateFormat("dd-MM-yyyy").format(Allobjctrl.Pelanggan.
                        showDaftarPelanggan(cek).getPelanggan().getTgl_kembali())+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"camera = "+CameraEntity.merk[Allobjctrl.Pelanggan.
                        showDaftarPelanggan(cek).getIndexCamera()];
        return text;
     
        }
    }