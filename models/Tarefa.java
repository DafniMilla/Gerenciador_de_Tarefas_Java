package models;

public class Tarefa extends Item{
    private Status status;
    private Usuario encarregado;
    private String categoria;
    private Prioridade prioridade;

    public Tarefa(String titulo, String descricao, Usuario encarregado, String categoria){
        super(titulo,descricao);
        this.status = Status.PENDENTE;
        this.encarregado = encarregado;
        this.categoria = categoria;
        this.prioridade = Prioridade.MEDIA;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status novoStatus){
        this.status = novoStatus;
    }

    public Usuario getEncarregado() {
        return encarregado;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade novaPrioridade) {
        this.prioridade = novaPrioridade;
    }

    @Override
    public void mostrarDetalhes(){
        System.out.println("Tarefa: " + getTitulo()
        + "\n Status: " + status
        + "\n Descrição: " + getDescricao()
        + "\n Encarregado: " + encarregado.getName()
        + "\n Categoria: " + categoria
        + "\n Prioridade: " + prioridade);
        System.out.println("---------------------------------");
    }
}
