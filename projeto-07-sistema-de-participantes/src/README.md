## Projeto 07 — Sistema de Participantes

- **Objetivo:** `Set` / `HashSet`.
- **Escopo:** `1. Inscrever participante` `2. Cancelar inscrição` `3. Verificar se está inscrito` `4. Listar participantes` `0. Sair`.
- **Conceitos-alvo:** garantir não-duplicidade via `HashSet`, `equals()`/`hashCode()` em `Participant`.
- **Secundários inevitáveis:** sobrescrever `equals`/`hashCode`.
- **Não fazer:** categorias de inscrição, limite de vagas, ordenação.
- **Concluído quando:** tentar inscrever o mesmo participante duas vezes não gera duplicata.
