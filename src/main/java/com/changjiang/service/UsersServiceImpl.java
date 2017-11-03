package com.changjiang.service;
import com.changjiang.common.utils.Assist;
import com.changjiang.dao.UserInformationDao;
import com.changjiang.dao.UsersDao;
import com.changjiang.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.List;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
	private UsersDao usersDao;

    @Autowired
    private UserInformationDao userInformationDao;

    @Override
    public long getUsersRowCount(Assist assist){
        return usersDao.getUsersRowCount(assist);
    }
    @Override
    public Users selectUsersById(Integer id){
        return usersDao.selectUsersById(id);
    }
    @Override
    public int insertUsers(Users value){
        return usersDao.insertUsers(value);
    }
    @Override
    public int insertNonEmptyUsers(Users value){
        return usersDao.insertNonEmptyUsers(value);
    }
    @Override
    public int deleteUsersById(Integer id){
    	Users user=selectUsersById(id);
    	userInformationDao.deleteUserInformationById(user.getUserInformation());
        return usersDao.deleteUsersById(id);
    }
    @Override
    @Transactional
    public int updateUsersById(Users users) {
        Connection conn = null;
//        try {
//            conn = dataSource.getObject().openSession().getConnection();
//            usersDao.updateUsersById(users);
//            // 禁用自动提交
//            conn.setAutoCommit(false);
//            // 用conn创建Statement对象类实例
//            Statement sql_statement = conn.createStatement();
//
//            sql_statement.executeUpdate("        insert into users(id,username,password,role_id,store,user_information,\n" +
//                    "        enabled) \n" +
//                    "        values(,'h','h','1','1','1','0')");
//            conn.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                conn.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//            return 0;
//        }
        return 2;
    }
    @Override
    public int updateUsers(Users value, Assist assist){
        return usersDao.updateUsers(value,assist);
    }
    @Override
    public int updateNonEmptyUsersById(Users enti){
        return usersDao.updateNonEmptyUsersById(enti);
    }
    @Override
    public int updateNonEmptyUsers(Users value, Assist assist){
        return usersDao.updateNonEmptyUsers(value,assist);
    }

    public UsersDao getUsersDao() {
        return this.usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
	@Override
	public Users selectUsersHaveAll(Integer id) {
		// TODO Auto-generated method stub
		return this.usersDao.selectSingleUserHaveAll(id);
	}

	//如果登录成功，返回这个成功登录的user对象
	@Override
	public Users login(String username, String password) {
		List<Users> users=usersDao.selectUsers(new Assist(Assist.and_eq("enabled","0")));
		for(Users u:users){
			if(username!=null&&password!=null&&u.getUsername().equals(username)&&
					u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}
	@Override
	//获得当前用户所在店铺的所有用户
	public List<Users> selectAllUsersByUserId(Integer id) {
		Users user=usersDao.selectUsersById(id);

		List<Users> users=usersDao.selectAllUsersHaveAllByStoreNumber(user.getStore());
		return users;
	}
	@Override
	//获得当前用户所在店铺的启用用户
	public List<Users> selectEnabledUsersByUserId(Integer id) {
		Users user=usersDao.selectUsersById(id);
		//根据user的id来查店铺编号
		List<Users> users=usersDao.selectEnabledUsersHaveAllByStoreNumber(user.getStore());

		return users;
	}
	@Override
	//获得当前用户所在店铺的未启用用户
	public List<Users> selectDisabledUsersByUserId(Integer id) {
		Users user=usersDao.selectUsersById(id);
		//根据user的id来查店铺编号
		List<Users> users=usersDao.selectDisabledUsersHaveAllByStoreNumber(user.getStore());

		return users;
	}
	@Override
	public boolean deleteManyUser(Integer[] users) {

		for(Integer i:users){
			usersDao.deleteUsersById(i);
		}

		return true;
	}
}