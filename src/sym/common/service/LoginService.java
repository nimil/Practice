package sym.common.service;

import sym.common.bean.AdminUserBean;

/**
 * �û���½����service��
 * @author guojl
 *
 */
public interface LoginService {
    /**
     * �ж��û�CD�������Ƿ���ȷ
     * @param user_cd
     * @param user_pswd
     * @return
     */
	public boolean findUser(String user_cd,String user_pswd);
	/**
	 * �����û�CD��ȡ�û���Ϣ
	 * @param user_cd
	 * @return
	 */
	public AdminUserBean findUserDefault(String user_cd);
}
