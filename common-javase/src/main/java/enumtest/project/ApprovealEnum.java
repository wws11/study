package enumtest.project;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/8 15:48
 */
public enum ApprovealEnum {
    /**
     * 项目批文
     */
    PROJECTAPPROVEAL(1,"项目批文"),
    /**
     * 初步设计批文
     */
    INITAPPROVEAL(2,"初步设计批文"),
    /**
     * 土地证
     */
    LANDAPPROVEAL(3,"土地证"),
    /**
     * 工规许可证
     */
    RULEAPPROVEAL(4,"工规许可证"),
    /**
     * 施工许可证
     */
    BUILDAPPROVEAL(5,"施工许可证")
    ;

private   Integer  type;
private   String  approvealName;

    ApprovealEnum(Integer type, String approvealName) {
        this.type = type;
        this.approvealName = approvealName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getApprovealName() {
        return approvealName;
    }

    public void setApprovealName(String approvealName) {
        this.approvealName = approvealName;
    }
}
