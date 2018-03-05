
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; 
/**
 *
 * @author Nivky Hearth Vient
 */
public class lihat_pembeli extends javax.swing.JFrame {
private Connection con; 
private Statement stat; 
private ResultSet res; 
    public lihat_pembeli() {
        initComponents();
        setTitle("Daftar Pembeli");
        koneksi();
        tabel();
        //membuat layout tampil di tengah pada saat di tampilkan
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }
 private void koneksi() 
{ try 
{ 
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/penjualanmobil", "root", ""); 
stat=con.createStatement(); 
} catch (ClassNotFoundException | SQLException e) { 
JOptionPane.showMessageDialog(null, e); 
} } 
private void tabel(){ 
DefaultTableModel t= new DefaultTableModel();
 t.addColumn("Kode Pembeli"); 
 t.addColumn("Nama"); 
 t.addColumn("Pekerjaan");
 t.addColumn("Alamat"); 
 t.addColumn("Umur");
 tbl.setModel(t); try{ res=stat.executeQuery("select * from pembeli"); 
 while (res.next()) { 
 t.addRow(new Object[]{ res.getString("kode_pembeli"),
 res.getString("nama"),   
  res.getString("pekerjaan"), 
 res.getString("alamat"), 
  res.getString("umur") 
 }); 
 }
 }catch (Exception e) { 
 JOptionPane.showMessageDialog(rootPane, e); 
 } 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        kode_pembeli = new javax.swing.JTextField();
        pekerjaan = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        umur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lihat");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DAFTAR PEMBELI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 30, 230, 28);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 400, 690, 230);

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 40, 90, 30);

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(110, 130, 260, 30);
        getContentPane().add(kode_pembeli);
        kode_pembeli.setBounds(110, 80, 90, 40);

        pekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pekerjaanActionPerformed(evt);
            }
        });
        getContentPane().add(pekerjaan);
        pekerjaan.setBounds(110, 180, 270, 40);

        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });
        getContentPane().add(alamat);
        alamat.setBounds(110, 240, 270, 40);
        getContentPane().add(umur);
        umur.setBounds(110, 290, 50, 40);

        jLabel2.setText("Nama");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 70, 40);

        jLabel3.setText("Kode Pembeli");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 90, 90, 30);

        jLabel4.setText("Pekerjaan");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 190, 70, 30);

        jLabel5.setText("Alamat");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 240, 50, 30);

        jLabel6.setText("Umur");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 300, 25, 14);

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 360, 67, 23);

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(150, 360, 51, 23);

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(260, 360, 110, 23);

        jButton5.setText("Cari");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(400, 80, 51, 23);

        setBounds(0, 0, 731, 666);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Penjualan().setVisible(true);
 dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          try {
 stat.executeUpdate("insert into pembeli values ("
+"'" + kode_pembeli.getText()+"',"         
+ "'" + nama.getText()+ "'," 
+ "'" + pekerjaan.getText()+ "',"          
+ "'" + alamat.getText()+ "'," 
+ "'" + umur.getText()+"')");    
// dengan menggunakan variabel res panggil sql 
// petunjuk dengan perintah prepareCall, Input berdasarkan nama pembeli, Output pada labelBonus
// query SQL //
} catch (SQLException | HeadlessException e) { 
JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
 } finally{
         tabel();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pekerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pekerjaanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pekerjaanActionPerformed

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         try { 
res=stat.executeQuery("select * from pembeli where "+ "kode_pembeli='" +kode_pembeli.getText()
+"'" ); while (res.next()) 
{ 
kode_pembeli.setText(res.getString("kode_pembeli")); 
nama.setText(res.getString("nama"));
pekerjaan.setText(res.getString("pekerjaan"));
alamat.setText(res.getString("alamat"));
umur.setText(res.getString("umur"));
}                                        
 }       
catch (Exception e) { 
JOptionPane.showMessageDialog(rootPane, e); 
}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          try {
            stat.executeUpdate("update pembeli set "
                + "kode_pembeli='"+kode_pembeli.getText()+"',"
                + "nama='"+nama.getText()+"',"
                + "pekerjaan='"+pekerjaan.getText()+"',"
                + "alamat='"+alamat.getText()+"',"
                + "umur='"+umur.getText()+"'"
                + " where " + "kode_pembeli='"+kode_pembeli.getText()+"'" );
            JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }finally{
         tabel();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         try { 
stat.executeUpdate("delete from pembeli where " 
+ "kode_pembeli='"+kode_pembeli.getText()
+"'" ); 
JOptionPane.showMessageDialog(null, "Berhasil");
 } catch (SQLException | HeadlessException e) { 
JOptionPane.showMessageDialog(null, "pesan salah : "+e);
 } finally{
         tabel();
          }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lihat_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_pembeli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_pembeli().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kode_pembeli;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField pekerjaan;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField umur;
    // End of variables declaration//GEN-END:variables
}
