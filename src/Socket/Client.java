/*
 * Descrição da classe.
 */
package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class Client {

    Socket cliente;
    private ObjectOutputStream output;
    private ObjectInputStream input;
        
    public void iniciarConexao(String ip, int porta) throws IOException{
        cliente = new Socket(ip, porta);
    }
    
    public ObjectOutputStream conexaoOutput(Socket cliente) throws IOException{
        this.output = new ObjectOutputStream(cliente.getOutputStream());
        return output;
    }
    
    public ObjectInputStream conexaoInput(Socket cliente) throws IOException{
        this.input = new ObjectInputStream(cliente.getInputStream());
        return input;
    }
    
    public void conexaoClose() throws IOException{
        output.close();
        input.close();
    }
    
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
