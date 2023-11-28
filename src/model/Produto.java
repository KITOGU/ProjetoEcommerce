package model;

/**
 * Classe produto, é a classe responsável para a criação de objetos produtos que será utilizados no software.
 */
public class Produto {

    private String nome;
    private double preco;
    private String descricao;
    private int estoque;

    /**
     * Atributo que diz o valor a ser descontado do preço após o cálculo da promoção.
     */
    private double valorDesconto;
    private double promocao;
    /**
     * Atributo responsável por dizer a quantidade dele no carrinho do cliente.
     */
    private int quantCarrinhos;

    /**
     * Método construtor que inicializa os atributo promoção e quantCarrinhos com valor 0.
     */
public Produto(){
    promocao = 0;
    quantCarrinhos =0;
}

// Gets e sets
    public int getQuantCarrinhos() {
        return quantCarrinhos;
    }

    public void setQuantCarrinhos(int quantCarrinhos) {
        this.quantCarrinhos = quantCarrinhos;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setPromocao(double promocao) {
        this.promocao = promocao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPromocao() {
        return promocao;
    }

    public void setPromocao(float promocao) {
        this.promocao = promocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Métodos

    /**
     * Método toString, ao ser chamado, imprime uma mensagem com vários atributos de um objeto do tipo produto.
     */
    public String toString(){
        return "\n Produto: " +getNome() + "\n preço: R$" +getPreco() + "\n Descrição: " +getDescricao()+"\n Promoção: "+getPromocao()+"%"+"\n Em estoque: " +getEstoque();
    }
    /**
     * Método toStringCarrinho, assim como o método toString, ao ser chamado, imprime uma mensagem com vários atributos de um objeto do tipo produto.
     */
    public String toStringCarrinho(){
        return "\n Produto: " +getNome() + "\n preço: R$" +getPreco() + "\n Descrição: " +getDescricao()+"\n Promoção: "+getPromocao()+"%"+"\n No carrinho: " +getQuantCarrinhos();
    }


    /**
     * Método que realiza o cálculo da promoção, onde, primeiramente o percentual da promoção é divido por 100
     * e depois multiplicado pelo preço do produto.
     * Ao final, o atribudo promoção recebe o valor do desconto, que posteriormente será subtraido do atribudo preço.
     * @param percentualPromocao é um valor recebido através de outro método, este valor deve ser inserido pelo usuário.
     */
    public void aplicarPromocao(double percentualPromocao) {
        // Calcula o valor do desconto com base no percentual
        double desconto = preco * (percentualPromocao / 100);
        promocao = percentualPromocao;
        // Define o valor da promoção
        valorDesconto = desconto;
        CalculoPromocao();

        System.out.println("Promoção aplicada com sucesso!");
    }
    /**
     * Método calculoPromocao, responsável por subtrair o valor da promoção do preço do produto.
     */
    public void CalculoPromocao(){
    preco = preco-valorDesconto;
    }
    /**
     * Método TemNoEstoque,  verifica se o valor pedido é menor que o do atributo estoque, caso o valor seja maior que o do estoque, deverá retornar falso.
     * @param quantidade é a quantidade de produtos que foi escolhida pelo usuário.
     */
    public boolean TemNoEstoque(int quantidade) {
        return quantidade <= estoque;
    }
    /**
     * Método removerDoEstoque se encarrega de retirar a quantidade de produtos escolhida pelo usuário do estoque e adicionala a quantCarrinhos.
     * @param quantidade quantidade de produtos, escolhido pelo usuário.
     */
    public void removerDoEstoque(int quantidade) {
        estoque -= quantidade;
        quantCarrinhos += quantidade;
    }

    /**
     * Método removerQuantCarrinho, realiza o processo inverso do método removerDoEstoque, aqui a quantidade é removida do quantCarrinhos e adicionada no estoque.
     * @param remover recebe um valor que será retirado do quantCarrinhos e adicionado ao estoque
     */
    public void removerQuantCarrinho(int remover){
    estoque += remover;
    quantCarrinhos -= remover;

    }


}


