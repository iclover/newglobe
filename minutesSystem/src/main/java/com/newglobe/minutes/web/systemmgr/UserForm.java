package com.newglobe.minutes.web.systemmgr;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Administrator on 14-2-18.
 */
public class UserForm {
    @NotEmpty(message = "用户名不为空" )
    private String userName;

    @NotEmpty(message = "密码不为空" )
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("properties userName=");
        if (userName != null) {
            sb.append("'").append(userName).append("', ");
        } else {
            sb.append(userName).append(", ");
        }
        sb.append("userPassword=").append(userPassword);
        return sb.toString();
    }
}
