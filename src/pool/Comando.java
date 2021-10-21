package pool;

import java.util.ArrayList;


/**
 *
 * @author debor
 */
public abstract class Comando{

    protected String sComando = "";
    protected String[] aParametro;  
    protected String sValidacao = "";
    protected static ArrayList<Thread> aThreads = new ArrayList();
    protected String sNome = "";
    
    public Comando(String comando) {
        this.sComando = comando;
        this.separaParametro();
    }
    
    private void separaParametro(){
        this.aParametro = this.sComando.split(" ");
    }
    
    protected boolean inArray(String sCom, ArrayList<String> aArray){
        for (String aArray1 : aArray) {
            if (aArray1.equals(sCom)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean validaNumero(String sNumero){
        return sNumero.matches("[0-9]*");
    }
    
    protected boolean validaTexto(String texto){
        if(texto.matches("[a-z]*")){
            return true;
        }
        return false;
    }

    public String getValidacao() {
        return this.sValidacao;
    }
    
    public abstract boolean valida();
}
