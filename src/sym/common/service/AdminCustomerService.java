package sym.common.service;

import java.util.List;

import sym.common.bean.AdminCustomerBean;

public interface AdminCustomerService {
int	insertCustomer(String cname,String ctel,String ctype,String status,String caddr,String updateid);
AdminCustomerBean searchCustomer(String cname, String ctel);
List<AdminCustomerBean> selectall(String cname,String ctel,String[] ctype,String[] status);
int updatec(String id,String cname,String tel,String addr,String status,String ctype);
}
