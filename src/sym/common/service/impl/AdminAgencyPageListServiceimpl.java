package sym.common.service.impl;

import java.util.List;

import sym.common.bean.AdminAgencyBean;
import sym.common.bean.AdminUserBean;
import sym.common.dao.AdminAgencyPageListDao;
import sym.common.dao.impl.AdminAgencyDaoimpl;
import sym.common.service.AdminAgencyPageListService;

public class AdminAgencyPageListServiceimpl implements AdminAgencyPageListService{
	private static AdminAgencyPageListDao aad=new AdminAgencyDaoimpl();
	

	@Override
	public List<AdminUserBean> searchuse(String aname) {
		// TODO Auto-generated method stub
		return aad.searchuse(aname);
	}

	@Override
	public int agencyadd(String aname, String status, String agency, String updateid) {
		// TODO Auto-generated method stub
		return aad.agencyadd(aname, status, agency, updateid);
	}

	@Override
	public List<AdminAgencyBean> searchone(String aname, String sname, String[] status) {
		// TODO Auto-generated method stub
		return aad.searchone(aname, sname, status);
	}

	@Override
	public int updatea(String acd, String aname, String uname, String status) {
		// TODO Auto-generated method stub
		return aad.updatea(acd, aname, uname, status);
	}

}
