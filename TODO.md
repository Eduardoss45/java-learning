# Trilha de Projetos Java — Modelo Fechado

## Regra geral (vale para os 20 projetos, sem exceção)

1. **Um projeto = um conceito-alvo.** Os "conceitos secundários" são só os que são *impossíveis de evitar* para o alvo funcionar.
2. **Escopo é fixo, não sugestivo.** A lista de funcionalidades de cada projeto é o teto, não o piso. Se não está na lista, não entra.
3. **Sem persistência real, sem banco de dados, sem framework, sem testes automatizados, sem API, sem GUI** — em nenhum dos 20 projetos, salvo indicação explícita (Projetos 18 e 19, que são especificamente sobre arquivo/JSON).
4. **Todo projeto roda no terminal com um menu numérico simples.** Sempre a mesma cara. Você não perde tempo decidindo "como" apresentar o programa, só o quê ele faz.
5. **Critério de conclusão é binário**: ou o programa faz exatamente o que está no escopo, ou não está pronto. Não existe "vou deixar mais bonito depois" — se sobrar energia, você começa o próximo projeto, não poli o atual.
6. **Tempo-alvo: 1 a 3 sessões de estudo por projeto.** Se passar disso, é sinal de que você extrapolou o escopo — volte e corte.

---

## Estrutura de pastas padrão (use em todos os projetos)

Isso elimina a variação de "como organizar" — você usa sempre a mesma, e só o conteúdo muda:

```
projeto-XX-nome/
 └── src/
     └── main/
         └── java/
             └── app/
                 ├── Main.java          -> só o menu e chamadas
                 ├── model/             -> classes de domínio (Conta, Livro, Produto...)
                 ├── service/           -> regras de negócio (BankService, LibraryService...)
                 └── exception/         -> exceptions customizadas (a partir do Projeto 17)
```

Regras da estrutura:
- `Main.java` **nunca** contém lógica de negócio. Só menu, leitura de input (`Scanner`) e chamadas para a camada `service`.
- `model` são classes "burras": atributos, getters, comportamentos que dizem respeito só àquele objeto.
- `service` é onde vive a lógica que envolve mais de um objeto ou uma coleção de objetos.
- Nada de pacote `util`, `helper`, `manager` genérico. Se você sentir necessidade de um desses, é sinal de que a responsabilidade está mal distribuída entre `model` e `service` — resolva ali.

---

## Template de cada projeto (copie isso para cada um)

```
OBJETIVO:
ESCOPO (funcionalidades exatas do menu):
CONCEITOS-ALVO:
CONCEITOS SECUNDÁRIOS INEVITÁVEIS:
NÃO FAZER:
CRITÉRIO DE CONCLUSÃO:
```

---

# Fase 1 — POO fundamental

## Projeto 01 — Conta Bancária
- **Objetivo:** classes, objetos, construtores, `this`, encapsulamento.
- **Escopo:** `1. Criar conta` `2. Depositar` `3. Sacar` `4. Consultar saldo` `0. Sair`.
- **Conceitos-alvo:** atributos privados + getters, construtor, `this`.
- **Secundários inevitáveis:** `Scanner`, `if`, `List<Conta>` em memória para guardar as contas criadas.
- **Não fazer:** múltiplos tipos de conta, juros, taxas, arquivo, herança.
- **Concluído quando:** você consegue explicar por que `saldo` é privado e por que existe `depositar()`/`sacar()` em vez de alterar `saldo` direto.

## Projeto 02 — Biblioteca
- **Objetivo:** composição.
- **Escopo:** `1. Cadastrar livro` `2. Cadastrar membro` `3. Emprestar livro` `4. Devolver livro` `5. Listar empréstimos ativos` `0. Sair`.
- **Conceitos-alvo:** uma classe (`Loan`) que tem outras duas (`Book`, `Member`) como atributos.
- **Secundários inevitáveis:** `List<Book>`, `List<Member>`, `List<Loan>`.
- **Não fazer:** multa por atraso, datas, categorias de livro, múltiplos exemplares do mesmo livro.
- **Concluído quando:** `Loan` nunca duplica dados de `Book`/`Member` — só referencia os objetos.

