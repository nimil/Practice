package sym.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sym.common.dao.ResetPasswordDao;
import sym.common.util.ConnectionPool;

public class ResetPasswordDaoimpl implements ResetPasswordDao{

	private String newpwd;
/**
 * 此方法用来验证当前输入的密码是否是当前用户的密码
 * 验证正确返回true   验证错误返回false
 */
	@Override
	public boolean findpasswd(String oldpwd,String User_cd) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionPool.getConn();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) from M_USER where USER_PSWD=? and USER_CD=?" );
			ps.setString(1, oldpwd);
			ps.setString(2, User_cd);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next()){
				i=rs.getInt(1);
			}
			if(i==1){
				return true;
			}else{
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionPool.close(ps, conn);
		}
		
		
		
		return false;
	}
	/**
	 * 此方法用来更新密码  
	 * 更新成功返回true 更新失败返回false 
	 */

	@Override
	public boolean updatepasswd(String User_cd, String newpwd) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionPool.getConn();
		PreparedStatement pstmt=null;
		String sql="update M_USER set USER_PSWD=? where USER_CD=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newpwd);
			pstmt.setString(2, User_cd);
//			System.out.println(User_cd+"----------------"+newpwd);
//			System.out.println("------------------------------"+sql);
			int i=pstmt.executeUpdate();
			
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionPool.close(pstmt, conn);
		}
		return false;
	}

}
