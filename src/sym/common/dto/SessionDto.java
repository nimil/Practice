package sym.common.dto;
/**
 * ����Ҫ���û���Ϣ��װ��SessionDto�����У�������session��ʹ��
 * 
 * @author guojl
 * @version 2014-08-11
 */
public class SessionDto  {
	/** �û�CD **/
	private String user_cd;
	
	/** �û��� **/
	private String user_nm;
	
    /** �û�Ȩ�� **/
	private String user_owner_flg;

	public void reset() {

	}

	/**
	 * @return CD
	 */
	public String getUser_cd() {
		return user_cd;
	}

	/**
	 * @param CD 
	 */
	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}

	/**
	 * @return �û���
	 */
	public String getUser_nm() {
		return user_nm;
	}

	/**
	 * @param user_nm
	 */
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	/**
	 * @return user_owner_flg �û�Ȩ��
	 */
	public String getUser_owner_flg() {
		return user_owner_flg;
	}

	/**
	 * @param user_owner_flg  
	 */
	public void setUser_owner_flg(String user_owner_flg) {
		this.user_owner_flg = user_owner_flg;
	}



}
