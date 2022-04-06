/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Vishnu
 */
public class inHouse extends Part 
{
    private int machineId;
    public inHouse(int id, String name, double price, int stock, int max,int min,int machineId1)
    {
     super(id,name,price,stock,max,min);
     machineId = machineId1;
    }
   public void setMachineid(int machineId1){machineId = machineId1;}
   public int getMachineid(){return machineId;}
    
}
