package com.napier.sem;


import java.sql.*;


public class App {

    private Connection con = null;

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get an employee
        Employee emp = a.getEmployee(255530);
        emp.title = a.getMostRecentJobTitle(emp.emp_no);
        emp.salary = a.getMostRecentSalary(emp.emp_no);
        emp.dept_name = a.getMostRecentDepartmentName(emp.emp_no);
        emp.manager = a.getMostRecentManager(emp.emp_no);

        // Display results
        a.displayEmployee(emp);

        // Disconnect from database
        a.disconnect();
    }

    private String getMostRecentManager(int emp_no) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT manager.emp_no, manager.first_name, manager.last_name "
                            + "FROM employees as manager " +
                            "LEFT JOIN dept_manager as dep_man " +
                            "ON manager.emp_no = dep_man.emp_no " +
                            "LEFT JOIN departments as dep " +
                            "ON dep_man.dept_no = dep.dept_no " +
                            "LEFT JOIN dept_emp as depemp " +
                            "ON dep.dept_no = depemp.dept_no " +
                            "LEFT JOIN employees as employee " +
                            "ON depemp.emp_no = employee.emp_no "
                            + "WHERE employee.emp_no = " + emp_no
                            + " ORDER BY dep_man.from_date DESC LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee manager if valid.
            // Check one is returned
            if (rset.next())
            {
                return rset.getInt("manager.emp_no") + " "
                        + rset.getString("manager.first_name") + " "
                        + rset.getString("manager.last_name");
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee manager details");
            return null;
        }
    }

    private String getMostRecentDepartmentName(int emp_no) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT dep.dept_name, depemp.from_date "
                            + "FROM departments as dep "
                            + "LEFT JOIN dept_emp as depemp "
                            + "ON dep.dept_no = depemp.dept_no "
                            + "WHERE depemp.emp_no = " + emp_no
                            + " ORDER BY from_date DESC LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return department name if valid.
            // Check one is returned
            if (rset.next())
            {
                return rset.getString("dep.dept_name");
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee department details");
            return null;
        }
    }

    private int getMostRecentSalary(int emp_no) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT salary "
                            + "FROM salaries "
                            + "WHERE emp_no = " + emp_no
                            + " ORDER BY from_date DESC LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return salary if valid.
            // Check one is returned
            if (rset.next())
            {
                return rset.getInt("salary");
            }
            else
                return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee salary details");
            return 0;
        }
    }

    private String getMostRecentJobTitle(int emp_no) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT title "
                            + "FROM titles "
                            + "WHERE emp_no = " + emp_no
                            + " ORDER BY from_date DESC LIMIT 1";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return job title if valid.
            // Check one is returned
            if (rset.next())
            {
                return rset.getString("title");
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee job title details");
            return null;
        }
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public Employee getEmployee(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT emp_no, first_name, last_name "
                            + "FROM employees "
                            + "WHERE emp_no = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    public void displayEmployee(Employee emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.emp_no + " "
                            + emp.first_name + " "
                            + emp.last_name + "\n"
                            + emp.title + "\n"
                            + "Salary:" + emp.salary + "\n"
                            + emp.dept_name + "\n"
                            + "Manager: " + emp.manager + "\n");
        }
    }

}
