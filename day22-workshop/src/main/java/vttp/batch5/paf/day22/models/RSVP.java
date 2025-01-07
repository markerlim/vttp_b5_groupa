package vttp.batch5.paf.day22.models;

import java.util.Date;

public class RSVP {
    private String rsvpId;
    private String email;
    private String phone;
    private Date confirmDate;
    private String comments;

    public void setRSVPId(String rsvpId) { this.rsvpId = rsvpId; }
    public String getRSVPId() { return this.rsvpId; }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return this.email; }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return this.phone; }

    public void setConfirmDate(Date confirmDate) { this.confirmDate = confirmDate; }
    public Date getConfirmDate() { return this.confirmDate; }

    public void setComments(String comments) { this.comments = comments; }
    public String getComments() { return this.comments; }

    @Override
    public String toString() {
        return "RSVP{rsvpId=%s, email=%s}".formatted(rsvpId, email);
    }
}
