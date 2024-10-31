package view;

import control.GerenciamentoCliente;
import control.GerenciamentoLoja;
import java.util.ArrayList;
import java.util.Scanner;
import model.CarrinhoDeCompras;
import model.CartaoDeCredito;
import model.Cliente;
import model.Endereco;
import model.Pedido;
import model.Produto;
import static view.TelaPrincipal.mostraMenuInicial;

public class TelaCliente {
    private static Integer opt = 0;
    private static boolean ctr = true;
    public static final Scanner input = new Scanner(System.in);

    public static void escolherProduto(CarrinhoDeCompras novoCarrinho) throws InterruptedException {
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========");
        GerenciamentoLoja.mostrarProdutosCliente();
        System.out.println("====================================");
        System.out.print("Escolha um produto: ");
        opt = input.nextInt();
        opt -= 1;
        Produto produtoBuscado = (Produto) GerenciamentoLoja.buscaProduto(opt);
        while (ctr != false) {
            System.out.print("Quantos você quer: ");
            opt = input.nextInt();
            ctr = ((CarrinhoDeCompras) novoCarrinho).addItem(produtoBuscado, opt);
            System.out.print("Pressione qualquer tecla, para avançar: ");
            String txt1 = input.nextLine();
            System.out.println(txt1);
        }
        ctr = true;
        mostraMenuUsuario(novoCarrinho);
    }

    public static void mostrarCarrinhoDeCompras(CarrinhoDeCompras novoCarrinho) throws InterruptedException {
        System.out.println(novoCarrinho);
        System.out.println("MENU:");
        System.out.println("  1. Ir para o login");
        System.out.println("  2. Voltar ao menu principal");
        System.out.println("====================================");
        opt = input.nextInt();
        switch (opt) {
            case 1 -> mostrarloginCliente(novoCarrinho);
            case 2 -> mostraMenuUsuario(novoCarrinho);
            default -> {
            }
        }
    }

    public static void mostrarloginCliente(CarrinhoDeCompras novoCarrinho) throws InterruptedException {
        System.out.println("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========\n");
        String email = "";
        ctr = GerenciamentoCliente.verificaEmail(email);
        if (ctr == false) {

            //E-mail não cadastrado.
            System.out.println("\nVamos criar sua nova conta:\n");
            System.out.print("Senha: ");
            String senha = input.nextLine(); //Variável de cada item do construtor
            System.out.print("Nome completo: ");
            String nome = input.nextLine(); //Variável de cada item do construtor
            System.out.print("CPF: ");
            String cpf = input.nextLine(); //Variável de cada item do construtor
            System.out.print("Telefone: ");
            String telefone = input.nextLine(); //Variável de cada item do construtor
            System.out.print("Data de nascimento: ");
            String nascimento = input.nextLine(); //Variável de cada item do construtor
            ArrayList<Endereco> listaVaziaEnderecos = new ArrayList<>();
            ArrayList<CartaoDeCredito> cartoesSalvoVazio = new ArrayList<>();
            ArrayList<Pedido> listaVaziaPedidos = new ArrayList<>();
            System.out.println("Clique qualquer tecla para avançar.");
            String txt1 = input.nextLine();
            System.out.println(txt1);
            Cliente novoCliente = new Cliente(email, senha, nome, cpf, telefone, listaVaziaEnderecos, nascimento, cartoesSalvoVazio, listaVaziaPedidos);
            GerenciamentoCliente.mostrarTelaFinalizandoCompra(novoCarrinho, novoCliente);
        } else {
            //E-mail cadastrado.
            System.out.print("Senha: ");
            String senha = input.nextLine();
            Object novoCliente = GerenciamentoCliente.verificarLogin(email, senha);
            GerenciamentoCliente.mostrarTelaFinalizandoCompra(novoCarrinho, (Cliente) novoCliente);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void mostrarCadastroEndereco(Cliente novoCliente) {
        String rua, numLugar, bairro, cidade, estado;
        System.out.println("========== NOVO ENDEREÇO ===========");
    
        try {
            System.out.print("Rua: ");
            rua = input.nextLine();
            System.out.print("Número: ");
            numLugar = input.nextLine();
            System.out.print("Bairro: ");
            bairro = input.nextLine();
            System.out.print("Cidade: ");
            cidade = input.nextLine();
            System.out.print("Estado: ");
            estado = input.nextLine();
    
            GerenciamentoCliente.cadastrarEnderecoCliente(novoCliente, bairro, cidade, estado, numLugar, rua);
            System.out.println("Endereço cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o endereço: " + e.getMessage());
        }
        System.out.println("====================================");
    }

    public static void imprimirListaDeEnderecos(ArrayList<Endereco> listaEnderecos) {
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========");
        System.out.println("***Endereços cadastrados:");
        if (listaEnderecos.isEmpty()) {
            System.out.println("\nNão há endereços salvos.\n");
        } else {
            for (Endereco endereco : listaEnderecos) {
                System.out.println(endereco);
            }
        }
    }

    public static void mostrarCadastroDeCC(Cliente novoCliente) {
        System.out.println("====== NOVO CARTÃO DE CRÉDITO =======");
        System.out.print("Nome impresso no cartão: ");
        String nomeImpresso = input.nextLine();
        System.out.print("Número do cartão: ");
        String numCartao = input.nextLine();
        System.out.print("Data de validade (MM/AA): ");
        String validade = input.nextLine();
        System.out.print("Código de segurança (CVV): ");
        String cvc = input.nextLine();
        System.out.println("=====================================");
        GerenciamentoCliente.salvarNovoCartao(novoCliente, nomeImpresso, numCartao, validade, cvc);
    }

    public static void imprimirListaCartoes(ArrayList<CartaoDeCredito> listaCartoes) {
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========");
        System.out.println("***Cartões cadastrados:");
        if (listaCartoes.isEmpty()) {
            System.out.println("\nNão há cartões salvos.\n");
        } else {
            for (CartaoDeCredito cartao : listaCartoes) {
                System.out.println(cartao);
            }
        }
    }

    public static void mostraMenuUsuario(CarrinhoDeCompras novoCarrinho) throws InterruptedException{
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========");
        GerenciamentoLoja.mostrarProdutosCliente();
        System.out.println("====================================");    
        System.out.println("Seja bem-vindo(a)!\n");
        System.out.println("MENU:");
        System.out.println("  1. Escolher um produto");
        System.out.println("  2. Ir para o carrinho");
        System.out.println("  3. Voltar para a Tela Principal");
        System.out.println("====================================");
        System.out.print("Escolha um comando: ");
        opt = input.nextInt();
        switch (opt) {
            case 1 -> escolherProduto(novoCarrinho);
            case 2 -> mostrarCarrinhoDeCompras(novoCarrinho);
            case 3 -> mostraMenuInicial();
            default -> {
            }
        }
    }

}
