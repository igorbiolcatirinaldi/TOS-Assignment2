package it.unipd.tos;


import org.junit.Test;
import it.unipd.tos.business.TakeAwayBillImpl;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.itemType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PaninotecaTest {
	
	@Test
	public void MenuItemGetItemTypeTest() {
		MenuItem mt= new MenuItem(itemType.Panino,"test",1);
		assertEquals(itemType.Panino,mt.getType());
	}
	
	@Test
	public void MenuItemGetNameTest() {
		MenuItem mt= new MenuItem(itemType.Panino,"test",1);
		assertEquals("test",mt.getName());		
	}
	
	@Test
	public void MenuItemGetPriceTest() {
		MenuItem mt= new MenuItem(itemType.Panino,"test",1);
		assertEquals(1,mt.getPrice(),0);
	}

	
	
	@Test
	public void GetOrderedPrice_SimpleSum_CalculatedTot() throws TakeAwayBillException{
		List<MenuItem> list= new ArrayList<MenuItem>();
		TakeAwayBillImpl orders= new TakeAwayBillImpl();
		list.add(new MenuItem(itemType.Panino,"Primavera",10.0));
		list.add(new MenuItem(itemType.Fritto,"Arancino",5.0));
		list.add(new MenuItem(itemType.Bevanda,"Acqua",1.0));
        assertEquals(16.0,orders.getOrderPrice(list),0);
        
	}
	
    @Test(expected= TakeAwayBillException.class)
    public void GetOrderedPrice_NegativePriceException_TakeAwayBillExceptionThrown() throws TakeAwayBillException  {
    	List<MenuItem> list= new ArrayList<MenuItem>();
    	TakeAwayBillImpl orders= new TakeAwayBillImpl();
    	list.add(new MenuItem(itemType.Bevanda,"negative",-1.0));
        orders.getOrderPrice(list);
    }
}
