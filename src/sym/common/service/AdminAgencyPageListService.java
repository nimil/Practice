package sym.common.service;

import java.util.List;

import sym.common.bean.AdminAgencyBean;
import sym.common.bean.AdminUserBean;

public interface AdminAgencyPageListService {
	List<AdminAgencyBean> searchone(String aname,String sname,String[] status);
	List<AdminUserBean> searchuse(String aname);
	int agencyadd(String aname,String status,String agency,String updateid);
	int updatea(String acd,String aname,String uname,String status);
}
