import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerTest {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=TradeDB";
        String user = "sa";
        String password = "RayyanKhan";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to SQL Server successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

