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
public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    public Part(int id2, String name2, double price2, int stock2, int min2, int max2)
    {   super();
        this.id = id2;
        this.name = name2;
        this.price = price2;
        this.stock = stock2;
        this.min = min2;
        this.max = max2;
    
    }
   public void setId(int id3){id = id3;}
   public void setName(String name3){name = name3;}
   public void setPrice(double price3){price = price3;}
   public void setStock(int stock3){stock = stock3;}
   public void setMin(int min3){min = min3;}
   public void setMax(int max3){max = max3;}
   public int getId(){return id;}
   public String getName(){return name;}
   public double getPrice(){return price;}
   public int getStock(){return stock;}
   public int getMin(){return min;}
   public int getMax(){return max;}
 
}
