
import java.util.Scanner;
import controllers.GerenciadorUsuarios;
import models.Status;
import models.Tarefa;
import models.Usuario;
import controllers.GerenciadorTarefas;


public class Menu {
    
    // Códigos ANSI para as cores
    public static final String RESET = "\u001B[0m";
    public static final String ROSA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String AMARELO = "\u001B[33m";
    public static final String VERDE = "\u001B[32m";
    public static final String VERMELHO = "\u001B[31m";

      //background
    String BLACK_BG = "\u001B[40m";
    String RED_BG = "\u001B[41m";
    String GREEN_BG = "\u001B[42m";
    String YELLOW_BG = "\u001B[43m";
    String BLUE_BG = "\u001B[44m";
    String PURPLE_BG = "\u001B[45m";
    String  CYAN_BG = "\u001B[46m";
    String WHITE_BG = "\u001B[47m";

      //cor da letra pra variaveis static
    private static final String REDP = "\u001B[31m";
    public static final String RESETP = "\u001B[0m";
    private static final String GREENP = "\u001B[32m";
    public static final String ROSAP = "\u001B[35m";


    private static GerenciadorUsuarios usuario = new GerenciadorUsuarios();
    private static Scanner scanner = new Scanner(System.in);
    private static GerenciadorTarefas tarefas = new GerenciadorTarefas(); // add tarefa


    public  void exibirMenu() {
        int opcao;

        do {  
            System.out.println(ROSA + "╔═══════════════════════════════════╗" + RESET);
            System.out.println(ROSA + "║      Gerenciador de tarefas       ║" + RESET);
            System.out.println(ROSA + "╚═══════════════════════════════════╝" + RESET);
            System.out.println();
            System.out.println(CYAN + "               MENU" + RESET);
            System.out.println(CYAN + "═════════════════════════════════════" + RESET);
            System.out.println(CYAN +"1. Adicionar Usuário" +RESET);
            System.out.println(CYAN +"2. Listar Usuários"+ RESET);           
            System.out.println(CYAN +"3. Remover Usuário"+ RESET);
            System.out.println(CYAN +"4. Adicionar Tarefa"+ RESET);
            System.out.println(CYAN +"5. Remover Tarefa"+ RESET);
            System.out.println("6. Listar Tarefas");
            System.out.println(CYAN +"0. Sair"+ RESET);
            System.out.print(CYAN + "Escolha uma opção: "+ RESET);
            opcao = scanner.nextInt();

                switch (opcao){
                    case 1 -> adicionarUsuario();
                    case 2 -> listarUsuarios();
                    case 3 -> removerUsuario();
                    case 4 -> adicionarTarefas(); 
                    case 5 -> removerTarefa();  
                    case 6 -> listartarefas();
                    case 0 -> System.out.println("Saindo do menu...");
                    default -> System.out.println(REDP + "Opção inválida. Tente novamente."+ RESET);
                }
            } while (opcao != 0);
        }
    
        private static void adicionarUsuario() {
            System.out.print("Digite o nome do usuário: ");
            String nome = scanner.next();
            usuario.adicionarUsuario(nome);
            System.out.println(GREENP+ "Usuário adicionado com sucesso!"+ RESETP);
        }
        private static void listarUsuarios() {
            System.out.println( "Lista de Usuários:" );
            for (Usuario u : usuario.listarUsuarios()) {
                System.out.println("- " + u.getName());
            }
        }
        private static void removerUsuario() {
            System.out.print("Digite o nome do usuário a ser removido: ");
            String nome = scanner.next();
            if (usuario.removerUsuario(nome)) {
                System.out.println(GREENP+ "Usuário removido com sucesso!"+RESETP);
            } else {
                System.out.println(REDP+ "Usuário não encontrado."+RESETP);
            }
        }
        ////// adicionar tarefa
        private static void adicionarTarefas() {
    System.out.print("Digite seu nome: ");
    String nome = scanner.next();

    try {
        Usuario usuarioEncontrado = usuario.buscarUsuarioPorNome(nome);
        scanner.nextLine(); // consumir \n pendente
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.adicionarTarefa(titulo, descricao, usuarioEncontrado);
        System.out.println(GREENP + "Tarefa adicionada com sucesso!" + RESETP);
    } catch (exceptions.UsuarioNaoEncontradoException e) {
        System.out.println(REDP + e.getMessage() + RESETP);
    }
}

        ///remover tarefa
       private static void removerTarefa() {
    System.out.println("Digite seu nome:");
    String nome = scanner.next();
    try {
        Usuario usuarioEncontrado = usuario.buscarUsuarioPorNome(nome);
        tarefas.listartarefas();
        System.out.print("Digite o número da tarefa que deseja remover: ");
        int indice = scanner.nextInt();
        boolean sucesso = tarefas.removerTarefaPorIndice(indice, usuarioEncontrado);
        if (sucesso) {
            System.out.println(GREENP + "Tarefa removida com sucesso!" + RESETP);
        } else {
            System.out.println(REDP + "Índice inválido ou tarefa não pertence ao usuário." + RESETP);
        }
    } catch (exceptions.UsuarioNaoEncontradoException e) {
        System.out.println(REDP + e.getMessage() + RESETP);
    }
}


        private static void listartarefas(){
            for(Tarefa t: tarefas.listartarefas()){
                t.mostrarDetalhes();
            }
        }
        public static void atualizarStatus(){
            System.out.println("Digite o titulo da tarefa que vai ser atualizada:");
            var titulo = scanner.next();
            System.out.println("Digite o novo status da tarefa (Pendente, Em Andamento, Concluída):");
            var status = scanner.nextInt();
            var novoStatus = switch (status){
                case 1 -> Status.PENDENTE;
                case 2 -> Status.EM_ANDAMENTO;
                case 3 -> Status.CONCLUIDA;
                default -> Status.PENDENTE;
            };
            if (tarefas.atualizarStatus(titulo,novoStatus )){
                System.out.println(("Status atualizado."));
            }else{
                System.out.println("Tarefa não encontrada.");
            }
        }

    }

   
    
     
