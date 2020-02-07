package com.hyw.validation;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/15 19:49
 * Description：TODO
 */
@Data
public class UserInfo {

    public interface LoginGroup{};
    public interface RegisterGroup{};


    @NotNull(message = "用户id不能为空", groups = LoginGroup.class)
    private String userName;
    @NotEmpty(message = "用户名不能为空", groups = RegisterGroup.class)
    private String passWord;
    private String email;
    private String phone;
    private Date birthday;

    private List<@Valid UserInfo> friends;


}
