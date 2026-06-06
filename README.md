# ATIVIDADE-INDIVIDUAL---TESTE-DE-CAIXA-BRANCA-E-REVIS-O-DE-C-DIGO-FONTE
ATIVIDADE INDIVIDUAL - TESTE DE CAIXA BRANCA E REVISÃO DE CÓDIGO-FONTE  
aluno Murilo de Paula Vieria 
RA 224108

PRINT DIAGRAMA FLUXO: 






# Análise Estrutural de Código utilizando Teste de Caixa Branca

## 1. Introdução

Esta atividade tem como objetivo realizar a análise estrutural de um código Java responsável pela autenticação de usuários através de conexão com banco de dados.

Foram aplicados conceitos de revisão estática de código, análise de fluxo de execução, cálculo da complexidade ciclomática e identificação de caminhos básicos.

---

## 2. Análise Estática do Código

### Documentação

O código não possui comentários ou documentação explicando a finalidade dos métodos e variáveis.

### Nomenclatura

Os métodos possuem nomes compreensíveis, porém algumas variáveis utilizam abreviações que dificultam a leitura.

### Legibilidade

O código apresenta estrutura simples, porém a ausência de comentários e a montagem da SQL por concatenação prejudicam a manutenção.

### Tratamento de Exceções

As exceções são capturadas, porém ignoradas através de blocos `catch` vazios.

### Conexões

Os recursos `Connection`, `Statement` e `ResultSet` não são fechados corretamente.

### Vulnerabilidades

Foi identificada vulnerabilidade de SQL Injection devido à concatenação direta dos parâmetros recebidos pelo usuário.

### Segurança

As credenciais do banco de dados estão expostas no código-fonte e as senhas são tratadas em texto puro.

### Boas Práticas

Foram identificadas más práticas como uso de variáveis globais, ausência de encapsulamento e falta de tratamento adequado de erros.

---

## 3. Grafo de Fluxo

<img width="808" height="684" alt="image" src="https://github.com/user-attachments/assets/2d968505-4853-4b1f-85da-f2892b764ae4" />

O grafo representa o fluxo lógico do método de autenticação, destacando o ponto de decisão responsável por validar a existência do usuário na consulta ao banco de dados.

---

## 4. Complexidade Ciclomática

Fórmula utilizada:

V(G) = E - N + 2P

Onde:

* E = 8
* N = 8
* P = 1

Cálculo:

V(G) = 8 - 8 + 2(1)

V(G) = 2

Resultado final:

Complexidade Ciclomática = 2

---

## 5. Caminhos Básicos

### Caminho 1

Início → Conectar Banco → Montar SQL → Executar Consulta → rs.next() = TRUE → Usuário encontrado → Retorna TRUE

### Caminho 2

Início → Conectar Banco → Montar SQL → Executar Consulta → rs.next() = FALSE → Retorna FALSE

---

## 6. Melhorias Implementadas

* Inclusão de comentários explicativos.
* Utilização de PreparedStatement.
* Tratamento adequado de exceções.
* Verificação de conexão nula.
* Fechamento adequado dos recursos.
* Melhoria da organização e legibilidade do código.
* Redução dos riscos de SQL Injection.

---

## 7. Conclusão

A análise estrutural permitiu identificar problemas de segurança, manutenção e qualidade presentes no código original.

A aplicação dos conceitos de Teste de Caixa Branca possibilitou compreender o fluxo de execução do sistema, calcular sua complexidade ciclomática e identificar os caminhos independentes de execução.

A revisão realizada contribuiu para melhorar a segurança, organização e confiabilidade da aplicação.

Print de comparação Códogo original
 <img width="1850" height="995" alt="image" src="https://github.com/user-attachments/assets/9e7673c7-1990-44e2-bd53-cb1adcc42497" />
CONTINUAÇÃO CÓDIGO ORIGINAL (2) <img width="1864" height="790" alt="image" src="https://github.com/user-attachments/assets/7f0d9eeb-006f-4b0b-8387-47a5e3865de1" />

Print código revisado


 <img width="1348" height="894" alt="image" src="https://github.com/user-attachments/assets/bacc72a9-0ac7-489d-b245-f352bee90165" />
<img width="1876" height="1015" alt="image" src="https://github.com/user-attachments/assets/f9cbae16-5f59-4e9d-b8ba-437c99d0d515" />
 <img width="1843" height="946" alt="image" src="https://github.com/user-attachments/assets/002656a3-f3fa-4e52-9465-deb23c447fd3" />
 <img width="1852" height="1014" alt="image" src="https://github.com/user-attachments/assets/39229e4a-f207-44c4-942f-b2a89a60c441" />
 <img width="1840" height="1015" alt="image" src="https://github.com/user-attachments/assets/b2816673-33cf-4d09-890b-bfc64c387d7e" />
<img width="1859" height="915" alt="image" src="https://github.com/user-attachments/assets/f4d0a285-bf74-471b-8309-5ea7bfe9998a" />
