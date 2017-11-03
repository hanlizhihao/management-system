package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.UserEvaluation;

import java.util.List;

public interface UserEvaluationService{
    long getUserEvaluationRowCount(Assist assist);
    List<UserEvaluation> selectUserEvaluation(Assist assist);
    UserEvaluation selectUserEvaluationById(Integer id);
    int insertUserEvaluation(UserEvaluation value);
    int insertNonEmptyUserEvaluation(UserEvaluation value);
    int deleteUserEvaluationById(Integer id);
    int deleteUserEvaluation(Assist assist);
    int updateUserEvaluationById(UserEvaluation enti);
    int updateUserEvaluation(UserEvaluation value, Assist assist);
    int updateNonEmptyUserEvaluationById(UserEvaluation enti);
    int updateNonEmptyUserEvaluation(UserEvaluation value, Assist assist);
}