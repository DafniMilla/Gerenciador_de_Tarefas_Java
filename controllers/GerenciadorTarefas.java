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
    public ArrayList<Tarefa>listartarefas(){
    return tarefas;
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

