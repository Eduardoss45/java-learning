package main.java.app.model;

public class Designer extends Employee {
    private int completedDesigns;

    public Designer(int id, String name, double baseSalary, int completedDesigns) {
        super(id, name, baseSalary);
        this.completedDesigns = completedDesigns;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (completedDesigns * 400);
    }
}
