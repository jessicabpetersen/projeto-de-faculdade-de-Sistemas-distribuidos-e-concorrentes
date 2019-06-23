/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe para enviar dados ao servidor
 *
 * @author Jessica
 */
public class Servidor {

    private String endereco;
    private int porta;
    private static Servidor instance;
    Socket conexao = null;
    ServerSocket server;

    public static Servidor getInstance() {
        if (instance == null) {
            instance = new Servidor();
        }
        return instance;
    }

    public Servidor() {
        endereco = "";
        porta = 56000;
        try {
            server.setSoTimeout(10000);
        } catch (IOException e) {
        }
    }

    public boolean receberConexao(){
        try{
            conexao = server.accept();
            return true;
        }catch(IOException e){
            return false;
        }
    }
    
    public String getEndereço() {
        return endereco;
    }

    public int getPorta() {
        return porta;
    }

    public Socket getConexao() {
        return conexao;
    }

    public boolean conectar() {
        try {
            server = new ServerSocket(porta);
            server.setReuseAddress(true);
            conexao = new Socket(endereco, porta);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            conexao.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
