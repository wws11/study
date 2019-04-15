package design.adapt;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/15 14:54
 */
public class Mp4Player implements   AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
