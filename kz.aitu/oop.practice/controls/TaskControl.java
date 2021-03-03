package kz.aitu.oop.practice.controls;

import kz.aitu.oop.practice.orders.repositories.TaskRepositories;
import kz.aitu.oop.practice.records.Task;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


public class TaskControl {
    private final TaskRepositories repo;

    public TaskControl(TaskRepositories repo){this.repo=repo;} // it is constructor for repositories

    public String createTask(int ID, String Title, Time Deadline, int Payment){ // it is our method to querying the database
        Task task = new Task(Title, Deadline, Payment);
        boolean created = repo.createTask(task); // we create boolean variable and go to repositries

        return (created ? "The task created" : "The task is not created!"); // if true so show "the task created" if false show "the task is not created"
    }
    public String listAllTask(){
        List<Task> tasks = repo.listAllTask(); // it is list variable

        return tasks.toString();
    }
    public String setDeadline(int ID, Time deadline){
        boolean created = repo.setDeadline(ID, deadline);

        return (created ? "The new deadline is set!" : "Please enter the correct data");
    }
}
