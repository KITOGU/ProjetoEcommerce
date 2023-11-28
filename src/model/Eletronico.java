package model;
/**
 * Classe Eletronico, herda de produto e tem como atributo própio a garantia.
 */
public class Eletronico extends Produto {
    private int garantia;

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }


    /**
     * Método toString da classe Eletronico, ele sobrescreve o da classe Produto.
     */
    @Override
    public java.lang.String toString() {
        return "\n///////////////////////////"+"\nClasse Eletrônico "+ super.toString()+"\n Garantia "+getGarantia()+" Meses" + "\n///////////////////////////";
    }

    /**
     * Método toStringCarrinho da classe Eletronico, ele sobrescreve o da classe Produto.
     */
    public java.lang.String toStringCarrinho() {
        return "\n///////////////////////////"+"\n Tipo: Eletrônico "+ super.toStringCarrinho()+"\n Garantia "+getGarantia()+" Meses" + "\n///////////////////////////";
    }

}
