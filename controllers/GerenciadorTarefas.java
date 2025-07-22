package controllers;
import java.util.ArrayList;
import models.Tarefa;
import models.Usuario;


public class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas=new ArrayList<>();

    public GerenciadorTarefas(){
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String titulo, String descricao, Usuario usuario ){
        Tarefa novTarefa=new Tarefa(titulo, descricao, usuario);
        tarefas.add(novTarefa);
    }
////listar tarefas
public void listarTarefasDoUsuario(Usuario usuario) {
    System.out.println("Tarefas de " + usuario.getName() + ":");
    int count = 0;
    for (int i = 0; i < tarefas.size(); i++) {
        Tarefa t = tarefas.get(i);
        if (t.getEncarregado().equals(usuario)) { //getEncarregado é o usuario da classe tarefa
            System.out.println(i + " - " + t.getTitulo() + ": " + t.getDescricao());
            count++;
        }
    }
    if (count == 0) {
        System.out.println("Nenhuma tarefa encontrada.");
    }
}

///remover tarefa
public boolean removerTarefaPorIndice(int indice, Usuario usuario) {
    if (indice >= 0 && indice < tarefas.size()) {
        tarefas.remove(indice);
        return true;
    }
    return false;
}

        
    }

