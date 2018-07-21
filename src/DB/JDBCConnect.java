package DB;
import java.sql.*;  
public class JDBCConnect {  
    public static Connection getConn() throws Exception  
    {  
         String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
  
          String dbURL="jdbc:sqlserver://192.168.174.129:1433;DatabaseName=Test";  
  
          String userName="sa";  
  
          String userPwd="123456";    
            
          Class.forName(driverName);  
            
          Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);  
            
          return dbConn;    
      
          
    }  
    public static void main(String[] args) throws Exception {  
    	Connection conn = getConn();
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("select * from Test1");
    	
    	ResultSetMetaData data = rs.getMetaData();
    	String columnNames = "";
    	for (int i = 1; i <= data.getColumnCount(); i++) {
			// 获得指定列的列名
    		String columnName = data.getColumnName(i);
    		if(columnNames == "") {
    			columnNames = columnName;
    		}else {
			
			columnNames =columnNames +"," +  columnName;
    		}
			
		}
    	rs = stmt.executeQuery("select count(*) as total from Test1");
    	int total = rs.getRow();
    	System.out.println(total);
    	
    	while(rs.next()) {
    		total = rs.getInt("total");
    	}
    	System.out.println(total);
        if(!getConn().isClosed())  
        {  
            System.out.println(columnNames);  
        }  
    }  
}
  