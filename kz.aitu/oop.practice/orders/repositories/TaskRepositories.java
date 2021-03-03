package kz.aitu.oop.practice.orders.repositories;

import kz.aitu.oop.practice.records.Task;

import java.sql.Time;
import java.util.List;

public interface TaskRepositories { // it is our storage for method
    boolean createTask(Task task);
    List<Task> listAllTask();
    boolean setDeadline(int ID, Time deadline);
}
