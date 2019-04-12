/*
 * Descrição da classe.
 */
package Socket;

import java.io.EOFException;
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
    public static void main(String[] args) throws IOException, ClassNotFoundException{
       Client cliente = new Client();
       
       ObjectInputStream input;
       ObjectOutputStream output;
       Object dados = "n";
       
        try {
            cliente.iniciarConexao("localhost", 5020);
            output = cliente.conexaoOutput(cliente.getCliente());
            input = cliente.conexaoInput(cliente.getCliente());
            output.flush();
            System.out.println("Recebendo dados!");
            
            while(true){
                try {
                    dados = input.readObject();
                    System.out.println(dados.toString());
                }
                catch (EOFException exc) {
                    break;
                }
            }
            
            
            /*System.out.println("Enviando mensagem...");
            String msn = "HELLO";
            output.writeUTF(msn);
            output.flush();
            
            System.out.println("Mensagem " + msn + " enviada.");
            
            msn = input.readUTF();
            System.out.println("Resposta: " + msn);*/

        } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            cliente.conexaoClose();
            cliente.fecharSocket(cliente.getCliente());
        }
    }
    
}
