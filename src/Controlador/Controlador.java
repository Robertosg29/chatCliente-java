
package Controlador;

import GUI.VPpal;
import data.Cliente;

/**
 *
 * @author Rober y Cris
 */
public class Controlador {
    
  Cliente c;
  VPpal v;

    public Controlador(Cliente c) {
        this.c=c;
        v=new VPpal(this);
    }

    public Cliente getC() {
        return c;
    }

    public VPpal getV() {
        return v;
    }
    
}
