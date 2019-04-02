package design.build.dynamic;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 9:44
 */
public interface IGamePlayer {

    //登录游戏
    public void login(String username, String password);

    //击杀Boss
    public void killBoss();

    //升级
    public void upGrade();
}
