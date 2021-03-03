package kz.aitu.oop.practice.orders;

import kz.aitu.oop.practice.records.Employees;
import kz.aitu.oop.practice.orders.repositories.EmployeesRepositories;
import kz.aitu.oop.practice.connection.DBinterface.DBinteface;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeOrder implements EmployeesRepositories {
    private final DBinteface db;
    public EmployeeOrder(DBinteface db) {
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employees employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Employees(Name, Surname, Gender, Birthday, Profession, Salary) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getGender());
            st.setDate(4, (Date) employee.getBirthday());
            st.setString(5, employee.getProfession());
            st.setInt(6, employee.getSalary());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean deleteEmployee(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Employees WHERE ID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,ID);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean addSalaryOne(int ID, int salary) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Employees SET Salary = Salary+? WHERE ID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(2,ID);
            st.setInt(1,salary);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean addSalaryAll(int salary) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Employees SET Salary = Salary+?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,salary);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean reduceSalaryOne(int ID, int salary) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Employees SET Salary = Salary-? WHERE ID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(2,ID);
            st.setInt(1,salary);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public boolean reduceSalaryAll(int salary) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Employees SET Salary = Salary-?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,salary);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public List<Employees> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employees = new LinkedList<>();
            while(rs.next()){
                Employees employee = new Employees(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        rs.getString("Gender"),
                        rs.getDate("Birthday"),
                        rs.getString("Profession"),
                        rs.getInt("Salary")
                );

                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public Employees findByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  * FROM Employees WHERE Name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employees employee = new Employees(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        rs.getString("Gender"),
                        rs.getDate("Birthday"),
                        rs.getString("Profession"),
                        rs.getInt("Salary")
                );
                return employee;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public Employees findByProfession(String profession) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  * FROM Employees WHERE Profession=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,profession);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employees employee = new Employees(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        rs.getString("Gender"),
                        rs.getDate("Birthday"),
                        rs.getString("Profession"),
                        rs.getInt("Salary")
                );
                System.out.println(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean changeProfession(int ID, String profession) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Employees SET Profession=? WHERE ID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(2,ID);
            st.setString(1,profession);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


}
