////////////////////////////////////////////////////////////////////
// [Igor] [Biolcati Rinaldi] [1170979]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    private itemType item;
    private String name;
    private double price;
    
    public MenuItem(itemType i,String n,double p) {
        this.item=i;
        this.name=n;
        this.price=p;
    }
    
    public itemType getType() {return item;}
    
    public String getName() {return name;}
    
    public double getPrice() {return price;}
}
