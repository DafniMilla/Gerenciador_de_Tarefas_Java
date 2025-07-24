package controllers;
import java.util.ArrayList;
import models.Tarefa;
import models.Usuario;
import models.Status;



public class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas=new ArrayList<>();


    public void adicionarTarefa(String titulo, String descricao, Usuario usuario, String categoria ){
        Tarefa novTarefa=new Tarefa(titulo, descricao, usuario,categoria);
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

public boolean atualizarStatus( String titulo, Status novoStatus){
    for( Tarefa t:tarefas){
        if (t.getTitulo().equalsIgnoreCase(titulo)) {
            t.setStatus(novoStatus);
            return true;
        }
    }
    return false;
}

}

