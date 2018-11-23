/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste1;

import java.util.ArrayList;

/**
 *
 * @author Joimar
 */
public class Protocolo 
{
    
    private ArrayList<String> mensagem;
    private String tipo;
    private String remetente;
    private String data;
    
    public Protocolo(String tipo, String remetente, String data)
    {
        this.tipo = tipo;
        this.remetente = remetente;
        this.data = data;
        
        mensagem.add(tipo); mensagem.add(remetente); mensagem.add(data);
    }
    
    
    
    public ArrayList<String> getMensagem()
    {
        return mensagem;
    }
    
    public String getTipo(){return tipo;}
    public String getRemetente(){return remetente;}
    public String getData(){return data;}
    
}
