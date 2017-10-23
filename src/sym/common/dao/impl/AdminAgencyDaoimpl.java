package sym.common.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sym.common.bean.AdminAgencyBean;
import sym.common.bean.AdminCurrencyBean;
import sym.common.bean.AdminUserBean;
import sym.common.dao.AdminAgencyPageListDao;
import sym.common.util.ConnectionPool;

public class AdminAgencyDaoimpl implements AdminAgencyPageListDao{
	private static QueryRunner qr=new QueryRunner(ConnectionPool.getDataSource()); 
	
	@Override
	public List<AdminUserBean> searchuse(String aname) {
		// TODO Auto-generated method stub

		String sql="select * from M_USER where USER_OWNER_FLG='S'";
		try {if("".equals(aname)||aname==null){
			List<AdminUserBean> aub=qr.query(sql,new BeanListHandler<AdminUserBean>(AdminUserBean.class));
				return aub;
		}
		else{
			sql+=" and USER_NM like *?*";					
			List<AdminUserBean> aub=qr.query(sql,new BeanListHandler<AdminUserBean>(AdminUserBean.class),aname);
			return aub;		
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int agencyadd(String aname, String status, String agency, String updateid) {
		String sql="insert into M_AGENCY(AGENCY_NM,AGENCY_USER_CD,IS_VALID,UPDATE_TIME,UPDATE_USER_ID) values(?,?,?,SYSDATE(),?)";
		Object[] params={aname,agency,status,updateid};
			int i=0;
			try {
				i=qr.update(sql, params);
				return i;	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;
	}
	@Override
	public List<AdminAgencyBean> searchone(String aname, String sname, String[] status) {
		String sql="select * from M_AGENCY where 1=1";
		// System.out.println(sql);
		   List<String> list=new ArrayList<String>();
			if(!"".equals(aname)&&aname!=null){
				sql+=" and AGENCY_NM like *?*";
				list.add(aname);
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
			if(!"".equals(sname)&&sname!=null){
				sql+=" and AGENCY_USER_CD like *?*";
				list.add(sname);
			}
		
			
//			for (String string : list) {
//				System.out.println(string);
//			}
		 Object[] params=list.toArray();
		 
		 List<AdminAgencyBean> list1=new ArrayList<AdminAgencyBean>();
		 try {
			list1=qr.query(sql, new BeanListHandler<AdminAgencyBean>(AdminAgencyBean.class), params);
			return list1;
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int updatea(String acd, String aname, String uname, String status) {
		String sql="update M_AGENCY set AGENCY_NM =?,AGENCY_USER_CD=?,IS_VALID=?,UPDATE_TIME=SYSDATE() where AGENCY_CD=? ";
		Object[] params={aname,uname,status,acd};
		try {
			int i=qr.update(sql, params);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
