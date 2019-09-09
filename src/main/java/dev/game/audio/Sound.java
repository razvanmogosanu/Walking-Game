package dev.game.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    public Sound() {
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("gameover.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (
                UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
