## Projeto 04 — Pagamentos

- **Objetivo:** interfaces.
- **Escopo:** `1. Cadastrar forma de pagamento (Pix/Cartão/Transferência)` `2. Processar pagamento` `3. Listar pagamentos processados` `0. Sair`.
- **Conceitos-alvo:** `interface PaymentMethod { void process(double valor); }`.
- **Secundários inevitáveis:** `List<PaymentMethod>` ou `List<Payment>` (registro do processamento).
- **Não fazer:** validação de cartão, taxas por método, gateway real, mais de 3 implementações.
- **Concluído quando:** o código consumidor referencia sempre `PaymentMethod`, nunca `Pix`/`CreditCard` diretamente.
