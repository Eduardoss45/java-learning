package main.java.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.app.model.Designer;
import main.java.app.model.Developer;
import main.java.app.model.Employee;
import main.java.app.model.Manager;

public class FuncionarioService {
    private final List<Employee> employees = new ArrayList<>();

    public void cadastrarDeveloper(int id, String name, double baseSalary, int projectsCompleted) {
        validarId(id);
        employees.add(new Developer(id, name, baseSalary, projectsCompleted));
    }

    public void cadastrarManager(int id, String name, double baseSalary, int teamSize) {
        validarId(id);
        employees.add(new Manager(id, name, baseSalary, teamSize));
    }

    public void cadastrarDesigner(int id, String name, double baseSalary, int teamSize) {
        validarId(id);
        employees.add(new Designer(id, name, baseSalary, teamSize));
    }

    public List<Employee> listarTodos() {
        return new ArrayList<>(employees);
    }

    public double calcularFolhaTotal() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }
        return total;
    }

    private void validarId(int id) {
        Optional<Employee> existente = employees.stream().filter(e -> e.getId() == id).findFirst();

        if (existente.isPresent()) {
            throw new IllegalArgumentException("Já existe um funcionário com este ID.");
        }
    }
}
