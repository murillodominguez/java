package mygame.Model;

import javax.swing.*;
import java.awt.*;

public class TextMessage extends JLabel {

    public TextMessage(String content){
        setText(content);
        setFont(new Font("Comic Sans MS",1,20));
    }
}
