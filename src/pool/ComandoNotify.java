/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

/**
 *
 * @author debor
 */
public class ComandoNotify extends Comando {
    
    public ComandoNotify(String comando) {
        super(comando);
        if(this.valida()){
            this.executa();
        }
        else {
            System.out.println("Comando inválido");
        }
    }
    
    @Override
    public boolean valida() {
        boolean bValida = false;
        if(this.aParametro.length == 2){
            bValida = validaTexto(this.aParametro[1]);
            if(!bValida){
                System.out.println("O parametro informado não é um texto");
            }
        }
        else {
            System.out.println("O(s) parametros informados não é(são) valido(s).");
        }
        return bValida;
    }
    
    public void executa(){
        for (MinhaThread oThread : this.aThreads) {
            if (this.aParametro[1].equals(oThread.getName())) {
                synchronized (oThread) {
                    if (oThread.isAlive()) {
                        oThread.setWait(false);
                        oThread.notify();
                    }
                }
            }
        }
    }

}
