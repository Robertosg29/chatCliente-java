package GUI;

import Controlador.Controlador;
import data.Protocolo;
import data.Usuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rober y Cris
 */
public class VPpal extends javax.swing.JFrame implements WindowListener {

    Controlador c;
    PMensajes pm;

    public VPpal(Controlador c) {
        this.c = c;
        this.pm = new PMensajes(c);
        initComponents();
        minitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void pintarMensaje(String mensaje) {
        pm.añadirMensajeGeneral(mensaje);
        ponPanel(pm);
    }
    public void pintarMensajePrivado(Usuario u,String mensaje){
        pm.añadirMensajePrivado(u, mensaje);
        revalidate();
    }

    public void ponPanel(JPanel p) {
        setContentPane(p);
        revalidate();
    }

    private void minitComponents() {
        setTitle("CHAT ROCRI USUARIO: "+c.getC().getNombre().toUpperCase());
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(this);
    }
    public void añadirUsuario(Usuario u){
       pm.añadirUsuario(u);
    }
    public void eliminarUsuario(Usuario u){
        pm.eliminar(u);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
             try {
            JOptionPane.showMessageDialog(this, "Gracias por utilizar nuestro servicio, Hasta Luego :)");
            c.getC().setFinCliente(true);
            c.getC().getOut().writeUTF("" + Protocolo.FIN_CLIENTE);
            c.getC().getOut().flush();
            c.getV().dispose();
        } catch (IOException ex) {
            Logger.getLogger(PMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
   
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
