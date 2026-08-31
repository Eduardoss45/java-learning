# Contributing Guide

Este documento define os procedimentos utilizados para criar, estruturar, executar e versionar os projetos deste repositório.

O objetivo é manter todos os projetos consistentes e evitar decisões de infraestrutura diferentes entre as etapas da trilha.

---

# 1. Criando um novo projeto

Cada projeto deve ser criado dentro da raiz do repositório.

Exemplo:

```text
java-learning/
├── README.md
├── TODO.md
├── CONTRIBUTING.md
├── .gitignore
│
├── projeto-01-conta-bancaria/
├── projeto-02-biblioteca/
└── projeto-03-funcionarios/
```

Ao iniciar um novo projeto, crie somente o diretório correspondente àquele projeto.

Exemplo:

```text
projeto-04-pagamentos/
```

Não crie antecipadamente os diretórios dos projetos futuros.

---

# 2. Estrutura padrão

Todo projeto deve seguir a mesma estrutura:

```text
projeto-XX-nome/
├── README.md
└── src/
    └── main/
        └── java/
            └── app/
                ├── Main.java
                ├── model/
                ├── service/
                └── exception/
```

A estrutura deve ser criada mesmo quando alguma das pastas ainda não possuir arquivos.

## `Main.java`

Responsável exclusivamente pela interface de terminal:

* exibir o menu;
* ler entradas com `Scanner`;
* chamar métodos dos serviços;
* apresentar resultados.

Não deve conter regras de negócio.

## `model/`

Contém as classes que representam o domínio do projeto.

Exemplos:

```text
model/
├── Account.java
├── Book.java
└── Member.java
```

As classes de domínio devem manter seus próprios estados e comportamentos diretamente relacionados ao objeto.

## `service/`

Contém regras que coordenam múltiplos objetos, coleções ou operações do sistema.

Exemplos:

```text
service/
├── BankService.java
└── LibraryService.java
```

## `exception/`

Utilizada para exceptions customizadas quando elas fizerem parte do projeto.

Nos projetos anteriores ao Projeto 17, não criar exceptions customizadas apenas para preencher a estrutura.

---

# 3. Criando os diretórios pelo terminal

A partir da raiz do repositório:

```powershell
mkdir projeto-01-conta-bancaria
cd projeto-01-conta-bancaria

mkdir src
mkdir src\main
mkdir src\main\java
mkdir src\main\java\app
mkdir src\main\java\app\model
mkdir src\main\java\app\service
mkdir src\main\java\app\exception
```

Depois crie:

```text
README.md
src/main/java/app/Main.java
```

As demais classes serão criadas conforme o projeto exigir.

---

# 4. Criando o `Main.java`

O arquivo deve declarar o pacote:

```java
package app;
```

Exemplo mínimo:

```java
package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("1. ...");
            System.out.println("0. Sair");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    // chamada para o service
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (option != 0);

        scanner.close();
    }
}
```

O exemplo acima representa apenas o formato da aplicação.

O conteúdo do menu deve seguir exatamente o escopo definido no `TODO.md`.

---

# 5. Compilação e execução

Os projetos devem poder ser executados individualmente.

A partir da pasta do projeto:

```powershell
cd projeto-01-conta-bancaria
```

Compile:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java).FullName
```

Execute:

```powershell
java -cp out app.Main
```

O diretório `out/` não deve ser versionado.

Ele é ignorado pelo `.gitignore`.

---

# 6. Dependências

Os projetos devem utilizar a API padrão do Java sempre que possível.

Não adicionar dependências externas apenas por conveniência.

Quando uma dependência externa for explicitamente necessária pelo escopo do projeto, ela deve ser configurada somente naquele projeto.

Exemplo do Projeto 19:

```text
projeto-19-importador-json/
├── README.md
├── pom.xml
└── src/
    └── ...
