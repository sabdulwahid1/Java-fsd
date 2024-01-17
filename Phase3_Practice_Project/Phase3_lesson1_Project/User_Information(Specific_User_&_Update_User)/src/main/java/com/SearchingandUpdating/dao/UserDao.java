package com.SearchingandUpdating.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.SearchingandUpdating.entity.UserEntity;
@Repository
public class UserDao {
@Autowired
JdbcTemplate jdbcTemplate;
public List<UserEntity> getAllUsers() {
return jdbcTemplate.query("select * from user", new RowMapper<UserEntity>()
{
public UserEntity mapRow(ResultSet rs, int rowNum) throws
SQLException {
UserEntity obj = new UserEntity();
obj.setId(rs.getLong(1));
obj.setName(rs.getString(2));
obj.setSalary(rs.getBigDecimal(3));
return obj;
}
});
}
public UserEntity getUserById(long id) {
return jdbcTemplate.query("select * from user where id=" + id,
new ResultSetExtractor<UserEntity>() {
public UserEntity extractData(ResultSet rs) throws
SQLException, DataAccessException {
// TODO Auto-generated method stub
if (rs.next()) {
UserEntity obj = new UserEntity();
obj.setId(rs.getLong(1));
obj.setName(rs.getString(2));
obj.setSalary(rs.getBigDecimal(3));
return obj;
}
return null;
}
});
}
public void updateUser(long id,String name,String salary) {
String sql = "update user set name="+"'"+name+"'"+","+"salary="+salary+" whereid="+id;
jdbcTemplate.update(sql);
}
}
