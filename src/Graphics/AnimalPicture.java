/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Allows the user to pick the picture for his animal.
 */
public class AnimalPicture extends JPanel implements ActionListener {
    protected String[] names;
    protected JComboBox jComboBox;
    protected JLabel pic;

    public AnimalPicture(String nm,int options){
        setSize(100,300);
        names=new String[options];
        for(int i=0;i<options;i++){
            names[i]=nm+(i+1)+"E";
        }
        jComboBox=new JComboBox(names);
        pic=new JLabel();
        updateIcon(names[0]);

        setLayout(new GridLayout(0,1));
        jComboBox.addActionListener(this);

        add(jComboBox);
        add(pic);



        setVisible(true);
    }
    public void updateIcon(String s) {
        String path = IDrawable.PICTURE_PATH + s + ".png";
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg);  // transform it back
        pic.setIcon(icon);
    }
    public int retSelected(){return jComboBox.getSelectedIndex()+1;}

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jComboBox){
            updateIcon(names[jComboBox.getSelectedIndex()]);
        }
    }

}
