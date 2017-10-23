package sym.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import sym.common.bean.Cable;
import sym.common.bean.Order;
import sym.common.bean.RtnMoney;
import sym.common.dao.OrderDao;
import sym.common.util.ConnectionPool;


public class OrderDaoImpl implements OrderDao {

  /** 瀹氫箟鏁版嵁搴撴搷浣滅敤鍒扮殑瀵硅薄 **/
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  int count = 0;
 
   

  public void addOrder(Order order) {
    // 1.鑾峰彇杩炴帴
    conn = ConnectionPool.getConn();
    // 2.鍒涘缓sql
    String sql = "insert into m_order values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try {
      // 3.缁欏崰浣嶇璧嬪��
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, order.getOrder_cd());
      pstmt.setString(2, order.getContract_num());
      pstmt.setString(3, order.getSalesman());
      pstmt.setString(4, order.getAgent_name());
      pstmt.setString(5, order.getClient_sort());
      pstmt.setString(6, order.getClient_name());
      pstmt.setString(7, order.getProject_name());
      pstmt.setString(8, order.getDeliver_month());
      pstmt.setString(9, order.getSend_month());
      pstmt.setBigDecimal(10, order.getBid_price());
      pstmt.setBigDecimal(11, order.getAccount());
      pstmt.setString(12, order.getCurr_name());
      pstmt.setBigDecimal(13, order.getTotal());
      pstmt.setBigDecimal(14, order.getComm_rate());
      pstmt.setBigDecimal(15, order.getComm_pay());
      pstmt.setString(16, "F");
      // 4.鍙戦�佹墽琛宻ql
      pstmt.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      // 閲婃斁杩炴帴
      ConnectionPool.close(pstmt, rs, conn);
    }
  }



@Override
public String getNextRtnId(String contract_num) {
	// TODO Auto-generated method stub
	String orderId = "";
    // 1.获取连接
    conn = ConnectionPool.getConn();
    // 2.创建sql
    String sql = "select max(cast(ORDER_CD as number))+1 as nextId from m_order";
    try {
      pstmt = conn.prepareStatement(sql);
      // 4.发送执行sql
      rs = pstmt.executeQuery();
      // 5.从结果集中取数据
      while (rs.next()) {
        orderId = rs.getString("nextId");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionPool.close(pstmt, rs, conn);
    }
    return orderId;
}



@Override
public void addRtnMoney(RtnMoney rtn) {
	// TODO Auto-generated method stub
	// 1.获取连接
    conn = ConnectionPool.getConn();
    // 2.创建sql
    String sql = "insert into m_rtnmoney values(?,?,?,?,?)";

    try {
      // 3.给占位符赋值
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, rtn.getRtnmon_cd());
      pstmt.setString(2, rtn.getScale());
      pstmt.setString(3, rtn.getMonth());
      pstmt.setString(4, rtn.getAmount());
      pstmt.setString(5, rtn.getContract_num());
      // 4.发送执行sql
      pstmt.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      // 释放连接
      ConnectionPool.close(pstmt, rs, conn);
    }
}



@Override
public void deleteRtnMoneyById(String contract_num) {
	// TODO Auto-generated method stub
	// 1.获取连接
    conn = ConnectionPool.getConn();
    // 2.创建sql
    String sql = "delete from m_rtnmoney where contract_num=? ";

    try {
      // 3.给占位符赋值
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, contract_num);
      // 4.发送执行sql
      pstmt.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      // 释放连接
      ConnectionPool.close(pstmt, rs, conn);
    }
}



@Override
public String getNextOrderId() {
	// TODO Auto-generated method stub
	String orderId = "";
    // 1.获取连接
    conn = ConnectionPool.getConn();
    // 2.创建sql
    String sql = "select max(cast(ORDER_CD as number))+1 as nextId from m_order";
    try {
      pstmt = conn.prepareStatement(sql);
      // 4.发送执行sql
      rs = pstmt.executeQuery();
      // 5.从结果集中取数据
      while (rs.next()) {
        orderId = rs.getString("nextId");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionPool.close(pstmt, rs, conn);
    }
    return orderId;
}

  

}
