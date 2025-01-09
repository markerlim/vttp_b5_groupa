package vttp.batch5.paf.day23.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day23.models.PurchaseOrder;

import static vttp.batch5.paf.day23.repositories.Queries.*;

@Repository
public class PurchaseOrderRepository {

    @Autowired
    private JdbcTemplate template;

    public void create(String poId, PurchaseOrder po) {
        template.update(SQL_CREATE_PURCHASE_ORDER
            , poId, po.getName(), po.getAddress(), po.getDeliveryDate());
    }

}
