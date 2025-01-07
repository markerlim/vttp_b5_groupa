package vttp.batch5.paf.day22.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.day22.models.RSVP;
import vttp.batch5.paf.day22.repositories.RSVPRepository;

@Service
public class RSVPService {

    @Autowired
    private RSVPRepository rsvpRepo;

    public List<RSVP> getRSVPs() {
        return rsvpRepo.getRSVPs();
    }
}
