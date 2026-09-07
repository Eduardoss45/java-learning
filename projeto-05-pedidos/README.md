## Projeto 05 — Pedidos

- **Objetivo:** `enum` e `record`.
- **Escopo:** `1. Criar pedido` `2. Avançar status do pedido` `3. Listar pedidos por status` `0. Sair`.
- **Conceitos-alvo:** `enum OrderStatus { CREATED, PAID, SHIPPED, DELIVERED, CANCELLED }`; um `record` para item de pedido (ex: `record OrderItem(String product, int qty)`).
- **Secundários inevitáveis:** `List<Order>`, `List<OrderItem>` dentro de `Order`.
- **Não fazer:** cálculo de frete, pagamento real, estoque.
- **Concluído quando:** a transição de status segue uma ordem lógica (não dá pra ir de `CREATED` direto pra `DELIVERED`).
