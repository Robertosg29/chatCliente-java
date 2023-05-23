/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JTextArea;

/**
 *
 * @author crist
 */
public class MiTextArea extends JTextArea{
    int codUsuario;

    public MiTextArea(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodUsuario() {
        return codUsuario;
    }
    
}
