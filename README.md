# EmployeeDB
JDBC application to perform employee database tasks such as:
  Adding employees to the system along with payroll information to the appropriate tables,
  birthday bonuses, commission thresholds, salary increases, and displaying various information.
See the application output text below for the creation of employees and execution of queries and various menu options. 

Name:    Corbin McKay
Course:  COSC 4301 Modern Programming
Program: Eight


Are you connecting to the ACC CIT Oracle database<N>? n

Enter your home Oracle database user name: 
Enter your home Oracle database password: 

Connecting to your home Oracle database...
The database connection was successful

Product Name    : Oracle
Product Version : Oracle Database 19c Enterprise Edition Release 19.0.0.0.0 - Production
Driver Version  : 12.2.0.1.0

Received success connection handle in main TestApp

Creating a statement...

Query statement created successfully.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
1
Enter SSN (Ex: 123-45-6789) 
555-55-5555
Enter first name: 
Corbin
Enter last name: 
McKay
Enter date of birth (Ex: 22-MAR-1999)
08-OCT-1997
Enter employee type: 
pieceEmployee
Enter department name: 
SALES
Employee added. 1 row(s) inserted.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
2
Enter existing Employee SSN to add payroll information (Ex: 123-45-6789)
555-55-5555
Enter week number (1-52) : 
2
Enter piece rate: 
23.5
Enter number of pieces: 
32
Enter bonus: 
0
Piece Employee payroll information added: 1 row(s) inserted
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
1
Enter SSN (Ex: 123-45-6789) 
666-66-6666
Enter first name: 
Bob
Enter last name: 
Smith
Enter date of birth (Ex: 22-MAR-1999)
11-JAN-1981
Enter employee type: 
commissionEmployee
Enter department name: 
SALES
Employee added. 1 row(s) inserted.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
2
Enter existing Employee SSN to add payroll information (Ex: 123-45-6789)
666-66-6666
Enter week number (1-52) : 
3
Enter weekly gross sales: 
11230
Enter commission rate: 
0.06
Enter bonus: 
0
Commission Employee payroll information added: 1 row(s) inserted
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
1
Enter SSN (Ex: 123-45-6789) 
777-77-7777
Enter first name: 
Ali
Enter last name: 
Cruze
Enter date of birth (Ex: 22-MAR-1999)
22-MAY-2000
Enter employee type: 
hourlyEmployee
Enter department name: 
HR
Employee added. 1 row(s) inserted.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
2
Enter existing Employee SSN to add payroll information (Ex: 123-45-6789)
777-77-7777
Enter week number (1-52) : 
3
Enter hours worked: 
40
Enter pay rate: 
34.50
Enter bonus: 
0
Hourly Employee payroll information added: 1 row(s) inserted
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
1
Enter SSN (Ex: 123-45-6789) 
888-88-8888
Enter first name: 
Bill
Enter last name: 
Stevens
Enter date of birth (Ex: 22-MAR-1999)
28-NOV-1977
Enter employee type: 
salariedEmployee
Enter department name: 
RD
Employee added. 1 row(s) inserted.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
2
Enter existing Employee SSN to add payroll information (Ex: 123-45-6789)
888-88-8888
Enter week number (1-52) : 
3
Enter salary: 
1890.34
Enter bonus: 
0
Salaried Employee payroll information added: 1 row(s) inserted
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
1
Enter SSN (Ex: 123-45-6789) 
999-99-9999
Enter first name: 
Sarah
Enter last name: 
Lee
Enter date of birth (Ex: 22-MAR-1999)
02-JUL-1993
Enter employee type: 
basePlusCommissionEmployee
Enter department name: 
SALES
Employee added. 1 row(s) inserted.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
2
Enter existing Employee SSN to add payroll information (Ex: 123-45-6789)
999-99-9999
Enter week number (1-52) : 
3
Enter weekly salary: 
1510.40
Enter gross sales: 
5000
Enter commission rate: 
0.04
Enter bonus: 
0
Base plus commission Employee payroll information added: 1 row(s) inserted
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
3
Base Plus Commission Employee salaries increased by 10%: 5 row(s) updated.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
4
$100 birthday month bonuses added: 5 row(s) updated.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
5
Commision sales bonuses added: 3 row(s) updated.
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
6
Enter SSN to select employee: 
555-55-5555
Enter columns to display in separated by commas
Columns include: SSN, First_Name, Last_Name, Birthday, Employee_Type, Department_Name
SSN, Last_Name, Birthday, Department_Name
SSN: 555-55-5555 | 
Last_Name: McKay | 
Birthday: 1997-10-08 00:00:00.0 | 
Department_Name: SALES | 
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
7
Enter last name: 
Smith
SSN: 666-66-6666 | First Name: Bob | Last Name: Smith | Birthday: 1981-01-11 | Employee Type: commissionEmployee | Department Name: SALES
SSN: 111-11-1111 | First Name: John | Last Name: Smith | Birthday: 1945-01-02 | Employee Type: salariedEmployee | Department Name: RD
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
8
Enter full month name (e.g., November) to print records of employees whose birthdays are in that month
January
SSN: 111-11-1111 | First Name: John | Last Name: Smith | Birthday: 1945-01-02 | Employee Type: salariedEmployee | Department Name: RD
SSN: 666-66-6666 | First Name: Bob | Last Name: Smith | Birthday: 1981-01-11 | Employee Type: commissionEmployee | Department Name: SALES
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
8
Enter full month name (e.g., November) to print records of employees whose birthdays are in that month
July
SSN: 999-99-9999 | First Name: Sarah | Last Name: Lee | Birthday: 1993-07-02 | Employee Type: basePlusCommissionEmployee | Department Name: SALES
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
9
Enter last name: 
Carter
Enter another last name: 
McKay
SSN: 222-22-2222 | First Name: Sue | Last Name: Jones | Birthday: 1961-03-02 | Employee Type: commissionEmployee | Department Name: SALES
SSN: 333-33-3333 | First Name: Bob | Last Name: Lowis | Birthday: 1958-05-10 | Employee Type: basePlusCommissionEmployee | Department Name: SALES
SSN: 555-55-5555 | First Name: Corbin | Last Name: McKay | Birthday: 1997-10-08 | Employee Type: pieceEmployee | Department Name: SALES
SSN: 777-77-7777 | First Name: Ali | Last Name: Cruze | Birthday: 2000-05-22 | Employee Type: hourlyEmployee | Department Name: HR
SSN: 999-99-9999 | First Name: Sarah | Last Name: Lee | Birthday: 1993-07-02 | Employee Type: basePlusCommissionEmployee | Department Name: SALES
-----------Menu-----------
1. Add an employee to the employee table
2. Add payroll information for an employee
3. Increase base salary by 10% for all base-plus-commision employees.
4. If the employee's birthday is in the current month, add a $100.00 bonus
5. For all commision employees with gross sales over $10,000.00 add a $250.00 bonus.
6. Display information about an employee.
7. Display the records matching a last name sorted by first name
8. Display the records of all employee whose birthdays are in a given month.
9. Display the records of all employees between two given last names.
10. Exit
10

Closing the Database Connection...
Program exited successfuly.
