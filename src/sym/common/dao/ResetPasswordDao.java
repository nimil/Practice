package sym.common.dao;

public interface ResetPasswordDao {
boolean findpasswd(String oldpwd,String User_cd);
boolean updatepasswd(String User_cd,String newpwd);
}
