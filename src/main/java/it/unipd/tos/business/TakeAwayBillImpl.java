////////////////////////////////////////////////////////////////////
// [Igor] [Biolcati Rinaldi] [1170979]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImpl implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double tot=0;
        for(MenuItem i: itemsOrdered) {
            if(i.getPrice()<=0 || i.getPrice()>=1000) {
                throw new TakeAwayBillException();
            }else {
                tot+=i.getPrice();
            }
        }
        return tot;
    }
}
