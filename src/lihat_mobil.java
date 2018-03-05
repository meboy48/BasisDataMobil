
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
public class lihat_mobil extends javax.swing.JFrame {

    private Connection con;
    private Statement stat;
    private ResultSet res;

    public lihat_mobil() {
        initComponents();
        setTitle("Daftar Mobil");
        koneksi();
        tabel();
        //membuat layout tampil di tengah pada saat di tampilkan
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/penjualanmobil", "root", "");
            stat = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void tabel() {
        DefaultTableModel t = new DefaultTableModel();
        t.addColumn("Kode Mobil");
        t.addColumn("Nama Mobil");
        t.addColumn("Merk");
        t.addColumn("Warna");
        t.addColumn("Tahun");
        t.addColumn("Harga");
        tbl.setModel(t);
        try {
            res = stat.executeQuery("select * from mobil");
            while (res.next()) {
                t.addRow(new Object[]{res.getString("kode_mobil"),
                    res.getString("nama_mobil"),
                    res.getString("merk"),
                    res.getString("warna"),
                    res.getString("tahun"),
                    res.getString("harga")
                });
            }
        } catch (Exception e) {
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
        jLabel2 = new javax.swing.JLabel();
        kode_mobil = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Terjual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lihat");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DAFTAR MOBIL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 30, 190, 28);

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
        jScrollPane1.setBounds(10, 81, 690, 230);

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(610, 30, 90, 30);

        jLabel2.setText("Kode Mobil :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 340, 110, 14);
        getContentPane().add(kode_mobil);
        kode_mobil.setBounds(260, 340, 100, 20);

        jButton2.setText("CARI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 340, 57, 23);

        jLabel3.setText("Terjual");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(500, 340, 51, 14);

        Terjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerjualActionPerformed(evt);
            }
        });
        getContentPane().add(Terjual);
        Terjual.setBounds(550, 340, 60, 20);

        setBounds(0, 0, 731, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Penjualan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
        res=stat.executeQuery("select count(kode_mobil) from transaksi where kode_mobil='"+kode_mobil.getText()+"';");
            while (res.next()) {
                Terjual.setText(res.getString("count(kode_mobil)"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TerjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerjualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TerjualActionPerformed

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
            java.util.logging.Logger.getLogger(lihat_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_mobil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Terjual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kode_mobil;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
