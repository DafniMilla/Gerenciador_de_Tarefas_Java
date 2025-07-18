import java.util.Scanner;
import controllers.GerenciadorUsuarios;
import models.Usuario;


public class Menu {
    private static GerenciadorUsuarios usuario = new GerenciadorUsuarios();
    private static Scanner scanner = new Scanner(System.in);

    public  void exibirMenu() {
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Listar Usuários");           
            System.out.println("3. Remover Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

                switch (opcao){
                    case 1 -> adicionarUsuario();
                    case 2 -> listarUsuarios();
                    case 3 -> removerUsuario();
                    case 0 -> System.out.println("Saindo do menu...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);
        }
    
        private static void adicionarUsuario() {
            System.out.print("Digite o nome do usuário: ");
            String nome = scanner.next();
            usuario.adicionarUsuario(nome);
            System.out.println("Usuário adicionado com sucesso!");
        }
        private static void listarUsuarios() {
            System.out.println("Lista de Usuários:");
            for (Usuario u : usuario.listarUsuarios()) {
                System.out.println("- " + u.getName());
            }
        }
        private static void removerUsuario() {
            System.out.print("Digite o nome do usuário a ser removido: ");
            String nome = scanner.next();
            if (usuario.removerUsuario(nome)) {
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        }
    }


     
