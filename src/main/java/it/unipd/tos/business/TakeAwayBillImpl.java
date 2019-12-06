////////////////////////////////////////////////////////////////////
// [Igor] [Biolcati Rinaldi] [1170979]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.itemType;

public class TakeAwayBillImpl implements TakeAwayBill {
    public static double sconto=0.9;

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double tot=0, mincostP=1000, countTotPF=0;
        int countP=0;
        if(itemsOrdered.size()>30) {throw new TakeAwayBillException();}
        for(MenuItem i: itemsOrdered) {
            if(i.getPrice()<=0 || i.getPrice()>=1000) {
                throw new TakeAwayBillException();
            }else {
                tot+=i.getPrice();
            }
            if(i.getType()==itemType.Panino) {
                countP++;
                if(i.getPrice()<=mincostP) {mincostP=i.getPrice();}
            }
            if(i.getType()==itemType.Panino || i.getType()==itemType.Fritto) {
                countTotPF+=i.getPrice();
            }
        }
        if(countP>5) {
            tot-=0.5*mincostP;
        }
        if(countTotPF>50) {
            tot*=sconto;
        }
        return tot;
    }
}
