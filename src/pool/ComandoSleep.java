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
public class ComandoSleep extends Comando{
    
    public ComandoSleep(String comando) {
        super(comando);
        if(this.valida()){
            
        }
    }

    @Override
    public boolean valida() {
        boolean bValida = false;
        if(this.aParametro.length == 3){
            bValida = validaNumero(this.aParametro[1]);
            if(bValida){
                bValida = validaTexto(this.aParametro[2]);
                if(!bValida){
                    this.sValidacao += "O parametro (2) informado não é um texto.";
                }
            }
            else {
                this.sValidacao += "O parametro informado não é um número";
            }
        }
        else {
            this.sValidacao = "O(s) parametros informados não é(são) valido(s).";
        }
        return bValida;
    }
    
}
