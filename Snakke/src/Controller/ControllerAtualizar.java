/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.Mensagem;
import Model.Servidor;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class ControllerAtualizar implements ObservadoAtualizar {

    private List<ObservadorAtualizar> observadores = new ArrayList<>();
    private Conta conta;
    Socket conexao = null;
    Servidor servidor;
    
    public ControllerAtualizar(){
        conta = Conta.getInstance();
//        servidor = Servidor.getInstance();
//        conexao = servidor.getConexao();

    }
    
    @Override
    public void addObservador(ObservadorAtualizar obs) {
        this.observadores.add(obs);
    }
    
    @Override
    public void mostrarDadosConta(){
        for (ObservadorAtualizar obs : observadores) {
            obs.mostrarDadosConta(conta.getUsuario().getNome(), conta.getUsuario().getUsuario(), conta.getSenha(), conta.getEmail(), conta.getTelefone());
        }
    }

    @Override
    public boolean atualizarDados(String nome, String usuario, String senha, String email, String telefone) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(conexao.getOutputStream());
            ///ver como ENVIAR UM OBJETO
            Mensagem msg = new Mensagem();
            msg.setAssunto(1);
            msg.setConta(new Conta(nome, usuario, email, senha, telefone));
            oos.writeObject(msg);
            oos.close();
        } catch (IOException ex) {
            return false;
        } 
        return true;
    }
    
}
