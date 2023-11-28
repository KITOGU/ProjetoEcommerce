package model;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe catalogo, ela possui uma lista, chamada listacat, está classe é resposavel por fazer o catalogo de
 * produtos disponíveis para compra
 */
public class Catalogo {

    private List<Produto> listacat = new ArrayList<>();

    public List<Produto> getListacat() {
        return listacat;
    }

    public void setListacat(List<Produto> listacat) {
        this.listacat = listacat;
    }

    public Catalogo(List<Produto> listacar) {
    }

    /**
     * Método adicionarCatalogo, responsável por adicionar objetos do tipo Produto a lista do catalogo.
     * @param produto Recebe um objeto produto que foi cadastrado pelo usuário.
     */
    public void adicionarCatalogo(Produto produto){

            listacat.add(produto);
            System.out.println("Produto cadastrado com sucesso no catálogo: " + produto.getNome());

    }

    /**
     * Método removerCatalogo, possui a função de retirar um objeto da lista catalogo.
     * Este método compara o nome dos produtos na lista com o parâmetro nome,
     * ao encontrar um que seja igual, remove o objeto.
     * @param nome recebe o nome do objeto produto que será removido.
     */
    public void removerCatalogo(String nome){

        // Iterator serve para percorrer a lista em busca da String
        Iterator<Produto> produtoRe = listacat.iterator();
        while (produtoRe.hasNext()) {
            Produto produto = produtoRe.next();
            if (produto.getNome().equals(nome)) {
                produtoRe.remove();
                System.out.println("Produto removido do catálogo: " + produto.getNome());
            }
        }
    }

    /**
     * Método listarCatalogo, mostra todos objetos na lista catalogo.
     */
    public void listarCatalogo(){
        for (Produto item: listacat
        ) {
            item.toString();
            System.out.println(item);
        }
    }



    /**
     * Método encontrarProduto, faz uma comparação entre o nome do produto e o parâmetro recebido, cada seja igual, retorna o produto.
     * @param nome recebe um nome de produto para fazer a comparação com a lista.
     */
    public Produto encontrarProduto(String nome) {
        for (Produto produto : listacat) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }


}
