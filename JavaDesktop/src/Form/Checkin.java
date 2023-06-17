/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Natanawa Creative Design
 */
public final class Checkin extends javax.swing.JFrame {
    String BASEURL = "http://localhost:8080/";
    public Checkin() {
        initComponents();
        this.setResizable(false);
        setTanggal(); 
        setJam();
        inputPlatNo.requestFocus();
        //initForm();
        setLocationRelativeTo(null);
        setTitle("Wahyu Nugroho Indrawinata");
        ImageIcon img = new ImageIcon("src/image/aplikasi.png");
        setIconImage(img.getImage());
    }
    
    public void setTanggal(){
        java.util.Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new
        java.text.SimpleDateFormat("dd MMMM yyyy");
        tanggal.setText(kal.format(skrg));
    }
    
    public void setJam(){
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "",nol_detik = "";

                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if(nilai_jam <= 9) nol_jam= "0";
                if(nilai_menit <= 9) nol_menit= "0";
                if(nilai_detik <= 9) nol_detik= "0";

                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);

                waktu.setText(jam+":"+menit+":"+detik+"");
            }
        };
        new Timer(1, taskPerformer).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTentang1 = new properti.PanelTentang();
        btnCheckout = new javax.swing.JButton();
        inputPlatNo = new properti.TextBox();
        jPanel1 = new javax.swing.JPanel();
        tanggal = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        cetakTiket = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jenis_kendaraan = new javax.swing.JLabel();
        no_plat = new javax.swing.JLabel();
        comboJenisKendaraan = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        displayPlat = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        dummyNoPlat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(238, 3, 3));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelTentang1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        btnCheckout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        inputPlatNo.setBorder(null);
        inputPlatNo.setForeground(new java.awt.Color(0, 0, 0));
        inputPlatNo.setToolTipText("Masukkan Nomor Kendaraan");
        inputPlatNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inputPlatNo.setMargin(new java.awt.Insets(2, 2, 2, 0));
        inputPlatNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputPlatNoKeyReleased(evt);
            }
        });

        tanggal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        tanggal.setText("17 Juni 2023");

        waktu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        waktu.setText("08:08:08");

        cetakTiket.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cetakTiket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        cetakTiket.setText("Cetak Tiket");
        cetakTiket.setBorder(null);
        cetakTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakTiketActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Nomor Polisi"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Jenis Kendaraan"); // NOI18N

        jenis_kendaraan.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jenis_kendaraan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jenis_kendaraan.setText("-"); // NOI18N

        no_plat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        no_plat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no_plat.setText("-"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tanggal)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(waktu)
                                .addGap(87, 87, 87))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jenis_kendaraan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(no_plat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cetakTiket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waktu)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(no_plat)
                .addGap(50, 50, 50)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(jenis_kendaraan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cetakTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        comboJenisKendaraan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        comboJenisKendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JENIS KENDARAAN", "MOBIL", "MOTOR" }));
        comboJenisKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJenisKendaraanActionPerformed(evt);
            }
        });

        displayPlat.setFont(new java.awt.Font("Segoe UI", 1, 75)); // NOI18N
        displayPlat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayPlat.setText("-"); // NOI18N

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        dummyNoPlat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dummyNoPlat.setText("Entry Camera"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dummyNoPlat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(displayPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(displayPlat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dummyNoPlat)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout panelTentang1Layout = new javax.swing.GroupLayout(panelTentang1);
        panelTentang1.setLayout(panelTentang1Layout);
        panelTentang1Layout.setHorizontalGroup(
            panelTentang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTentang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTentang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPlatNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTentang1Layout.createSequentialGroup()
                        .addComponent(comboJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTentang1Layout.setVerticalGroup(
            panelTentang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTentang1Layout.createSequentialGroup()
                .addGroup(panelTentang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTentang1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputPlatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTentang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboJenisKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTentang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTentang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
         
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!no_plat.getText().isEmpty()){
            try {
                int ok;
                if ((ok = JOptionPane.showConfirmDialog(null, "Proses Transaksi Sedang Berjalan,Anda Yakin Keluar ?", "Wahyu Nugroho Indrawinata", JOptionPane.YES_NO_OPTION)) == 0) {
                        resetForm();    
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    } else{
                        inputPlatNo.requestFocus();
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
                    }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error : \n" + e.getMessage(), "Perhatian", JOptionPane.WARNING_MESSAGE);
            }
        }else{
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        inputPlatNo.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void cetakTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakTiketActionPerformed
        java.util.Date today = new java.util.Date();
        java.text.SimpleDateFormat kal = new
        java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String tgl = kal.format(today);
        String noPlat = displayPlat.getText();
        String jenisKendaraan = jenis_kendaraan.getText();
        if(noPlat.equals("-")){
            JOptionPane.showMessageDialog(null, " Silakan masukkan nomor kendaraan terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(jenisKendaraan.equals("-")){
            JOptionPane.showMessageDialog(null, " Silakan pilih jenis kendaraan terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            URL urlForGetRequest = null;
            InputStream is = null;
            HttpURLConnection connection;
            try {
                JSONObject parameter = new JSONObject();
                parameter.put("noPlat", noPlat);
                parameter.put("jenisKendaraan", jenisKendaraan);
                parameter.put("tanggalMasuk", tgl);
               
                urlForGetRequest = new URL(BASEURL+"checkin");
                connection = (HttpURLConnection) urlForGetRequest.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty ("Authorization", "c11e71c2-0c7c-11ee-be56-0242ac120002");
                
                connection.setRequestProperty("Content-Length", Integer.toString(parameter.toString().getBytes().length));
                connection.setRequestProperty("Content-Language", "en-US");  
                connection.setUseCaches(false);
                connection.setDoOutput(true);
            
                DataOutputStream wr = new DataOutputStream (
                connection.getOutputStream());
                wr.writeBytes(parameter.toString());
                wr.close();

                try {
                    is = connection.getInputStream();
                } catch (IOException ioe) {
                    if (connection instanceof HttpURLConnection) {
                        HttpURLConnection httpConn = (HttpURLConnection) connection;
                        int statusCode = httpConn.getResponseCode();
                        if (statusCode != 200) {
                            is = httpConn.getErrorStream();
                        }
                    }
                }
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                }
                rd.close();
                
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    resetForm();
                    JOptionPane.showMessageDialog(null, "Nomor Tiket : " + response, "Proses Berhasil", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, response, "Proses Gagal", JOptionPane.WARNING_MESSAGE);
                }
            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Proses Gagal", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Proses Gagal", JOptionPane.WARNING_MESSAGE);
            } 
        }
    }//GEN-LAST:event_cetakTiketActionPerformed
    
    private void resetForm(){
        inputPlatNo.setText("");
        no_plat.setText("-");
        displayPlat.setText("-");
        comboJenisKendaraan.setSelectedIndex(0);
   }
    
    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        this.hide();
        Checkout checkout = new Checkout();
        checkout.setVisible(true);
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void inputPlatNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPlatNoKeyReleased
        String normalisasi = inputPlatNo.getText().replaceAll("\\s+","");
        inputPlatNo.setText(normalisasi.toUpperCase());
        if(normalisasi.isEmpty()){
            normalisasi = "-";
        }
        no_plat.setText(normalisasi.toUpperCase());
        displayPlat.setText(normalisasi.toUpperCase());


    }//GEN-LAST:event_inputPlatNoKeyReleased

    private void comboJenisKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJenisKendaraanActionPerformed
        String valueKendaraan = comboJenisKendaraan.getSelectedItem().toString();
        if(valueKendaraan.equals("JENIS KENDARAAN")){
            valueKendaraan = "-";
        }
        jenis_kendaraan.setText(valueKendaraan);
    }//GEN-LAST:event_comboJenisKendaraanActionPerformed
 
    /**
    * @param args the command line arguments
    */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton cetakTiket;
    private javax.swing.JComboBox<String> comboJenisKendaraan;
    private javax.swing.JLabel displayPlat;
    private javax.swing.JLabel dummyNoPlat;
    private properti.TextBox inputPlatNo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jenis_kendaraan;
    private javax.swing.JLabel no_plat;
    private properti.PanelTentang panelTentang1;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}
