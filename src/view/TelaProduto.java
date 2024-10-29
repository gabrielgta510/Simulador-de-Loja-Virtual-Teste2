package view;

import java.util.Scanner;

/*
 * Mesma implementação de TelaUsuario
 */
public class TelaProduto {
    private static String opt = "";
    private static Scanner input = new Scanner(System.in);

    public static void mostraMenuProduto(){
        System.out.print("\033[H\033[2J"); // Limpar a tela
        System.out.println("\t\t###########  SIMULADOR DE LOJA VIRTUAL  ###########\n");    
        System.out.println("\tMENU PRODUTO");
        System.out.println("\t\t1. Cadastrar Produto");
        System.out.println("\t\t2. Consultar Produto");
        System.out.println("\t\t3. Listar Produtos\n");
        System.out.println("\t\t4. ...\n");
        System.out.println("\t\t5. Voltar para o Menu Inicial\n");
        System.out.print("Escolha umas das opções acima ");
        opt = input.nextLine();
        switch (opt) {
            case "1":
                cadastraUsuario();
                break;
            case "2":
                consultaUsuario();
                break;
            case "3":
                ListaUsuarios();
                break;
            case "5":
                TelaPrincipal.mostraMenuInicial();
                break;
            default:
                break;
        }
        input.close();
    }

    private static void consultaUsuario() {
        //TODO
    }

    private static void ListaUsuarios() {
        //TODO
    }

    private static void cadastraUsuario() {
        //TODO
    }
}
