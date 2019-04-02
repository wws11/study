package design.build;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/1 19:50
 */
public interface Builder {

    /**
     * 抽象建造
     * @author liaowp
     *
     */


        /**
         * 打基础
         */
        public void  buildBasic();

        /**
         * 砌墙
         */
        public void  buildWalls();

        /**
         * 封顶
         */
        public void  roofed();

        /**
         * 造房子
         * @return
         */
        public Product buildProduct();
}
