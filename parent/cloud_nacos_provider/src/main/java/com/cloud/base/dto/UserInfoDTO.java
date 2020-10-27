package com.cloud.base.dto;

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

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "身份证号")
    private String cardId;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "性别（01:男；02：女）")
    private String sex;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "操作人id")
    private String oprator;

    @ApiModelProperty(value = "操作人名称")
    private String operatorName;

    @ApiModelProperty(value = "状态（01：启用；02：禁用）")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "头像地址")
    private String photo;


}
