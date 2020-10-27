package com.cloud.base.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @className UserInfoDTO
 * @package com.cloud.base.dto
 * @describe
 * @author hua.yang
 * @date 2020/10/27 12:25:00
 */
@Data
public class UserInfoDTO {
    @ApiModelProperty(value = "主键ID")
    @TableId("${field.annotationColumnName}")
    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("${field.annotationColumnName}")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("${field.annotationColumnName}")
    private String password;

    @ApiModelProperty(value = "昵称")
    @TableField("${field.annotationColumnName}")
    private String nickname;

    @ApiModelProperty(value = "身份证号")
    @TableField("${field.annotationColumnName}")
    private String cardId;

    @ApiModelProperty(value = "真实姓名")
    @TableField("${field.annotationColumnName}")
    private String realName;

    @ApiModelProperty(value = "性别（01:男；02：女）")
    @TableField("${field.annotationColumnName}")
    private String sex;

    @ApiModelProperty(value = "家庭住址")
    @TableField("${field.annotationColumnName}")
    private String address;

    @ApiModelProperty(value = "手机号码")
    @TableField("${field.annotationColumnName}")
    private String phone;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("${field.annotationColumnName}")
    private String email;

    @ApiModelProperty(value = "操作人id")
    @TableField("${field.annotationColumnName}")
    private String oprator;

    @ApiModelProperty(value = "操作人名称")
    @TableField("${field.annotationColumnName}")
    private String operatorName;

    @ApiModelProperty(value = "状态（01：启用；02：禁用）")
    @TableField("${field.annotationColumnName}")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField("${field.annotationColumnName}")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("${field.annotationColumnName}")
    private Date updateTime;

    @ApiModelProperty(value = "头像地址")
    @TableField("${field.annotationColumnName}")
    private String photo;


}
