package vttp.batch5.paf.day23.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day23.models.LineItem;
import vttp.batch5.paf.day23.models.PurchaseOrder;

import static vttp.batch5.paf.day23.repositories.Queries.*;

@Repository
public class LineItemRepository {

    @Autowired
    private JdbcTemplate template;

    public void create(PurchaseOrder po) {
        create(po.getPoId(), po.getLineItems());
    }

    public void create(String poId, List<LineItem> lis) {
        List<Object[]> params = lis.stream()
            .map(li -> {
                Object[] rec = new Object[4];
                rec[0] = li.getName();
                rec[1] = li.getQuantity();
                rec[2] = li.getUnitPrice();
                rec[3] = poId;
                return rec;
            }).toList();

        template.batchUpdate(SQL_CREATE_LINE_ITEM, params);
    }
}
