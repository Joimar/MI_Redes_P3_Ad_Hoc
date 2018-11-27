/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kelvin
 */
public class MulticastReceiver implements Runnable {
    
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    protected String ipGroup;       
    
    private String mensagem;
    
    public MulticastReceiver(String ipGroup) {
        this.ipGroup = ipGroup;
       
    }
    
    public String getMensagem()
    {
        return mensagem;
    }
    
    
    @Override
    public void run() {
        try {
            socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName(this.ipGroup);
            socket.joinGroup(group);
            System.out.println("Esperando mensagem do grupo ...");
            
            while(true)
            {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(
                packet.getData(), 0, packet.getLength());
                System.out.println(received);
                
                mensagem = received;
                TimeUnit.SECONDS.sleep(3);
               // System.out.println("Loop Receiver");
            }
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(MulticastReceiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MulticastReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
    
}
