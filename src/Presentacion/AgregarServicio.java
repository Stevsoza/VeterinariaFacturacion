package Presentacion;


import Entidades.Animal;
import Entidades.Servicio;
import Entidades.Veterinario;
import LogicaNegocio.LnAnimal;
import LogicaNegocio.LnServicio;
import LogicaNegocio.LnVeterinario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Presentacion.Venta;
/**
 *
 * @author Steven
 */
public class AgregarServicio extends javax.swing.JDialog {

    DefaultTableModel modelo;
    public int Codigo = -1;
    public int clientCod = -1;

    public AgregarServicio(java.awt.Frame parent, boolean modal, int codigo) {
        super(parent, modal);
        clientCod = codigo;
        initComponents();
        this.setLocationRelativeTo(null);

        try {
            cbxAnimal.removeAllItems();
            cbxVeterinario.removeAllItems();
            LnAnimal logicaA = new LnAnimal();
            LnVeterinario logicaV = new LnVeterinario();
            List<Animal> listAnimal;
            List<Veterinario> listVeter;
            String condicion = String.format("id_cliente = %d", clientCod);
            listAnimal = logicaA.ListarRegistros(condicion);
            for(Animal animal : listAnimal){
                cbxAnimal.addItem(animal.getAlias());
            }
            listVeter = logicaV.ListarRegistros("");
            for(Veterinario veterinario : listVeter){
                cbxVeterinario.addItem(veterinario.getNombre()+" "+veterinario.getApellido1());
            }
            cargarDatos("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void LimpiarTabla() {

        try {
            modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tblServicios.setModel(modelo);
            modelo.addColumn("Código");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Precio");
            modelo.addColumn("Descuento");
        } catch (Exception ex) {
            throw ex;
        }

    }

    private void cargarDatos(String condicion) throws Exception {
        try {
            LnServicio logica = new LnServicio();
            List<Servicio> lista;
            LimpiarTabla();
            Object[] fila = new Object[4];
            lista = logica.ListarRegistros(condicion);
            for (Servicio servicio : lista) {
                fila[0] = servicio.getId_servicio();
                fila[1] = servicio.getDescripcion();
                fila[2] = servicio.getPrecio();
                fila[3] = servicio.getDescuento();
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        cerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSearchService = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxAnimal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxVeterinario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicios);

        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Images/cerrar.png"))); // NOI18N
        cerrar.setAutoscrolls(true);
        cerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Servicio");

        txtSearchService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchServiceKeyReleased(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Veterinario");

        cbxAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAnimal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAnimalItemStateChanged(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Animal");

        cbxVeterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxVeterinario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVeterinarioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtSearchService)
                        .addGap(275, 275, 275))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSearchService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(cbxVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked

        this.dispose();
    }//GEN-LAST:event_cerrarMouseClicked

    private void tblServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiciosMouseClicked

        if (evt.getClickCount() == 2) {

            int fila = tblServicios.rowAtPoint(evt.getPoint());

            Codigo = Integer.parseInt(tblServicios.getValueAt(fila, 0).toString());
            this.dispose();
        }
    }//GEN-LAST:event_tblServiciosMouseClicked

    private void txtSearchServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchServiceKeyReleased

        String condicion = "";
        try {
            if (!txtSearchService.getText().equals("")) {
//                if (CbxCategoria.getSelectedItem().equals("Todos")) {
                    condicion = String.format("descripcion like '%%%s%%'", txtSearchService.getText());
//                } else {
//                    condicion = String.format("descripcion like '%%%s%%' and categoria = '%s'", txtSearchProduct.getText(), CbxCategoria.getSelectedItem().toString());
//                }
//
            }
            cargarDatos(condicion);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_txtSearchServiceKeyReleased

    private void cbxAnimalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAnimalItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAnimalItemStateChanged

    private void cbxVeterinarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVeterinarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVeterinarioItemStateChanged

    private void cargarComboBox() throws Exception {
//        try {
//            String condicion;
//            if (CbxCategoria.getSelectedIndex() > 0) {
//                if (!txtSearchProduct.getText().equals("")) {
//                    condicion = String.format("categoria = '%s' and descripcion like '%%%s%%'", CbxCategoria.getSelectedItem().toString(), txtSearchProduct.getText());
//                    cargarDatos(condicion);
//                } else {
//                    condicion = String.format("categoria = '%s'", CbxCategoria.getSelectedItem().toString());
//                    cargarDatos(condicion);
//                }
//            } else {
//                cargarDatos("");
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
    }

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
            java.util.logging.Logger.getLogger(AgregarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarServicio dialog = new AgregarServicio(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxAnimal;
    private javax.swing.JComboBox<String> cbxVeterinario;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtSearchService;
    // End of variables declaration//GEN-END:variables
}
