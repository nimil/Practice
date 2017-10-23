package sym.common.bean;

public class AdminAgencyBean {
private String agency_cd;
private String agency_nm;
private String agency_user_cd;
private String is_valid;
private String update_time;
private String update_agency_id;
public String getAgency_cd() {
	return agency_cd;
}
public void setAgency_cd(String agency_cd) {
	this.agency_cd = agency_cd;
}
public String getAgency_nm() {
	return agency_nm;
}
public void setAgency_nm(String agency_nm) {
	this.agency_nm = agency_nm;
}
public String getAgency_user_cd() {
	return agency_user_cd;
}
public void setAgency_user_cd(String agency_user_cd) {
	this.agency_user_cd = agency_user_cd;
}
public String getIs_valid() {
	return is_valid;
}
public void setIs_valid(String is_valid) {
	this.is_valid = is_valid;
}
public String getUpdate_time() {
	return update_time;
}
public void setUpdate_time(String update_time) {
	this.update_time = update_time;
}
public String getUpdate_agency_id() {
	return update_agency_id;
}
public void setUpdate_agency_id(String update_agency_id) {
	this.update_agency_id = update_agency_id;
}
@Override
public String toString() {
	return "AdminAgencyBean [agency_cd=" + agency_cd + ", agency_nm=" + agency_nm + ", agency_user_cd=" + agency_user_cd
			+ ", is_valid=" + is_valid + ", update_time=" + update_time + ", update_agency_id=" + update_agency_id
			+ "]";
}
public AdminAgencyBean(String agency_cd, String agency_nm, String agency_user_cd, String is_valid, String update_time,
		String update_agency_id) {
	this.agency_cd = agency_cd;
	this.agency_nm = agency_nm;
	this.agency_user_cd = agency_user_cd;
	this.is_valid = is_valid;
	this.update_time = update_time;
	this.update_agency_id = update_agency_id;
}
public AdminAgencyBean() {
}




}
