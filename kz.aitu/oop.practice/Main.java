package kz.aitu.oop.practice;
//in this import i connect all class to main
//this 2 class to connection to database
import kz.aitu.oop.practice.connection.DBconnection;
import kz.aitu.oop.practice.connection.DBinterface.DBinteface;

//this 3 class for actions with employees
import kz.aitu.oop.practice.controls.EmployeesControl;
import kz.aitu.oop.practice.orders.EmployeeOrder;
import kz.aitu.oop.practice.orders.repositories.EmployeesRepositories;

//this 3 class for actions with teams
import kz.aitu.oop.practice.controls.TeamControl;
import kz.aitu.oop.practice.orders.repositories.TeamRepositories;
import kz.aitu.oop.practice.orders.TeamOrder;

//this 3 class for actions with tasks
import kz.aitu.oop.practice.controls.TaskControl;
import kz.aitu.oop.practice.orders.TaskOrder;
import kz.aitu.oop.practice.orders.repositories.TaskRepositories;


public class Main {
    public static void main(String[] args) {
        DBinteface db = new DBconnection(); //in this i connection to database
        EmployeesRepositories repo = new EmployeeOrder(db); //in this i create repositories to interact with employees
        EmployeesControl controller = new EmployeesControl(repo); //in this i create controller to control and give comand to database
        //so on with teams and tasks
        TeamRepositories team_repo = new TeamOrder(db);
        TeamControl teamControl = new TeamControl(team_repo);
        TaskRepositories task_repo = new TaskOrder(db);
        TaskControl taskControl = new TaskControl(task_repo);
        Application app = new Application(teamControl, taskControl, controller);// in this i activate my apllication with thee conroller(team, task and employees controller)
        app.start(); // i start the program
    }
}
