package enumtest.project;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 项目批文实体pojo
 * @Author DJZ-WWS
 * @Date 2019/5/21 17:24
 */
public class ProjectApproveal implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 项目批文名字
     */
    private String approvealName;
    /**
     * 上传人
     */
    private String uploadUser;
    /**
     * 项目批文类型
     */
    private Integer type;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 项目批文关联项目id
     */
    private String projectId;
    /**
     * 批文附件uuid
     */
    private String attachUuid;
    /**
     * 批文附件名字
     */
    private String attachName;
    /**
     * 批文附件md5
     */
    private String attachMd5;
    /**
     * 批文大小
     */
    private  Long attachSize;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 批文编号
     */
    private String approvealNum;
}
