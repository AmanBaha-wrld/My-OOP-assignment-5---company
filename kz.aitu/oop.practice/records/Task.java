package kz.aitu.oop.practice.records;

import java.sql.Time;

public class Task {
    private int ID; // create variables
    private String Title;
    private Time Deadline;
    private int Payment;
    public Task(){

    }
    public Task(String Title, Time Deadline, int Payment){ // use constructor without ID
        setTitle(Title);
        setDeadline(Deadline);
        setPayment(Payment);
    }
    public Task(int ID, String Title, Time Deadline, int Payment){// use constructor with ID
        setID(ID);
        setTitle(Title);
        setDeadline(Deadline);
        setPayment(Payment);
    }
    // it is setters
    public void setID(int ID){this.ID = ID;}
    public void setTitle(String Title){this.Title = Title;}
    public void setDeadline(Time Deadline){this.Deadline = Deadline;}
    public void setPayment(int Payment){this.Payment = Payment;}

    // it is getters
    public int getId() {return ID; }
    public int getPayment() {return Payment; }
    public String getTitle() {return Title; }
    public Time getDeadline() {return Deadline; }

    @Override
    public String toString() {
        return "Task{" +
                "id = " + ID + "\n" +
                "Title = " + Title + "\n" +
                "Deadline = " + Deadline + '\n' +
                "Payment = " + Payment + "\n" +
                "}";
    }
}
