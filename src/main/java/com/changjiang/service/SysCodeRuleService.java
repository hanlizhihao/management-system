package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.SysCodeRule;

import java.util.List;

public interface SysCodeRuleService{
    long getSysCodeRuleRowCount(Assist assist);
    List<SysCodeRule> selectSysCodeRule(Assist assist);
    SysCodeRule selectSysCodeRuleById(Integer id);
    int insertSysCodeRule(SysCodeRule value);
    int insertNonEmptySysCodeRule(SysCodeRule value);
    int deleteSysCodeRuleById(Integer id);
    int deleteSysCodeRule(Assist assist);
    int updateSysCodeRuleById(SysCodeRule enti);
    int updateSysCodeRule(SysCodeRule value, Assist assist);
    int updateNonEmptySysCodeRuleById(SysCodeRule enti);
    int updateNonEmptySysCodeRule(SysCodeRule value, Assist assist);
}