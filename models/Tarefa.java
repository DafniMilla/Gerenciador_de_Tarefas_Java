package models;

public class Tarefa extends Item{
    private String status;
    private Usuario encarregado;
    private String categoria;

    public Tarefa(String titulo, String descricao, Usuario encarregado, String categoria){
        super(titulo,descricao);
        this.status = "Pendente";
        this.encarregado = encarregado;
        this.categoria = categoria;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(Status novoStatus){
        this.status = novoStatus.toString();
    }

    public Usuario getEncarregado() {
        return encarregado;
    }

    @Override
    public void mostrarDetalhes(){
        System.out.println("Tarefa: "+ getTitulo() + " | Status: " + status + " | Descrição: " + getDescricao() + " | Encarregado: " + encarregado.getName() + " | Categoria: " + categoria);
    }
}
