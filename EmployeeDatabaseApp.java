import java.sql.*;
import java.util.*;

public class EmployeeDatabaseApp {
    
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Method to connect to database
    private static Connection connect() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // explicitly load driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC",
            "root",
            "1234"
        );
    }

    // method for adding employee
    public static void add(String name, String dept, double salary){
        String sql1 = "INSERT INTO employees(name, department, salary) VALUES(?, ?, ?)";

        // we use try catch so that it will close automatic 
        try(Connection con = connect();
            PreparedStatement pstm = con.prepareStatement(sql1)) {
            
            pstm.setString(1, name);
            pstm.setString(2, dept);
            pstm.setDouble(3, salary);

            pstm.executeUpdate();

            System.out.println("===Employee added successfully!===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method to view the employee
    public static void view(){
        String sql = "SELECT * FROM employees";

        try(Connection con = connect();
            Statement stmt = con.createStatement();
            ResultSet rslt = stmt.executeQuery(sql)){

                System.out.println("\n===Employee List===");

                while(rslt.next()){
                    System.out.println("ID: " + rslt.getInt("id") +
                                   ", Name: " + rslt.getString("name") +
                                   ", Department: " + rslt.getString("department") +
                                   ", Salary: " + rslt.getDouble("salary"));
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }

    }

    // method to updating the employee
    public static void update(int id, String name, String dept, double salary) {
        String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";

        try (Connection con = connect(); PreparedStatement psmt = con.prepareStatement(sql)) {

            // these are updated values when we set
            psmt.setString(1, name);
            psmt.setString(2, dept);
            psmt.setDouble(3, salary);
            psmt.setInt(4, id);

            int rows = psmt.executeUpdate();

            if (rows > 0)
                System.out.println("===Employee updated successfully!===");
            else
                System.out.println("==No employee found with that ID.==");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to delete an employee
    public static void delete(int id) {
        String sql = "DELETE FROM employees WHERE id=?";

        try (Connection con = connect(); PreparedStatement psmt = con.prepareStatement(sql)) {
            psmt.setInt(1, id);

            int rows = psmt.executeUpdate();
            if (rows > 0)
                System.out.println("===Employee deleted successfully!===");
            else
                System.out.println("==No employee found with that ID.==");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) { 
            System.out.println("\n=== Employee Database Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch(choice){

                // Create
                case 1:
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    add(name, dept, salary);
                    break;

                // Read
                case 2:
                    view();
                    break;

                // Update
                case 3:
                    System.out.println("Enter the Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    System.out.println("Enter updated name: ");
                    String Uname = sc.nextLine();
                    System.out.println("Enter the updated department: ");
                    String Udept = sc.nextLine();
                    System.out.println("Enter updated salary: ");
                    double Usalary = sc.nextDouble();
                    update(id, Uname, Udept, Usalary);
                    break;
                
                // Delete
                case 4:
                    System.out.println("Enter Id to delete: ");
                    int Did = sc.nextInt();
                    delete(Did);
                    break;

                // exiting program
                case 5: 
                    System.out.println("Exiting the program...Bye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again!");
            }
        }
        sc.close();
    }
}
