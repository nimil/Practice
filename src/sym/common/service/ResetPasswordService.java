package sym.common.service;

public interface ResetPasswordService {
	//��֤��һ���û�����ĺϷ���
	boolean findpasswd(String oldpwd,String User_cd);
	boolean updatepasswd(String User_cd,String newpwd);
}
