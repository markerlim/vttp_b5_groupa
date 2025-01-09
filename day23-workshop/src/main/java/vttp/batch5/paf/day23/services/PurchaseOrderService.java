package vttp.batch5.paf.day23.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day23.repositories.LineItemRepository;
import vttp.batch5.paf.day23.repositories.PurchaseOrderRepository;
import vttp.batch5.paf.day23.models.PurchaseOrder;

@Service
public class PurchaseOrderService {

    @Autowired
    private LineItemRepository lineItemRepo;

    @Autowired
    private PurchaseOrderRepository poRepo;

    public String create(PurchaseOrder po) {
        final String poId = UUID.randomUUID().toString().substring(0, 8);
        poRepo.create(poId, po);
        lineItemRepo.create(poId, po.getLineItems());
        return poId;
    }

}
