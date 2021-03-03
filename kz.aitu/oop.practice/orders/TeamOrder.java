package kz.aitu.oop.practice.orders;

import kz.aitu.oop.practice.connection.DBinterface.DBinteface;
import kz.aitu.oop.practice.orders.repositories.TeamRepositories;
import kz.aitu.oop.practice.records.Team;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TeamOrder implements TeamRepositories {
    private final DBinteface db;
    public TeamOrder(DBinteface db) {
        this.db = db;
    }

    @Override
    public boolean createTeam(Team team) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Team(Manager_ID, Frontend_ID, Backend_ID) VALUES(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,team.getManager_ID());
            st.setInt(2, team.getFrontend_ID());
            st.setInt(3, team.getBackend_ID());
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
    public List<Team> listAllTeam() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Team";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Team> teams = new LinkedList<>();
            while(rs.next()){
                Team team = new Team(rs.getInt("ID"),
                        rs.getInt("Manager_ID"),
                        rs.getInt("Frontend_ID"),
                        rs.getInt("Backend_ID")
                );
                teams.add(team);
            }
            return teams;
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

}
