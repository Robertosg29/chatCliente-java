
package GUI;

import data.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Rober
 */
public class Render extends JLabel implements ListCellRenderer{

    public Render() {
        setOpaque(true);
    }
    

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
         Usuario u=(Usuario)value;
         Color background;
         Color foreground;
         Font f=new Font("Arial",0,12);
         setText(value.toString());
         setFont(f);
         
         if(!u.isMensajeLeido()){
             background = Color.WHITE;
             foreground = new Color(74,236,108);
             setFont(f.deriveFont(1));
         }
         else{
             background = Color.WHITE;
             foreground = Color.BLACK;
             setFont(f.deriveFont(0));
         }
         if(isSelected){
             background = new Color(176,215,244);
             foreground = Color.WHITE;
             setFont(new Font("Arial Black",0,12));
         }
        
         setBackground(background);
         setForeground(foreground);

         return this;
    }

   
   
}
