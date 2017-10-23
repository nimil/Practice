package sym.common.service;

public interface ResetPasswordService {
	//验证第一个用户密码的合法性
	boolean findpasswd(String oldpwd,String User_cd);
	boolean updatepasswd(String User_cd,String newpwd);
}
