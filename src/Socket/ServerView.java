/*
 * Descrição da classe.
 */
package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ServerView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        Socket cliente = null;
        
        try {
            server.criarServidor(5022);
            cliente = server.aguardarConexao();
            System.out.println(" PASSOU AQUI");
        } catch (IOException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
            
            String msnCliente = input.readUTF();
            System.out.println("Passou msnCliente");
            System.out.println("Mensagem do CLIENTE: " + msnCliente);
            System.out.println("Passou print do msnCliente");
            output.writeUTF("Olá, cliente!");
            System.out.println("Mensagem foi enviada ao cliente.");
            
            input.close();
            output.close();
            server.getCliente().close();
        } catch (IOException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
    
}
