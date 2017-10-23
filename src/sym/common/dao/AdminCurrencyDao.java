package sym.common.dao;

import java.util.List;

import sym.common.bean.AdminCurrencyBean;

public interface AdminCurrencyDao {
	AdminCurrencyBean madd(String mcd,String mname,String status,String update_id);
	List<AdminCurrencyBean> selectall(String mname,String[] status);
	int updatec(String ccd,String cname);
}
