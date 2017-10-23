package sym.common.bean;

import java.math.BigDecimal;
import java.util.List;

public class Order {
  private String  order_cd;
  private String  contract_num;
  private String  salesman;
  private String  agent_name;
  private String  client_sort;
  private String  client_name;
  private String  project_name;
  private String  deliver_month;
  private String  send_month;
  private BigDecimal  bid_price;
  private BigDecimal  account;
  private String  curr_name;
  private BigDecimal  total;
  private BigDecimal  comm_rate;
  private BigDecimal  comm_pay;
  private String rtn_state;
  private List<Cable> cableList;
  private List<RtnMoney> rntList;
  
  
  public String getRtn_state() {
    return rtn_state;
  }
  public void setRtn_state(String rtn_state) {
    this.rtn_state = rtn_state;
  }
  public String getOrder_cd() {
    return order_cd;
  }
  public void setOrder_cd(String order_cd) {
    this.order_cd = order_cd;
  }
  public String getContract_num() {
    return contract_num;
  }
  public void setContract_num(String contract_num) {
    this.contract_num = contract_num;
  }
  public String getSalesman() {
    return salesman;
  }
  public void setSalesman(String salesman) {
    this.salesman = salesman;
  }
  public String getAgent_name() {
    return agent_name;
  }
  public void setAgent_name(String agent_name) {
    this.agent_name = agent_name;
  }
  public String getClient_sort() {
    return client_sort;
  }
  public void setClient_sort(String client_sort) {
    this.client_sort = client_sort;
  }
  public String getClient_name() {
    return client_name;
  }
  public void setClient_name(String client_name) {
    this.client_name = client_name;
  }
  public String getProject_name() {
    return project_name;
  }
  public void setProject_name(String project_name) {
    this.project_name = project_name;
  }
  public String getDeliver_month() {
    return deliver_month;
  }
  public void setDeliver_month(String deliver_month) {
    this.deliver_month = deliver_month;
  }
  public String getSend_month() {
    return send_month;
  }
  public void setSend_month(String send_month) {
    this.send_month = send_month;
  }
  public BigDecimal getBid_price() {
    return bid_price;
  }
  public void setBid_price(BigDecimal bid_price) {
    this.bid_price = bid_price;
  }
  public BigDecimal getAccount() {
    return account;
  }
  public void setAccount(BigDecimal account) {
    this.account = account;
  }
  public String getCurr_name() {
    return curr_name;
  }
  public void setCurr_name(String curr_name) {
    this.curr_name = curr_name;
  }
  public BigDecimal getTotal() {
    return total;
  }
  public void setTotal(BigDecimal total) {
    this.total = total;
  }
  public BigDecimal getComm_rate() {
    return comm_rate;
  }
  public void setComm_rate(BigDecimal comm_rate) {
    this.comm_rate = comm_rate;
  }
  public BigDecimal getComm_pay() {
    return comm_pay;
  }
  public void setComm_pay(BigDecimal comm_pay) {
    this.comm_pay = comm_pay;
  }
  public List<Cable> getCableList() {
    return cableList;
  }
  public void setCableList(List<Cable> cableList) {
    this.cableList = cableList;
  }
  public List<RtnMoney> getRntList() {
    return rntList;
  }
  public void setRntList(List<RtnMoney> rntList) {
    this.rntList = rntList;
  }
  
 
}
