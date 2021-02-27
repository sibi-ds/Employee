import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * This class used to
 * Create,Read,Update,Delete
 * employee details
 *
 * @author  sibi
 * @created 2021-02-23
 */
public class EmployeeManagement {

    private Map<Integer, Employee> employees = new LinkedHashMap<Integer, Employee>();

    public static void main(String[] args) {
        int employeeId = 1;    // to track the current key
        byte option = 0;       // to track the command of the user

        EmployeeManagement employeeManagement = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("select an option to perform a particular operation on an employee's details");

        while (5 != option) {
            System.out.println("1 - Create , 2 - Display all employees , 3 - Update , 4 - Delete , 5 - Exit");
            option = scanner.nextByte();
            scanner.nextLine();

            switch (option) {
                case 1:
                    employeeManagement.createEmployee(employeeId);
                    employeeId++;
                    break;

                case 2:
                    employeeManagement.displayEmployees();
                    break; 

                case 3:
                    employeeManagement.updateEmployee();
                    break;

                case 4:
                    System.out.println("Enter employee's ID to delete the employee");
                    employeeManagement.deleteEmployee(scanner.nextInt());
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Enter valid option");
            }
        }
    }
    
    /*
     * creates an employee object and store it in employees database
     *
     * @param employeeId    unique value to point the details of an employee
     */
    void createEmployee(int employeeId) {
        System.out.println("Enter employee's details ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name          : ");
        String name = scanner.nextLine();
        System.out.print("Birth Date    : ");
        byte birthDate = scanner.nextByte();
        System.out.print("Birth Month   : ");
        byte birthMonth = scanner.nextByte();
        System.out.print("Birth Year    : ");
        short birthYear = scanner.nextShort();
        System.out.print("Salary        : ");
        float salary = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Mobile Number : ");
        String mobileNumber = String.valueOf(scanner.nextLong());
                
        employees.put(employeeId
                , new Employee(employeeId, name, birthDate, birthMonth, birthYear, salary, mobileNumber));
        System.out.println("Employee details stored successfully");
    }

    /*
     * iterates over all the employeeIDs
     * and displays the details of each employee
     */
    void displayEmployees() {
        System.out.println("\n******** Employees Database ********\n");
        employees.forEach((employeeId, employeeDetails) -> {
            System.out.println("ID     : " + employeeDetails.getId()
                    + "\nNAME   : " + employeeDetails.getName()
                    + "\nDOB    : " + employeeDetails.getBirthDate() + " - "
                                    + employeeDetails.getBirthMonth() + " - "
                                    + employeeDetails.getBirthYear()
                    + "\nSALARY : " + employeeDetails.getSalary() + " INR"
                    + "\nMOBILE : " + employeeDetails.getMobileNumber() + "\n");
        });
    }

    /*
     * gets the employee ID value and parameter that
     * need to be updated and then updates an detail of the employee
     */
    void updateEmployee() {
        System.out.println("Enter employee's ID to update details");
        Scanner scanner = new Scanner(System.in);
        int employeeId = scanner.nextInt();

        if (!employees.containsKey(employeeId)) {
            System.out.println("Employee details not present");
            return;
        }

        System.out.println("Choose which detail need to be updated");

        while (true) {
            System.out.println("N - Name , D - DOB , S - Salary , M - Mobile number , C - Cancel Updation");
            char updationParameter = scanner.next().charAt(0);
            scanner.nextLine();

            switch (updationParameter) {
                case 'N':
                    System.out.println("Enter updated NAME");
                    employees.get(employeeId).setName(scanner.nextLine());
                    System.out.println("Updation Successful");
                    break;

                case 'D':
                    System.out.println("Enter updated DOB in DD , MM , YYYY order");
                    employees.get(employeeId).setBirthDate(scanner.nextByte());
                    employees.get(employeeId).setBirthMonth(scanner.nextByte());
                    employees.get(employeeId).setBirthYear(scanner.nextShort());
                    System.out.println("Updation Successful");
                    scanner.nextLine();
                    break;

                case 'S':
                    System.out.println("Enter SALARY");
                    employees.get(employeeId).setSalary(scanner.nextFloat());
                    System.out.println("Updation Successful");
                    scanner.nextLine();
                    break;

                case 'M':
                    System.out.println("Enter updated MOBILE NUMBER");
                    employees.get(employeeId).setMobileNumber(scanner.next());
                    System.out.println("Updation Successful");
                    break;

                case 'C':
                    System.out.println("Updation cancelled");
                    return;

                default:
                    System.out.println("Enter valid option");
                    break;
            }

        }

    }

    /*
     * get employee ID from the user and
     * deletes all the details of the employee
     *
     * @param employeeId    refers the certain employee's details
     */
    void deleteEmployee(int employeeId) {
        if (!employees.containsKey(employeeId)) {
            System.out.println("Employee details not present");
            return;
        }

        employees.remove(employeeId);
        System.out.println("Deletion Successful");
    }

} 