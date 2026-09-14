## Projeto 12 — Processador de Vendas

- **Objetivo:** generics, lambdas, functional interfaces.
- **Escopo:** `1. Registrar venda (produto, cliente, valor)` `2. Filtrar vendas acima de um valor` `3. Encontrar maior venda` `4. Listar vendas` `0. Sair`.
- **Conceitos-alvo:** `Predicate<Sale>`, `Function<Sale, X>`, uso de lambda em vez de classe anônima.
- **Secundários inevitáveis:** `List<Sale>`.
- **Não fazer:** Stream API ainda (deixe para o Projeto 13), relatórios agregados complexos.
- **Concluído quando:** pelo menos uma operação recebe uma lambda como parâmetro (ex: método genérico de filtro).
