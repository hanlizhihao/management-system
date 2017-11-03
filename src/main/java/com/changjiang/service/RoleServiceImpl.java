package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.dao.RoleMapper;
import com.changjiang.dao.RolePowerDao;
import com.changjiang.dao.UsersDao;
import com.changjiang.entity.Role;
import com.changjiang.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
	private RoleMapper roleMapper;
    @Autowired
    private UsersDao userDao;
    @Autowired
    private RolePowerDao rolePowerDao;
    @Override
    public long getRoleRowCount(Assist assist){
        return roleMapper.getRoleRowCount(assist);
    }
    @Override
    public List<Role> selectRole(String id){
    	List<Role> roles= roleMapper.selectRole(new Assist(Assist.and_eq("store_id",id)));
        return roles;
    }
    @Override
    public Role selectRoleById(Integer id){
        return roleMapper.selectRoleById(id);
    }
    @Override
    public int insertRole(Role value){
        return roleMapper.insertRole(value);
    }
    @Override
    public int insertNonEmptyRole(Role value){
        return roleMapper.insertNonEmptyRole(value);
    }
    @Override
    public int deleteRoleById(Integer id){
    	Users user=new Users();
    	List<Users> users=userDao.selectUsers(new Assist(Assist.and_eq("name","无权限")));
    	user.setRoleId(users.get(0).getId());//设置为默认无权限
    	userDao.updateNonEmptyUsers(user,new Assist(Assist.and_eq("users.role_id",id.toString())));//依赖角色的用户置为默认
    	rolePowerDao.deleteRolePower(new Assist(Assist.and_eq("role_power.role_id",id.toString())));
        return roleMapper.deleteRoleById(id);
    }
    @Override
    public int deleteRole(Assist assist){
        return roleMapper.deleteRole(assist);
    }
    @Override
    public int updateRoleById(Role enti){
        return roleMapper.updateRoleById(enti);
    }
    @Override
    public int updateRole(Role value, Assist assist){
        return roleMapper.updateRole(value,assist);
    }
    @Override
    public int updateNonEmptyRoleById(Role enti){
        return roleMapper.updateNonEmptyRoleById(enti);
    }
    @Override
    public int updateNonEmptyRole(Role value, Assist assist){
        return roleMapper.updateNonEmptyRole(value,assist);
    }

    public RoleMapper getRoleMapper() {
        return this.roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
	@Override
	public List<Role> selectEnabledRole(String storeId) {
		//选择storeId相同，启用的
		List<Role> enabledRoles= roleMapper.selectRole(new Assist(Assist.and_eq("store_id",storeId),
				Assist.and_eq("state","0")));
		// TODO Auto-generated method stub
		return enabledRoles;
	}
	@Override
	public List<Role> selectDisabledRole(String storeId) {
		List<Role> disabledRoles= roleMapper.selectRole(new Assist(Assist.and_eq("store_id",storeId),
				Assist.and_eq("state","1")));
		// TODO Auto-generated method stub
		return disabledRoles;
	}
	@Override
	public boolean deleteManyRole(Integer[] roles) {
		try{
			for(Integer i:roles){
				roleMapper.deleteRoleById(i);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}