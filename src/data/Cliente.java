package data;
//EL SERVIDOR ES EL QUE LE TIENE QUE PASAR LA LISTA CON LOS USUARIOS QUE HAY, PORQUE LA LISTA ESTÁTICA ES DIFERENTE PARA CLASE

import Controlador.Controlador;
import static data.Main.introducirNombre;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rober y Cris
 */
public class Cliente {

    Socket conexionConServidor = null;
    DataInputStream in = null;
    DataOutputStream out = null;
    boolean finCliente = false;
    String nombre;
    int cod;
    Controlador c;
    List<Usuario> usuarios = new ArrayList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public int getCod() {
        return cod;
    }

    public void setFinCliente(boolean finCliente) {
        this.finCliente = finCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean conectarServer() {

        try {
            conexionConServidor = new Socket(("localhost"), 50000);
        } catch (IOException ex) {
            return false;
        }

        try {
            in = new DataInputStream(conexionConServidor.getInputStream());
            out = new DataOutputStream(conexionConServidor.getOutputStream());
            //aqui envíamos el nombre a Gestiona Cliente
            out.writeUTF(Protocolo.USUARIO_CONECTADO_C + Protocolo.SEPARADOR + nombre);
            out.flush();
            while (!finCliente) {
                //este try catch es necesario para poder utilizar el setsoTime y liberar el codigo del in.read
                try {
                    conexionConServidor.setSoTimeout(3000);
                    String cad = in.readUTF();
                    System.out.println("Servidor dice : " + cad);
                    recibirServidor(cad);

                } catch (IOException iOException) {
                }

            }

        } catch (IOException ex) {
            System.out.println("Error al crear el flujo de entrada o salida del Cliente o el servidor ha cortado la conexion");
        }

        try {

            out.close();
            in.close();
            conexionConServidor.close();
            System.out.println("Se ha finalizado el chat.");
        } catch (IOException ex) {
            System.out.println("Algún flujo no puede cerrarse.");
        }

        return true;
    }

    private void recibirServidor(String cad) {
        Usuario u;
        String[] msj2;
        String[] msjServidor = cad.split(Protocolo.SEPARADOR);
        switch (msjServidor[0]) {
            case "" + Protocolo.MENSAJE_S:
                recibirMensaje(msjServidor[1]);
                c.getV().setVisible(true);
                break;
            case "" + Protocolo.FIN_SERVIDOR:
                cerrarConexionServidorDesconectado();
                break;
            case "" + Protocolo.ASIGNAR_CODIGO_S:
                cod = Integer.parseInt(msjServidor[1]);
                this.c = new Controlador(this);
                break;
            case "" + Protocolo.LISTA_USUARIOS_CONECTADOS:
                if (msjServidor.length > 1) {
                    añadirUsuariosIniciales(msjServidor);
                }
                break;
            case "" + Protocolo.NOMBRE_YA_EXISTE_S:
                
                try {
                nombre = JOptionPane.showInputDialog(null, msjServidor[1]);
                while (nombre.compareTo("") == 0) {
                    nombre = JOptionPane.showInputDialog(null, "No puedes introducir una cadena vacía ¿Cómo te llamas?");
                }
                try {
                    out.writeUTF(Protocolo.USUARIO_CONECTADO_C + Protocolo.SEPARADOR + nombre);
                    out.flush();
                } catch (Exception ex) {
                }

            } catch (Exception e) {
                try {
                    finCliente=true;
                    out.writeUTF("" + Protocolo.FIN_CLIENTE_SIN_CONECTAR);
                    out.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "" + Protocolo.USUARIO_CONECTADO_S:
                msj2 = msjServidor[1].split(Protocolo.SEPARADOR2);
                u = new Usuario(msj2[0], Integer.parseInt(msj2[1]));
                c.getV().añadirUsuario(u);
                usuarios.add(u);
                recibirMensaje("\nSe ha unido " + msj2[0]);
                break;
            case "" + Protocolo.ELIMINAR_USUARIO_DESCONECTADO_S:
                u = buscarUsuario(Integer.parseInt(msjServidor[1]));
                c.getV().eliminarUsuario(u);
                usuarios.remove(u);
                break;
            case "" + Protocolo.MENSAJE_PRIVADO_S:
                u = buscarUsuario(Integer.parseInt(msjServidor[1]));
                c.getV().pintarMensajePrivado(u, msjServidor[2]);
                break;
        }
    }

    private void recibirMensaje(String mensaje) {
        c.getV().pintarMensaje(mensaje);
    }

    private void cerrarConexionServidorDesconectado() {
        JOptionPane.showMessageDialog(c.getV(), "El servidor ha cerrado la conexión, Hasta Luego :)");
        c.getC().setFinCliente(true);
        c.getV().dispose();
    }

    private void añadirUsuariosIniciales(String[] msj) {
        Usuario u;
        for (int i = 1; i < msj.length; i++) {
            String[] msj2 = msj[i].split(Protocolo.SEPARADOR2);
            u = new Usuario(msj2[0], Integer.parseInt(msj2[1]));
            usuarios.add(u);
            c.getV().añadirUsuario(u);
        }
    }

    private Usuario buscarUsuario(int cod) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCod() == cod) {
                return usuario;
            }
        }
        return null;
    }

}
