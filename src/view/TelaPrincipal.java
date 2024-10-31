package view;

import control.GerenciamentoCliente;
import java.util.ArrayList;
import java.util.Scanner;
import model.CarrinhoDeCompras;
import model.Item;

public class TelaPrincipal {
    private static String opt = "";
    public static Scanner input = new Scanner(System.in);
    /*
     * Método apenas para escrever menu na tela
     */
    public static void mostraMenuInicial() throws InterruptedException{
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("\t\t###########  SIMULADOR DE LOJA VIRTUAL  ###########\n");
        System.out.println("\tMENU INICIAL");
        System.out.println("\t\t1. Módulo Cliente");//Faz o gerenciamento de usuário -- CRUD
        System.out.println("\t\t2. Módulo Produto");//Faz o gerenciamento de produto da loja -- CRUD
        System.out.println("\t\t3. Mostrar Clientes Cadastrados\n");    
        System.out.print("Escolha umas das opções acima ");
        opt = input.nextLine();

        switch (opt) {
            case "1" -> {
                ArrayList<Item> listaVazia = new ArrayList<>();
                CarrinhoDeCompras novoCarrinho = new CarrinhoDeCompras(listaVazia, null);
                TelaCliente.mostraMenuUsuario(novoCarrinho);
            }
            case "2" -> TelaProduto.mostraMenuProduto();
            case "3" -> GerenciamentoCliente.mostrarClientesCadastrados();
            default -> {
            }
        }
    }
}
