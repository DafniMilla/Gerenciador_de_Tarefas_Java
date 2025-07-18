package controllers;
import java.util.ArrayList;
import models.Usuario;


public class GerenciadorUsuarios {
   private ArrayList<Usuario> usuarios = new ArrayList<>();

   public void adicionarUsuario(String nome){
      usuarios.add(new Usuario(nome));
   }

   public ArrayList<Usuario> listarUsuarios() {
       return usuarios;
   }

   public boolean removerUsuario(String nome) {
      return usuarios.removeIf(u -> u.getName().equals(nome));
   }

   public Usuario buscarUsuarioPorNome(String nome) {
    for (Usuario u : usuarios) {
        if (u.getName().equalsIgnoreCase(nome)) {
            return u;
        }
    }
    return null;
}

}


