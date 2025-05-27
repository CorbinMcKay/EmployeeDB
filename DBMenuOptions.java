//********************************************************************
//
//  Developer:     Corbin McKay
//
//  Program #:     Eight
//
//  File Name:     DBMenuOptions.java
//
//  Course:        COSC 4301 Modern Programming
//
//  Due Date:      5/8/2024
//
//  Instructor:    Prof. Fred Kumi 
//
//  Java Version:  17
//
//  Description:   DBMenuOptions class object to perform sql operations. Main class connects to 
//                 database and passes the connection and statement objects. Options user selects in main
//                 file call menu options methods in this class.
//
//                 Public methods:                                   Private methods:
//				   setConnection()                                   addSalariedInfo(String ssn)
//                 setStatement()                                    addHourlyInfo(String ssn)
//                 ***menu option methods**                          addCommissionInfo(String ssn)
//                 displayMenu()                                     addPlusCommissionInfo(String ssn) 
//                 addEmployee()                                     addPieceInfo(String ssn)
//                 addPayrollInfo()                                  printEmployeeRecord(ResultSet rs)
//                 increaseSalaryBPC()
//                 birthMonthBonus()
//                 commissionSalesBonus()
//                 displayEmployeeInfo()
//                 getMatchingLName()
//                 getMatchingMonths()
//                 recordsBetweenLastNames()
//                  
//
//********************************************************************

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class DBMenuOptions 
{
	Connection connection = null;
	Statement statement = null;
	Scanner input = new Scanner(System.in);
	
	public void setConnection(Connection connection) 
	{
		this.connection = connection;
	}
	
	public void setStatement(Statement statement) 
	{
		this.statement = statement;
	}
	
	
    //***************************************************************
    //
    //  Method:       displayMenu
    // 
    //  Description:  displays menu options to the user
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void displayMenu() 
	{
		System.out.println("-----------Menu-----------");
		System.out.println("1. Add an employee to the employee table");
		System.out.println("2. Add payroll information for an employee");
		System.out.println("3. Increase base salary by 10% for all base-plus-commision employees.");
		System.out.println("4. If the employee's birthday is in the current month, add a $100.00 bonus");
		System.out.println("5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.");
		System.out.println("6. Display information about an employee.");
		System.out.println("7. Display the records matching a last name sorted by first name");
		System.out.println("8. Display the records of all employee whose birthdays are in a given month.");
		System.out.println("9. Display the records of all employees between two given last names.");
		System.out.println("10. Exit");
	}  // end of displayMenu method
	
    //***************************************************************
    //
    //  Method:       addEmployee
    // 
    //  Description:  Prompts user to enter necessary info for adding a new 
	//                employee to the employee table.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void addEmployee() 
	{
		try {
			// prompt user to enter employee information  
			System.out.println("Enter SSN (Ex: 123-45-6789) ");
			String ssn = input.nextLine();
			
			System.out.println("Enter first name: ");
			String fname = input.nextLine();
			System.out.println("Enter last name: ");
			String lname = input.nextLine();
			
			System.out.println("Enter date of birth (Ex: 22-MAR-1999)");
			String birthday = input.nextLine();
			
			// convert input string to sql date type
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	        java.util.Date date;
			date = sdf.parse(birthday);
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			System.out.println("Enter employee type: ");
			String employeeType = input.nextLine();
			
			System.out.println("Enter department name: ");
			String department = input.nextLine();
			
			// construct query statement
			String query = "INSERT INTO Employees (SSN, First_name, Last_name, Birthday, Employee_Type, Department_Name) VALUES (?, ?, ?, ?, ?, ?)";
			
			// prepared statement, set parameter values for each column
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setDate(4, sqlDate);
			ps.setString(5, employeeType);
	        ps.setString(6, department);
	        
	        // execute insert statement
	        int rowsAffected = ps.executeUpdate();     
	        System.out.println("Employee added. " + rowsAffected + " row(s) inserted.");
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}  // end of addEmployee method
	
    //***************************************************************
    //
    //  Method:       addPayrollInfo
    // 
    //  Description:  Prompts user to enter the SSN of employee they wish to add payroll information to.
	//                Prepared statement query is created to find the row with the given ssn, set as parameter and 
	//                executed. Result set is sued to get the string of employee type, which is then put in a switch
	//                statement to call the associated method to add information into. 
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void addPayrollInfo()
	{
		try {
			System.out.println("Enter existing Employee SSN to add payroll information (Ex: 123-45-6789)");
			String ssn = input.nextLine();
			
			// construct query to obtain row of desired employee to find employee type
			String query = "SELECT Employee_Type FROM Employees WHERE SSN = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			// set ssn parameter value and execute query, obtaining result set to get employee type
			ps.setString(1, ssn);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			String employeeType = rs.getString("Employee_Type");     // get string of employee type for result set
			
			// call the appropriate method to add information based on employee type
			switch(employeeType) {
			case "salariedEmployee" -> addSalariedInfo(ssn);
			case "hourlyEmployee" -> addHourlyInfo(ssn);
			case "commissionEmployee" -> addCommissionInfo(ssn);
			case "basePlusCommissionEmployee" -> addPlusCommissionInfo(ssn);
			case "pieceEmployee" -> addPieceInfo(ssn);
			default -> System.out.println("Employee type not found.");
			}
			
			input.nextLine();  // flush input
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of addPayrollInfo method
	
	
    //***************************************************************
    //
    //  Method:       increaseSalaryBPC
    // 
    //  Description:  method to increase the base salary of all base plus commission 
	//                employees by 10 percent
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void increaseSalaryBPC()
	{
		try {
			int numRowsUpdated = 0;
			// create query strings to select ssn and salary from each record in plus_commission_employees table
			String selectQuery = "SELECT SSN, Base_Salary FROM Plus_Commission_Employees";
			// create update query to update the specified row (by using primary key ssn) by setting a new base salary
			String updateQuery = "UPDATE Plus_Commission_Employees SET Base_Salary = ? WHERE SSN = ?";
			ResultSet rs = statement.executeQuery(selectQuery);
			
			while(rs.next()) 
			{
				// get the ssn and salary from result set row
				String ssn = rs.getString("SSN");
				double incSalary = rs.getDouble("Base_Salary") * 1.10;
				
				// update salary
                PreparedStatement ps = connection.prepareStatement(updateQuery);
                ps.setDouble(1, incSalary);
                ps.setString(2, ssn);
                int rowsAffected = ps.executeUpdate();
                numRowsUpdated += rowsAffected; // count the total number of updates
			}
			System.out.println("Base Plus Commission Employee salaries increased by 10%: " + numRowsUpdated + " row(s) updated.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of increaseSalaryBPC method
	
    //***************************************************************
    //
    //  Method:       birthMonthBonus
    // 
    //  Description:  method that checks if an employee in the employees table has the same birth month as the current
	//                month. If so, a $100 bonus is added.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void birthMonthBonus() {
	    try {
	        // Get current date and format to get just the month in pattern MMM
	        LocalDate currentDate = LocalDate.now();
	        String month = currentDate.getMonth().toString().toUpperCase();

	        int numRowsUpdated = 0; // Counter for updated entries

	        // Get query of all employees, with columns ssn and birthday
	        String employeeQuery = "SELECT SSN, Birthday, Employee_Type FROM Employees";
	        PreparedStatement psSelect = connection.prepareStatement(employeeQuery);
	        ResultSet rs = psSelect.executeQuery();

	        while (rs.next()) {
	            String ssn = rs.getString("SSN");
	            String employeeType = rs.getString("Employee_Type");
	            Date birthday = rs.getDate("Birthday");
	            LocalDate birthDate = birthday.toLocalDate();
	            String birthMonth = birthDate.getMonth().toString().toUpperCase();

	            // Check if birth month is current month
	            if (month.equals(birthMonth)) {
	                // Pass employeeType value into switch statement to assign value for the associated table name
	                String employeeTypeTable = switch (employeeType) {
	                    case "salariedEmployee" -> "Salaried_Employees";
	                    case "hourlyEmployee" -> "Hourly_Employees";
	                    case "commissionEmployee" -> "Commission_Employees";
	                    case "basePlusCommissionEmployee" -> "Plus_Commission_Employees";
	                    case "pieceEmployee" -> "Piece_Employees";
	                    default -> "";
	                };

	                // Get row from employee type table for the current employee
	                // Note: I chose to order by week descending, to retrieve the most current week to add bonus and to avoid adding multiple bonuses
	                String query = "SELECT SSN, Bonus FROM " + employeeTypeTable + " WHERE SSN = ?";
	                PreparedStatement psUpdate = connection.prepareStatement(query);
	                psUpdate.setString(1, ssn);

	                ResultSet addBonus = psUpdate.executeQuery();
	                if (addBonus.next()) {
	                    // Add 100 to bonus
	                    double newBonus = addBonus.getDouble("Bonus") + 100.00;

	                    // Construct update query and set parameters for the prepared statement
	                    String updateQuery = "UPDATE " + employeeTypeTable + " SET Bonus = ? WHERE SSN = ?";
	                    PreparedStatement psUpdateBonus = connection.prepareStatement(updateQuery);
	                    psUpdateBonus.setDouble(1, newBonus);
	                    psUpdateBonus.setString(2, ssn);

	                    // Execute update query
	                    int rowsAffected = psUpdateBonus.executeUpdate();
	                    numRowsUpdated += rowsAffected;
	                }
	            }
	        }
	        System.out.println("$100 birthday month bonuses added: " + numRowsUpdated + " row(s) updated.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}  // end of birthMonthBonus method
	
	
    //***************************************************************
    //
    //  Method:       commissionSalesBonus
    // 
    //  Description:  method that checks if a commission employee has gross sales over 10000 and adds a 
	//                $250 bonus 
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void commissionSalesBonus()
	{
		try {
			// query to get result set of commission employees with gross sales over 10000
			String query = "SELECT SSN, Week_Number, Gross_Sales, Bonus FROM Commission_Employees WHERE Gross_Sales > 10000";
			ResultSet rs = statement.executeQuery(query);
			
			int numRowsUpdated = 0;
			
			// iterate result set
			while(rs.next()) {
				// get column values
				String ssn = rs.getString("SSN");
				int week = rs.getInt("Week_Number");
				double salesBonus = rs.getDouble("Bonus") + 250.00;     // add 250 to bonus

				// prepare update query, set bonus where ssn and week number match current entry
				String updateQuery = "UPDATE Commission_Employees SET Bonus = ? WHERE SSN = ? AND Week_Number = ?";
				PreparedStatement ps = connection.prepareStatement(updateQuery);
				
				// set parameter values
				ps.setDouble(1, salesBonus);
				ps.setString(2, ssn);
				ps.setInt(3, week);
				
				// execute update query
				int updates = ps.executeUpdate();
				numRowsUpdated += updates;
			}
			System.out.println("Commision sales bonuses added: " + numRowsUpdated + " row(s) updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of commissionSalesBonus method
	
	
    //***************************************************************
    //
    //  Method:       displayEmployeeInfo
    // 
    //  Description:  method that lets user select the employee (SSN) and column(s) to display in
	//                order to display information about an employee.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void displayEmployeeInfo()
	{
		try {
			// prompt user to enter employee ssn
			System.out.println("Enter SSN to select employee: ");
			String ssn = input.nextLine();
			
			// prompt user to enter desire columns
			System.out.println("Enter columns to display in separated by commas");
			System.out.println("Columns include: SSN, First_Name, Last_Name, Birthday, Employee_Type, Department_Name");
			String columns = input.nextLine();
			String [] columnNames = columns.split(", ");     // array to hold column names for iteration when displaying values for each column
			
			// build query
			String query = "SELECT " + columns + " FROM Employees WHERE SSN = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			
			ResultSet rs = ps.executeQuery();     // execute query and get result set
			
			// if there is a result set, iterate columnNames string, passing each column name value into result set getString parameter to retrieve value
			if(rs.next()) {
				for(String column : columnNames) {
					System.out.println(column + ": " + rs.getString(column) + " | ");
				}	
			} 
			else {     // no result set, invalid input
				System.out.println("Invalid ssn, please try again");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of displayEmployeeInfo method
	
	
    //***************************************************************
    //
    //  Method:       getMatchingLName
    // 
    //  Description:  method that asks user for a last name and prints the records
	//                matching the given last name, sorted by first name
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void getMatchingLName()
	{
		try {
			// prompt user to enter last name
			System.out.println("Enter last name: ");
			String lname = input.nextLine();
			
			// construct query
			String query = "SELECT * FROM Employees WHERE Last_Name = ? ORDER BY First_Name";
			
			// set parameter and execute query
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, lname);
			ResultSet rs = ps.executeQuery();
			
			// iterate through result set and call private method to display record information for the set
			while(rs.next()) {
				printEmployeeRecord(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of getMatchingLName
	
	
    //***************************************************************
    //
    //  Method:       getMatchingMonths
    // 
    //  Description:  method that asks user to enter a full month name and displays
	//                all employee records with matching birthday month
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void getMatchingMonths()
	{
		try {
			// get user input month
			System.out.println("Enter full month name (e.g., November) to print records of employees whose birthdays are in that month");
			String month = input.nextLine().toUpperCase();
			String abrevMonth = Month.valueOf(month).toString();
			
			// get query of all employees, with columns ssn and birthday
			String query = "SELECT * FROM Employees";
			ResultSet rs = statement.executeQuery(query);
			
			// iterate through query of all employees and check birthday month
			while(rs.next()) {
				
				// get month from birthday
				Date birthday = rs.getDate("Birthday");
				LocalDate birthDate = birthday.toLocalDate();
				String birthMonth = birthDate.getMonth().toString().toUpperCase();
				
				// if matching months print the employee record
				if(birthMonth.equalsIgnoreCase(abrevMonth)) {
					printEmployeeRecord(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of getMatchingMonths method
	
	
    //***************************************************************
    //
    //  Method:       recordsBetweenLastNames
    // 
    //  Description:  prints the records of all employees between two given last names 
	//                input by the user.
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void recordsBetweenLastNames()
	{
		try {
			System.out.println("Enter last name: ");
			String lname1 = input.nextLine();
			
			System.out.println("Enter another last name: ");
			String lname2 = input.nextLine();
			
			String query = "SELECT * FROM Employees WHERE Last_Name >= ? AND Last_Name <= ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			// compare which name comes before the other 
			int compare = lname1.compareToIgnoreCase(lname2);
			
			// user compare value to determine where each name is inserted into query statement
			if(compare < 0) {
				//lname1 comes before lname2
				ps.setString(1, lname1);
				ps.setString(2, lname2);
			}
			else {
				//lname2 comes before lname1 or they are equal
				ps.setString(1, lname2);
				ps.setString(2, lname1);
			}
			
			// execute query and store into result set
			ResultSet rs = ps.executeQuery();
			
			// iterate result set and display each record
			while(rs.next()) {
				printEmployeeRecord(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}  // end of recordsBetweenLastNames method
	
    //***************************************************************
    //
    //  Method:       addSalariedInfo
    // 
    //  Description:  private method called by addPayrollInfo to add salaried employee
	//                information.
    //
    //  Parameters:   ssn: String
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void addSalariedInfo(String ssn) 
	{
		try {
			// prompt user to enter salaried info values
			System.out.println("Enter week number (1-52) : ");
			int week = input.nextInt();
			
			System.out.println("Enter salary: ");
			double salary = input.nextDouble();
			
			System.out.println("Enter bonus: ");
			double bonus = input.nextDouble();
			
			// construct query insert statement
			String query = "INSERT into Salaried_Employees (SSN, Week_Number, Weekly_Salary, Bonus) Values (?, ?, ?, ?)";
			
			// use prepare statement to set parameter values
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setInt(2, week);
			ps.setDouble(3, salary);
			ps.setDouble(4, bonus);
			
			// execute sql query insert statement, display to user info is added and the rows inserted to verify
			int rowsAffected = ps.executeUpdate();
			System.out.println("Salaried Employee payroll information added: " + rowsAffected + " row(s) inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of addSalariedInfo method
	
    //***************************************************************
    //
    //  Method:       addHourlyInfo
    // 
    //  Description:  private method called by addPayrollInfo to add hourly employee
	//                information.
    //
    //  Parameters:   ssn: String
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void addHourlyInfo(String ssn) 
	{
		try {
			// prompt user to enter hourly info values
			System.out.println("Enter week number (1-52) : ");
			int week = input.nextInt();
			
			System.out.println("Enter hours worked: ");
			double hours = input.nextDouble();
			
			System.out.println("Enter pay rate: ");
			double payRate = input.nextDouble();
			
			System.out.println("Enter bonus: ");
			double bonus = input.nextDouble();
			
			// construct query insert statement
			String query = "INSERT into Hourly_Employees (SSN, Week_Number, Hours_worked, Pay_Rate, Bonus) Values (?, ?, ?, ?, ?)";
			
			// use prepare statement to set parameter values
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setInt(2, week);
			ps.setDouble(3, hours);
			ps.setDouble(4, payRate);
			ps.setDouble(5, bonus);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Hourly Employee payroll information added: " + rowsAffected + " row(s) inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of addHourlyInfo method
	
    //***************************************************************
    //
    //  Method:       addCommissionInfo
    // 
    //  Description:  private method called by addPayrollInfo to add commission employee
	//                information.
    //
    //  Parameters:   ssn: String
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void addCommissionInfo(String ssn) 
	{
		try {
			// prompt user to enter commission info values
			System.out.println("Enter week number (1-52) : ");
			int week = input.nextInt();
			
			System.out.println("Enter weekly gross sales: ");
			double sales = input.nextDouble();
			
			System.out.println("Enter commission rate: ");
			double commissionRate = input.nextDouble();
			
			System.out.println("Enter bonus: ");
			double bonus = input.nextDouble();
			
			// construct query insert statement
			String query = "INSERT into Commission_Employees (SSN, Week_Number, Gross_Sales, Commission_Rate, Bonus) Values (?, ?, ?, ?, ?)";
			
			// use prepare statement to set parameter values
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setInt(2, week);
			ps.setDouble(3, sales);
			ps.setDouble(4, commissionRate);
			ps.setDouble(5, bonus);
			
			// execute insert sql statement
			int rowsAffected = ps.executeUpdate();
			System.out.println("Commission Employee payroll information added: " + rowsAffected + " row(s) inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of addCommissionInfo method
	
    //***************************************************************
    //
    //  Method:       addPlusCommissionInfo
    // 
    //  Description:  private method called by addPayrollInfo to add plus commission employee
	//                information.
    //
    //  Parameters:   ssn: String
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void addPlusCommissionInfo(String ssn) 
	{
		try {
			// prompt user to enter salaried info values
			System.out.println("Enter week number (1-52) : ");
			int week = input.nextInt();
			
			System.out.println("Enter weekly salary: ");
			double salary = input.nextDouble();
			
			System.out.println("Enter gross sales: ");
			double sales = input.nextDouble();
			
			System.out.println("Enter commission rate: ");
			double commissionRate = input.nextDouble();
			
			System.out.println("Enter bonus: ");
			double bonus = input.nextDouble();
			
			// construct query insert statement
			String query = "INSERT into Plus_Commission_Employees (SSN, Week_Number, Base_Salary, Gross_Sales, Commission_Rate, Bonus) Values (?, ?, ?, ?, ?, ?)";
			
			// use prepare statement to set parameter values
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setInt(2, week);
			ps.setDouble(3, salary);
			ps.setDouble(4, sales);
			ps.setDouble(5, commissionRate);
			ps.setDouble(6, bonus);
			
			// execute insert sql statement
			int rowsAffected = ps.executeUpdate();
			System.out.println("Base plus commission Employee payroll information added: " + rowsAffected + " row(s) inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of addPlusCommissionInfo method
	
    //***************************************************************
    //
    //  Method:       addPieceInfo
    // 
    //  Description:  private method called by addPayrollInfo to add piece employee
	//                information.
    //
    //  Parameters:   ssn: String
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void addPieceInfo(String ssn) 
	{
		try {
			// prompt user to enter hourly info values
			System.out.println("Enter week number (1-52) : ");
			int week = input.nextInt();
			
			System.out.println("Enter piece rate: ");
			double pieceRate = input.nextDouble();
			
			System.out.println("Enter number of pieces: ");
			int numPieces = input.nextInt();
			
			System.out.println("Enter bonus: ");
			double bonus = input.nextDouble();
			
			// construct query insert statement
			String query = "INSERT into Piece_Employees (SSN, Week_Number, Piece_Rate, Number_Pieces, Bonus) Values (?, ?, ?, ?, ?)";
			
			// use prepare statement to set parameter values
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setInt(2, week);
			ps.setDouble(3, pieceRate);
			ps.setInt(4, numPieces);
			ps.setDouble(5, bonus);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Piece Employee payroll information added: " + rowsAffected + " row(s) inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // end of addPieceInfo method
	
	
    //***************************************************************
    //
    //  Method:       printEmployeeRecord
    // 
    //  Description:  Accepts result set as parameter and prints the
	//                employee record information for the current result set cursor.
    //
    //  Parameters:   rs: ResultSet
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	private void printEmployeeRecord(ResultSet rs)
	{
		try {
			// get record data and display to user
			String record = "SSN: " + rs.getString("SSN") + " | First Name: " + rs.getString("First_Name") + " | Last Name: " 
					+ rs.getString("Last_Name") + " | Birthday: " + rs.getDate("Birthday").toString() + " | Employee Type: " 
					+ rs.getString("Employee_Type") + " | " + "Department Name: " + rs.getString("Department_Name");
			System.out.println(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  // end of printEmployeeRecord method
	
	
}
