## Projeto 02 — Biblioteca

- **Objetivo:** composição.
- **Escopo:** `1. Cadastrar livro` `2. Cadastrar membro` `3. Emprestar livro` `4. Devolver livro` `5. Listar empréstimos ativos` `0. Sair`.
- **Conceitos-alvo:** uma classe (`Loan`) que tem outras duas (`Book`, `Member`) como atributos.
- **Secundários inevitáveis:** `List<Book>`, `List<Member>`, `List<Loan>`.
- **Não fazer:** multa por atraso, datas, categorias de livro, múltiplos exemplares do mesmo livro.
- **Concluído quando:** `Loan` nunca duplica dados de `Book`/`Member` — só referencia os objetos.