import javax.sound.sampled.*;
import java.io.File;

public class Audio {

    File file;
    AudioInputStream audioStream;
    Clip clip;
    String fp;

    Audio(String fp){
        this.fp=fp;
        file=new File(fp);
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void playSfx(){
        clip.setMicrosecondPosition(0);
        clip.start();
    }
    void stopSfx(){
        clip.stop();
    }

    void closeSfx(){
        clip.close();
    }

    void setVol(float v){
        if(v<0f||v>2f){
            //waley
        }
        FloatControl gc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gc.setValue(20f*(float)Math.log10(v));
    }
}
