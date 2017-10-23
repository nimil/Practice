package sym.common.bean;

import java.io.Serializable;

/**
 * �û�bean
 * @author guojl
 * @version 2014-08-11
 *
 */
public class AdminUserBean implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** �û�cd */
    private String user_cd;
    /** �û��� */
	private String user_nm;
    /** ���� */
    private String user_pswd;
    /** �绰 */
    private String user_phone;
    /** Ȩ�� */
    private String user_owner_flg;
    /** �Ƿ���Ч */
    private String is_valid;
    /** ������ */
    private String update_date;
    /** ������ */
    private String update_user_id;

	/**
	 * @return �û�CD
	 */
	public String getUser_cd() {
		return user_cd;
	}
	/**
	 * @param  �û�CD
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
	 * @param �û��� Ҫ���õ� user_nm user_nm
	 */
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	/**
	 * @return �û�����
	 */
	public String getUser_pswd() {
		return user_pswd;
	}
	/**
	 * @param �û����� Ҫ���õ� user_pswd user_pswd
	 */
	public void setUser_pswd(String user_pswd) {
		this.user_pswd = user_pswd;
	}
	/**
	 * @return �û��绰
	 */
	public String getUser_phone() {
		return user_phone;
	}
	/**
	 * @param �û��绰 Ҫ���õ� user_phone 
	 */
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	/**
	 * @return �û���������
	 */
	public String getUser_owner_flg() {
		return user_owner_flg;
	}
	/**
	 * @param �û��������� Ҫ���õ�  user_owner_flg
	 */
	public void setUser_owner_flg(String user_owner_flg) {
		this.user_owner_flg = user_owner_flg;
	}
	/**
	 * @return �Ƿ���Ч
	 */
	public String getIs_valid() {
		return is_valid;
	}
	/**
	 * @param �Ƿ���Ч Ҫ���õ� is_valid
	 */
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getUpdate_date() {
		return update_date;
	}
	/**
	 * @param ����ʱ�� Ҫ���õ�update_date
	 */
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	/**
	 * @return ������id
	 */
	public String getUpdate_user_id() {
		return update_user_id;
	}
	/**
	 * @param ������id Ҫ���õ� update_user_id
	 */
	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}


}
