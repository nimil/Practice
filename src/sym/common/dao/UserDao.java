package sym.common.dao;

import sym.common.dto.SessionDto;

/**
 * �û����ݿ�������ʽӿ�
 * @author guojl
 *
 *
 */
public interface UserDao {
	/**
	 * ��֤�û���������
	 * @param user_cd
	 * @param user_pswd
	 * @return
	 */
    public int findUser(String user_cd,String user_pswd);
    
    /**
     * �����û�cd��ȡ�û���Ϣ
     * @param user_cd
     * @return
     */
    public SessionDto findUserDefault(String user_cd);
}
