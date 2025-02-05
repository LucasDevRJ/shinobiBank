# Shinobi Bank
Projeto que simula um sistema bancário sendo executado via terminal com interação com o usuário. O programa foi desenvolvido em Java utilizando a programação orientada a objetos, todos os pilares dela: abstração, polimorfismo e herança. Coloquei o minímo de métodos possíveis, porque os consegui reutilizar ou rescrever para os dois tipos de contas do sistema, poupança e corrente.

![Print do sistema](https://github.com/user-attachments/assets/9ead40ac-1e80-4f74-9478-084b1845b394)

## Como acessar o projeto
Para acessar o projeto e executa-lo na sua máquina, basta clicar <a href="https://github.com/LucasDevRJ/shinobiBank/archive/refs/heads/main.zip">aqui</a> para baixar o projeto e colocar o projeto em sua IDE que funcione Java.

## Instruções do Desafio
> Para acessar o projeto e executa-lo na sua máquina, basta clicar aqui para baixar o projeto e colocar o projeto em sua IDE que funcione Java.
> 1. Crie uma interface chamada Conta com os métodos consultarSaldo() e depositar(double valor).
> 2. Crie uma classe abstrata chamada ContaBancaria que implementa a interface Conta.
> 3. Crie uma classe chamada ContaCorrente que estende a classe ContaBancaria.
> 4. Implemente o método depositar(double valor) para adicionar o valor ao saldo.
> 5. Crie uma classe chamada ContaPoupanca que também estende a classe ContaBancaria.
> 6. Implemente o método depositar(double valor) para adicionar o valor ao saldo com uma pequena taxa de depósito (por exemplo, deduzir 1% do valor depositado).
> 
> Desafio Extra: Como desafio adicional, adicione um enum chamado TipoConta para representar diferent tipos de contas, como CORRENTE e POUPANCA. Modifique as classes ContaCorrente ContaPoupanca para usar esse enum e adicione um método sobrecarregado na classe BancoKonoha para realizar transferências entre contas.

## Aprendizados
Meu maior aprendizado com esse projeto foi saber utilizar melhor a Abstração da Orientação a Objetos. Foi o que me fez ficar mais preso ao projeto. Mas fiquei feliz com resultado.

## Apresentação
Fiz um vídeo apresentando o <a href="https://www.linkedin.com/posts/lucas-pereira-de-lima-programador_java-projeto-backend-activity-7292985238287216640-0Cpk?utm_source=share&utm_medium=member_desktop">projeto</a>.

## Conteúdos
* Classes Concretas e Abstratas
* Métodos Concretos e Abstratos
* Interfaces
* Abstração
* Enumeradores
* Polimorfismo
* Entre outros
