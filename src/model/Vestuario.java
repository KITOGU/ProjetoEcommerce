package model;

/**
 * Classe Vestuario, herda de Produto, possui como atributos própios tamanho e cor.
 */
public class Vestuario extends Produto{
    private String tamanho;
    private String cor;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Método toString da classe Vestuario, ele sobrescreve o da classe Produto.
     */
    @Override
    public java.lang.String toString() {
        return "\n///////////////////////////"+super.toString()+"\n Tamanho: "+getTamanho()+"\n Cor: "+getCor()+"\n///////////////////////////";
    }

    /**
     *Método toStringCarrinho da classe Vestuario, ele sobrescreve o da classe Produto.
     */
    public java.lang.String toStringCarrinho() {
        return "\n///////////////////////////" +"\n Tipo: vestuário "+super.toStringCarrinho()+"\n Tamanho: "+getTamanho()+"\n Cor: "+getCor()+"\n///////////////////////////";
    }
}
