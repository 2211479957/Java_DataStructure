import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class 数据查询 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection con=null;
        Statement sql;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("配置成功");
        }
        catch(Exception e) {}
        String url = "jdbc:mysql://localhost:3306/yggl?user=root&password=root&useSSL=false&serverTimezone=UTC";
        try {
            con = DriverManager.getConnection(url);
        }
        catch(SQLException e) { }
        try {
            sql= con.createStatement();
            rs=sql.executeQuery("SELECT name,education,income,outcome FROM employees,salary where employees.employeeid=salary.employeeid");
            while(rs.next()) {
                String name=rs.getString(1);
                String education = rs.getString(2);
                float income = rs.getFloat(3);
                float outcome = rs.getFloat(4);
                System.out.printf("%s\t", name);
                System.out.printf("%s\t", education);
                System.out.printf("%.2f\t", income);
                System.out.printf("%.2f\t\n", outcome);
            }
            con.close();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

}