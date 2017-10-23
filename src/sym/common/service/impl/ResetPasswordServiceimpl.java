package sym.common.service.impl;

import sym.common.dao.impl.ResetPasswordDaoimpl;
import sym.common.service.ResetPasswordService;

public class ResetPasswordServiceimpl implements ResetPasswordService{

	@Override
	public boolean findpasswd(String oldpwd,String User_cd) {
		// TODO Auto-generated method stub

		return new ResetPasswordDaoimpl().findpasswd(oldpwd, User_cd);
	}

	@Override
	public boolean updatepasswd(String User_cd, String newpwd) {
		// TODO Auto-generated method stub
		 return new ResetPasswordDaoimpl().updatepasswd(User_cd, newpwd);
	}

	
   
	
	
}
