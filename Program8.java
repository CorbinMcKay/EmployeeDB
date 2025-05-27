//********************************************************************
//
//  Developer:     Corbin McKay
//
//  Program #:     Eight
//
//  File Name:     Program8.java
//
//  Course:        COSC 4301 Modern Programming
//
//  Due Date:      5/8/2024
//
//  Instructor:    Prof. Fred Kumi 
//
//  Java Version:  17
//
//  Description:   Database and Code Management program. Database application using JDBC to connect to Oracle 
//                 database to allow user to perform database tasks.
//                 Class ConnectToOraccleDB is used to connect to oracle database from home or acc
//                 User selects from menu options below until value 10 to exit is entered.
//                 1. Add an employee to the employee table.
//				   2. Add payroll information for an employee.
//                 3. Increase base salary by 10% for all base-plus-commission employees.
//                 4. If the employee’s birthday is in the current month, add a $100.00 bonus.
//                 5. For all commission employees with gross sales over $10,000.00, add a $250.00 bonus.
//                 6. Display information about an employee.
//                 7. Display the records matching a last name sorted by first name.
//                 8. Display the records of all the employees whose birthdays are in a given month.
//                 9. Display the records of all the employees between two given last names.
//                 10.Exit
//
//********************************************************************

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program8 
{
	
	Connection connection = null;
	Statement statement = null;
	ConnectToOracleDB dbConnect;

    //***************************************************************
    //
    //  Method:       main
    // 
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public static void main(String[] args) 
	{
		Program8 obj = new Program8();
		obj.developerInfo();
		obj.runSQLDemo();

	}
	
    //***************************************************************
    //
    //  Method:       runSQLDemo
    // 
    //  Description:  Driver method. loads drivers and connects to database. DBMenuOptions
	//                object is initialized. User runs program, and enters menu options to perform
	//                sql operations in the DBMenuOptions class. User runs program until value 10 is
	//                entered. Connection is then closed.
	//
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public void runSQLDemo()
	{
		Scanner input = new Scanner(System.in);
		// load the JDBC driver and create db connection
		createConnectionAndStatement();
		
		// create class object for DBMenuOptions
		DBMenuOptions options = new DBMenuOptions();
		
		setConnectAndStatement(options);
		
		boolean runProgram = true;     // boolean flag variable
		
		// run program until value 10 is entered
		while(runProgram)
		{
			try {
				// display menu options
				options.displayMenu();
				int selection = input.nextInt();     // get user option input
				
				// process user input option
				switch (selection) {
				case 1 -> options.addEmployee();
				case 2 -> options.addPayrollInfo();
				case 3 -> options.increaseSalaryBPC();
				case 4 -> options.birthMonthBonus();
				case 5 -> options.commissionSalesBonus();
				case 6 -> options.displayEmployeeInfo();
				case 7 -> options.getMatchingLName();
				case 8 -> options.getMatchingMonths();
				case 9 -> options.recordsBetweenLastNames();
				case 10 -> runProgram = false;
				default -> {
					System.out.println("Invalid option, please try again");
				}
				}
			} catch (InputMismatchException e) {
				System.err.println("Invalid input, please try again.");
			}
		}
		
		// loop exited, close connection
		closeConnection();
		
		System.out.println("Program exited successfuly.");
		
	}  // end of runSQLDemo method

	
	// ***************************************************************
	//
	// Method:      createConnection
	//
	// Description: Creates a database connection
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	// **************************************************************
	public void createConnectionAndStatement() 
	{
		try {
			dbConnect = new ConnectToOracleDB();
			
			dbConnect.loadDrivers();
			connection = dbConnect.connectDriver();
	
		    if (connection != null)
		    {
			   System.out.println("\nReceived success connection handle in main TestApp");
			   statement = dbConnect.createQueryStatement();
			   
			   if (statement != null)
			      System.out.println("\nQuery statement created successfully.");
		    }
		}
		catch(Exception exp)
		{
            System.out.println("Something terrible went wrong "  + exp.getMessage());
			System.exit(1);
        }
	}
	
	//***************************************************************
	//
	// Method:      selectQueryToRun
	//
	// Description: This method calls runSelectQuery to run a query
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void setConnectAndStatement(DBMenuOptions options) 
	{
		options.setConnection(connection);
		options.setStatement(statement);
    }
	
	
	//***************************************************************
	//
	// Method:      closeConnection
	//
	// Description: Calls closeDBConnection() to close the query
	//              statement and database connection.
	//
	// Parameters:  None
	//
	// Returns:     N/A
	//
	//**************************************************************
	public void closeConnection() 
	{
		try {
			dbConnect.closeDBConnection();
		} catch (Exception e) {
			System.out.println("\nClosing the Database Connection failed");
			System.exit(1);
		}
	}
	
	   //***************************************************************
	   //
	   //  Method:       developerInfo (Non Static)
	   // 
	   //  Description:  The developer information method of the program
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      N/A 
	   //
	   //**************************************************************
	   public void developerInfo()
	   {
	      System.out.println("Name:    Corbin McKay");
	      System.out.println("Course:  COSC 4301 Modern Programming");
	      System.out.println("Program: Eight\n\n");

	   } // End of the developerInfo method
	


}
