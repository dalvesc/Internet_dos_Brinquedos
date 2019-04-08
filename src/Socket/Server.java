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
public class Server {
    
    private ServerSocket servidor;
    private Socket cliente;
    
    /**
     * Método cria um servidor
     * @param porta
     * @throws java.io.IOException
     */
    public void criarServidor(int porta) throws IOException{
        this.servidor = new ServerSocket(porta);
    }
    
    /**
     * Método que aguarda uma conexão com um cliente e aceita.
     * @return cliente
     * @throws java.io.IOException
     */
    public Socket aguardarConexao() throws IOException{
        cliente = servidor.accept();
        return cliente;
    }
    

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

}
