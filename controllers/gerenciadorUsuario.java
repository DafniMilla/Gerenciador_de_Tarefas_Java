package controllers;
import java.util.ArrayList;
import models.Usuario;


public class gerenciadorUsuario {
   private ArrayList<Usuario> usuarios = new ArrayList<>();

   public void adicionarUsuario(String nome){
      usuarios.add(new Usuario(nome));
   }

   public ArrayList<Usuario> listaUsuarios() {
       return usuarios;
   }

   public boolean removeUsuario(String nome) {
      return usuarios.removeIf(u -> u.getName().equals(nome));
   }
}


