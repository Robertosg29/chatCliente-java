
package data;

/**
 *
 * @author Rober y Cris
 */
public class Usuario {
    String nombre;
    int cod;
    boolean mensajeLeido=true;

    public Usuario(String nombre, int cod) {
        this.nombre = nombre;
        this.cod = cod;
    }
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCod() {
        return cod;
    }

    public boolean isMensajeLeido() {
        return mensajeLeido;
    }

    public void setMensajeLeido(boolean mensajeLeido) {
        this.mensajeLeido = mensajeLeido;
    }
    

    @Override
    public String toString() {
        return nombre;
    }
    
}
