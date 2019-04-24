/*
 *
 */
package SocketClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Client implements Serializable{

    Socket cliente;
    private ObjectOutputStream output;
    private ObjectInputStream input;
        
    /**
     * Método que inicia uma conexão com um servidor, especificando sua porta e IP.
     * @param ip
     * @param porta
     * @throws IOException 
     */
    public void iniciarConexao(String ip, int porta) throws IOException{
        cliente = new Socket(ip, porta);
    }
    
    /**
     * Método que recebe uma mensagem do servidor.
     * @param cliente
     * @return ObjectOutputStream
     * @throws IOException 
     */
    public ObjectOutputStream conexaoOutput(Socket cliente) throws IOException{
        this.output = new ObjectOutputStream(cliente.getOutputStream());
        return output;
    }
    
    /**
     * Método que envia uma mensagem para o servidor.
     * @param cliente
     * @return ObjectInputStream
     * @throws IOException 
     */
    public ObjectInputStream conexaoInput(Socket cliente) throws IOException{
        this.input = new ObjectInputStream(cliente.getInputStream());
        return input;
    }
    
    /**
     * Método que finaliza o fluxo de entrada e saída de mensagens.
     * @throws IOException 
     */
    public void conexaoClose() throws IOException{
        output.close();
        input.close();
    }
    
    /**
     * Método que finaliza a conexão com o servidor.
     * @param cliente
     * @throws IOException 
     */
    public void fecharSocket(Socket cliente) throws IOException{
        cliente.close();
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }
}
