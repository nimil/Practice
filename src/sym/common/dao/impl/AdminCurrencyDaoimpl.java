package sym.common.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sym.common.bean.AdminCurrencyBean;
import sym.common.bean.AdminCustomerBean;
import sym.common.dao.AdminCurrencyDao;
import sym.common.util.ConnectionPool;

public class AdminCurrencyDaoimpl implements AdminCurrencyDao{
	 QueryRunner qr=new QueryRunner(ConnectionPool.getDataSource()); 
	@Override
	public AdminCurrencyBean madd(String mcd, String mname, String status, String update_id) {

		String sql="insert into M_CURRENCY values(?,?,?,SYSDATE(),?)";
		Object[] params={mcd,mname,status,update_id};
		
			int i=0;
			try {
				i = qr.update(sql, params);
				if(i>0){
					String sql1="select * from M_CURRENCY where CURRENCY_CD=?";
					AdminCurrencyBean acb=qr.query(sql1,new BeanHandler<AdminCurrencyBean>(AdminCurrencyBean.class),mcd);
				return acb;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
		return null;
	}
	@Override
	public List<AdminCurrencyBean> selectall(String mname, String[] status) {
		String sql="select * from M_CURRENCY where 1=1";
		// System.out.println(sql);
		   List<String> list=new ArrayList<String>();
			if(!"".equals(mname)&&mname!=null){
				sql+=" and CUSTOMER_NM like ?";
				list.add(mname);
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
		
			
//			for (String string : list) {
//				System.out.println(string);
//			}
		 Object[] params=list.toArray();
		 
		 List<AdminCurrencyBean> list1=new ArrayList<AdminCurrencyBean>();
		 try {
			list1=qr.query(sql, new BeanListHandler<AdminCurrencyBean>(AdminCurrencyBean.class), params);
			return list1;
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int updatec(String ccd, String cname) {
		String sql="update M_CURRENCY set CURRENCY_NM=? where CURRENCY_CD=? ";
		Object[] params={ccd,cname};
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
