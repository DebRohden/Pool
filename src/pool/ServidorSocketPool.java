package pool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author debor
 */
public class ServidorSocketPool {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket oServidor = null;

        try {
            oServidor = new ServerSocket(3322);

            while (true) {
                Socket oConexao          = oServidor.accept();
                Servidor oThreadServidor = new Servidor(oConexao);
                oThreadServidor.start();
            }
        } catch (IOException ex) {
            System.out.println("Algo errado aconteceu.");
        } finally {
            oServidor.close();
        }
    }
}