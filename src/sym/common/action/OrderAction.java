package sym.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sym.common.bean.Order;
import sym.common.bean.RtnMoney;
import sym.common.service.OrderService;
import sym.common.service.impl.OrderServiceImpl;

public class OrderAction extends HttpServlet {
	  private static OrderService orderService = new OrderServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("addOrder".equals(method)){
			 addOrder(request, response);
			
		}
	}

	private void addOrder(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	    Order order = new Order();
	    String order_cd = orderService.getNextOrderId();
	    String num1 = request.getParameter("num1");
	    String num2 = request.getParameter("num2");
	    String contract_num = num1 + "-"+num2;
	    String salesman = request.getParameter("salesman");
	    String agent_name = request.getParameter("agent_name");
	    String client_sort = request.getParameter("client_sort");
	    String client_name = request.getParameter("client_name");
	    String project_name = request.getParameter("project_name");
	    String deliver_month = request.getParameter("deliver_month");
	    String send_month = request.getParameter("send_month");
	    String bid_price = request.getParameter("bid_price");
	    String account = request.getParameter("account");
	    String curr_name = request.getParameter("curr_name");
	    String total = request.getParameter("total");
	    String comm_rate = request.getParameter("comm_rate");
	    String comm_pay = request.getParameter("comm_pay");
	    
	    
	    order.setOrder_cd(order_cd);
	    order.setContract_num(contract_num);
	    order.setSalesman(salesman);
	    order.setAgent_name(agent_name);
	    order.setClient_sort(client_sort);
	    order.setClient_name(client_name);
	    order.setProject_name(project_name);
	    order.setDeliver_month(deliver_month);
	    order.setSend_month(send_month);
	    order.setBid_price(new BigDecimal(bid_price));
	    order.setAccount(new BigDecimal(account));
	    order.setCurr_name(curr_name);
	    order.setTotal(new BigDecimal(total));
	    order.setComm_rate(new BigDecimal(comm_rate));
	    order.setComm_pay(new BigDecimal(comm_pay));
	    orderService.addOrder(order);
	    orderService.deleteRtnMoneyById(contract_num);
	    String[] scale = request.getParameterValues("scale");
	    String[] month = request.getParameterValues("month");
	    String[] amount = request.getParameterValues("amount");
	    if((scale.length==month.length)&&(month.length==amount.length)){
	      for(int i=0;i<scale.length;i++){
	        RtnMoney rtn = new RtnMoney();
	        String rtnmon_cd = orderService.getNextRtnId(contract_num);
	        rtn.setRtnmon_cd(rtnmon_cd);
	        rtn.setScale(scale[i]);
	        rtn.setAmount(amount[i]);
	        rtn.setMonth(month[i]);
	        rtn.setContract_num(contract_num);
	        orderService.addRtnMoney(rtn);
	      }
	    }
	   
	    
	    PrintWriter out = null;
	    try {
	      out = response.getWriter();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    out.print("Ìí¼Ó³É¹¦£¡");
	    out.flush();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
