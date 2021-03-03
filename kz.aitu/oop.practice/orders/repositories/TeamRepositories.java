package kz.aitu.oop.practice.orders.repositories;

import kz.aitu.oop.practice.records.Team;

import java.util.List;

public interface TeamRepositories {
    boolean createTeam(Team team);
    List<Team> listAllTeam();
}
