package main.java.app.model;

public abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("%s | ID: %d | Nome: %s | Salário: R$ %.2f",
                this.getClass().getSimpleName(),
                id,
                name,
                calculateSalary());
    }
}