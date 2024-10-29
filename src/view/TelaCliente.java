package view;

import control.GerenciamentoCliente;
import control.GerenciamentoLoja;
import java.util.ArrayList;
import java.util.Scanner;
import model.CarrinhoDeCompras;
import model.CartaoDeCredito;
import model.Cliente;
import model.Endereco;
import model.Item;
import model.Pedido;
import model.Produto;

public class TelaCliente {
    private static Integer opt = 0;
    private static boolean ctr = true;
    public static Scanner input = new Scanner(System.in);

    public static void escolherProduto(CarrinhoDeCompras novoCarrinho) {
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

    public static void mostrarCarrinhoDeCompras(CarrinhoDeCompras novoCarrinho) {
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

    public static void mostrarloginCliente(CarrinhoDeCompras novoCarrinho) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========\n");
        System.out.print("Login: ");
        String email = input1.nextLine();
        ctr = GerenciamentoCliente.verificaEmail(email);
        if (ctr == false) {
            //E-mail não cadastrado.
            System.out.println("\nVamos criar sua nova conta:\n");
            System.out.print("Senha: ");
            String senha = input1.nextLine(); //Variável de cada item do construtor
            System.out.print("Nome completo: ");
            String nome = input1.nextLine(); //Variável de cada item do construtor
            System.out.print("CPF: ");
            String cpf = input1.nextLine(); //Variável de cada item do construtor
            System.out.print("Telefone: ");
            String telefone = input1.nextLine(); //Variável de cada item do construtor
            System.out.print("Data de nascimento: ");
            String nascimento = input1.nextLine(); //Variável de cada item do construtor
            ArrayList<Endereco> listaVaziaEnderecos = new ArrayList<>();
            ArrayList<CartaoDeCredito> cartoesSalvoVazio = new ArrayList<>();
            ArrayList<Pedido> listaVaziaPedidos = new ArrayList<>();
            System.out.println("Clique qualquer tecla para avançar.");
            String txt1 = input1.nextLine();
            System.out.println(txt1);
            input1.close();
            Cliente novoCliente = new Cliente(email, senha, nome, cpf, telefone, listaVaziaEnderecos, nascimento, cartoesSalvoVazio, listaVaziaPedidos);
            mostrarTelaFinalizandoCompra(novoCarrinho, novoCliente);
        } else {
            //E-mail cadastrado.
            System.out.print("Senha: ");
            String senha = input1.nextLine();
            input1.close();
            Object novoCliente = GerenciamentoCliente.verificarLogin(email, senha);
            mostrarTelaFinalizandoCompra(novoCarrinho, (Cliente) novoCliente);
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void mostrarCadastroEndereco(Cliente novoCliente) {
        Scanner input2 = new Scanner(System.in);
        String rua, numLugar, bairro, cidade, estado;
        System.out.println("========== NOVO ENDEREÇO ===========");
        System.out.print("Rua: ");
        rua = input2.nextLine();
        System.out.print("Número: ");
        numLugar = input2.nextLine();
        System.out.print("Bairro: ");
        bairro = input2.nextLine();
        System.out.print("Cidade: ");
        cidade = input2.nextLine();
        System.out.print("Estado: ");
        estado = input2.nextLine();
        input2.close();
        System.out.println("====================================");
        GerenciamentoCliente.cadastrarEnderecoCliente(novoCliente, bairro, cidade, estado, numLugar, rua);
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

    public static void mostrarTelaFinalizandoCompra(CarrinhoDeCompras novoCarrinho, Cliente novoCliente) {
        ArrayList<Endereco> listaEnderecos = novoCliente.getEnderecos();
        imprimirListaDeEnderecos(listaEnderecos);
        if (novoCliente.getEnderecos().isEmpty()) {
            mostrarCadastroEndereco(novoCliente);
            System.out.println("Novo endereço cadastrado com sucesso!");
            System.out.println("Digite qualquer coisa: ");
            int teste = input.nextInt();
            System.out.println(teste);
            Endereco enderecoSelec = novoCliente.getEnderecos().get(0);
            //(Endereco enderecoEntrega, CartaoDeCredito cartaoPagamento, int numPedido, String statusPedido)
            String statusPedido = "Pedido Criado";
            ArrayList<CartaoDeCredito> listaCartoes = novoCliente.getCartoesSalvo();
            imprimirListaCartoes(listaCartoes);
            mostrarCadastroDeCC(novoCliente);
            CartaoDeCredito novoCartao = novoCliente.getCartoesSalvo().get(0);
            ArrayList<Item> produtosPedido = novoCarrinho.getItens();
            Pedido novoPedido = new Pedido(enderecoSelec, novoCartao, 1, statusPedido, produtosPedido);
            novoCliente.addPedido(novoPedido);
            System.out.println("Pedido conclído com sucesso!");
            ArrayList<Item> novoItem = new ArrayList<>();            
            CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, statusPedido);
            mostraMenuUsuario(novoCarrinhoDeCompras);
        } else {
            System.out.println("Deseja cadastrar um novo endereço? [S/N]");
            String teste = input.nextLine().toUpperCase();

            if ("S".equals(teste)) {
                mostrarCadastroEndereco(novoCliente);
                System.out.println("Digite qualquer coisa: ");
                String avan = input.nextLine();
                System.out.println(avan);
                ArrayList<Endereco> listaEnderecos2 = novoCliente.getEnderecos();
                imprimirListaDeEnderecos(listaEnderecos2);
                System.out.print("Selecione um endereço de entrega: ");
                int num1 = input.nextInt();
                Endereco enderecoSelec = novoCliente.getEnderecos().get(num1-1);
                ArrayList<CartaoDeCredito> listaCartoes = novoCliente.getCartoesSalvo();
                imprimirListaCartoes(listaCartoes);
                System.out.println("Deseja cadastrar um novo cartão? [S/N]");
                String teste1 = input.nextLine().toUpperCase();
                /// ============================ IGUAL 1 ==========================================================
                if ("S".equals(teste1)) {
                    mostrarCadastroDeCC(novoCliente);
                    ArrayList<CartaoDeCredito> listaCartoes1 = novoCliente.getCartoesSalvo();
                    imprimirListaCartoes(listaCartoes1);
                    CartaoDeCredito cartaoCompra = novoCliente.getCartoesSalvo().getLast();
                    int num2 = 3;
                    String statusPedido = "Peidido Criado!";
                    ArrayList<Item> produtosPedido = novoCarrinho.getItens();
                    Pedido novoPedido = new Pedido(enderecoSelec, cartaoCompra, num2, statusPedido, produtosPedido);
                    novoCliente.addPedido(novoPedido);
                    System.out.println("Digite qualquer coisa para voltar ao ínicio:");
                    String qualquer = input.nextLine();
                    ArrayList<Item> novoItem = new ArrayList<>();            
                    CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, qualquer);
                    mostraMenuUsuario(novoCarrinhoDeCompras);
                } else {
                    System.out.print("Selecione um cartão: ");
                    int ccSelec = input.nextInt();
                    CartaoDeCredito cartaoCompra = novoCliente.getCartoesSalvo().get(ccSelec-1);
                    int num2 = 3;
                    String statusPedido = "Peidido Criado!";
                    ArrayList<Item> produtosPedido = novoCarrinho.getItens();
                    Pedido novoPedido = new Pedido(enderecoSelec, cartaoCompra, num2, statusPedido, produtosPedido);
                    novoCliente.addPedido(novoPedido);
                    System.out.println("Digite qualquer coisa para voltar ao ínicio:");
                    String qualquer = input.nextLine();
                    ArrayList<Item> novoItem = new ArrayList<>();            
                    CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, qualquer);
                    mostraMenuUsuario(novoCarrinhoDeCompras);
                }
                /// ============================ IGUAL 1 ==========================================================
            } else {
                System.out.print("Selecione um endereço de entrega: ");
                int num1 = input.nextInt();
                Endereco enderecoSelec = novoCliente.getEnderecos().get(num1-1);
                ArrayList<CartaoDeCredito> listaCartoes = novoCliente.getCartoesSalvo();
                imprimirListaCartoes(listaCartoes);
                System.out.println("Deseja cadastrar um novo cartão? [S/N]");
                String teste1 = input.nextLine().toUpperCase();
                /// ============================ IGUAL 1 ==========================================================
                if ("S".equals(teste1)) {
                    mostrarCadastroDeCC(novoCliente);
                    ArrayList<CartaoDeCredito> listaCartoes1 = novoCliente.getCartoesSalvo();
                    imprimirListaCartoes(listaCartoes1);
                    CartaoDeCredito cartaoCompra = novoCliente.getCartoesSalvo().getLast();
                    int num2 = 3;
                    String statusPedido = "Peidido Criado!";
                    ArrayList<Item> produtosPedido = novoCarrinho.getItens();
                    Pedido novoPedido = new Pedido(enderecoSelec, cartaoCompra, num2, statusPedido, produtosPedido);
                    novoCliente.addPedido(novoPedido);
                    System.out.println("Digite qualquer coisa para voltar ao ínicio:");
                    String qualquer = input.nextLine();
                    ArrayList<Item> novoItem = new ArrayList<>();            
                    CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, qualquer);
                    mostraMenuUsuario(novoCarrinhoDeCompras);
                } else {
                    System.out.print("Selecione um cartão: ");
                    int ccSelec = input.nextInt();
                    CartaoDeCredito cartaoCompra = novoCliente.getCartoesSalvo().get(ccSelec-1);
                    int num2 = 3;
                    String statusPedido = "Peidido Criado!";
                    ArrayList<Item> produtosPedido = novoCarrinho.getItens();
                    Pedido novoPedido = new Pedido(enderecoSelec, cartaoCompra, num2, statusPedido, produtosPedido);
                    novoCliente.addPedido(novoPedido);
                    System.out.println("Digite qualquer coisa para voltar ao ínicio:");
                    String qualquer = input.nextLine();
                    ArrayList<Item> novoItem = new ArrayList<>();            
                    CarrinhoDeCompras novoCarrinhoDeCompras = new CarrinhoDeCompras(novoItem, qualquer);
                    mostraMenuUsuario(novoCarrinhoDeCompras);
                }
                /// ============================ IGUAL 1 ==========================================================
            }
        }
    }

    public static void mostraMenuUsuario(CarrinhoDeCompras novoCarrinho){
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("=========== LOJA VIRTUAL ===========");
        GerenciamentoLoja.mostrarProdutosCliente();
        System.out.println("====================================");    
        System.out.println("Seja bem-vindo(a)!\n");
        System.out.println("MENU:");
        System.out.println("  1. Escolher um produto");
        System.out.println("  2. Ir para o carrinho");
        System.out.println("  3. Fazer login");
        System.out.println("====================================");
        System.out.print("Escolha um comando: ");
        opt = input.nextInt();
        switch (opt) {
            case 1 -> escolherProduto(novoCarrinho);
            case 2 -> mostrarCarrinhoDeCompras(novoCarrinho);
            default -> {
            }
        }
    }

}
