## Projeto 03 — Funcionários

- **Objetivo:** herança, classe abstrata, polimorfismo.
- **Escopo:** `1. Cadastrar funcionário (Developer/Manager/Designer)` `2. Listar funcionários` `3. Calcular folha de pagamento total` `0. Sair`.
- **Conceitos-alvo:** `abstract class Employee` com `abstract double calculateSalary()`; cada subtipo implementa diferente.
- **Secundários inevitáveis:** `List<Employee>`, `@Override`.
- **Não fazer:** benefícios, impostos, hierarquia de cargos, mais de 3 subtipos.
- **Concluído quando:** o código que soma a folha chama `employee.calculateSalary()` sem nenhum `if (employee instanceof ...)`.
