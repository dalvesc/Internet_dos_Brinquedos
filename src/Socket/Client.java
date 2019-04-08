/*
 * Descrição da classe.
 */
package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Client {
    private Socket cliente;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    /**
     * Método cria um cliente e conecta-o ao servidor.
     * @param ip
     * @param porta
     * @throws java.io.IOException
     */
    public void criarCliente(String ip, int porta) throws IOException{
        
        this.cliente = new Socket(ip, porta);
    }
    
    /**
     * Método que irá tratar da conexão e recebimento de dados entre servidor-cliente
     * @return input
     * @throws java.io.IOException
     */
    public ObjectInputStream conexaoInput() throws IOException{
        input = new ObjectInputStream(cliente.getInputStream());
        return input;
    }
    
    /**
     * Método que irá tratar da conexão e envio de dados entre servidor-cliente
     * @return output
     * @throws java.io.IOException
     */
    public ObjectOutputStream conexaoOutput() throws IOException{
        output = new ObjectOutputStream(cliente.getOutputStream());
        return output;
    }
    
    public void pedidoDeDados(String pedido){
        
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }
    
    
    
}
