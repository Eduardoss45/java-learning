package main.java.app.model;

public class Developer extends Employee {
    private int projectsCompleted;

    public Developer(int id, String name, double baseSalary, int projectsCompleted) {
        super(id, name, baseSalary);
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (projectsCompleted * 500);
    }
}
