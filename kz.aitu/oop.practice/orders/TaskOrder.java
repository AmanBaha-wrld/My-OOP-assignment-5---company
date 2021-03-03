package kz.aitu.oop.practice.orders;

import kz.aitu.oop.practice.connection.DBinterface.DBinteface;
import kz.aitu.oop.practice.orders.repositories.TaskRepositories;

import kz.aitu.oop.practice.records.Task;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TaskOrder implements TaskRepositories {
    private final DBinteface db; // connection with database
    public TaskOrder(DBinteface db) {
        this.db = db;
    }

    @Override
    public boolean createTask(Task task) { // create boolean method
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Task(ID, Title, Deadline, Payment) VALUES(?,?,?,?)"; // use sql command
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, task.getId());
            st.setString(2,task.getTitle());
            st.setTime(3, task.getDeadline());
            st.setInt(4, task.getPayment());
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
    public List<Task> listAllTask() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Task";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Task> tasks = new LinkedList<>();
            while(rs.next()){
                Task task = new Task(rs.getInt("ID"),
                        rs.getString("Title"),
                        rs.getTime("Deadline"),
                        rs.getInt("Payment")
                );
                tasks.add(task);
            }
            return tasks;
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
    public boolean setDeadline(int ID, Time Deadline) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Task SET Deadline=? WHERE ID = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(2,ID);
            st.setTime(1,Deadline);
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
