/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conta;
import Model.Mensagem;
import Model.Usuario;
import View.Conversa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jessica
 */
public class ControllerApp implements ObservadoApp {

    private List<ObservadorApp> observadores = new ArrayList<>();
    private ArrayList<Usuario> contatos = new ArrayList<>();
    Conta conta;
    DefaultListModel listaOn;
    DefaultListModel listaOff;
    ArrayList<Conversa> janelasAbertas = new ArrayList<>();
    private static ControllerApp instance;

    public static ControllerApp getInstance() throws IOException {
        if (instance == null) {
            instance = new ControllerApp();
        }
        return instance;
    }

    public ControllerApp()  {
        conta = Conta.getInstance();
        contatos = conta.getContatos();
    }
    
    public void iniciarEscuta(){
        Escuta escuta;
        try {
            escuta = new Escuta(this);
            escuta.start();
        } catch (IOException ex) {
            Logger.getLogger(ControllerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario[] getContatosAbertos() {
        Usuario[] usuarios = new Usuario[janelasAbertas.size()];
        int marcador = 0;
        for (Conversa janela : janelasAbertas) {
            usuarios[marcador] = janela.getController().getUsuario();
            marcador++;
        }

        return usuarios;
    }

    public void atualizarTelaInicial() {
        atualizarNomeUsuario();
        atualizarListas(contatos);
    }

    public void atualizarNomeUsuario() {
        for (ObservadorApp obs : observadores) {
            obs.atualizarNome(conta.getUsuario().getNome());
        }
    }

    public void atualizarListas(ArrayList<Usuario> lista) {
        listaOn = new DefaultListModel();
        listaOff = new DefaultListModel();
        for (Usuario usuario : conta.getContatos()) {
            if (usuario.isOnline()) {
                listaOn.addElement(usuario.getNome());
            } else {
                listaOff.addElement(usuario.getNome());
            }
        }

        atualizarListaOn(listaOn);
        atualizarListaOff(listaOff);
    }

    private void atualizarListaOn(DefaultListModel listaOn) {
        for (ObservadorApp obs : observadores) {
            obs.atualizarListaOn(listaOn);
        }
    }

    private void atualizarListaOff(DefaultListModel listaOff) {
        for (ObservadorApp obs : observadores) {
            obs.atualizarListaOff(listaOff);
        }
    }

    @Override
    public void addObservador(ObservadorApp obs) {
        this.observadores.add(obs);
    }

    public Conversa getJanelaAberta(String usuario) {
        Conversa conversa = null;
        for (Conversa janela : janelasAbertas) {
            if (janela.getController().getUsuario().getUsuario().equals(usuario)) {
                conversa = janela;
            }
        }
        return conversa;
    }

    @Override
    public void listaOnClicada(String nome) {
        String usuario =  retornaNomeUsuByNome(nome);
        
        boolean janelaAberta = false;
        if (janelasAbertas.size() > 0) {
            for (Conversa janelasAberta : janelasAbertas) {
                if (janelasAberta.getController().getUsuario().getUsuario().equals(usuario)) {
                    janelaAberta = true;
                }
            }
        } 
        if(!janelaAberta){
            for (Usuario usu : contatos) {
                if (usu.getUsuario().equals(usuario)) {
                    Conversa conversa = new Conversa(new ControllerConversa(usu), this);
                    conversa.setVisible(true);
                    janelasAbertas.add(conversa);
                    break;
                }
            }

        }
    }
    
    public String retornaNomeUsuByNome(String nome){
        String usuario=  "";
        for (Usuario contato : contatos) {
            if(contato.getNome().equals(nome)){
                usuario = contato.getUsuario();
            }
        }
        return usuario;
    }

    public void novaJanelaConversa(String nome, String msg) {
        String usuario = retornaNomeUsuByNome(nome);
        for (Usuario usu : contatos) {
            if (usu.getNome().equals(usuario)) {
                Conversa conversa = new Conversa(new ControllerConversa(usu), this);
                conversa.setVisible(true);
                conversa.getjTextAreaConversa().append(msg);
                janelasAbertas.add(conversa);
                break;
            }
        }
    }

    public void removerJanelaConversa(Conversa conversa) {
        this.janelasAbertas.remove(conversa);
    }

    /**
     * Atualizar Dados do próprio contato
     */
    @Override
    public void AtualizarDados() {

    }

    /**
     * Adicionar Usuário
     *
     * @param usuario
     * @return
     */
    @Override
    public boolean adicionarContato(String usuario) {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     * Remover Usuário
     *
     * @param usuario
     * @return
     */
    @Override
    public boolean removerContato(String usuario) {
        if (true) {
            return true;
        }
        return false;
    }

    void encerraChamada(Mensagem msg) {
        for (Conversa janelasAberta : janelasAbertas) {
            if(msg.getConta().getUsuario().getUsuario().equals(janelasAberta.getController().getUsuario().getUsuario())){
                janelasAberta.getController().getAudio().encerrarChamada();
                janelasAberta.getjTextAreaConversa().append(msg.getConta().getUsuario().getNome()+" encerrou a chamada de áudio. \n");
            }
        }
    }

}
