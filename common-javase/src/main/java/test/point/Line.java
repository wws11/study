package test.point;

import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 19:09
 */
public class Line {

    /**
     * 线里面定义了点的集合
     */
    private List<Point>  points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line() {
    }


    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
