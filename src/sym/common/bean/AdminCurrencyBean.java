package sym.common.bean;

public class AdminCurrencyBean {
	private static final long serialVersionUID = 1L;
	private String currency_cd;
	private String currency_nm;
	private String is_valid;
	private String update_date;
	private String update_user_id;
	public String getCurrency_cd() {
		return currency_cd;
	}
	public void setCurrency_cd(String currency_cd) {
		this.currency_cd = currency_cd;
	}
	public String getCurrency_nm() {
		return currency_nm;
	}
	public void setCurrency_nm(String currency_nm) {
		this.currency_nm = currency_nm;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user_id() {
		return update_user_id;
	}
	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}
	public AdminCurrencyBean(String currency_cd, String currency_nm, String is_valid, String update_date,
			String update_user_id) {
		this.currency_cd = currency_cd;
		this.currency_nm = currency_nm;
		this.is_valid = is_valid;
		this.update_date = update_date;
		this.update_user_id = update_user_id;
	}
	public AdminCurrencyBean() {
	}
	@Override
	public String toString() {
		return "AdminCurrencyBean [currency_cd=" + currency_cd + ", currency_nm=" + currency_nm + ", is_valid="
				+ is_valid + ", update_date=" + update_date + ", update_user_id=" + update_user_id + "]";
	}
	
	
	
	
	
}
