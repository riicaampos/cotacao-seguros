# Nome do Projeto

Cotação de Seguros

## Como rodar

- Projeto feito no Java 24
- Execute: SegurosApplication
- Está configurado para subir na porta 8080
- Swagger pode ser acessado em http://localhost:8080/swagger-ui.html

## Construção do projeto

Por ser um projeto simples, optei pela arquitetura MVC. O ponto inicial da aplicação
é um controller, que recebe uma requisição, verifica em qual regra de % esse valor se aplica
e faz a cobrança do seguro em cima do valor do veiculo. Para não encher o codigo de if/else
eu optei por usar o padrão "Chain of Responsability". foi criado uma interface com 2 metodos,
um metodo para verificar a range de valor e o outro para fazer o calculo do percentual em cima do valor,
se um dia entrar mais ranges com novos calculos, basta eu criar mais uma classe e implementar a minha interface.

Na classe onde é feito o calculo, eu crio uma lista com instancias das minhas 3 implementações usando injeção de dependencias,
então usei o @PostConstruct para injetar as dependencias assim que o spring tiver gerado todas as instancias. Feito isso
percorro a lista fazendo um filter e chamando o metodo que valida a range, caso não atenda ele passa para o proiximo, caso atenda a range e retorne true
eu uso o findFirst me retornando a implementação que preciso, e no map eu chamo o metodo que faz o calculo com o valor correto.