/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import datos.ReservaStore;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Cliente;
import logica.Reserva;
import logica.Vehiculo;

/**
 *
 * @author jonat
 */
public class DlgNewReserva extends javax.swing.JDialog {
private ReservaStore reservaStore;
private ArrayList<Cliente> listaClientes;
private ArrayList<Vehiculo> listaVehiculos;
private int operacion;
private int indice;
    /**
     * Creates new form DlgNewVehiculo
     */
    public DlgNewReserva(java.awt.Frame parent, boolean modal,
        ReservaStore reservaStore,
        ArrayList<Cliente> listaClientes,
        ArrayList<Vehiculo> listaVehiculos,
        int operacion,
        int indice) {

    super(parent, modal);
    initComponents();

    this.reservaStore = reservaStore;
    this.listaClientes = listaClientes;
    this.listaVehiculos = listaVehiculos;
    this.operacion = operacion;
    this.indice = indice;

    cargarClientes();
    cargarVehiculos();
    configurarFormulario();

    setLocationRelativeTo(parent);
}
private void cargarClientes() {

    cmbCliente.removeAllItems();

    for (Cliente cliente : listaClientes) {
        cmbCliente.addItem(cliente);
    }
}
private void cargarVehiculos() {

    cmbVehiculo.removeAllItems();

    for (Vehiculo vehiculo : listaVehiculos) {
        cmbVehiculo.addItem(vehiculo);
    }
}
   private void configurarFormulario() {

    if (operacion == 1) {

        setTitle("Nueva Reserva");

        txtNumReserva.setText(
                String.valueOf(
                        reservaStore.obtenerSiguienteNumero()
                )
        );

        dtpFechaReserva.setDate(LocalDate.now());

    } else if (operacion == 2) {

        setTitle("Editar Reserva");
        cargarReserva();
    }
}
   private void cargarReserva() {

    Reserva reserva = reservaStore
            .getListaReservas()
            .get(indice);

    txtNumReserva.setText(
            String.valueOf(reserva.getNumReserva())
    );

    dtpFechaReserva.setDate(
            reserva.getFechaReserva()
    );

    cmbCliente.setSelectedItem(
            reserva.getCliente()
    );

    cmbVehiculo.setSelectedItem(
            reserva.getVehiculo()
    );

    txtCantidadDias.setText(
            String.valueOf(reserva.getCantDias())
    );

    txtPrecioDia.setText(
            String.valueOf(reserva.getPrecioDia())
    );

    mostrarCalculos();
}
   private void mostrarCalculos() {

    try {
        int dias = Integer.parseInt(
                txtCantidadDias.getText().trim()
        );

        double precio = Double.parseDouble(
                txtPrecioDia.getText().trim()
        );

        if (dias <= 0 || precio < 0) {
            limpiarCalculos();
            return;
        }

        double subtotal = dias * precio;
        double impuesto = subtotal * 0.13;
        double total = subtotal + impuesto;

        txtSubTotal.setText(
                String.format("%.2f", subtotal)
        );

        txtImpuesto.setText(
                String.format("%.2f", impuesto)
        );

        txtTotal.setText(
                String.format("%.2f", total)
        );

    } catch (NumberFormatException e) {
        limpiarCalculos();
    }
}
   private void limpiarCalculos() {
    txtSubTotal.setText("");
    txtImpuesto.setText("");
    txtTotal.setText("");
}
   private Reserva obtenerReserva() {

    if (dtpFechaReserva.getDate() == null) {
        JOptionPane.showMessageDialog(
                this,
                "Seleccione la fecha de la reserva."
        );
        return null;
    }

    if (cmbCliente.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(
                this,
                "Seleccione un cliente."
        );
        return null;
    }

    if (cmbVehiculo.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(
                this,
                "Seleccione un vehículo."
        );
        return null;
    }

    if (txtCantidadDias.getText().trim().isEmpty()
            || txtPrecioDia.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Complete todos los campos."
        );
        return null;
    }

    try {
        int dias = Integer.parseInt(
                txtCantidadDias.getText().trim()
        );

        double precioDia = Double.parseDouble(
                txtPrecioDia.getText()
                        .trim()
                        .replace(",", ".")
        );

        if (dias <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "La cantidad de días debe ser mayor que cero."
            );
            return null;
        }

        if (precioDia < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "El precio por día no puede ser negativo."
            );
            return null;
        }

        Cliente cliente =
                (Cliente) cmbCliente.getSelectedItem();

        Vehiculo vehiculo =
                (Vehiculo) cmbVehiculo.getSelectedItem();

        Reserva reserva = new Reserva();

        reserva.setFechaReserva(
                dtpFechaReserva.getDate()
        );

        reserva.setCliente(cliente);
        reserva.setVehiculo(vehiculo);
        reserva.setCantDias(dias);
        reserva.setPrecioDia(precioDia);
        reserva.setImpuesto(
                reserva.calcularImpuesto()
        );
        reserva.setTotal(
                reserva.calcularTotal()
        );

        return reserva;

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "La cantidad de días y el precio deben ser numéricos."
        );

        return null;
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidadDias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioDia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtpFechaReserva = new com.github.lgooddatepicker.components.DatePicker();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbVehiculo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNumReserva = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Vehículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setText("CantDías");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCantidadDias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidadDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadDiasKeyReleased(evt);
            }
        });

        jLabel2.setText("Precio Día");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPrecioDia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setText("Impuesto");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtImpuesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Cliente");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setText("Total:");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setText("Fech Compra:");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        dtpFechaReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmbCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Vehiculo:");

        jLabel8.setText("Num Reserva:");

        jLabel9.setText("SubTotal:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dtpFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCantidadDias, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(96, 96, 96)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecioDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(46, 46, 46))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
Reserva reserva = obtenerReserva();

    if (reserva == null) {
        return;
    }

    if (operacion == 1) {

        if (reservaStore.insertar(reserva)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva guardada correctamente."
            );

            dispose();
        }

    } else if (operacion == 2) {

        if (reservaStore.editar(indice, reserva)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Reserva editada correctamente."
            );

            dispose();
        }
    }       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void txtCantidadDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadDiasKeyReleased
       mostrarCalculos();
    }//GEN-LAST:event_txtCantidadDiasKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        if (operacion == 1) {
        dtpFechaReserva.setDate(LocalDate.now());
        cmbCliente.setSelectedIndex(0);
        cmbVehiculo.setSelectedIndex(0);
    }

    txtCantidadDias.setText("");
    txtPrecioDia.setText("");
    limpiarCalculos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
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
            java.util.logging.Logger.getLogger(DlgNewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgNewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgNewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgNewReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgNewReserva dialog = new DlgNewReserva(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbVehiculo;
    private com.github.lgooddatepicker.components.DatePicker dtpFechaReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidadDias;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtNumReserva;
    private javax.swing.JTextField txtPrecioDia;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
