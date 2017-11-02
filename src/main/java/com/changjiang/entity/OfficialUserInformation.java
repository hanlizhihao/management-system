package com.changjiang.entity;

import lombok.Data;

@Data
public class OfficialUserInformation {
    private Integer id;
    private String realname;
    private String idNumber;
    private String phone;
    private String dbDesc;
    private String sex;
    private String icon;
    private String address;
    private String qq;
    private String wechat;
    private String email;
    private String state;
}
