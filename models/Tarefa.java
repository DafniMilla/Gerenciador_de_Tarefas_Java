package models;

public class Tarefa {
    private String descricao;
    private Usuario usuario;

    public Tarefa(String descricao, Usuario usuario){
        this.descricao=descricao;
        this.usuario=usuario;
    }
    public Usuario getUsuario(){
        return usuario;
    }

    public String getDescricao(){
        return descricao;
    }
    
}
