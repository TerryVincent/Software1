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
public class OutSourced extends Part 
{
    private String CompanyName;
    public OutSourced(int id, String name, double price, int stock, int max,int min,String CompanyName1)
    {
     super(id,name,price,stock,max,min);
     CompanyName = CompanyName1;
    }    
    public void setCompanyName(String companyName1){CompanyName = companyName1;}
    public String getCompanyName(){return CompanyName;}
}
