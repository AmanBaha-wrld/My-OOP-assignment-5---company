package kz.aitu.oop.practice.controls;

import kz.aitu.oop.practice.orders.repositories.EmployeesRepositories;
import kz.aitu.oop.practice.records.Employees;

import java.sql.Date;
import java.util.List;

public class EmployeesControl {
    private final EmployeesRepositories repo;

    public EmployeesControl(EmployeesRepositories repo){this.repo=repo;}

    public String createEmployee(String name, String Surname, String Gender, Date Birthday, String Profession, int salary){
        Employees employee = new Employees(name, Surname, Gender, Birthday, Profession, salary);
        boolean created = repo.createEmployee(employee);

        return (created ? "The employee is hired!" : "Please enter the correct data! ");
    }
    public String deleteEmployee(int ID){
        boolean deleted = repo.deleteEmployee(ID);

        return (deleted ? "The employee is dismissed!" : "Please enter the correct data! ");
    }
    public  String findByName(String name){
        Employees employee = repo.findByName(name);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }
    public  String findByProfession(String profession){
        Employees employee = repo.findByProfession(profession);

        return (employee == null ? "Profession was not found!" : employee.toString());
    }
    public String addSalaryOne(int ID, int salary){
        boolean employee = repo.addSalaryOne(ID, salary);

        return (employee ? "Successfully added" : "Please enter the correct data!");
    }
    public String addSalaryAll(int salary){
        boolean employee = repo.addSalaryAll(salary);

        return (employee ? "Successfully added" : "Please enter the correct data!");
    }
    public String reduceSalaryOne(int ID, int salary){
        boolean employee = repo.reduceSalaryOne(ID, salary);

        return (employee ? "Successfully added" : "Please enter the correct data!");
    }
    public String reduceSalaryAll(int salary){
        boolean employee = repo.reduceSalaryAll(salary);

        return (employee ? "Successfully added" : "Please enter the correct data!");
    }
    public String changeProfession(int ID, String profession){
        boolean employee = repo.changeProfession(ID, profession);

        return (employee ? "Successfully changed" : "Please enter the correct data!");
    }

    public String getAllEmployees(){
        List<Employees> employees = repo.getAllEmployees();

        return employees.toString();
    }
}
