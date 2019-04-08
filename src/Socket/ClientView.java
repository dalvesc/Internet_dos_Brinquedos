/*
 * Descrição da classe.
 */
package Socket;

import Socket.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ClientView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client cliente = new Client();
        
        try {
            cliente.criarCliente("localhost", 5022);
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ObjectOutputStream output = cliente.conexaoOutput();
            output.writeUTF("Olá, servidor!");
            System.out.println("Mensagem foi enviada ao servidor.");
            String msnServidor = cliente.conexaoInput().readUTF();
            System.out.println("Passou do msnServidor");
            System.out.println("Mensagem do CLIENTE: " + msnServidor);
            System.out.println("Passou do print msnServidor");
            
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cliente.getInput().close();
            cliente.getOutput().close();
            cliente.getCliente().close();
        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
}
