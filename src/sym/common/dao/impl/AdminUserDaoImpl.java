package sym.common.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sym.common.bean.AdminUserBean;
import sym.common.dao.AdminUserDao;
import sym.common.util.ConnectionPool;

public class AdminUserDaoImpl implements AdminUserDao{
private static	QueryRunner qr=new QueryRunner(ConnectionPool.getDataSource()); 
	@Override
	public boolean UserAdd(String uname, String tel, String dept, String status, String updateid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
			String sql="insert into M_USER(USER_NM,USER_PSWD,USER_PHONE,USER_OWNER_FLG,IS_VALID,UPDATE_DATE,UPDATE_USER_ID)values(?,?,?,?,?,SYSDATE(),?)";
			Object[] params={uname,"111",tel,dept,status,updateid};
			try {
				int i=qr.update(sql, params);
			if(i>0){
				return true;
			}else{
				return false;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
	}

	@Override
	public AdminUserBean searchone(String uname, String dept, String tel) {
		// TODO Auto-generated method stub

		String sql="select * from M_USER where USER_NM=? and USER_OWNER_FLG=? and USER_PHONE=?";
		try {
			String[] params={uname,dept,tel};
			//qr.query(sql, params, new BeanHandler<AdminUserBean>(AdminUserBean.class));
			AdminUserBean aub=qr.query(sql,new BeanHandler<AdminUserBean>(AdminUserBean.class),params);
			if(aub==null){
				System.out.println("----------------------------");
			}
				return aub;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<AdminUserBean> selectall(String uname, String[] dept, String[] status, String tel) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		   String sql="select * from M_USER where 1=1";
		  // System.out.println(sql);
		   List<String> list=new ArrayList<String>();
			if(!"".equals(uname)&&uname!=null){
				sql+=" and USER_NM like ?";
				list.add(uname);
			}
			if(dept.length!=0){
				if(dept.length==1){
					sql+=" and USER_OWNER_FLG in(?)";
					list.add(dept[0]);
				}else if(dept.length==2){
					sql+=" and USER_OWNER_FLG in(?,?)";
					list.add(dept[0]);
					list.add(dept[1]);
				}else{
					
					sql+=" and USER_OWNER_FLG in(?,?,?)";
					list.add(dept[0]);
					list.add(dept[1]);
					list.add(dept[2]);
				}
			}
			if(status.length!=0){
				if(status.length==1){
					sql+=" and IS_VALID in(?)";
					list.add(status[0]);
				}else{
					sql+=" and IS_VALID in(?,?)";
					list.add(status[0]);
					list.add(status[1]);
				}
			}
			if(!"".equals(tel)&&tel!=null)
			{
				sql+=" and USER_PHONE=?";
			}
//			for (String string : list) {
//				System.out.println(string);
//			}
		 Object[] params=list.toArray();
		 
		 List<AdminUserBean> list1=new ArrayList<AdminUserBean>();
		 try {
			list1=qr.query(sql, new BeanListHandler<AdminUserBean>(AdminUserBean.class), params);
			return list1;
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
		}

	@Override
	public int updateuser(String uid,String uname,String tel,String dept,String status) {
		// TODO Auto-generated method stub
		String sql="update  M_USER set USER_NM=?,USER_PHONE=?,USER_OWNER_FLG=?,IS_VALID=? where USER_CD=?";
		if("1".equals(dept)){
			dept="M";
		}else if("2".equals(dept)){
			dept="S";
		}else{
			dept="F";
		}
		
		if("1".equals(status)){
			status="T";
		}else{
			status="F";
		}
		Object[] params={uname,tel,dept,status,uid};
		try {
			int i=qr.update(sql,params);
		return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	}


