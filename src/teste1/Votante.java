/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste1;

/**
 *
 * @author Joimar
 */
public class Votante 
{
    private String id;
    private int bateria;
    
    public Votante(String id, String bateria)
    {
    
        this.id = id;
        this.bateria = Integer.parseInt(bateria);
    }
    
    public void setID(String id)
    {
        this.id = id;
    }
    public String getID()
    {
        return id;
    }
    
    public void setBateria(int bateria)
    {
        this.bateria = bateria;
    }
    
    public int getBateria()
    {
        return bateria;
    }
}
