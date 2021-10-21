/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author debor
 */
public class ComandoNew extends Comando implements Runnable{
    
    public ComandoNew(String comando) {
        super(comando);
        if(this.valida()){
            Thread oThread = new Thread(this);
            oThread.setName(super.sNome);
            oThread.start();
            this.aThreads.add(oThread);
        }
    }
    
    @Override
    public boolean valida() {
        boolean bValida = false;
        if(this.aParametro.length == 4){
            bValida = validaNumero(this.aParametro[1]);
            if(bValida){
                bValida = validaTexto(this.aParametro[2]);
                if(bValida){
                    bValida = validaTexto(this.aParametro[3]);
                    super.sNome = this.aParametro[2];
                }
                
                if(!bValida){
                    this.sValidacao += "O parametro (3,4) informado não é um texto.";
                }
            }
            else {
                this.sValidacao += "O parametro (2) informado não é um número.";
            }
        }
        else {
           this.sValidacao += "O(s) parametros informados não é(são) valido(s).";
        }
        return bValida;
    }

    @Override
    public void run() {
        try {
            for(int i=0; i< Integer.parseInt(this.aParametro[1]); i++){
                int valor = new Random().nextInt(10);
                int fibo = fibonnacci(valor);
                System.out.println("Fibo de "+ valor + " = " + fibo);
            }
        } catch (IOException ex) {
            Logger.getLogger(ComandoNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int fibonnacci(int numero) throws IOException{
        if(numero < 2){
            return numero;
        }
        else {           
            return fibonnacci(numero - 1) + fibonnacci(numero - 2 );
        }
    }
    
}
