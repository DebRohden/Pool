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
public class ComandoNew extends Comando{
    
    public ComandoNew(String comando) {
        super(comando);
        if(this.valida()){
            MinhaThread thread = new MinhaThread(super.sNome);
            this.aThreads.add(thread);
            thread.start();
        }
        else {
            System.out.println("Comando inválido.");
        }
    }
    
    @Override
    public boolean valida() {
        boolean bValida = false;
        if(this.aParametro.length == 3){
            bValida = validaNumero(this.aParametro[1]);
            if(bValida){
                bValida = validaTexto(this.aParametro[2]);
                if(bValida){
                    super.sNome = this.aParametro[2];
                }
                
                if(!bValida){
                    System.out.println("O parametro (3,4) informado não é um texto.");
                }
            }
            else {
                System.out.println("O parametro (2) informado não é um número.");
            }
        }
        else {
           System.out.println("O(s) parametros informados não é(são) valido(s).");
        }
        return bValida;
    }
    
}
