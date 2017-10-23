package sym.common.service;

import java.util.List;

import sym.common.bean.AdminUserBean;

public interface AdminUserService {
	boolean UserAdd(String uname,String tel,String dept,String status,String updateid);
	AdminUserBean searchone(String uname,String dept,String tel);
	List<AdminUserBean> selectall(String uname,String[] dept,String[] status,String tel);
	int updateuser(String uid,String uname,String tel,String dept,String status);
	
}
