package sym.common.dao;

import java.util.HashMap;
import java.util.List;

import sym.common.bean.Cable;
import sym.common.bean.Order;
import sym.common.bean.RtnMoney;

public interface OrderDao {

	 
	  public void addOrder(Order order);

	public String getNextRtnId(String contract_num);

	public void addRtnMoney(RtnMoney rtn);

	public void deleteRtnMoneyById(String contract_num);
	public String getNextOrderId();

  
  
}
