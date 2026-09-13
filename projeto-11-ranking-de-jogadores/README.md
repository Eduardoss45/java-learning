## Projeto 11 — Ranking de Jogadores

- **Objetivo:** `Comparable` e `Comparator`.
- **Escopo:** `1. Cadastrar jogador (nome, pontuação, idade)` `2. Ranking por pontuação` `3. Ranking por nome` `4. Ranking por idade` `0. Sair`.
- **Conceitos-alvo:** `Player implements Comparable<Player>` (ordenação natural por pontuação) + `Comparator` externo para nome e idade.
- **Secundários inevitáveis:** `Collections.sort()` ou `list.sort()`.
- **Não fazer:** empates com desempate múltiplo, histórico de partidas, ranking persistente.
- **Concluído quando:** você sabe dizer a diferença entre a ordenação natural (`Comparable`) e a ordenação por critério externo (`Comparator`).