## Projeto 03 — Funcionários
- **Objetivo:** herança, classe abstrata, polimorfismo.
- **Escopo:** `1. Cadastrar funcionário (Developer/Manager/Designer)` `2. Listar funcionários` `3. Calcular folha de pagamento total` `0. Sair`.
- **Conceitos-alvo:** `abstract class Employee` com `abstract double calculateSalary()`; cada subtipo implementa diferente.
- **Secundários inevitáveis:** `List<Employee>`, `@Override`.
- **Não fazer:** benefícios, impostos, hierarquia de cargos, mais de 3 subtipos.
- **Concluído quando:** o código que soma a folha chama `employee.calculateSalary()` sem nenhum `if (employee instanceof ...)`.

## Projeto 04 — Pagamentos
- **Objetivo:** interfaces.
- **Escopo:** `1. Cadastrar forma de pagamento (Pix/Cartão/Transferência)` `2. Processar pagamento` `3. Listar pagamentos processados` `0. Sair`.
- **Conceitos-alvo:** `interface PaymentMethod { void process(double valor); }`.
- **Secundários inevitáveis:** `List<PaymentMethod>` ou `List<Payment>` (registro do processamento).
- **Não fazer:** validação de cartão, taxas por método, gateway real, mais de 3 implementações.
- **Concluído quando:** o código consumidor referencia sempre `PaymentMethod`, nunca `Pix`/`CreditCard` diretamente.

## Projeto 05 — Pedidos
- **Objetivo:** `enum` e `record`.
- **Escopo:** `1. Criar pedido` `2. Avançar status do pedido` `3. Listar pedidos por status` `0. Sair`.
- **Conceitos-alvo:** `enum OrderStatus { CREATED, PAID, SHIPPED, DELIVERED, CANCELLED }`; um `record` para item de pedido (ex: `record OrderItem(String product, int qty)`).
- **Secundários inevitáveis:** `List<Order>`, `List<OrderItem>` dentro de `Order`.
- **Não fazer:** cálculo de frete, pagamento real, estoque.
- **Concluído quando:** a transição de status segue uma ordem lógica (não dá pra ir de `CREATED` direto pra `DELIVERED`).

---

# Fase 2 — Collections

## Projeto 06 — Catálogo de Produtos
- **Objetivo:** `List` / `ArrayList`.
- **Escopo:** `1. Adicionar produto` `2. Remover produto` `3. Buscar produto por nome` `4. Listar todos` `0. Sair`.
- **Conceitos-alvo:** `ArrayList`, iteração, busca linear.
- **Secundários inevitáveis:** nenhum além do que já foi visto.
- **Não fazer:** ordenação, filtros complexos, categorias, estoque com quantidade mínima.
- **Concluído quando:** busca e remoção funcionam por critério (nome), não por índice digitado manualmente.

## Projeto 07 — Sistema de Participantes
- **Objetivo:** `Set` / `HashSet`.
- **Escopo:** `1. Inscrever participante` `2. Cancelar inscrição` `3. Verificar se está inscrito` `4. Listar participantes` `0. Sair`.
- **Conceitos-alvo:** garantir não-duplicidade via `HashSet`, `equals()`/`hashCode()` em `Participant`.
- **Secundários inevitáveis:** sobrescrever `equals`/`hashCode`.
- **Não fazer:** categorias de inscrição, limite de vagas, ordenação.
- **Concluído quando:** tentar inscrever o mesmo participante duas vezes não gera duplicata.

## Projeto 08 — Agenda Telefônica
- **Objetivo:** `Map` / `HashMap`.
- **Escopo:** `1. Adicionar contato` `2. Buscar contato por nome` `3. Remover contato` `4. Listar contatos` `0. Sair`.
- **Conceitos-alvo:** `Map<String, String>` (nome → telefone) ou `Map<String, Contact>` se quiser guardar mais dados.
- **Secundários inevitáveis:** nenhum novo.
- **Não fazer:** múltiplos telefones por contato, grupos, favoritos.
- **Concluído quando:** busca por chave é O(1) na sua cabeça — você sabe dizer por que não está usando `List` aqui.

