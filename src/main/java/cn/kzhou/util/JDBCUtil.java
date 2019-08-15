package cn.kzhou.util;

import cn.kzhou.model.PolicyModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public final class JDBCUtil {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://suzeissql08:1433;databaseName=KDZHOU_DEV";
    private static String user = "KDZHOU_DEV";;
    private static String password = "EXIGEN";;

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static Connection getConnection(){
        //注册驱动，反射方式加载
        try {
            Class.forName(driver);
            System.out.println("connecting to the database");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("creating a statement..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<PolicyModel> execuse(Date appointDate, int size){
        List<PolicyModel> list = new ArrayList<>();
        String sql = "select top (?) * from PolicySummary where effective< ?;";

        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,size);
            preparedStatement.setTimestamp(2,StrTransSqlDate(appointDate));
            resultSet =  preparedStatement.executeQuery();
            int no = 1;
            while(resultSet.next()){
                PolicyModel policyModel = new PolicyModel();
                policyModel.setNo(no++);
                policyModel.setPolicyNumber(resultSet.getString("policyNumber"));
                policyModel.setEffective(resultSet.getDate("effective"));
                policyModel.setExpiration(resultSet.getDate("expiration"));
                policyModel.setFees(resultSet.getDouble("fees"));

                System.out.println(resultSet.getString("policyNumber"));
                list.add(policyModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static java.sql.Timestamp StrTransSqlDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //java.util.Date nowDate;
        java.sql.Timestamp transdate = null;
        try {
            //nowDate = simpleDateFormat.parse(date);
            transdate = new java.sql.Timestamp(date.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return transdate;
    }
}
