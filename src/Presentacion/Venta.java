/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entidades.*;
import LogicaNegocio.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steven
 */
public class Venta extends javax.swing.JFrame {

    /**
     * Creates new form Venta
     */
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;

    public int clienteCod;
    public int vendedorCod;

    public Venta() {
        initComponents();
        setSize(1000, 600);
        setLocationRelativeTo(null);
        LimpiarTabla();
        CbxTipo.removeAllItems();
        CbxTipo.addItem("Contado");
        CbxTipo.addItem("Credito");
        try {
            cargarFactura();
            cargarCbx("");
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, "Error: " + ex.getMessage());
        }

    }

    private void cargarCbx(String condicion) throws Exception {
        VendedorCbx.removeAllItems();
        vendedorCod = 1;
        try {
            LnVendedor logica = new LnVendedor();
            List<Vendedor> lista;
            lista = logica.ListarRegistros(condicion);
            for (Vendedor vendedor : lista) {
                VendedorCbx.addItem("ID: " + vendedor.getId_vendedor() + " " + vendedor.getNombre()
                        + " " + vendedor.getApellido1() + " " + vendedor.getApellido2());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void cargarFactura() throws Exception {
        LnVenta logica = new LnVenta();
        Entidades.Venta venta = new Entidades.Venta();
        int id_factura_venta = -1;
        try {
            id_factura_venta = logica.Insertar(venta);
            txtFacturaId.setText(Integer.toString(id_factura_venta));
            txtFecha.setText(String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss"))));
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void LimpiarTabla() {

        modelo1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblProductos.setModel(modelo1);
        modelo1.addColumn("ID producto");
        modelo1.addColumn("Descripción");
        modelo1.addColumn("Categoria");
        modelo1.addColumn("Cantidad");
        modelo1.addColumn("Precio");
        modelo1.addColumn("Descuento");
        modelo1.addColumn("Total");

        tblServicios.setModel(modelo2);
        modelo2.addColumn("ID Servicio");
        modelo2.addColumn("Descripción");
        modelo2.addColumn("Veterinario");
        modelo2.addColumn("Animal");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Descuento");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Total");
    }

    private void cargarCalculo() {
        double total = 0;
        double subtotal = 0;

        if (modelo1.getRowCount() > 0 || modelo2.getRowCount() > 0) {
            if (modelo1.getRowCount() > 0) {
                for (int i = 0; i < modelo1.getRowCount(); i++) {
                    subtotal += (double) tblProductos.getValueAt(i, 5);
                }
            }
            if (modelo2.getRowCount() > 0) {
                for (int i = 0; i < modelo2.getRowCount(); i++) {
                    subtotal += (double) tblServicios.getValueAt(i, 7);
                }
            }
            txtSubtotal.setText(String.valueOf(String.format("%.2f", subtotal)));
        } else {
            txtSubtotal.setText("------");
        }
    }

    private int cargarVeterinario() {
        int veterinario = -1;
        return veterinario;
    }

    private int cargarAnimal() {
        int animal = -1;
        return animal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtVendedorId = new javax.swing.JLabel();
        VendedorCbx = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEliminarP = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();
        btnAgregarS = new javax.swing.JButton();
        btnEliminarS = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConfVenta = new javax.swing.JButton();
        btnReducir = new javax.swing.JButton();
        btnAumentar = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        txtClienteNombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JLabel();
        txtFacturaId = new javax.swing.JLabel();
        CbxTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtImpuesto1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Veterinaria-Venta");
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Factura id:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 49, -1, -1));

        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 150, -1, -1));

        txtVendedorId.setText("-----");
        getContentPane().add(txtVendedorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        VendedorCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        VendedorCbx.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                VendedorCbxItemStateChanged(evt);
            }
        });
        getContentPane().add(VendedorCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 92, 233, -1));

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
        tblServicios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblServicios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 229, 400, 170));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tblProductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 423, 170));

        btnEliminarP.setText("Eliminar");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 414, -1, -1));

        btnAgregarP.setText("Agregar Producto");
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 414, -1, -1));

        btnAgregarS.setText("Agregar Servicio");
        btnAgregarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        btnEliminarS.setText("Eliminar");
        btnEliminarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 414, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Subtotal: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("I.V.A:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 516, -1, -1));

        btnConfVenta.setText("Confirm Venta");
        btnConfVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 509, 127, 51));

        btnReducir.setText("-");
        btnReducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirActionPerformed(evt);
            }
        });
        getContentPane().add(btnReducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 414, 45, -1));

        btnAumentar.setText("+");
        btnAumentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAumentarMouseClicked(evt);
            }
        });
        btnAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAumentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 414, 45, -1));

        btnAgregarCliente.setText("Agregar cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        txtClienteNombre.setText("------------");
        getContentPane().add(txtClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 150, -1, -1));

        jButton1.setText("Limpiar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 509, 121, 50));

        jLabel7.setText("ID:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        txtClienteId.setText("----");
        getContentPane().add(txtClienteId, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        txtFacturaId.setText("------------");
        getContentPane().add(txtFacturaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 49, -1, -1));

        CbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(CbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 145, -1, -1));

        jLabel8.setText("Factura tipo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Descuento");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 516, -1, -1));

        txtDescuento.setText("-------");
        getContentPane().add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 522, -1, -1));

        jLabel11.setText("Fecha:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 49, -1, -1));

        txtFecha.setText("-------");
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 49, -1, -1));

        txtTotal.setText("-------");
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 522, -1, -1));

        txtSubtotal.setText("-------");
        getContentPane().add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        jLabel6.setText("Vendedor:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 97, -1, -1));

        jLabel10.setText("ID: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 100, 30, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 516, -1, -1));

        txtImpuesto1.setText("-------");
        getContentPane().add(txtImpuesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 522, -1, -1));

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 120, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSActionPerformed
        // TODO add your handling code here:
        AgregarServicio servicio = new AgregarServicio(null, true, clienteCod);
        servicio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = servicio.Codigo;
                    int cantRows = tblServicios.getRowCount();
                    boolean existeProducto = false;
                    int filaUpdate = -1;
                    LnServicio logica = new LnServicio();
                    Servicio servicio;
                    String condicion = "";
                    if (cantRows > 0) {
                        for (int i = 0; i < cantRows; i++) {
                            if ((int) tblServicios.getValueAt(i, 0) == id) {
                                existeProducto = true;
                                filaUpdate = i;
                            }
                        }
                    }
                    if (!existeProducto) {
                        if (id > -1) {
                            condicion = String.format("id_servicio = %d", id);
                            servicio = logica.ObtenerRegistro(condicion);
                            if (servicio.isExiste()) {
                                Object[] fila = new Object[8];
                                fila[0] = servicio.getId_servicio();
                                fila[1] = servicio.getDescripcion();
                                fila[2] = cargarVeterinario();
                                fila[3] = cargarAnimal();
                                fila[4] = 1;//la cantidad va ser 1
                                //la primera vez
                                fila[5] = servicio.getDescuento();
                                fila[6] = servicio.getPrecio();
                                //volvemos a poner el precio ya que
                                //esa unidad va ser el total
                                //posteriormente se modifica este valor
                                fila[7] = servicio.getPrecio();
                                modelo2.addRow(fila);
                                cargarCalculo();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error: El servicio no existe");
                            }
                        }
                    } else {
                        Object cantidad;
                        Object total;
                        //obtener cantidad actual del servicio a vender
                        cantidad = Integer.valueOf(tblServicios.getValueAt(filaUpdate, 4).toString());

                        //se suma la cantidad
                        cantidad = (int) cantidad + 1;
                        //se asigna el valor en la tabla
                        tblServicios.setValueAt(cantidad, filaUpdate, 4);
                        //se calcula el total con la cantidad actual
                        total = Integer.parseInt(cantidad.toString()) * Double.parseDouble(tblServicios.getValueAt(filaUpdate, 7).toString());
                        //se coloca la cantidad total del producto
                        tblServicios.setValueAt(total, filaUpdate, 7);
                        cargarCalculo();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        servicio.setVisible(true);
    }//GEN-LAST:event_btnAgregarSActionPerformed

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        // TODO add your handling code here:\

        AgregarProducto producto = new AgregarProducto(null, true);
        producto.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    //se trae el codigo en una variable global de 
                    int id = producto.Codigo;
                    //creamos una variable booleana
                    //para más tarde 
                    //conocer si el producto existe en la tablas
                    boolean existeProducto = false;
                    int cantRows = tblProductos.getRowCount();
                    int filaUpdate = -1;
                    if (cantRows > 0) {
                        for (int i = 0; i < cantRows; i++) {
                            if ((int) tblProductos.getValueAt(i, 0) == id) {
                                existeProducto = true;
                                filaUpdate = i;
                            }
                        }
                    }
                    if (!existeProducto) {
                        String condicion = "";
                        LnProducto logica = new LnProducto();
                        Producto producto;
                        if (id > -1) {
                            condicion = String.format("id_producto = %d", id);
                            producto = logica.ObtenerRegistro(condicion);
                            if (producto.getExistencia() > 0) {
                                Object[] fila = new Object[7];
                                fila[0] = producto.getId_producto();
                                fila[1] = producto.getDescripcion();
                                fila[2] = producto.getCategoria();
                                fila[3] = 1;//la cantidad va ser 1
                                //la primera vez
                                fila[4] = producto.getPrecio();
                                fila[5] = producto.getDescuento();
                                //volvemos a poner el precio ya que
                                //esa unidad va ser el total
                                //posteriormente se modifica este valor
                                fila[6] = producto.getPrecio();
                                modelo1.addRow(fila);
                                cargarCalculo();
                            } else {
                                JOptionPane.showMessageDialog(null, "No hay inventario");
                            }
                        }
                    } else {
                        String condicion = String.format("id_producto = %d", id);
                        LnProducto logica = new LnProducto();
                        Producto producto;
                        //obtener datos del producto
                        producto = logica.ObtenerRegistro(condicion);
                        Object cantidad;
                        Object total;
                        //obtener cantidad actual del producto a vender
                        cantidad = Integer.valueOf(tblProductos.getValueAt(filaUpdate, 3).toString());
                        //verificar que al agregar uno más
                        //la cantidad en exitencia sea igual o menor
                        if ((int) cantidad + 1 <= producto.getExistencia()) {
                            //se suma la cantidad
                            cantidad = (int) cantidad + 1;
                            //se asigna el valor en la tabla
                            tblProductos.setValueAt(cantidad, filaUpdate, 3);
                            //se calcula el total con la cantidad actual
                            total = Integer.parseInt(cantidad.toString()) * Double.parseDouble(tblProductos.getValueAt(filaUpdate, 4).toString());
                            //se coloca la cantidad total del producto
                            tblProductos.setValueAt(total, filaUpdate, 6);
                            cargarCalculo();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay suficiente existencia");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        producto.setVisible(true);
    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnConfVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfVentaActionPerformed
        // TODO add your handling code here:

        if (!txtClienteId.getText().equals("----")) {
            if (modelo1.getRowCount() == 0 && modelo2.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Debe agregar al menos un producto o servicio");
            } else {
                LnVenta logica = new LnVenta();
                Entidades.Venta venta;
                int resultado;
                venta = new Entidades.Venta(
                        Integer.parseInt(txtFacturaId.getText()),
                        Integer.parseInt(txtClienteId.getText()),
                        Date.valueOf(LocalDate.now()),
                        vendedorCod,
                        Double.parseDouble(txtSubtotal.getText()),
                        00.00,
                        "CANCELADO",
                        "CONTADO"
                );
                if (CbxTipo.getSelectedItem().equals("Contado")) {
                    try {
                        resultado = logica.Insertar(venta);
                        if (resultado > -1) {
                            LnDetalle logicaDetalle = new LnDetalle();
                            for (int i = 0; i < modelo2.getRowCount(); i++) {
                                DetalleServicio dServicio = new DetalleServicio();
                                dServicio.setId_venta(Integer.parseInt(txtFacturaId.getText()));
                                dServicio.setId_servicio((int) tblServicios.getValueAt(i, 0));
                                dServicio.setDescripcion(tblServicios.getValueAt(i, 1).toString());
                                dServicio.setId_veterinario((int) tblServicios.getValueAt(i, 2));
                                dServicio.setId_animal((int) tblServicios.getValueAt(i, 3));
                                dServicio.setCantidad((int) tblServicios.getValueAt(i, 4));
                                dServicio.setDescuento((double) tblServicios.getValueAt(i, 5));
                                dServicio.setPrecio((double) tblServicios.getValueAt(i, 6));
                                dServicio.setTotal((double) tblServicios.getValueAt(i, 7));

                                resultado = logicaDetalle.insertarDetalleS(dServicio);
                            }
                            for (int i = 0; i < modelo1.getRowCount(); i++) {
                                DetalleProducto dProducto = new DetalleProducto();
                                dProducto.setId_venta(Integer.parseInt(txtFacturaId.getText()));
                                dProducto.setId_producto((int) tblProductos.getValueAt(i, 0));
                                dProducto.setDescripcion(tblProductos.getValueAt(i, 1).toString());
                                //dProducto.set(tblServicios.getValueAt(i, 2));
                                dProducto.setCantidad((int) tblProductos.getValueAt(i, 3));
                                dProducto.setPrecio((double) tblProductos.getValueAt(i, 4));
                                dProducto.setDescuento((double) tblProductos.getValueAt(i, 5));
                                dProducto.setTotal((double) tblProductos.getValueAt(i, 6));

                                resultado = logicaDetalle.insertarDetalleP(dProducto);
                            }
                            if (resultado > -1) {
                                JOptionPane.showMessageDialog(null, "Factura Guardada");
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                } else {
                    venta.setTipo("CREDITO");
                    venta.setEstado("PENDIENTE");
                    try {
                        resultado = logica.Insertar(venta);
                        if (resultado > -1) {
                            JOptionPane.showMessageDialog(null, "Factura Guardada");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe agregar un cliente");
        }
    }//GEN-LAST:event_btnConfVentaActionPerformed

    private void btnReducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirActionPerformed
        // TODO add your handling code here:
        if (tblProductos.getSelectedRow() > -1) {
            int fila = tblProductos.getSelectedRow();
            Object cantidad = (int) tblProductos.getValueAt(fila, 3);
            Object total = (double) tblProductos.getValueAt(fila, 5);
            if ((int) cantidad - 1 > 0) {
                total = (double) total - (double) tblProductos.getValueAt(fila, 4);
                cantidad = (int) cantidad - 1;
                tblProductos.setValueAt(cantidad, fila, 3);
                tblProductos.setValueAt(total, fila, 5);
                cargarCalculo();
            } else {
                JOptionPane.showMessageDialog(null, "no se puede quitar más cantidad, elimine Producto si asi lo desea con el boton 'Eliminar'");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar fila");
        }
    }//GEN-LAST:event_btnReducirActionPerformed

    private void btnAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarActionPerformed
        // TODO add your handling code here:
        if (tblProductos.getSelectedRow() > -1) {
            try {
                //obtener numero de fila
                int fila = tblProductos.getSelectedRow();
                //obtener codigo del producto
                int codigo = Integer.parseInt(tblProductos.getValueAt(fila, 0).toString());
                String condicion = String.format("id_producto = %d", codigo);
                LnProducto logica = new LnProducto();
                Producto producto;
                //obtener datos del producto
                producto = logica.ObtenerRegistro(condicion);
                Object cantidad;
                Object total;
                //obtener cantidad actual del producto a vender
                cantidad = Integer.valueOf(tblProductos.getValueAt(fila, 3).toString());
                //verificar que al agregar uno más
                //la cantidad en exitencia sea igual o menor
                if ((int) cantidad + 1 <= producto.getExistencia()) {
                    //se suma la cantidad
                    cantidad = (int) cantidad + 1;
                    //se asigna el valor en la tabla
                    tblProductos.setValueAt(cantidad, fila, 3);
                    //se calcula el total con la cantidad actual
                    total = Integer.parseInt(cantidad.toString()) * Double.parseDouble(tblProductos.getValueAt(fila, 4).toString());
                    //se coloca la cantidad total del producto
                    tblProductos.setValueAt(total, fila, 5);
                    cargarCalculo();
                } else {
                    JOptionPane.showMessageDialog(null, "No hay suficiente existencia");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
            //revisar que haya inventario para agregar a la seleccion

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un fila");
        }
    }//GEN-LAST:event_btnAumentarActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // TODO add your handling code here:
        AgregarCliente cliente = new AgregarCliente(null, true);

        cliente.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = cliente.ObtenerId();
                    String condicion = "";
                    LnCliente logica = new LnCliente();
                    Cliente cliente;
                    if (id > -1) {
                        condicion = String.format("id_cliente = %d", id);
                        cliente = logica.ObtenerRegistro(condicion);
                        txtClienteId.setText(String.valueOf(cliente.getId_cliente()));
                        clienteCod = cliente.getId_cliente();
                        txtClienteNombre.setText(cliente.getNombre()
                                + " " + cliente.getApellido1() + " " + cliente.getApellido2());
                    } else {
                        txtClienteNombre.setText("------------");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        cliente.setVisible(true);
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void VendedorCbxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_VendedorCbxItemStateChanged
        // TODO add your handling code here:
        vendedorCod = VendedorCbx.getSelectedIndex() + 1;
        txtVendedorId.setText(String.valueOf(vendedorCod));
    }//GEN-LAST:event_VendedorCbxItemStateChanged

    private void btnAumentarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAumentarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAumentarMouseClicked

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        // TODO add your handling code here:
        if (tblProductos.getSelectedRow() > -1) {
            int fila = tblProductos.getSelectedRow();
            modelo1.removeRow(fila);
            cargarCalculo();
        } else {
            if (tblProductos.getRowCount() > 0) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            } else {
                JOptionPane.showMessageDialog(null, "No hay productos agregados");
            }
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnEliminarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSActionPerformed
        // TODO add your handling code here:
        if (tblServicios.getSelectedRow() > -1) {
            int fila = tblServicios.getSelectedRow();
            modelo2.removeRow(fila);
            cargarCalculo();
        } else {
            if (tblServicios.getRowCount() > 0) {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            } else {
                JOptionPane.showMessageDialog(null, "No hay productos agregados");
            }
        }
    }//GEN-LAST:event_btnEliminarSActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PantallasPrincipal principal = new PantallasPrincipal();
        this.dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxTipo;
    private javax.swing.JComboBox<String> VendedorCbx;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnAgregarS;
    private javax.swing.JButton btnAumentar;
    private javax.swing.JButton btnConfVenta;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnEliminarS;
    private javax.swing.JButton btnReducir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblServicios;
    private javax.swing.JLabel txtClienteId;
    private javax.swing.JLabel txtClienteNombre;
    private javax.swing.JLabel txtDescuento;
    private javax.swing.JLabel txtFacturaId;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtImpuesto1;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtVendedorId;
    // End of variables declaration//GEN-END:variables
}