package mygame.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Fase extends JPanel{

    private Image background;

    public Fase(){
        setLayout(new BorderLayout());
        add(new TextMessage("Em memória de Juan... Nunca mais seremos os mesmos."), BorderLayout.WEST);
        ImageIcon imageref = new ImageIcon("src/rsc/img/background.jpg");
        JLabel image = new JLabel(imageref);
        add(image, BorderLayout.EAST);
        setBorder(BorderFactory.createEmptyBorder(20,60,40,60));
//        background = imageref.getImage();
    }

//    public void paint(Graphics g){
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(background, 650, 230, null);
//        g.dispose();
//    }
}