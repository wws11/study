package enumtest;

import enumtest.project.ApprovealEnum;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/8 15:52
 */
public class ColorTest {


    public static void main(String[] args) {


        String approvealName = ApprovealEnum.BUILDAPPROVEAL.getApprovealName();
        Integer type = ApprovealEnum.BUILDAPPROVEAL.getType();
        System.out.println(type+  approvealName);

    }
}