## Projeto 09 — Fila de Atendimento
- **Objetivo:** `Queue`.
- **Escopo:** `1. Adicionar cliente à fila` `2. Atender próximo` `3. Ver próximo da fila` `4. Mostrar fila completa` `0. Sair`.
- **Conceitos-alvo:** `Queue<String>` (ou `Queue<Client>`) com `LinkedList` como implementação, `offer()`/`poll()`/`peek()`.
- **Secundários inevitáveis:** nenhum novo.
- **Não fazer:** prioridade de atendimento, tempo de espera, múltiplos guichês.
- **Concluído quando:** você consegue explicar por que é FIFO e não conseguiria fazer isso de forma tão direta com `List`.

## Projeto 10 — Histórico de Navegação
- **Objetivo:** `Deque`.
- **Escopo:** `1. Visitar página (nova URL)` `2. Voltar` `3. Avançar` `4. Mostrar página atual` `0. Sair`.
- **Conceitos-alvo:** duas `Deque<String>` (pilha de voltar e pilha de avançar) ou uma única `Deque` navegada nos dois sentidos.
- **Secundários inevitáveis:** nenhum novo.
- **Não fazer:** múltiplas abas, favoritos, histórico persistente.
- **Concluído quando:** "voltar" depois "avançar" retorna exatamente à página de onde você saiu.

---

# Fase 3 — Ordenação

## Projeto 11 — Ranking de Jogadores
- **Objetivo:** `Comparable` e `Comparator`.
- **Escopo:** `1. Cadastrar jogador (nome, pontuação, idade)` `2. Ranking por pontuação` `3. Ranking por nome` `4. Ranking por idade` `0. Sair`.
- **Conceitos-alvo:** `Player implements Comparable<Player>` (ordenação natural por pontuação) + `Comparator` externo para nome e idade.
- **Secundários inevitáveis:** `Collections.sort()` ou `list.sort()`.
- **Não fazer:** empates com desempate múltiplo, histórico de partidas, ranking persistente.
- **Concluído quando:** você sabe dizer a diferença entre a ordenação natural (`Comparable`) e a ordenação por critério externo (`Comparator`).

---

# Fase 4 — Java moderno

## Projeto 12 — Processador de Vendas
- **Objetivo:** generics, lambdas, functional interfaces.
- **Escopo:** `1. Registrar venda (produto, cliente, valor)` `2. Filtrar vendas acima de um valor` `3. Encontrar maior venda` `4. Listar vendas` `0. Sair`.
- **Conceitos-alvo:** `Predicate<Sale>`, `Function<Sale, X>`, uso de lambda em vez de classe anônima.
- **Secundários inevitáveis:** `List<Sale>`.
- **Não fazer:** Stream API ainda (deixe para o Projeto 13), relatórios agregados complexos.
- **Concluído quando:** pelo menos uma operação recebe uma lambda como parâmetro (ex: método genérico de filtro).

## Projeto 13 — Relatório de Vendas
- **Objetivo:** Stream API.
- **Escopo:** reaproveite as vendas do Projeto 12 e ofereça `1. Total vendido` `2. Produto mais vendido` `3. Vendas por cliente` `4. Média de vendas` `0. Sair`.
- **Conceitos-alvo:** `stream().filter().map().collect()`, `groupingBy`, `sorted`.
- **Secundários inevitáveis:** `Collectors`.
- **Não fazer:** paralelismo (`parallelStream`), múltiplas fontes de dados, exportação de relatório.
- **Concluído quando:** nenhuma das 4 operações usa `for` — todas usam Stream.

## Projeto 14 — Sistema de Configuração
- **Objetivo:** `Optional`.
- **Escopo:** `1. Definir configuração (chave/valor)` `2. Buscar configuração (pode não existir)` `3. Buscar com valor padrão` `0. Sair`.
- **Conceitos-alvo:** `Optional<String>`, `orElse`, `orElseThrow`, `isPresent`/`ifPresent`.
- **Secundários inevitáveis:** `Map<String, String>` por baixo.
- **Não fazer:** usar `Optional` como atributo de classe (é anti-padrão — aprenda isso na prática, não só na teoria).
- **Concluído quando:** você sabe justificar por que `Optional` é usado no retorno da busca e não em outro lugar.

