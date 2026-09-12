## Projeto 10 — Histórico de Navegação

- **Objetivo:** `Deque`.
- **Escopo:** `1. Visitar página (nova URL)` `2. Voltar` `3. Avançar` `4. Mostrar página atual` `0. Sair`.
- **Conceitos-alvo:** duas `Deque<String>` (pilha de voltar e pilha de avançar) ou uma única `Deque` navegada nos dois sentidos.
- **Secundários inevitáveis:** nenhum novo.
- **Não fazer:** múltiplas abas, favoritos, histórico persistente.
- **Concluído quando:** "voltar" depois "avançar" retorna exatamente à página de onde você saiu.
