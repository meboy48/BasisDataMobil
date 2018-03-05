
import java.awt.Dimension;
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
public class lihat_transaksi extends javax.swing.JFrame {
private Connection con; 
private Statement stat; 
private ResultSet res; 
    public lihat_transaksi() {
        initComponents();
        setTitle("TRANSAKSI");
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
 t.addColumn("No Transaksi"); 
 t.addColumn("No Faktur"); 
 t.addColumn("Tanggal");
 t.addColumn("Jam"); 
 t.addColumn("Kode Pembeli"); 
 t.addColumn("Nama"); 
 t.addColumn("Kode Mobil"); 
 t.addColumn("Nama Mobil"); 
 t.addColumn("Merk");
 t.addColumn("Warna"); 
 t.addColumn("Tahun"); 
 t.addColumn("Harga"); 
 tbl.setModel(t); try{ res=stat.executeQuery("select * from transaksi"); 
 while (res.next()) { 
 t.addRow(new Object[]{ res.getString("no_transaksi"),
 res.getString("no_faktur"), 
  res.getString("tgl_fktur"), 
 res.getString("jam_fktur"), 
  res.getString("kode_pembeli"), 
    res.getString("nama"),
    res.getString("kode_mobil"), 
 res.getString("nama_mobil"),   
  res.getString("merk"), 
 res.getString("warna"), 
  res.getString("tahun"), 
    res.getString("harga") 
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
        jLabel7 = new javax.swing.JLabel();
        tanggal_transaksi = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tpenjualan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lihat");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DAFTAR TRANSAKSI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 30, 250, 28);

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
        jScrollPane1.setBounds(10, 160, 1040, 230);

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(960, 40, 90, 30);

        jLabel7.setText("Tanggal Transaksi");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 90, 86, 30);

        tanggal_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggal_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(tanggal_transaksi);
        tanggal_transaksi.setBounds(180, 90, 140, 40);

        jButton7.setText("Cari");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(360, 90, 51, 23);

        jLabel2.setText("Total Penjualan");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(450, 90, 170, 14);

        tpenjualan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tpenjualan);
        tpenjualan.setBounds(570, 80, 120, 30);

        setBounds(0, 0, 1078, 505);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Penjualan().setVisible(true);
 dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tanggal_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_transaksiActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
 try {
        res=stat.executeQuery("select count(tgl_fktur) from transaksi where tgl_fktur='"+tanggal_transaksi.getText()+"';");
            while (res.next()) {
                tpenjualan.setText(res.getString("count(tgl_fktur)"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }  
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(lihat_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new lihat_transaksi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tanggal_transaksi;
    private javax.swing.JTable tbl;
    private javax.swing.JLabel tpenjualan;
    // End of variables declaration//GEN-END:variables
}
