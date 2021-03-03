package kz.aitu.oop.practice.controls;

import kz.aitu.oop.practice.orders.repositories.TeamRepositories;
import kz.aitu.oop.practice.records.Team;

import java.sql.Date;
import java.util.List;


public class TeamControl {
    private final TeamRepositories repo;

    public TeamControl(TeamRepositories repo){this.repo=repo;}

    public String createTeam(int Manager_ID, int Frontend_ID, int Backend_ID){
        Team team = new Team(Manager_ID, Frontend_ID, Frontend_ID, Backend_ID);
        boolean created = repo.createTeam(team);

        return (created ? "The team created" : "The team is not created!");
    }
    public String listAllTeam(){
        List<Team> team = repo.listAllTeam();

        return team.toString();
    }
}
