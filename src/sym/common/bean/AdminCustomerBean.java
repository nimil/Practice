package sym.common.bean;

public class AdminCustomerBean {
	private static final long serialVersionUID = 1L;
	
	
	private String CUSTOMER_NM;
	private String CUSTOMER_CD;
	private String END_DATE;
	private String START_DATE;
	private String ADDRESS;
	private String CONNECT_KIND;
	private String CUSTOMER_TYPE;
	private String IS_VALID;
	private String UPDATE_DATE;
	private String UPDATE_USER_ID;
	public String getCUSTOMER_NM() {
		return CUSTOMER_NM;
	}
	public void setCUSTOMER_NM(String cUSTOMER_NM) {
		CUSTOMER_NM = cUSTOMER_NM;
	}
	public String getCUSTOMER_CD() {
		return CUSTOMER_CD;
	}
	public void setCUSTOMER_CD(String cUSTOMER_CD) {
		CUSTOMER_CD = cUSTOMER_CD;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCONNECT_KIND() {
		return CONNECT_KIND;
	}
	public void setCONNECT_KIND(String cONNECT_KIND) {
		CONNECT_KIND = cONNECT_KIND;
	}
	public String getCUSTOMER_TYPE() {
		return CUSTOMER_TYPE;
	}
	public void setCUSTOMER_TYPE(String cUSTOMER_TYPE) {
		CUSTOMER_TYPE = cUSTOMER_TYPE;
	}
	public String getIS_VALID() {
		return IS_VALID;
	}
	public void setIS_VALID(String iS_VALID) {
		IS_VALID = iS_VALID;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	public String getUPDATE_USER_ID() {
		return UPDATE_USER_ID;
	}
	public void setUPDATE_USER_ID(String uPDATE_USER_ID) {
		UPDATE_USER_ID = uPDATE_USER_ID;
	}
	@Override
	public String toString() {
		return "AdminCustomerBean [CUSTOMER_NM=" + CUSTOMER_NM + ", CUSTOMER_CD=" + CUSTOMER_CD + ", END_DATE="
				+ END_DATE + ", START_DATE=" + START_DATE + ", ADDRESS=" + ADDRESS + ", CONNECT_KIND=" + CONNECT_KIND
				+ ", CUSTOMER_TYPE=" + CUSTOMER_TYPE + ", IS_VALID=" + IS_VALID + ", UPDATE_DATE=" + UPDATE_DATE
				+ ", UPDATE_USER_ID=" + UPDATE_USER_ID + "]";
	}
	public AdminCustomerBean(String cUSTOMER_NM, String cUSTOMER_CD, String eND_DATE, String sTART_DATE, String aDDRESS,
			String cONNECT_KIND, String cUSTOMER_TYPE, String iS_VALID, String uPDATE_DATE, String uPDATE_USER_ID) {
		CUSTOMER_NM = cUSTOMER_NM;
		CUSTOMER_CD = cUSTOMER_CD;
		END_DATE = eND_DATE;
		START_DATE = sTART_DATE;
		ADDRESS = aDDRESS;
		CONNECT_KIND = cONNECT_KIND;
		CUSTOMER_TYPE = cUSTOMER_TYPE;
		IS_VALID = iS_VALID;
		UPDATE_DATE = uPDATE_DATE;
		UPDATE_USER_ID = uPDATE_USER_ID;
	}
	public AdminCustomerBean() {
	}
	

	
	  
	
	
	
}
