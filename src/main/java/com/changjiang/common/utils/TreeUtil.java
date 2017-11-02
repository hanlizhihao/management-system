package com.changjiang.common.utils;

import com.changjiang.common.Assist;
import com.changjiang.dao.OrganizationDao;
import com.changjiang.entity.Organization;
import com.changjiang.viewModel.FunctionNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanlizhi
 * @create 2017-10-25 14:45
 */

public class TreeUtil {

    public static List<FunctionNode> getOrganizationTree(List<Organization> organizations, OrganizationDao dao) {
        List<FunctionNode> result = new ArrayList<>();
        List<Organization> os = new ArrayList<>();
        for (Organization o : organizations) {
            os = dao.selectOrganization(new Assist(Assist.and_eq("upper_level_id", o.getId().toString())));
            if (os == null || os.size() == 0) {
                FunctionNode node = new FunctionNode();
                node.setId(o.getId());
                node.setName(o.getName());
                node.setPId(o.getUpperLevelId().toString());
                result.add(node);
            } else {
                result.addAll(getOrganizationTree(os, dao));
            }
        }
        return result;
    }

}
