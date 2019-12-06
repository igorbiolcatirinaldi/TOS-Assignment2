////////////////////////////////////////////////////////////////////
// [Igor] [Biolcati Rinaldi] [1170979]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.itemType;

public class TakeAwayBillImpl implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double tot=0, mincostP=1000;
        int countP=0;
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
        }
        if(countP>5) {
            tot-=0.5*mincostP;
        }
        return tot;
    }
}
