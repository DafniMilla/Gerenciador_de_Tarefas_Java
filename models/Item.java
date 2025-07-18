package models;

public class Item {
    private String titulo;
    private String descricao;

    public Item(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void mostrarDetalhes() {
        System.out.println("Item: " + titulo + ", Descrição: " + descricao);
    }
    
}
