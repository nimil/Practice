package sym.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPool {
	//˽�л����췽��
	private ConnectionPool(){}
	
	//ʹ��DBCP���ӳػ�����ݿ�����(��o��)��
	private static BasicDataSource bds=new BasicDataSource();
	static{
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost/OMS?characterEncoding=UTF-8");
		bds.setUsername("root");
		bds.setPassword("123456");
		bds.setInitialSize(10);//���ó�ʼ��������
		bds.setMaxActive(80);//�������������
		bds.setMaxIdle(60);//����������������
		bds.setMinIdle(10);//������С����������
		bds.setMaxWait(3000);
	}
	
	
	public static DataSource getDataSource(){
		return bds;
	}
	
	//��ͨ����������ݿ�����
	public static Connection getConn()
	{
		 Connection conn=null;
		   String user="root"; //���ݿ��û���
		   String pass="123456";  //����
		   String url="jdbc:mysql://localhost:3306/OMS?characterEncoding=UTF-8"; //�����ַ���
		   
		   //�������ݿ���������һ������oracle����jar����ӵ���Ŀ�У��ڶ�������д���뽫��������ص��ڴ�
		   try {
			Class.forName("com.mysql.jdbc.Driver"); //�ڶ����Ĵ���
			//��ȡ����
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
