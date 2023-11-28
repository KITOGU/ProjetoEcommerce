package model;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Carrinho, ela possui uma lista, chamada listacar, está classe é resposavel por fazer o carrinho de
 * produtos escolhidos para compra pelo usuário.
 */
public class Carrinho{

    private List<Produto> listacar = new ArrayList<>();



    public List<Produto> getListacar() {
        return listacar;
    }

    public void setListacar(List<Produto> listacar) {
        this.listacar = listacar;
    }

    public Carrinho(List<Produto> listacar) {
    }


    /**
     * Método adicionarCarrinho, recebe um produto da lista catalogo escolhido pelo usuário e o adiciona a lista
     * carrinho, ao mesmo tempo, retira a quantidade do estoque.
     * @param produto nome do produto que será adicionado a lista carrinho.
     * @param quantidade quantidade de itens que devem ser removidos do estoque.
     */
    public void adicionarCarrinho(Produto produto, int quantidade){
        produto.removerDoEstoque(quantidade);
        listacar.add(produto);
    }

    /**
     * Método removerCarrinho, remove um produto da lista carrinho e retornar a quantidade no carrinho para o estoque
     * @param nome recebe o nome do produto que será removido.
     */
    public void removerCarrinho(String nome){

        // Iterator serve para percorrer a lista em busca da String
        Iterator<Produto> produtoRe = listacar.iterator();
        while (produtoRe.hasNext()) {
            Produto produto = produtoRe.next();
            if (produto.getNome().equals(nome)) {
                produto.removerQuantCarrinho(produto.getQuantCarrinhos());
                produtoRe.remove();
                System.out.println("Produto removido do carrinho: " + produto.getNome());

            }
        }
    }
    /**
     * Método limparCarrinho, responsável por remover todos os objetos da listacat e devolver
     * a quantidade deles no carrinho para o estoque.
     */
    public void limparCarrinho(){
        Iterator<Produto> produtoRe = listacar.iterator();
        while (produtoRe.hasNext()) {
            Produto produto = produtoRe.next();

                produto.removerQuantCarrinho(produto.getQuantCarrinhos());
                produtoRe.remove();
                System.out.println("Produto removido do carrinho: " + produto.getNome());
        }
        System.out.println("Compra cancelada com sucesso!!");
    }

    /**
     * Método listarCarrinho, lista todos objetos da lista carrinho
     */
    public void listarCarrinho(){
        for (Produto item: listacar
        ) {
            System.out.println(item.toStringCarrinho());
            // arrumar
        }
    }
    /**
     * Método totalCompra, realiza o cálculo do valor total de todos produtos no carrinho, incluindo valores de promoção,
     * então retorna o valor total no final.
     */
    public double totalCompra(){
        double total = 0;
        for (Produto p: listacar
        ) {
            total += p.getPreco() * p.getQuantCarrinhos();
        }
        return total;
    }
}
