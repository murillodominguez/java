package mygame.Model;

import javax.swing.*;
import java.awt.*;

public class TextMessage extends JLabel {

    public TextMessage(String content){
        setText(content);
        setFont(new Font("Times New Roman",1,20));
    }
}
