package view;

import control.GerenciamentoLoja;
import java.util.ArrayList;
import java.util.Scanner;
import model.Produto;

/*
 * Mesma implementação de TelaUsuario
 */
public class TelaProduto {
    private static String opt = "";
    private static final Scanner input = new Scanner(System.in);

    public static void mostraMenuProduto() throws InterruptedException{
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("\t\t###########  SIMULADOR DE LOJA VIRTUAL  ###########\n");
        System.out.println(GerenciamentoLoja.mostrarEstoque());    
        System.out.println("\tMENU PRODUTO");
        System.out.println("\t\t1. Cadastrar Produto");
        System.out.println("\t\t2. Editar Produto");
        System.out.println("\t\t3. Voltar para o Menu Inicial\n");
        System.out.print("Escolha umas das opções acima ");
        opt = input.nextLine();
        switch (opt) {
            case "1" -> cadastrarProduto();
            case "2" -> consultarProduto();
            case "3" -> TelaPrincipal.mostraMenuInicial();
            default -> {
            }
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private static void cadastrarProduto() throws InterruptedException {
        System.out.print("Nome do produto: ");
        String nome = input.nextLine();
        System.out.print("Quantidade em estoque: ");
        int quantidade = input.nextInt();
        System.out.print("Preço de custo: ");
        float precoDeCusto = input.nextFloat();
        GerenciamentoLoja.setNumero();
        int numero = GerenciamentoLoja.getNumero();
        Produto novoProduto = new Produto(nome, quantidade, precoDeCusto, numero);
        GerenciamentoLoja.cadastrarProduto(novoProduto);
        System.out.println("Produto Cadastrado!");
        try {
            Thread.sleep(3000); // Pausa de 3 segundos
            mostraMenuProduto();
        } catch (InterruptedException e) {
            e.printStackTrace();
            mostraMenuProduto();
        }
        mostraMenuProduto();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void consultarProduto() throws InterruptedException {
        ArrayList<Produto> produtos = GerenciamentoLoja.getEstoque(); 
        System.out.print("Digite o nome do produto para buscar: ");
        String nomeBusca = input.nextLine();

        // Buscar o produto na lista (implementação simplificada)
        Produto produtoEncontrado = null;
        for (Produto produto : produtos) {
            if (produto.getNomeProduto().equalsIgnoreCase(nomeBusca)) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado:");
            System.out.println(produtoEncontrado);

            System.out.println("\nMenu de edição:");
            System.out.println("  1. Editar nome");
            System.out.println("  2. Editar quantidade");
            System.out.println("  3. Editar preço de custo");
            System.out.println("  4. Sair");
            System.out.println("==================================");
            System.out.print("Digite a opção desejada: ");

            int opcao = input.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o novo nome: ");
                    produtoEncontrado.setNomeProduto(input.nextLine());
                    try {
                        Thread.sleep(3000); // Pausa de 3 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.print("Digite a nova quantidade: ");
                    produtoEncontrado.setQuantidade(input.nextInt());
                    try {
                        Thread.sleep(3000); // Pausa de 3 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    System.out.print("Digite o novo preço de custo: ");
                    produtoEncontrado.setPrecoDeCusto(input.nextFloat());
                    try {
                        Thread.sleep(3000); // Pausa de 3 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    System.out.println("Saindo da edição.");
                    try {
                        Thread.sleep(3000); // Pausa de 3 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                default -> System.out.println("Opção inválida.");
            }
            mostraMenuProduto();
        } else {
            System.out.println("Produto não encontrado.");
            mostraMenuProduto();
        }
    }
}
