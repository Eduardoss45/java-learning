# Java Learning

Trilha prática de projetos desenvolvida para consolidar os fundamentos da linguagem Java de forma progressiva.

O repositório reúne projetos pequenos e independentes, onde cada projeto possui um **conceito-alvo principal**. A complexidade é introduzida gradualmente, evitando antecipar abstrações, frameworks ou ferramentas que não fazem parte do objetivo daquele estágio.

A proposta não é construir aplicações completas, mas utilizar problemas simples para transformar conceitos da linguagem em prática.

---

## Estrutura da trilha

A trilha está organizada em fases, seguindo uma progressão de complexidade.

### Fase 1 — POO fundamental

| Projeto             | Tema principal                                  |
| ------------------- | ----------------------------------------------- |
| 01 — Conta Bancária | Classes, objetos, construtores e encapsulamento |
| 02 — Biblioteca     | Composição                                      |
| 03 — Funcionários   | Herança, classe abstrata e polimorfismo         |
| 04 — Pagamentos     | Interfaces                                      |
| 05 — Pedidos        | `enum` e `record`                               |

### Fase 2 — Collections

| Projeto                       | Tema principal       |
| ----------------------------- | -------------------- |
| 06 — Catálogo de Produtos     | `List` / `ArrayList` |
| 07 — Sistema de Participantes | `Set` / `HashSet`    |
| 08 — Agenda Telefônica        | `Map` / `HashMap`    |
| 09 — Fila de Atendimento      | `Queue`              |
| 10 — Histórico de Navegação   | `Deque`              |

### Fase 3 — Ordenação

| Projeto                   | Tema principal              |
| ------------------------- | --------------------------- |
| 11 — Ranking de Jogadores | `Comparable` e `Comparator` |

### Fase 4 — Java moderno

| Projeto                      | Tema principal                            |
| ---------------------------- | ----------------------------------------- |
| 12 — Processador de Vendas   | Generics, lambdas e functional interfaces |
| 13 — Relatório de Vendas     | Stream API                                |
| 14 — Sistema de Configuração | `Optional`                                |
| 15 — Sistema de Reservas     | `java.time`                               |
| 16 — Sistema Financeiro      | `BigDecimal`                              |

### Fase 5 — Tratamento de erros

| Projeto               | Tema principal          |
| --------------------- | ----------------------- |
| 17 — Caixa Eletrônico | Exceptions customizadas |

### Fase 6 — I/O

| Projeto                       | Tema principal                      |
| ----------------------------- | ----------------------------------- |
| 18 — Gerenciador de Tarefas   | `Path` e `Files`                    |
| 19 — Importador de Dados JSON | Serialização e desserialização JSON |

---

## Organização dos projetos

Cada projeto é mantido como uma unidade independente dentro do monorepo.

```text
java-learning/
├── README.md
├── TODO.md
│
├── projeto-01-conta-bancaria/
│   ├── README.md
│   └── src/
│       └── main/
│           └── java/
│               └── app/
│                   ├── Main.java
│                   ├── model/
│                   ├── service/
│                   └── exception/
│
├── projeto-02-biblioteca/
│   ├── README.md
│   └── src/
│       └── ...
│
└── projeto-19-importador-json/
    ├── README.md
    └── src/
        └── ...
```

A estrutura interna segue o mesmo padrão em todos os projetos para evitar que decisões de organização desviem o foco do estudo.

### `Main.java`

Responsável apenas pela interação com o usuário:

* menu;
* leitura de entrada;
* chamadas aos serviços.

A lógica de negócio não deve ficar no `Main`.

### `model/`

Contém as classes de domínio do projeto.

As classes devem concentrar seus próprios atributos e comportamentos, sem assumir responsabilidades que pertencem ao serviço.

### `service/`

Contém as regras de negócio que envolvem múltiplos objetos, coleções ou operações do sistema.

### `exception/`

Utilizado para exceptions customizadas a partir do Projeto 17, quando fizerem parte do objetivo do projeto.

---

## Regras da trilha

Os projetos seguem algumas restrições para manter o foco nos conceitos estudados.

* Um projeto possui um único conceito-alvo.
* O escopo de cada projeto é fechado.
* Conceitos secundários aparecem somente quando forem necessários para implementar o conceito-alvo.
* Os projetos são executados pelo terminal utilizando um menu numérico simples.
* Não são utilizados banco de dados, persistência real, frameworks, APIs, GUI ou testes automatizados, salvo quando explicitamente definidos pelo projeto.
* Cada projeto deve permanecer independente dos demais.
* A conclusão é determinada pelo atendimento completo do escopo definido.
* O tempo de desenvolvimento esperado é curto; caso um projeto cresça além do objetivo, seu escopo deve ser revisado em vez de receber novas funcionalidades.

---

## Persistência e I/O

Os primeiros projetos trabalham exclusivamente com dados em memória.

Persistência em arquivo é introduzida somente nos projetos específicos para I/O:

* **Projeto 18:** arquivos de texto utilizando `Path` e `Files`.
* **Projeto 19:** leitura e escrita de JSON utilizando uma biblioteca dedicada.

A serialização nativa com `Serializable` não constitui um projeto da trilha. O conceito será estudado apenas para compreender suas características e limitações.

---

## Critério de progressão

Um projeto só é considerado concluído quando seu escopo estiver completamente implementado e o conceito-alvo puder ser explicado a partir do próprio código.

A trilha prioriza **compreensão e domínio dos fundamentos**, não quantidade de funcionalidades.

Depois do Projeto 19, a próxima etapa será um projeto maior que combinará os conceitos estudados em uma aplicação única, introduzindo progressivamente arquitetura em camadas, persistência real, testes e, posteriormente, Spring Boot.

---

## Planejamento

O planejamento completo, incluindo o escopo detalhado, conceitos-alvo, conceitos secundários, restrições e critérios específicos de conclusão de cada projeto, está mantido em:

**[`TODO.md`](TODO.md)**

O `TODO.md` representa a linha de base da trilha. Os READMEs individuais dos projetos documentam o objetivo e o escopo específico de cada etapa.
