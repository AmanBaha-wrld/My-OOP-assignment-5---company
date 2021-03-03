package kz.aitu.oop.practice.records;

public class Team {
    private int ID;
    private int Manager_ID;
    private int Frontend_ID;
    private int Backend_ID;
    public Team(){

    }
    public Team(int Manager_ID, int Frontend_ID, int Backend_ID){
        setManager_ID(Manager_ID);
        setBackend_ID(Frontend_ID);
        setFrontend_ID(Backend_ID);
    }
    public Team(int ID, int Manager_ID, int Frontend_ID, int Backend_ID){
        setID(ID);
        setManager_ID(Manager_ID);
        setBackend_ID(Frontend_ID);
        setFrontend_ID(Backend_ID);
    }

    public void setID(int ID){this.ID = ID;}
    public void setManager_ID(int Manager_ID){this.Manager_ID = Manager_ID;}
    public void setBackend_ID(int Frontend_ID){this.Frontend_ID = Frontend_ID;}
    public void setFrontend_ID(int Backend_ID){this.Backend_ID = Backend_ID;}

    public int getId() {return ID; }
    public int getManager_ID() {return ID; }
    public int getBackend_ID() {return ID; }
    public int getFrontend_ID() {return ID; }

    @Override
    public String toString() {
        return "Team{" +
                "id = " + ID + "\n" +
                "Manager ID = " + Manager_ID + "\n" +
                "Frontend ID = " + Frontend_ID + '\n' +
                "Backend ID = " + Backend_ID + "\n" +
                "}";
    }
}
