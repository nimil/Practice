package sym.common.dao;

import java.util.List;

import sym.common.bean.AdminUserBean;

public interface AdminUserDao {
	boolean UserAdd(String uname,String tel,String dept,String status,String updateid);
	AdminUserBean searchone(String uname,String dept,String tel);
	List<AdminUserBean> selectall(String uname,String[] dept,String[] status,String tel);
	int updateuser(String uid,String uname,String tel,String dept,String status);
}
