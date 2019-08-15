package cn.kzhou.dao;

import cn.kzhou.model.PolicyModel;
import cn.kzhou.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PolicyDao {
    //注入Jdbctemplate属性操作JDBC
    private JdbcTemplate jdbcTemplate;

/*    public void reduceMoney(){
        String stringSql = "update account set salary = salary-? where username=?";
        jdbcTemplate.update(stringSql,new Object[]{4,"小王"});
        String stringSql2 = "select * from account where username=?";
        jdbcTemplate.query(stringSql2,new Object[]{"小王"}, new ResultSetExtractor<PolicyModel>() {
            @Override
            public PolicyModel extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    PolicyModel orderModel = new PolicyModel();
                    orderModel.setUserName(rs.getString("username"));
                    orderModel.setSalary(rs.getInt("salary"));
                    System.out.println(orderModel.toString());
                    return orderModel;
                }
                return null;
            }
        });
    }*/

    public List<PolicyModel> quaryPolicySummary(Date appointDate, int size){
        List<PolicyModel> list = JDBCUtil.execuse(appointDate,size);
        return list;
    }
    public void addMoney(){
        String sql = "update account set salary = salary +? where username=?";
        jdbcTemplate.update(sql,new Object[]{4,"小张"});
    }

    //set方法注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
