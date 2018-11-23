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
    private String data;
    private  int id;
    private int bateria;
    private String ipgrupo;
    private String mensagem;
    private ArrayList<String> listaIP = new ArrayList<String>();
    
    private static MulticastPublisher publicante;
    //Thread nova;
    
    private static MulticastReceiver recebedor;
    //private static Thread recebe;
    
    public No()
    {
        
        
       
    }
    
    public void montaMensagem(String mensagem, String tipoMensagem)
    {
        
    }
    
    public void  Transmite(String mensagem, String tipoMensagem) throws UnknownHostException
    {
       mensagem = tipoMensagem+mensagem;
       MulticastPublisher publicante = new MulticastPublisher(mensagem, ipgrupo);
     //  nova = new Thread(publicante);
     //  nova.start();
    }
    
    public void Recebe(String ipgrupo)throws UnknownHostException
    {
    
        MulticastReceiver recebedor = new MulticastReceiver (ipgrupo);
     //   recebe = new Thread(recebedor);
     //   recebe.start();
        
    }
    
    
    
    public static void main(String args[]) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerMsg = new Scanner(System.in);
        No a = new No();
        a.getBateria();
        
        System.out.print("Insira o ID: \n");
        int inputID = scanner.nextInt();
        a.setID(inputID);
        
        System.out.print("Insira Bateria: \n");
        int inputBateria = scanner.nextInt();
        a.setBateria(inputBateria);
        
        System.out.println("Insira Mensagem: \n");
        String inputMensagem = scannerMsg.nextLine();
        a.setMensagem(inputMensagem);
        
        System.out.print("Insira IP do grupo: \n");
        String inputIPgrupo = scanner.next();
        a.setGrupo(inputIPgrupo);
        
        a.exibe();
        
        a.Transmite(a.getMensagem(), "1");
        a.Recebe(inputIPgrupo);
        
        Thread pub = new Thread(publicante);
        Thread rece = new Thread(recebedor);
        
        pub.start();
         rece.start();
       
             
          
    }
    
    public void exibe(){System.out.println("Valor: "+id+" "+bateria+" "+mensagem);}
    
    public void setData(String data)
    {
        this.data = data;
    }
    
    public String getData()
    {
        return data;
    }
    
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
    
    public void addListaIP(String ip)
    {
        listaIP.add(ip);
    }
    
    
}