```

A dependência de Jackson ou Gson pertence ao Projeto 19, e não ao repositório inteiro.

---

# 7. Independência entre projetos

Os projetos não devem importar classes de outros projetos.

Não fazer:

```java
import projeto01.Account;
```

ou criar estruturas compartilhadas como:

```text
java-learning/
├── common/
├── shared/
├── utils/
└── core/
```

Cada projeto deve possuir tudo que precisa para funcionar dentro do próprio diretório.

Pequenas repetições entre projetos são aceitáveis.

A prioridade é manter os projetos independentes e preservar o conceito estudado em cada etapa.

---

# 8. Fluxo de desenvolvimento

Para cada novo projeto:

```text
1. Criar diretório do projeto
2. Criar estrutura padrão
3. Criar README.md
4. Implementar o escopo
5. Compilar
6. Executar
7. Verificar o critério de conclusão
8. Fazer commit
```

Não iniciar o próximo projeto enquanto o atual não atender ao critério de conclusão definido no `TODO.md`.

---

# 9. Padrão de commits

Os commits seguem o formato:

```text
tipo: descrição
```

Quando necessário, ações relacionadas podem ser agrupadas utilizando `&`:

```text
tipo: ação 1 & ação 2
```

A descrição deve ser curta e objetiva, indicando o que foi alterado.

## Tipos principais

| Tipo       | Uso                                        |
| ---------- | ------------------------------------------ |
| `init`     | Inicialização                              |
| `add`      | Adição de algo novo                        |
| `feat`     | Implementação de funcionalidade            |
| `fix`      | Correção de comportamento                  |
| `remove`   | Remoção                                    |
| `refactor` | Reorganização sem mudança de comportamento |
| `docs`     | Documentação                               |
| `chore`    | Configuração ou manutenção                 |

---

# 10. Commits de inicialização

Utilize `init` quando estiver criando a estrutura inicial de algo.

### Repositório

```text
init: java learning repository
```

### Novo projeto

```text
init: bank account project structure
```

### Configuração

```text
init: project 19 json configuration
```

---

# 11. Commits de adição

Utilize `add` quando a mudança representa principalmente a inclusão de componentes.

### Nova classe

```text
add: Account model
```

### Nova camada

```text
add: BankService
```

### Nova estrutura

```text
add: project 02 library structure
```

### Documentação

```text
add: project 03 README
```

---

# 12. Commits de funcionalidade

Utilize `feat` quando uma funcionalidade do projeto foi implementada.

### Conta bancária

```text
feat: implement account deposit
```

```text
feat: implement account withdrawal
```

### Biblioteca

```text
feat: implement book lending
```

```text
feat: implement loan return
```

### Pagamentos

```text
feat: implement payment processing
```

---

# 13. Commits agrupando ações

Quando duas alterações pequenas fazem parte da mesma unidade lógica, elas podem ser agrupadas.

Exemplo:

```text
feat: add deposit & withdrawal operations
```

Outro exemplo:

```text
add: Book and Member models
```

Ou:

```text
fix: validate account balance & withdrawal amount
```

Não agrupe alterações que possuem objetivos independentes apenas para reduzir a quantidade de commits.

---

# 14. Commits de correção

Utilize `fix` quando algo que deveria funcionar foi corrigido.

### Regra de saque

```text
fix: prevent withdrawal above account balance
```

### Busca

```text
fix: search products by name
```

### Navegação

```text
fix: restore previous page when navigating back
```

---

# 15. Commits de refatoração

Utilize `refactor` quando o comportamento permanece essencialmente o mesmo, mas a implementação foi reorganizada.

Exemplos:

```text
refactor: move business logic to BankService
```

```text
refactor: extract payment processing from Main
```

```text
refactor: simplify order status transition
```

Um `refactor` não deve ser utilizado para esconder uma nova funcionalidade.

Se o comportamento mudou porque uma funcionalidade foi implementada, prefira `feat`.

---

# 16. Commits de remoção

Utilize `remove` quando algo deixa de fazer parte do projeto.

Exemplos:

```text
remove: unused exception class
```

```text
remove: obsolete helper method
```

```text
remove: unused project dependency
```

---

# 17. Commits de documentação

Utilize `docs` para alterações exclusivamente documentais.

Exemplos:

```text
docs: update project 01 README
```

```text
docs: document project 07 concepts
```

```text
docs: update repository structure
```

---

# 18. Commits de manutenção

Utilize `chore` para alterações de configuração ou manutenção que não representam uma funcionalidade do domínio.

Exemplos:

```text
chore: update gitignore
```

```text
chore: configure Java version
```

```text
chore: remove generated build files
```

---

# 19. O que evitar nos commits

Evite mensagens genéricas:

```text
update
fix
changes
test
stuff
final
done
```

Evite também colocar uma descrição que não explica a mudança:

```text
feat: changes
```

Prefira:

```text
feat: implement participant registration
```

---

# 20. Quando fazer commit

Um commit deve representar uma unidade lógica de mudança.

Exemplo de desenvolvimento do Projeto 01:

```text
init: bank account project structure
add: Account model
add: BankService
feat: implement account creation
feat: implement account deposit
feat: implement account withdrawal
feat: implement balance consultation
docs: update project 01 README
```

Não é necessário criar um commit para cada pequena alteração de código.

Se você implementou uma funcionalidade inteira e ela está coerente, ela pode ser um único commit.

---

# 21. Antes de finalizar um projeto

Verifique:

```text
[ ] O projeto está dentro do diretório correto
[ ] README.md existe
[ ] Main.java contém somente interação e chamadas
[ ] Regras de negócio estão nas classes corretas
[ ] O escopo do TODO.md foi seguido
[ ] Nenhuma funcionalidade fora do escopo foi adicionada
[ ] O projeto compila
[ ] O projeto executa
[ ] Arquivos gerados não estão sendo versionados
[ ] O critério de conclusão foi atendido
```

Depois:

```powershell
git status
```

Confirme que somente os arquivos esperados estão sendo adicionados.

Então:

```powershell
git add projeto-XX-nome
git commit -m "feat: complete project XX"
```

---

# 22. Regra principal

A estrutura do repositório deve permanecer previsível.

Para qualquer projeto, deve ser possível responder imediatamente:

```text
Onde está o projeto?
→ projeto-XX-nome/

Onde está a documentação?
→ projeto-XX-nome/README.md

Onde está o código?
→ projeto-XX-nome/src/main/java/

Onde está a entrada da aplicação?
→ app/Main.java

Onde estão os modelos?
→ app/model/

Onde estão as regras de negócio?
→ app/service/

Onde estão as exceptions customizadas?
→ app/exception/
```

A organização existe para reduzir decisões durante o estudo.

O foco deve permanecer no conceito-alvo de cada projeto.
