
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
public class Server {

    private ServerSocket servidor;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    /**
     * Método que instancia e cria o servidor, na porta escolhida enviada por paramêtro.
     * @param porta
     * @throws IOException 
     */
    public void criarServidor(int porta) throws IOException{
        servidor = new ServerSocket(porta);
    }
    
    /**
     * Método que espera uma conexão com um cliente.
     * @return Socket
     * @throws IOException 
     */
    public Socket esperarConexao() throws IOException{
        Socket cliente = servidor.accept();
        return cliente;
    }
    
    /**
     * Método que recebe uma mensagem do cliente.
     * @param cliente
     * @return ObjectOutputStream
     * @throws IOException 
     */
    public ObjectOutputStream conexaoOutput(Socket cliente) throws IOException{
        this.output = new ObjectOutputStream(cliente.getOutputStream());
        return output;
    }
    
    /**
     * Método que envia uma mensagem para o cliente.
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
     * Método que finaliza a conexão com um determinado cliente.
     * @param cliente
     * @throws IOException 
     */
    public void fecharSocket(Socket cliente) throws IOException{
        cliente.close();
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
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
