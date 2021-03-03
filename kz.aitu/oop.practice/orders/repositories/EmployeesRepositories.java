package kz.aitu.oop.practice.orders.repositories;

import kz.aitu.oop.practice.records.Employees;
import java.util.List;

public interface EmployeesRepositories {
    boolean createEmployee(Employees employee);
    boolean deleteEmployee(int ID);
    boolean addSalaryOne(int ID, int salary);
    boolean addSalaryAll(int salary);
    boolean reduceSalaryOne(int ID, int salary);
    boolean reduceSalaryAll(int salary);
    Employees findByProfession(String profession);
    Employees findByName(String name);
    boolean changeProfession(int id, String profession);
    List<Employees> getAllEmployees();
}
