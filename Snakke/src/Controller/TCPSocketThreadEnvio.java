/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mensagem;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class TCPSocketThreadEnvio extends Thread {

    private Socket conexao;
    private Mensagem msg;
    private static int porta = 56000;

    public TCPSocketThreadEnvio(Mensagem msg, String endereço) throws IOException {
        conexao = new Socket(endereço, porta);
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(conexao.getOutputStream());
            oos.writeObject(msg);
            oos.close();
        } catch (IOException ex) {

        }
    }

}
