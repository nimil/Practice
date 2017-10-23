package sym.common.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sym.common.dao.UserDao;
import sym.common.dto.SessionDto;
import sym.common.util.ConnectionPool;

/**
 * �û�������ص�dao��ʵ����
 * @author guojl
 * @version 2014-08-11
 */
public class UserDaoImpl implements UserDao{
	
   /** �������ݿ�����õ��Ķ��� **/
   Connection conn=null;
   PreparedStatement pstmt=null;
   ResultSet rs=null;
   
	/**
	 * �����û��������룬�ж��û���½
	 * @param user_cd
	 * @param user_pswd
	 * @return result ������� 0���û��������벻��ȷ  1����ȷ��½
	 */
	@Override
	public int findUser(String user_cd, String user_pswd)
	{
		int result=0;  //��ʼ��Ϊ0���趨��ʼ���Ϊ�û��������벻��ȷ
		//1.��������
		conn=ConnectionPool.getConn();
		
		//2.����sql
		String sql="SELECT count(U.USER_CD) FROM M_USER U WHERE U.IS_VALID = 'T' AND U.USER_CD = ? AND U.USER_PSWD = ?";
		
		try {
			//3.��ռλ����ֵ
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_cd);
			pstmt.setString(2, user_pswd);
			
			//4.����ִ��sql���
			rs=pstmt.executeQuery();
			
			//5.�жϽ��
			while(rs.next())
			{   //�ӽ������ȡ����¼��
				int num=rs.getInt("count(U.USER_CD)");
				
				//�����¼������0����ʾ��ȷ��½����result��Ϊ1
				if(num>0)
				{
				result=1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//�ͷ�����
			ConnectionPool.close(pstmt, rs, conn);
		}

		return result;
	}
	
	/**
	 * �����û�cd����ȡ�û�������Ϣ
	 * @param user_cd
	 * @return dto
	 */
	@Override
	public SessionDto findUserDefault(String user_cd)
	{
		SessionDto dto=new SessionDto();
		//1.��ȡ����
		conn=ConnectionPool.getConn();
		//2.����sql
		String sql="SELECT  USER_CD,USER_NM, USER_OWNER_FLG FROM M_USER WHERE USER_CD = ?";
		
		try {
			//3.��ռλ����ֵ
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_cd);
			//4.����ִ��sql
			rs=pstmt.executeQuery();
			
			//5.�ӽ����ȡ����,����dto���������
			while(rs.next())
			{
				dto.setUser_cd(rs.getString("USER_CD"));
				dto.setUser_nm(rs.getString("USER_NM"));
				dto.setUser_owner_flg(rs.getString("USER_OWNER_FLG"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//�ͷ�����
			ConnectionPool.close(pstmt, rs, conn);
		}
		return dto;
	}
}
