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
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public void criarServidor(int porta) throws IOException{
        servidor = new ServerSocket(porta);
    }
    
    public Socket esperarConexao() throws IOException{
        Socket cliente = servidor.accept();
        return cliente;
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
