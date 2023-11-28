import model.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe GerenciarEcommerce, é a classe principal do sistema, aqui é onde tudo acontece.
 */

public class GerenciarEcommerce {

    /**
     * Declaração de um scanner para uso durante a execução do algoritmo.
     */
    Scanner sc = new Scanner(System.in);
    List<Produto> listacar = new java.util.ArrayList<>();
    Carrinho carrinho = new Carrinho(listacar);

    List<Produto> listacat = new java.util.ArrayList<>();

    Catalogo catalogo = new Catalogo(listacat);

    /**
     * Menu do programa, onde são dadas as opções para que o usuário escolha, após feita a escolha, os respectivos
     * métodos são chamados.
     */
    public static void main(String[] args) {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        GerenciarEcommerce gerenciarEcommerce= new GerenciarEcommerce();

        do {
            System.out.println("Menu Principal");
            System.out.println("Para os produtos que estiverem com promoção, o preço ja aparecerá contando o valor do desconto");
            System.out.println("1. Cadastrar Produto no catalogo");
            System.out.println("2. Remover Produto do catalogo");
            System.out.println("3. Colocar produto em promoção");
            System.out.println("4. Ver catalogo");
            System.out.println("5. Adicionar produto ao carrinho");
            System.out.println("6. Ver produtos no carrinho");
            System.out.println("7. Remover produto do carrinho");
            System.out.println("8. Cancelar compra");
            System.out.println("9. Finalizar Compra");
            System.out.println("Escolha uma opcao");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    gerenciarEcommerce.execCadastrar();
                    break;
                case 2:
                    gerenciarEcommerce.execRemoverCat();
                    break;
                case 3:
                    gerenciarEcommerce.execPromocao();
                    break;
                case 4:
                    gerenciarEcommerce.execListaCat();
                    break;
                case 5:
                    gerenciarEcommerce.execAdicionarCarrinho();
                    break;
                case 6:
                    gerenciarEcommerce.execListaCarri();
                    break;
                case 7:
                    gerenciarEcommerce.execRemoverCarri();
                    break;
                case 8:
                    gerenciarEcommerce.execCancelarCompra();
                    break;
                case 9:
                    gerenciarEcommerce.execFinalizarCompra();
                    System.out.println("Fim do programa");
                    System.exit(0);

                default:
                    System.out.println("opcao invalida");
            }

        } while (opcao !=9);

        }





    /**
     * Método execCadastrar, permite que o usuário cadastre produtos no catalogo, primeiro pede a classe do produto
     * eletrônico ou vestuário, depois de acordo com a classe escolhida, pede a inserçõa das informações do item, para
     * então finalizar o cadastro chamando o método adicionarCatalogo da classe Catalogo.
     */
    public void execCadastrar(){
        System.out.println("Digite a classe do produto");
        System.out.println("1.Eletrônico");
        System.out.println("2.Vestuário");
        int op = sc.nextInt();
        sc.nextLine();
        if (op == 1){
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            double precoProduto = sc.nextDouble();
            sc.nextLine();

            System.out.print("Digite a descrição do produto: ");
            String descricaoProduto = sc.nextLine();

            System.out.println("Digite a quantidade em Estoque");
            int quantEstoque = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite a quantidade em meses de garantia");
            int meses = sc.nextInt();
            sc.nextLine();

            //Passa os dados para criar o objeto
            Eletronico eletronico = new Eletronico();
            eletronico.setNome(nomeProduto);
            eletronico.setPreco(precoProduto);
            eletronico.setDescricao(descricaoProduto);
            eletronico.setEstoque(quantEstoque);
            eletronico.setGarantia(meses);

            //Adiciona a lista
            catalogo.adicionarCatalogo(eletronico);

        }else if (op == 2){
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            double precoProduto = sc.nextDouble();
            sc.nextLine();

            System.out.print("Digite a descrição do produto: ");
            String descricaoProduto = sc.nextLine();

            System.out.println("Digite a quantidade em Estoque");
            int quantEstoque = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite a o tamanho da roupa (P,M,G)");
            String tamanho = sc.nextLine();

            System.out.println("Digite a cor da roupa");
            String cor = sc.nextLine();

            //Passa os dados para criar o objeto
            Vestuario vestuario = new Vestuario();
            vestuario.setNome(nomeProduto);
            vestuario.setPreco(precoProduto);
            vestuario.setDescricao(descricaoProduto);
            vestuario.setEstoque(quantEstoque);
            vestuario.setTamanho(tamanho);
            vestuario.setCor(cor);

            //Adiciona a lista
            catalogo.adicionarCatalogo(vestuario);
        }else{
            System.out.println("opção inválida");
        }

    }

    /**
     * Método execRemoverCat, remove um item da lista catalogo, pede um nome para o usuário e depois o remove da lista.
     */
    public void execRemoverCat(){

        System.out.print("Escolha o nome do item que deseja remover : ");
        String nome = sc.nextLine();

        catalogo.removerCatalogo(nome);

    }

    /**
     * Método execPromocao, permite que o usuário cadastre uma promoção para um produto em especifico,
     * primeiro digitando o nome do produto que será aplicada a promoção e depois o percentual da promoção,
     * então é chamado o método aplicarPromocao.
     */
    public void execPromocao(){
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = sc.nextLine();
        Produto produto = catalogo.encontrarProduto(nomeProduto);
        if (produto != null) {
            System.out.print("Digite o percentual de promoção: ");
            double percentualPromocao = sc.nextDouble();

            // Aplica a promoção no produto
            produto.aplicarPromocao(percentualPromocao);

            // Exibe o preço com desconto
            System.out.println("Preço com desconto: " + produto.getValorDesconto());
        } else {
            System.out.println("Produto não encontrado no catálogo.");
        }
    }

    /**
     * Método execListaCat, lista os produtos no catologo, chama o método listarCatalogo da classe Catalogo.
     */
    public void execListaCat(){
        catalogo.listarCatalogo();
    }

    /**
     * Método execAdicionarCarrinho, adiciona itens ao carrinho, pede o nome de um produto ao usuário, depois chama
     * o método encontrarProduto da classe catalogo, se o produto for encontrado pede a quantidade que o usuário deseja,
     * e então adiciona o produto a lista carrinho.
     */
    public void execAdicionarCarrinho(){

        System.out.print("Digite o nome do produto desejado: ");
        String nomeProduto = sc.nextLine();

        // Encontra o produto no catálogo
        Produto produtoSelecionado = catalogo.encontrarProduto(nomeProduto);

        if (produtoSelecionado != null) {
            // Solicita ao usuário que digite a quantidade desejada
            System.out.print("Digite a quantidade desejada: ");
            int quantidade = sc.nextInt();

            // Adiciona ao carrinho se a quantidade for válida
            carrinho.adicionarCarrinho(produtoSelecionado, quantidade);
        } else {
            System.out.println("Produto não encontrado no catálogo.");
        }

        // Exibe o estoque atual após a operação
        System.out.println("Estoque atual:");
        for (Produto produto : catalogo.getListacat()) {
            System.out.println(produto.getNome() + ": " + produto.getEstoque());
        }

    }

    /**
     * Método para listar os produtos no carrinho, chama o método listarCarrinho da classe Carrinho.
     */
    public void execListaCarri(){
        carrinho.listarCarrinho();
    }


    /**
     * Método execRemoverCarri pede para o usuário entrar com o nome de um prodoto para ser removido do carrinho,
     * então chama o método removerCarrinho da Classe Carrinho passando o parâmetro nome.
     */
    public void execRemoverCarri(){

        System.out.print("Digite o nome do produto que deseja remover (Isto ira remover todos os produtos iguais caso tenha mais de um) ");
        String nome = sc.nextLine();


        carrinho.removerCarrinho(nome);
    }

    /**
     * Método execCancelarCompra, cancela a compra e remove todos itens do carrinho, chama o método limparCarrinho da Classe carrinho.
     */
    public void execCancelarCompra(){
        carrinho.limparCarrinho();
    }

    /**
     * Método execFinalizarCompra, Finaliza a compra do usuário e mostra o valor total, chama o método totalCompra da classe Carrinho.
     */
    public void execFinalizarCompra(){
        double total = carrinho.totalCompra();
    carrinho.totalCompra();
        System.out.println("o total da compra foi: R$"+ total);

    }
}