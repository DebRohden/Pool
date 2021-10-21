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
public class FactoryComando implements IFactoryComando {

    public Comando criarComando(String comando) {
        String[] aParametro = comando.split(" ");
        if(aParametro[0].equals("notify")){
            return new ComandoNotify(comando);
        }
        else if(aParametro[0].equals("wait")){
            return new ComandoWait(comando);
        }
        else if(aParametro[0].equals("sleep")){
            return new ComandoSleep(comando);
        }
        else if(aParametro[0].equals("new")){
            return new ComandoNew(comando);
        }
        return new ComandoNew(comando);
    }
}
