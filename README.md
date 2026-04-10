# Projeto RMI Quadro Colaborativo

## Sistemas Distribuídos 2026.1
**Discentes:** </br>
Amanda Barros Matos </br>
Feliph de Matos Macedo Lima </br>

##  Como Executar
Para rodar o projeto, siga os passos abaixo no terminal:

### 1. Compilação
Compile todos os módulos diretamente da raiz do projeto:
> `javac src/interfaces/*.java src/server/*.java src/client/*.java`

### 2. Iniciar o Servidor
> `java -cp src -Djava.security.policy=src/resources/server.policy server.ServerRMI`

### 3. Iniciar o Cliente
> `java -cp src -Djava.security.policy=src/resources/client.policy client.ClientRMI`

Para conectar em um servidor remoto, passe o host como argumento:
> `java -cp src -Djava.security.policy=src/resources/client.policy client.ClientRMI <host>`
