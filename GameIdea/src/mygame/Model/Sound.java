package mygame.Model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    public Clip clip;
    public URL[] soundURL = new URL[30];

    public Sound(int file) {
        setFile(file);
    }

    public URL[] listSounds(){
        soundURL[0] = getClass().getResource("/sound/maintheme.wav");
        soundURL[1] = getClass().getResource("/sound/mario_jump.wav");
        return soundURL;
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(listSounds()[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void close(){
        clip.close();
    }

    public void stop(){
        clip.stop();
    }
}
