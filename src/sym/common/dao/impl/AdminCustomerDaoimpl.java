package sym.common.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sym.common.bean.AdminCustomerBean;
import sym.common.bean.AdminUserBean;
import sym.common.dao.AdminCustomerDao;
import sym.common.util.ConnectionPool;

public class AdminCustomerDaoimpl implements AdminCustomerDao{
	  QueryRunner qr=new QueryRunner(ConnectionPool.getDataSource()); 
	@Override
	public int insertCustomer(String cname, String ctel, String ctype, String status, String caddr, String updateid) {
		// TODO Auto-generated method stub
		 
			String sql="insert into M_CUSTOMER(CUSTOMER_NM,START_DATE,ADDRESS,CONNECT_KIND,CUSTOMER_TYPE,IS_VALID,UPDATE_DATE,UPDATE_USER_ID)values(?,SYSDATE(),?,?,?,?,SYSDATE(),?)";
			Object[] params={cname,caddr,ctel,ctype,status,updateid};
			
				int i=0;
				try {
					i = qr.update(sql, params);
					return i;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				return i;
	}

	@Override
	public AdminCustomerBean searchCustomer(String cname, String ctel) {
		// TODO Auto-generated method stub
		String sql="select * from M_CUSTOMER where CUSTOMER_NM=? and CONNECT_KIND=?";
		try {
			String[] params={cname,ctel};
			//qr.query(sql, params, new BeanHandler<AdminUserBean>(AdminUserBean.class));
			AdminCustomerBean acb=qr.query(sql,new BeanHandler<AdminCustomerBean>(AdminCustomerBean.class),params);
			if(acb==null){
				System.out.println("----------------------------");
			}else{
				return acb;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<AdminCustomerBean> selectall(String cname, String ctel, String[] ctype, String[] status) {
		// TODO Auto-generated method stub
		   String sql="select * from M_CUSTOMER where 1=1";
		  // System.out.println(sql);
		   List<String> list=new ArrayList<String>();
			if(!"".equals(cname)&&cname!=null){
				sql+=" and CUSTOMER_NM like ?";
				list.add(cname);
			}
			if(ctype.length!=0){
				if(ctype.length==1){
					sql+=" and CUSTOMER_TYPE in(?)";
					list.add(ctype[0]);
				}else if(ctype.length==2){
					sql+=" and CUSTOMER_TYPE in(?,?)";
					list.add(ctype[0]);
					list.add(ctype[1]);
				}else if(ctype.length==3){
					
					sql+=" and CUSTOMER_TYPE in(?,?,?)";
					list.add(ctype[0]);
					list.add(ctype[1]);
					list.add(ctype[2]);
				}else{
					sql+=" and CUSTOMER_TYPE in(?,?,?,?)";
					list.add(ctype[0]);
					list.add(ctype[1]);
					list.add(ctype[2]);
					list.add(ctype[3]);
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
			if(!"".equals(ctel)&&ctel!=null)
			{
				sql+=" and CONNECT_KIND=?";
			}
//			for (String string : list) {
//				System.out.println(string);
//			}
		 Object[] params=list.toArray();
		 
		 List<AdminCustomerBean> list1=new ArrayList<AdminCustomerBean>();
		 try {
			list1=qr.query(sql, new BeanListHandler<AdminCustomerBean>(AdminCustomerBean.class), params);
			return list1;
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
		}

	@Override
	public int updatec(String id, String cname, String tel, String addr, String status, String ctype) {
	
		String sql="update  M_USER set CUSTOMER_NM=?,START_DATE=SYSDATE(),CONNECT_KIND=?,CUSTOMER_TYPE=?,ADDRESS=?,IS_VALID=? where CUSTOMER_CD =?";
		try {
			Object[] params={cname,tel,ctype,addr,id};
			int i=qr.update(sql,params);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	}


