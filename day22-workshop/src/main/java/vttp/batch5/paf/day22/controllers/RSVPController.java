package vttp.batch5.paf.day22.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp.batch5.paf.day22.services.RSVPService;

@Controller
@RequestMapping("/api")
public class RSVPController {

    @Autowired
    private RSVPService rsvpSvc;

    @GetMapping("/rsvps")
    @ResponseBody
    public ResponseEntity<String> getRSVP() {
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        rsvpSvc.getRSVPs().stream()
            .map(r ->  Json.createObjectBuilder()
                    .add("email", r.getEmail())
                    .add("phone", r.getPhone())
                    .add("comments", r.getComments())
                    .add("confirmDate", df.format(r.getConfirmDate()))
                    .build()
            )
            .forEach(j -> arrBuilder.add(j));;
        return ResponseEntity.ok(arrBuilder.build().toString());
    }

}
