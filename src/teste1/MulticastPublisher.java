package teste1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kelvin
 */
public class MulticastPublisher implements Runnable {
    
    private  DatagramSocket socket;
    private  InetAddress group;
    private static byte[] buf;
    
    
    public MulticastPublisher (String multicastMessage, String ipMulticast) throws UnknownHostException {
        group = InetAddress.getByName(ipMulticast);
        buf = multicastMessage.getBytes();
    }
    
    // public static void main(String[] args) throws IOException {
        
       // MulticastPublisher request = new MulticastPublisher("start", "230.0.0.0");
        //MulticastPublisher request = new MulticastPublisher("start", "192.168.1.3");
        //MulticastPublisher request = new MulticastPublisher("MC Hammer", "192.168.1.2");
       // MulticastPublisher request = new MulticastPublisher(buf, "192.168.1.2");
       // Thread nova = new Thread(request);
       // nova.start();
        
  //  }
 
    @Override
    public void run() {
        try {
            //System.out.println("Publisher");
            socket = new DatagramSocket();
            DatagramPacket packet  = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);
            socket.close();
        } catch (SocketException ex) {
            Logger.getLogger(MulticastPublisher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MulticastPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        
    }
    
}

