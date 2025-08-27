# SGR - Sistema de Gestão de Restaurante

Sistema simples para gestão de restaurante, desenvolvido em Java, com persistência em arquivos CSV e interface via terminal.

## Funcionalidades

- Cadastro, listagem e remoção de clientes
- Cadastro, listagem e remoção de itens do cardápio
- Cadastro, listagem e remoção de pedidos
- Cadastro e processamento de pagamentos (Dinheiro, Cartão, Pix)
- Validação de CPF, nome e telefone
- Persistência dos dados em arquivos CSV
- Interface de usuário via terminal

## Estrutura do Projeto

```
src/
  main/java/com/sgr/
    App.java
    dados/
    fachada/
    negocio/
    ui/
    util/
test/
  java/
csv/
  clientes.csv
  itens.csv
  pedidos.csv
  pagamentos.csv
build.gradle
```

## Como executar

1. **Pré-requisitos:**  
   - Java 8 ou superior  
   - Gradle instalado (ou use o wrapper `./gradlew`)

2. **Compilar o projeto:**  
   ```
   ./gradlew build
   ```

3. **Executar o sistema:**  
   ```
   ./gradlew run
   ```

## Como adicionar dependências

No arquivo `build.gradle`, adicione suas dependências, por exemplo:

````groovy
dependencies {
    implementation 'com.opencsv:opencsv:5.9'
    testImplementation 'junit:junit:4.13.2'
}