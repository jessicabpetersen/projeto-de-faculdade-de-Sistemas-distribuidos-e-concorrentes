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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class ControllerLogin implements ObservadoLogin {
    
    private List<ObservadorLogin> observadores = new ArrayList<>();
    Servidor servidor;
    Socket conexao = null;
    Conta conta;
    
    public ControllerLogin() {
        servidor = Servidor.getInstance();
    
        
    }
    
    public String esqueceuSenha(String email) {
        if (servidor.conectar()) {
            conexao = servidor.getConexao();
        }
        Mensagem msg = new Mensagem();
        msg.setAssunto(2);
        msg.getConta().setEmail(email);
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(conexao.getOutputStream());
            oos.writeObject(msg);
            oos.close();
        } catch (IOException ex) {
            return "Não foi possivel recuperar sua senha, tente novamente mais tarde";
        }
        
        servidor.desconectar();

        //receber msn  com login ou foi enviado p o email
        //email
        return "Sua mensagem foi enviada para seu email";
    }
    
    public boolean login(String usuario, String senha) {
//        testeLogin();
        try {
            if (servidor.conectar()) {
                conexao = servidor.getConexao();
            }
            
            if (servidor.conectar()) {
                conexao = servidor.getConexao();
            }
            ObjectOutputStream oos = new ObjectOutputStream(conexao.getOutputStream());
            ///ver como ENVIAR UM OBJETO
            Mensagem msg = new Mensagem();
            msg.setAssunto(3);
            msg.getConta().getUsuario().setUsuario(usuario);
            msg.getConta().setSenha(senha);
            oos.writeObject(msg);
            oos.close();
            //espera receber dados
            //se deu certo
            if (servidor.receberConexao()) {
                ObjectInputStream object = new ObjectInputStream(servidor.getConexao().getInputStream());
                conta = (Conta) object.readObject();
                object.close();
                servidor.desconectar();
            } else {//se não deu
                return false;
            }
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
        return true;
    }
    
    public void testeLogin() {
        conta = Conta.getInstance();
    }
    
    @Override
    public void addObservador(ObservadorLogin obs) {
        observadores.add(obs);
    }
    
}
