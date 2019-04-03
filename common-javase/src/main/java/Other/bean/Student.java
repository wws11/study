package Other.bean;

import lombok.Data;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 19:31
 */

@Data
public class Student   {

    /**
     * 用户名
     */
    private  String name;
    /**
     * 分数
     */
    private   Integer score;
    /**
     * 性别
     */
    private   Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


}
