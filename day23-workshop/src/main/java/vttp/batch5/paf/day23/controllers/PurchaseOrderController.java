package vttp.batch5.paf.day23.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.batch5.paf.day23.models.PurchaseOrder;
import vttp.batch5.paf.day23.services.PurchaseOrderService;

import static vttp.batch5.paf.day23.Utils.*;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchaseOrderController {

    private final Logger logger = Logger.getLogger(PurchaseOrderController.class.getName());

    @Autowired
    private PurchaseOrderService poSvc;

    @PutMapping(path="/purchaseorder", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> putPurchaseOrder(@RequestBody String payload) {

        try {
            PurchaseOrder po = toPurchaseOrder(payload);
            String poId = poSvc.create(po);
            JsonObject resp = Json.createObjectBuilder()
                .add("poId", poId)
                .build();
            // Return a 201 with the URL of where we can retrieve the purchase ordre
            // See below
            return ResponseEntity
                .created(URI.create("/api/purchaseorder/%s".formatted(poId)))
                .body(resp.toString());

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Adding new purchase order", ex);
            JsonObject resp = Json.createObjectBuilder()
                .add("message", ex.getMessage())
                .build();
            return ResponseEntity
                .status(HttpStatusCode.valueOf(500))
                .body(resp.toString());
        }
    }

    @GetMapping(path="/purchaserorder/{poId}")
    @ResponseBody
    public ResponseEntity<String> getPurchaseOrderById(@PathVariable String poId) {

        // TODO: Not implemented

        JsonObject result = Json.createObjectBuilder()
            .build();
        return ResponseEntity.ok(result.toString());

    }

}
