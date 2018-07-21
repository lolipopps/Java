package DB;

import java.sql.SQLException;

public class ConnOracle {
    public static void main(String[] args) throws SQLException {
        OracleJdbcTest test = new OracleJdbcTest();
        try {
            test.query("drop table student");
        } catch (SQLException e) {}
         
        //test.query("create table test(id int, name nchar(20))");
         
        test.query("insert into test values(1,'zhangsan')");
         
        test.query("insert into test values(2,'lisi')");
         
        test.query("select * from test", true);
         
        test.close();
    }
}