package pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author debor
 */
public class Servidor extends Thread{
    
    private BufferedReader oBuffer;
    
    public Servidor(Socket conexao) {
        try {
            this.oBuffer = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String sComando = this.oBuffer.readLine();
                System.out.println(sComando);
                FactoryComando factoryComando = new FactoryComando();
                factoryComando.criarComando(sComando);
            }        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
