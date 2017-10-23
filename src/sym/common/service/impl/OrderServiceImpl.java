package sym.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sym.common.bean.Cable;
import sym.common.bean.Order;
import sym.common.bean.RtnMoney;
import sym.common.dao.OrderDao;
import sym.common.dao.impl.OrderDaoImpl;
import sym.common.service.OrderService;


public class OrderServiceImpl  implements OrderService {
  private static OrderDao orderDao = new OrderDaoImpl();

@Override
public void addOrder(Order order) {
	// TODO Auto-generated method stub
	orderDao.addOrder(order);
}

@Override
public String getNextRtnId(String contract_num) {
	// TODO Auto-generated method stub
	return orderDao.getNextRtnId(contract_num);
}

@Override
public void addRtnMoney(RtnMoney rtn) {
	// TODO Auto-generated method stub
	orderDao.addRtnMoney(rtn);
}

@Override
public void deleteRtnMoneyById(String contract_num) {
	// TODO Auto-generated method stub
	orderDao.deleteRtnMoneyById(contract_num);
}

@Override
public String getNextOrderId() {
	// TODO Auto-generated method stub
	return orderDao.getNextOrderId();
}




 
}
