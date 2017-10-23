package sym.common.service.impl;

import java.util.List;

import sym.common.bean.AdminCurrencyBean;
import sym.common.dao.AdminCurrencyDao;
import sym.common.dao.impl.AdminCurrencyDaoimpl;

public class AdminCurrencyServiceimpl implements AdminCurrencyDao{
	AdminCurrencyDaoimpl acdi=new AdminCurrencyDaoimpl();
	@Override
	public AdminCurrencyBean madd(String mcd, String mname, String status, String update_id) {
		// TODO Auto-generated method stub
		return acdi.madd(mcd, mname, status, update_id);
	}
	@Override
	public List<AdminCurrencyBean> selectall(String mname, String[] status) {
		// TODO Auto-generated method stub
		return acdi.selectall(mname, status);
	}
	@Override
	public int updatec(String ccd, String cname) {
		// TODO Auto-generated method stub
		return acdi.updatec(ccd, cname);
	}

}
