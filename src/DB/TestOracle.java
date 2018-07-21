package DB;

import java.sql.*;

public class TestOracle {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //sqlserver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.174.129:1521/orcl";
            String user = "test";

            //mysql
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://192.168.199.99:3306/xiaomai?useUnicode=true&characterEncoding=UTF-8";
//            String user = "root";

            String pass = "123456";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();

        try {

            DatabaseMetaData databaseMetaData=conn.getMetaData();
            ResultSet resultSet=databaseMetaData.getTables(conn.getCatalog(),"TEST",null,new String[]{"TABLE"});
            while (resultSet.next()){
               System.out.println(resultSet.getString("TABLE_NAME"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

