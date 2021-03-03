package kz.aitu.oop.practice;
//i import class, which i need in this class
import kz.aitu.oop.practice.controls.EmployeesControl;
import kz.aitu.oop.practice.controls.TaskControl;
import kz.aitu.oop.practice.controls.TeamControl;
//i import libraries, which I need for my work
//i wont repeat it
import java.sql.Date;
import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    //in this i just create controls for my application
    private final TeamControl teamControl;
    private final TaskControl taskControl;
    private final EmployeesControl controller;

    private final Scanner scanner;//in this i connect scanner, which i need for data entry

    public Application(TeamControl teamControl, TaskControl taskControl, EmployeesControl controller){ //it is concructor with controls
        this.teamControl = teamControl;
        this.taskControl = taskControl;
        this.controller = controller;
        scanner = new Scanner(System.in); //i create scanner in, for data entry
    }

    public void start(){
        while(true){ // it means, while we are, if we don't finish the job, the program will run no matter how many queries we enter
            System.out.println();
            System.out.println("Welcome to Employee Monitoring App");
            System.out.println("Select option: ");
            System.out.println("1. I am the Manager");
            System.out.println("2. I am the General Manager");
            System.out.println("3. I am a Employee");
            System.out.println("0. Exit");
            System.out.println();
            try { // it is for select option, and i wont repeat it
                System.out.println("Enter the option: (1-3)");
                int option = scanner.nextInt();
                // we input integer, and it is our option
                if(option == 1){
                    System.out.println("Select option: ");
                    System.out.println("1. Create new Task");
                    System.out.println("2. Set a new deadline");
                    System.out.println("3. List of all tasks");
                    System.out.println("4. List of all teams");
                    System.out.println("5. Create a new team");
                    System.out.println("0. Exit");
                    try {
                        System.out.println("Enter the option: (1-5)");
                        int option_for_m = scanner.nextInt();
                        if(option_for_m==1){
                            createTask(); // calling the method and i wont to repeat
                        }
                        else if(option_for_m ==2){
                            setDeadline();
                        }
                        else if(option_for_m == 3){
                            listAllTask();
                        }
                        else if(option_for_m == 4){
                            listAllEmployee();
                        }
                        else if(option_for_m == 5){
                            createTeam();
                        }
                        else if(option_for_m == 0){
                            System.exit(0);
                        }
                        else{
                            break; // if our input data isnt 1-5 and 0, we just break
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be integer"); // if our input data isnt integer, we go out
                        scanner.nextLine();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else if(option ==2){
                    System.out.println("Select option: ");
                    System.out.println("1. Add salary (to one)");
                    System.out.println("2. Add salary (to all)");
                    System.out.println("3. Reduce salary (for one)");
                    System.out.println("4. Reduce salary (for everyone)");
                    System.out.println("5. Find by Profession");
                    System.out.println("6. Find by Name");
                    System.out.println("7. Change an employee's profession");
                    System.out.println("8. Add an employee");
                    System.out.println("9. Dismiss an employee");
                    System.out.println("10. List of all tasks");
                    System.out.println("11. List of all employees");
                    System.out.println("12. Create a new team");
                    System.out.println("13. List of all team");
                    System.out.println("0. Exit");
                    try {
                        System.out.println("Enter the option: (1-13)");
                        int option_for_manager = scanner.nextInt();
                        if(option_for_manager==1){
                            addSalaryOne();
                        }
                        else if(option_for_manager ==2){
                            addSalaryAll();
                        }
                        else if(option_for_manager == 3){
                            reduceSalaryOne();
                        }
                        else if(option_for_manager == 4){
                            reduceSalaryAll();
                        }
                        else if(option_for_manager == 5){
                            findByProfession();
                        }
                        else if(option_for_manager == 6){
                            findByName();
                        }
                        else if(option_for_manager == 7){
                            changeProfession();
                        }
                        else if(option_for_manager == 8){
                            addEmployee();
                        }
                        else if(option_for_manager == 9){
                            deleteEmployee();
                        }
                        else if(option_for_manager == 10){
                            listAllTask();
                        }
                        else if(option_for_manager == 11){
                            getAllEmployees();
                        }
                        else if(option_for_manager == 12){
                            createTeam();
                        }
                        else if(option_for_manager == 13) {
                            listAllEmployee();
                        }
                        else if(option_for_manager == 0){
                            System. exit(0);
                        }
                        else{
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be integer");
                        scanner.nextLine();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else if(option == 3){
                    System.out.println("Select option: ");
                    System.out.println("1. List of all tasks");
                    System.out.println("2. List of all employees in the team");
                    System.out.println("0. Exit");
                    try {
                        System.out.println("Enter the option: (1-2)");
                        int option_for_e = scanner.nextInt();
                        if(option_for_e == 1){
                            listAllTask();
                        }
                        else if(option_for_e == 2){
                            listAllEmployee();
                        }
                        else if(option_for_e == 0){
                            System.exit(0);
                        }
                        else{
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input must be integer");
                        scanner.nextLine();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else if(option == 0) { // if we input zero, we go out
                    System.exit(0);
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("*******************************"); // in the end for each query to the database, this will be displayed
        }
    }

    //it is method for employees
    public void getAllEmployees(){
        String response = controller.getAllEmployees();
        System.out.println(response);
    }
    public void addSalaryOne(){
        System.out.println("Please enter ID");
        int ID = scanner.nextInt();
        System.out.println("Please enter how much you want to add");
        int salary = scanner.nextInt();
        String response = controller.addSalaryOne(ID, salary);
        System.out.println(response);
    }
    public void addSalaryAll(){
        System.out.println("Please enter how much you want to add");
        int salary = scanner.nextInt();
        String response = controller.addSalaryAll(salary);
        System.out.println(response);
    }
    public void reduceSalaryOne(){
        System.out.println("Please enter ID");
        int ID = scanner.nextInt();
        System.out.println("Please enter how much you want to reduce");
        int salary = scanner.nextInt();
        String response = controller.reduceSalaryOne(ID, salary);
        System.out.println(response);
    }
    public void reduceSalaryAll(){
        System.out.println("Please enter how much you want to reduce");
        int salary = scanner.nextInt();
        String response = controller.reduceSalaryAll(salary);
        System.out.println(response);
    }
    public void findByProfession(){
        System.out.println("Please enter profession");
        String profession = scanner.next();
        String response = controller.findByProfession(profession);
        System.out.println(response);
    }
    public void findByName(){
        System.out.println("Please enter name");
        String name = scanner.next();
        String response = controller.findByName(name);
        System.out.println(response);
    }
    public void changeProfession(){
        System.out.println("Please enter ID");
        int ID = scanner.nextInt();
        System.out.println("Please enter new profession");
        String  profession = scanner.next();
        String response = controller.changeProfession(ID, profession);
        System.out.println(response);
    }
    public void addEmployee(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter Surname");
        String surname = scanner.next();
        System.out.println("Please enter gender");
        String gender = scanner.next();
        System.out.println("Please enter birthday");
        Date birthday = Date.valueOf(scanner.next());
        System.out.println("Please enter profession");
        String profession = scanner.next();
        System.out.println("Please enter Salary");
        int salary = scanner.nextInt();

        String response = controller.createEmployee(name, surname, gender, birthday, profession, salary);
        System.out.println(response);
    }
    public void deleteEmployee(){
        System.out.println("Please enter ID");
        int ID = scanner.nextInt();

        String response = controller.deleteEmployee(ID);
        System.out.println(response);
    }

    //it is method for team
    public void createTeam(){
        System.out.println("Please enter Manager ID");
        int manager_id = scanner.nextInt();
        System.out.println("Please enter Frontend ID");
        int frontend_id = scanner.nextInt();
        System.out.println("Please enter Backend ID");
        int backend_id = scanner.nextInt();

        String response = teamControl.createTeam(manager_id, frontend_id, backend_id);
        System.out.println(response);
    }
    public void listAllEmployee(){
        String response = teamControl.listAllTeam();
        System.out.println(response);
    }

    //it is method for task
    public void listAllTask(){
        String response = taskControl.listAllTask();
        System.out.println(response);
    }
    public void setDeadline(){
        System.out.println("Please enter ID of the Task");
        int ID = scanner.nextInt();
        System.out.println("Please enter a new deadline");
        Time deadline = Time.valueOf(scanner.next());
        String response = taskControl.setDeadline(ID, deadline);
        System.out.println(response);
    }
    public void createTask(){
        System.out.println("Please enter Team ID");
        int ID = scanner.nextInt();
        System.out.println("Please enter Title");
        String title = scanner.next();
        System.out.println("Please enter Deadline");
        Time deadline = Time.valueOf(scanner.next());
        System.out.println("Please enter payment");
        int payment = scanner.nextInt();

        String response = taskControl.createTask(ID, title, deadline, payment);
        System.out.println(response);
    }

}
