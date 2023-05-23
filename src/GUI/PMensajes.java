
package GUI;

import Controlador.Controlador;
import data.Protocolo;
import data.Usuario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rober
 */

// HAY QUE ELIMINAR EL TEXT AREA PRIVADO DE TODOS LOS CLIENTES CUANDO UNO SE DESCONECTE
public class PMensajes extends javax.swing.JPanel {

    List<MiTextArea> listaTextArea= new ArrayList();
    DefaultListModel <Usuario> modelo= new DefaultListModel();
    Controlador c;
    Render r=new Render();
    MiTextArea txtPuesto;
    public PMensajes(Controlador c) {
        this.c=c;
        initComponents();
        listaUsuarios.setModel(modelo);
        modelo.addElement(new Usuario("General",0));
        listaTextArea.add(new MiTextArea(0));
        minitComponents();
        listaUsuarios.setCellRenderer(r);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrar = new javax.swing.JTextArea();
        bSalir = new javax.swing.JButton();
        bEnviar = new javax.swing.JButton();
        txtEnviar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido al chat de Rober y Cris ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txtMostrar.setColumns(20);
        txtMostrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMostrar.setRows(5);
        jScrollPane1.setViewportView(txtMostrar);

        bSalir.setBackground(new java.awt.Color(255, 102, 102));
        bSalir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bEnviar.setBackground(new java.awt.Color(153, 255, 153));
        bEnviar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bEnviar.setText("Enviar");
        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnviarActionPerformed(evt);
            }
        });

        txtEnviar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnviarActionPerformed(evt);
            }
        });
        txtEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnviarKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Introduce tu mensaje :");

        listaUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaUsuariosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaUsuarios);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html> Elige un formato <br>de envío : </html>");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Voltear", "Unicode", "Mayúsculas", "Minúsculas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEnviar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEnviar)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void enviarMensaje(){
        Usuario u=listaUsuarios.getSelectedValue();
        //estos ifs sirven para si no tienes seleccionado nada en la lista o seleccionas se envien correctamente al destinatario
        try {
            if(txtEnviar.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"Por favor introduce algun mensaje antes de pulsar en enviar.");
            }else{
                if(u==null){
                    c.getC().getOut().writeUTF(Protocolo.MENSAJE_C+Protocolo.SEPARADOR+encriptador(txtEnviar.getText()));
                    c.getC().getOut().flush();
                    
                }
                else if(u.getCod()==0){
                    c.getC().getOut().writeUTF(Protocolo.MENSAJE_C+Protocolo.SEPARADOR+encriptador(txtEnviar.getText()));
                    c.getC().getOut().flush();
                }
                else{
                    c.getC().getOut().writeUTF(Protocolo.MENSAJE_PRIVADO_C+Protocolo.SEPARADOR+c.getC().getCod()
                                               +Protocolo.SEPARADOR+u.getCod()+Protocolo.SEPARADOR+encriptador(txtEnviar.getText()));
                    c.getC().getOut().flush();
                    // con esta linea ponemos el txtArea del cliente al que queremos mandar el mensaje y añadimos YO--> mas el texto en nuestra pantalla
                    ponerTextArea(u.getCod()).append("\nYo-->"+txtEnviar.getText());
                }
            }
            txtEnviar.setText("");
        } catch (IOException ex) {
            Logger.getLogger(PMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void bEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnviarActionPerformed
       enviarMensaje();
    }//GEN-LAST:event_bEnviarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        try {
            JOptionPane.showMessageDialog(this,"Gracias por utilizar nuestro servicio, Hasta Luego :)");
            c.getC().setFinCliente(true);
            c.getC().getOut().writeUTF(""+Protocolo.FIN_CLIENTE);
            c.getC().getOut().flush();
            c.getV().dispose();
        } catch (IOException ex) {
            Logger.getLogger(PMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSalirActionPerformed

    private void listaUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaUsuariosValueChanged
        if(listaUsuarios.getSelectedValuesList().size()>1){
            JOptionPane.showMessageDialog(this, "Solo puede seleccionar un usuario para enviar un mensaje");
        }
        Usuario u=listaUsuarios.getSelectedValue();
        txtEnviar.setText("");
        if(u!=null){
            mensajeLeidoUsuario(u.getCod(), true);
            txtPuesto=ponerTextArea(u.getCod());
            jScrollPane1.setViewportView(txtPuesto);
        }
        listaUsuarios.revalidate();
        listaUsuarios.repaint();
      
    }//GEN-LAST:event_listaUsuariosValueChanged

    private void txtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnviarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtEnviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnviarKeyPressed
        //CARGAMOS UN EVENTO DE TECLADO AL TXTENVIAR PARA ENVIAR AL PULSAR ENTER
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            enviarMensaje();
        }
    }//GEN-LAST:event_txtEnviarKeyPressed

    void añadirMensajeGeneral(String mensaje) {
        mensajeLeidoUsuario(0, false);
        if(txtPuesto.getCodUsuario()==0){
            mensajeLeidoUsuario(0, true);
        }
        ponerTextArea(0).append(mensaje);
        listaUsuarios.revalidate();
        listaUsuarios.repaint();
    }
    public void añadirUsuario(Usuario u){
        modelo.addElement(u);
        MiTextArea mTxt=new MiTextArea(u.getCod());
        mTxt.append("Chat con "+u.getNombre());
        mTxt.setEditable(false);
        listaTextArea.add(mTxt);
    }
    
    public void eliminar(Usuario u){
        modelo.removeElement(u);
        listaTextArea.remove(ponerTextArea(u.getCod()));
        txtPuesto=ponerTextArea(0);
        jScrollPane1.setViewportView(txtPuesto);
    }
    public void añadirMensajePrivado(Usuario u,String mensaje){
        mensajeLeidoUsuario(u.getCod(), false);
        if(txtPuesto.getCodUsuario()==u.getCod()){
            mensajeLeidoUsuario(u.getCod(), true);
        }
        ponerTextArea(u.getCod()).append("\n"+u.getNombre()+"-->"+mensaje);
        listaUsuarios.revalidate();
        listaUsuarios.repaint();
    }
    public void mensajeLeidoUsuario(int cod, boolean leido){
        for (int i = 0; i < modelo.size(); i++) {
            if(modelo.get(i).getCod()==cod){
                modelo.get(i).setMensajeLeido(leido);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEnviar;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<Usuario> listaUsuarios;
    private javax.swing.JTextField txtEnviar;
    private javax.swing.JTextArea txtMostrar;
    // End of variables declaration//GEN-END:variables

    private void minitComponents() {
        txtPuesto=ponerTextArea(0);
        jScrollPane1.setViewportView(ponerTextArea(0));
    }
    private MiTextArea ponerTextArea(int cod){
        for (MiTextArea miTextArea : listaTextArea) {
            if(miTextArea.getCodUsuario()==cod){
                return miTextArea;
            }
        }
        return null;
    }
    private String encriptador(String mensaje){

        String seleccion= (String)jComboBox1.getSelectedItem();
        switch (seleccion) {
            case "Normal":
                return mensaje;
            case "Voltear":
                StringBuilder mensajeVolteado=new StringBuilder(mensaje);
                return mensajeVolteado.reverse().toString();
            case "Unicode":
                return convertirUnicode(mensaje);
            case "Mayúsculas":
                return mensaje.toUpperCase();
            case "Minúsculas":
                return mensaje.toLowerCase();
        }
        return mensaje;
    }

    private String convertirUnicode(String palabra) {
         String mensaje="";
        for (int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i)!=' '){
            mensaje+=(int)palabra.charAt(i);
         }else{
                mensaje+=palabra.charAt(i);
            } 
        }return mensaje;
    }

  
}
