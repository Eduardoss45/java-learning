package main.java.app.model;

public class Manager extends Employee {
    private int teamSize;

    public Manager(int id, String name, double baseSalary, int teamSize) {
        super(id, name, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (teamSize * 300);
    }
}
