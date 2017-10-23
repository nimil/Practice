package sym.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPool {
	//私有化构造方法
	private ConnectionPool(){}
	
	//使用DBCP连接池获得数据库连接(⊙o⊙)…
	private static BasicDataSource bds=new BasicDataSource();
	static{
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost/OMS?characterEncoding=UTF-8");
		bds.setUsername("root");
		bds.setPassword("123456");
		bds.setInitialSize(10);//设置初始化连接数
		bds.setMaxActive(80);//设置最大连接数
		bds.setMaxIdle(60);//设置最大空闲连接数
		bds.setMinIdle(10);//设置最小空闲连接数
		bds.setMaxWait(3000);
	}
	
	
	public static DataSource getDataSource(){
		return bds;
	}
	
	//普通方法获得数据库连接
	public static Connection getConn()
	{
		 Connection conn=null;
		   String user="root"; //数据库用户名
		   String pass="123456";  //密码
		   String url="jdbc:mysql://localhost:3306/OMS?characterEncoding=UTF-8"; //连接字符串
		   
		   //加载数据库驱动：第一步，将oracle驱动jar包添加到项目中，第二步，编写代码将驱动类加载到内存
		   try {
			Class.forName("com.mysql.jdbc.Driver"); //第二步的代码
			//获取连接
			conn=DriverManager.getConnection(url, user, pass);		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return conn;
	}
	
	
	public static void close(PreparedStatement pstmt,Connection conn)
	{
		
			try {
				if(pstmt!=null)
				{
				pstmt.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
	
	public static void close(PreparedStatement pstmt,ResultSet rs,Connection conn)
	{
		try {
			if(pstmt!=null)
			{
			pstmt.close();
			}
			if(rs!=null)
			{
				rs.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}
}
