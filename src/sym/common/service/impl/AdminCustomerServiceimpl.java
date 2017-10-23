package sym.common.service.impl;

import java.util.List;

import sym.common.bean.AdminCustomerBean;
import sym.common.dao.impl.AdminCustomerDaoimpl;
import sym.common.service.AdminCustomerService;

public class AdminCustomerServiceimpl implements AdminCustomerService{
	AdminCustomerDaoimpl acdi=new AdminCustomerDaoimpl();
	@Override
	public int insertCustomer(String cname, String ctel, String ctype, String status, String caddr,String updateid) {
		// TODO Auto-generated method stub
		if(cname==null||ctel==null||ctype==null||status==null||caddr==null){
			return 0;
		}else{
			return acdi.insertCustomer(cname, ctel, ctype, status, caddr, updateid);
		}
	}

	@Override
	public AdminCustomerBean searchCustomer(String cname, String ctel) {
		// TODO Auto-generated method stub
		return acdi.searchCustomer(cname, ctel);
	}

	@Override
	public List<AdminCustomerBean> selectall(String cname, String ctel, String[] ctype, String[] status) {
		// TODO Auto-generated method stub
		return acdi.selectall(cname, ctel, ctype, status);
	}

	@Override
	public int updatec(String id, String cname, String tel, String addr, String status, String ctype) {
		// TODO Auto-generated method stub
		return acdi.updatec(id, cname, tel, addr, status, ctype);
	}

}
