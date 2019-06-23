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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class ControllerCadastro implements ObservadoCadastro {

    private List<ObservadorCadastro> observadores = new ArrayList<>();
    Socket conexao = null;
    Servidor servidor;

    @Override
    public void addObservador(ObservadorCadastro obs) {
        this.observadores.add(obs);
    }

    public ControllerCadastro() {
        servidor = Servidor.getInstance();
//        Servidor servidor = new Servidor();
//        endereco = servidor.getEndereço();
//        porta = servidor.getPorta();
//        try {
//            server.setSoTimeout(3000);
//            server = new ServerSocket(porta);
//            server.setReuseAddress(true);
//        } catch (IOException e) {
//        }
    }

    @Override
    public void voltar() {
        for (ObservadorCadastro obs : observadores) {
            obs.voltar();
        }
    }

    @Override
    public boolean cadastro(String nome, String usuario, String email, String senha, String telefone) {
        try {
            if (servidor.conectar()) {
                conexao = servidor.getConexao();
            }
            ObjectOutputStream oos = new ObjectOutputStream(conexao.getOutputStream());
            ///ver como ENVIAR UM OBJETO
            Mensagem msg = new Mensagem();
            msg.setAssunto(1);
            msg.setConta(new Conta(nome, usuario, email, senha, telefone));
            oos.writeObject(msg);
            oos.close();
            conexao.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
