/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste1;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joimar
 */
public class No 
{    
    private int id;
    private int bateria;
    private String ipgrupo;
    private String mensagem;
    private ArrayList<String> listaBateria = new ArrayList<String>();
    
   // private MulticastPublisher publicante;
    //Thread nova;
    
  //  private MulticastReceiver recebedor;
    //private static Thread recebe;
    
    public No() throws UnknownHostException 
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerMsg = new Scanner(System.in);
        
       
        
        System.out.print("Insira o ID: \n");
        this.id = scanner.nextInt();
        
        
        System.out.print("Insira Bateria: \n");
        this.bateria = scanner.nextInt();
        
        
       // System.out.println("Insira Mensagem: \n");
       // this.mensagem = scannerMsg.nextLine();
        
        
        System.out.print("Insira IP do grupo: \n");
        this.ipgrupo = scanner.next();
                
       executa();
        
       
    }
    
    public void executa() throws UnknownHostException
    {
        MulticastReceiver recebedor = new MulticastReceiver (ipgrupo);
        
       //mensagem = +id+" 1 "+mensagem;
        mensagem = +id+" 1 "+bateria;
        MulticastPublisher publicante = new MulticastPublisher(mensagem, ipgrupo);
       
        Thread pub = new Thread(publicante);
        Thread rece = new Thread(recebedor);
        
        rece.start();
        
        pub.start();
        
    }
    
    public void eleicao(MulticastReceiver recebedor)
    {
        
        while(true)
        {
            String id = new String();
            String bateria = new String();
            id = recebedorID(recebedor);
            int intID = Integer.parseInt(id);
            
            bateria = recebedorBateria(recebedor);
            
            this.addListaBateria(intID, bateria);
            
            
        }
        
    }
    
    public String recebedorID(MulticastReceiver recebedor)
    {
    
        String msg = recebedor.getMensagem();
        
        String[] split = msg.split(" ");
        return split[0];
    }
    
    public String recebedorBateria(MulticastReceiver recebedor)
    {
        String msg = recebedor.getMensagem();
        String saida = new String();
        int espacos = 0;
        
            
            
        String[] split = msg.split(" ");
            
        return split[3];
        
    }
    

    public static void main(String args[]) throws IOException
    {
        
        
       new No();
             
          
    }
    
    public void exibe(){System.out.println("Valor: "+id+" "+bateria+" "+mensagem);}
    
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setBateria(int bateria){this.bateria = bateria;}
    public int getBateria(){return bateria;}
    
    public void setMensagem(String mensagem){this.mensagem = mensagem;}
    public String getMensagem(){return mensagem;}
    
    public String getGrupo()
    {
        return ipgrupo;
    }
    
    public void setGrupo(String ipgrupo)
    {
        this.ipgrupo = ipgrupo;
    }
    
    public void addListaBateria(int id, String ip)
    {
        listaBateria.add(id,ip);
    }
    
    
}
