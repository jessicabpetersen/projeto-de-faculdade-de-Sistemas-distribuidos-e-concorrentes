/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author Jessica
 */
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private String email;
    private String senha;
    private String telefone;
    private static Conta instance;
    private ArrayList<Usuario> contatos = new ArrayList<>();

    public synchronized static Conta getInstance() {
        if (instance == null) {
            instance = new Conta();
        }
        return instance;
    }

    public Conta(String nome, String usuario, String email, String senha, String telefone) {
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.usuario = new Usuario(nome, true, usuario);
//        testeContatos();
        
    }

    public Conta() {
//        testeContatos();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public Conta(String usuario, String senha) {
        getUsuario().setUsuario(usuario);
        this.senha = senha;
        testeContatos();
    }

    public void testeContatos() {
        
        Usuario dono = new Usuario("Jéssica", true, "jessicabp");
        this.email = "jessica@gmail.com";
        this.senha = "1234";
        this.telefone = "sada";
        this.usuario = dono;
        Usuario usuario = new Usuario("Márcia", true, "marcia");
        usuario.setIp("192.168.0.10");
        addContato(usuario);
         usuario = new Usuario("Cleiton", true, "cleitonk");
        usuario.setIp("192.168.0.15");
        addContato(usuario);
    }

    public void addContato(Usuario usu) {
        this.contatos.add(usu);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public ArrayList<Usuario> getContatos() {
        return contatos;
    }

    public void atualizarContatos(ArrayList<Usuario> lista) {
        this.contatos = lista;
    }

}
