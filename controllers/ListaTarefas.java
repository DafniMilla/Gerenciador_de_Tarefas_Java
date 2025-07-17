package controllers;

import java.util.ArrayList;
//import java.util.HashSet; //usada pra não repetir nome na lista, mas não esta sendo usada no código

import models.Tarefa;
import models.Usuario;

public class ListaTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListaTarefas(){
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void listarUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            usuarios.add(tarefa.getUsuario());
        }

        System.out.println("Usuários com tarefas:");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario.getName());
        }
    }
}
