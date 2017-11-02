package com.changjiang.entity;

import lombok.Data;

@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
    private Integer roleId;
    private String store;
    private Integer userInformation;
    private String enabled;
    private Role role;
    private UserInformation user;
}
