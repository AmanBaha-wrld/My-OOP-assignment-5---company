package kz.aitu.oop.practice.records;

import java.sql.Date;

public class Employees {
    private int ID;
    private String Name;
    private String Surname;
    private String Gender;
    private Date Birthday;
    private String Profession;
    private int Salary;
    public Employees(){

    }
    public Employees(String Name, String Surname, String Gender, Date Birthday, String profession, int Salary){
        setName(Name);
        setSurname(Surname);
        setGender(Gender);
        setBirthday(Birthday);
        setProfession(profession);
        setSalary(Salary);
    }
    public Employees(int ID, String Name, String Surname, String Gender, Date Birthday, String profession, int Salary){
        setID(ID);
        setName(Name);
        setSurname(Surname);
        setGender(Gender);
        setBirthday(Birthday);
        setProfession(profession);
        setSalary(Salary);
    }

    public void setID(int ID){this.ID = ID;}
    public void setGender(String gender){this.Gender=gender;}
    public void setName(String name){this.Name=name;}
    public void setSurname(String surname){this.Surname=surname;}
    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }
    public void setProfession(String profession) {
        Profession = profession;
    }
    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getSalary() {
        return Salary;
    }
    public Date getBirthday() {
        return Birthday;
    }
    public int getId() {return ID; }
    public String getName(){return Name;}
    public String getSurname(){return Surname;}
    public String getGender(){return Gender;}
    public String getProfession() {
        return Profession;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + ID + "\n" +
                "Name = " + Name + "\n" +
                "Surname = " + Surname + '\n' +
                "Gender = " + Gender + "\n" +
                "Birthday '" + Birthday + "'\n" +
                "Profession = '" + Profession + "'\n" +
                "Salary = " + Salary + "\n" +
                "}";
    }
}
