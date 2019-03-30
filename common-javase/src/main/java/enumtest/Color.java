package enumtest;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/8 15:48
 */
public enum Color {
    /**
     * 蓝色
     */
    BLUE(1,"蓝色"),
    /**
     * 绿色
     */
    GREEN(2,"绿色"),OGIGIN(3,"黄色"),BLACK(4,"黑色");



private   Integer  key;
private   String  color;

    Color(Integer key, String color) {
        this.key = key;
        this.color = color;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }}
