package design.adapt;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/15 14:53
 */
public class VlcPlayer  implements  AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
