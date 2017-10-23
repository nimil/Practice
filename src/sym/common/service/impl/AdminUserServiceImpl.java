package sym.common.service.impl;

import java.util.List;

import sym.common.bean.AdminUserBean;
import sym.common.dao.AdminUserDao;
import sym.common.dao.impl.AdminUserDaoImpl;
import sym.common.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService{
	private static AdminUserDao aud=new  AdminUserDaoImpl();
	@Override
	public boolean UserAdd(String uname, String tel, String dept, String status, String updateid) {
		//将获取的数字转化为数据库可以存储的字符串形式 jdk版本太低不支持字符串switch。。。换了换了
				//'权限所属(M：管理；S：业务；F：财务)';'是否有效(T：有效；F：无效)';
				switch (dept) {
				case "1":
					dept="M";
					break;
				case "2":
					dept="S";
					break;
				case "3":
					dept="F";
					break;
				}
				switch (status) {
				case "1":
					status="T";
					break;
				case "2":
					status="F";
					break;
				}
		return aud.UserAdd(uname, tel, dept, status, updateid);
			}


	@Override
	public AdminUserBean searchone(String uname, String dept, String tel) {
		// TODO Auto-generated method stub
	// 转换部门信息
		
		switch (dept) {
		case "1":
			dept="M";
			break;
		case "2":
			dept="S";
			break;
		case "3":
			dept="F";
			break;
		}	
		return aud.searchone(uname, dept, tel);
	}

	@Override
	public List<AdminUserBean> selectall(String uname, String[] dept, String[] status, String tel) {
		// TODO Auto-generated method stub
		return aud.selectall(uname, dept, status, tel);
	}


	@Override
	public int updateuser(String uid,String uname,String tel,String dept,String status) {
		// TODO Auto-generated method stub
		return aud.updateuser(uid, uname, tel, dept, status);
	}

}
