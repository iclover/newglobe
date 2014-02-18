package com.newglobe.minutes.web.systemmgr;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Administrator on 14-2-18.
 */
public class UserForm {
    @NotEmpty
    private String userName;

    @NotEmpty
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
