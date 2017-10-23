package sym.common.service.impl;

import sym.common.bean.AdminUserBean;
import sym.common.dao.impl.UserDaoImpl;
import sym.common.dto.SessionDto;

/**
 * �����û���¼��service��
 * @author guojl
 * @version 2014-08-11
 */
public class LoginServiceImpl {
   
	/**
	 * ��֤�û�cd���û�������ȷ��
	 * @param user_cd
	 * @param user_pswd
	 * @return bool true����ʾ��ȷ��½ false:��ʾ�û������������
	 */
	public boolean findUser(String user_cd,String user_pswd)
	{
		boolean bool=false; //Ĭ��Ϊfalse
		int result=new UserDaoImpl().findUser(user_cd, user_pswd);
		//����UserDao�е�findUser������������ؽ��resultΪ1����ʾ��ȷ��½����bool����Ϊtrue
		if(result==1)
		{
			bool=true;
		}
		
		return bool;
	}
	
	/**
	 * �����û�CD��ȡ�û�������Ϣ
	 * @param user_cd
	 * @return adminUserBean����
	 */
	public AdminUserBean findUserDefault(String user_cd)
	{
		 
		AdminUserBean adminUserBean=new AdminUserBean();
		//����UserDao���еķ�������ȡSessionDto����dto
		SessionDto dto=new UserDaoImpl().findUserDefault(user_cd);
		//��dto������ֵ����adminUserBean
		adminUserBean.setUser_cd(dto.getUser_cd());
		adminUserBean.setUser_nm(dto.getUser_nm());
		adminUserBean.setUser_owner_flg(dto.getUser_owner_flg());
		
		//����adminUserBean����
		return adminUserBean;
	}
}