## Projeto 15 — Sistema de Reservas
- **Objetivo:** `java.time`.
- **Escopo:** `1. Criar reserva (data, hora início, hora fim)` `2. Verificar conflito de horário` `3. Listar reservas futuras` `4. Calcular duração de uma reserva` `0. Sair`.
- **Conceitos-alvo:** `LocalDate`, `LocalTime`, `LocalDateTime`, `Duration`.
- **Secundários inevitáveis:** `List<Reservation>`.
- **Não fazer:** fuso horário (`ZonedDateTime`), recorrência de reservas, notificações.
- **Concluído quando:** o sistema recusa corretamente uma reserva que colide com outra já existente.

## Projeto 16 — Sistema Financeiro
- **Objetivo:** `BigDecimal`.
- **Escopo:** `1. Registrar transação (valor, tipo: crédito/débito)` `2. Consultar saldo` `3. Aplicar juros simples sobre saldo` `0. Sair`.
- **Conceitos-alvo:** `BigDecimal` para todo valor monetário, `setScale`, `RoundingMode`.
- **Secundários inevitáveis:** `List<Transaction>`.
- **Não fazer:** juros compostos complexos, múltiplas moedas, `double` em qualquer parte do cálculo.
- **Concluído quando:** você consegue explicar, com um exemplo numérico, por que `double` erraria esse cálculo e `BigDecimal` não.

---

# Fase 5 — Erros

## Projeto 17 — Caixa Eletrônico
- **Objetivo:** exceptions customizadas.
- **Escopo:** `1. Criar conta` `2. Sacar` `3. Consultar saldo` `0. Sair`.
- **Conceitos-alvo:** `SaldoInsuficienteException`, `ContaNaoEncontradaException`, `ValorInvalidoException` (checked ou unchecked — escolha uma e justifique), `try/catch`, `throw`, `throws`.
- **Secundários inevitáveis:** reaproveita a base do Projeto 01.
- **Não fazer:** capturar `Exception` genérica só para dar `printStackTrace()` — cada exceção tem tratamento específico e mensagem própria.
- **Concluído quando:** cada erro de negócio tem sua própria exception, não um `if` retornando `null` ou `-1`.

---

# Fase 6 — I/O

## Projeto 18 — Gerenciador de Tarefas Persistente
- **Objetivo:** `Path`, `Files` (persistência simples em texto).
- **Escopo:** `1. Criar tarefa` `2. Listar tarefas` `3. Concluir tarefa` `4. Remover tarefa` `0. Sair` — tudo salvo em um arquivo `.txt`, lido ao abrir o programa.
- **Conceitos-alvo:** `Files.readAllLines`, `Files.write`, `Path`.
- **Secundários inevitáveis:** parsing simples de linha (ex: `id;descricao;concluida`).
- **Não fazer:** banco de dados, formato binário, múltiplos arquivos, backup automático.
- **Concluído quando:** ao fechar e reabrir o programa, as tarefas continuam lá.

## Projeto 19 — Importador de Dados JSON
- **Objetivo:** ler/escrever JSON.
- **Escopo:** `1. Importar produtos de um arquivo products.json` `2. Listar produtos importados` `3. Exportar produtos para um novo JSON` `0. Sair`.
- **Conceitos-alvo:** biblioteca de JSON (Jackson ou Gson — escolha uma e use só ela), serialização e desserialização de objetos.
- **Secundários inevitáveis:** `model.Product` com os mesmos campos do JSON.
- **Não fazer:** implementar parser de JSON na mão, validação de schema, JSON aninhado complexo.
- **Concluído quando:** você importa um JSON, mexe nos dados em memória, e exporta de volta corretamente.

---

## Sobre serialização nativa (`Serializable`)

Não vira projeto. Você lê sobre o conceito, entende os problemas dela (versionamento frágil, acoplamento à JVM), e segue — JSON (Projeto 19) é o que você realmente vai usar depois.

---

## Depois dos 19

Só depois de fechar essa trilha entra o projeto de escala maior: um sistema único, com arquitetura em camadas, persistência real, testes e, posteriormente, Spring Boot. Esses 19 são deliberadamente pequenos — o objetivo é fixar conceito por conceito sem se prender. O próximo é onde tudo isso se combina de verdade.