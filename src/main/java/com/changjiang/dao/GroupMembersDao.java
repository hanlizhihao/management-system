package com.changjiang.dao;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.GroupMembers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMembersDao{
    long getGroupMembersRowCount(Assist assist);
    List<GroupMembers> selectGroupMembers(Assist assist);
    GroupMembers selectGroupMembersById(Integer id);
    int insertGroupMembers(GroupMembers value);
    int insertNonEmptyGroupMembers(GroupMembers value);
    int deleteGroupMembersById(Integer id);
    int deleteGroupMembers(Assist assist);
    int updateGroupMembersById(GroupMembers enti);
    int updateGroupMembers(@Param("enti") GroupMembers value, @Param("assist") Assist assist);
    int updateNonEmptyGroupMembersById(GroupMembers enti);
    int updateNonEmptyGroupMembers(@Param("enti") GroupMembers value, @Param("assist") Assist assist);
}