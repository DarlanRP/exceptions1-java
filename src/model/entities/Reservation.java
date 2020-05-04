
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    
    private Integer roomNumver;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(){
        
    }
    
    public Reservation(Integer roomNumver, Date checkin, Date checkout) {
        this.roomNumver = roomNumver;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumver() {
        return roomNumver;
    }

    public void setRoomNumver(Integer roomNumver) {
        this.roomNumver = roomNumver;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public String updateDates(Date checkin, Date checkout){
        Date now = new Date();
            if(checkin.before(now) || checkout.before(now) ){
                return "Reservation dates for update must be future dates"; 
            }
            if(!checkout.after(checkin)){
                return "Check-out date must be after check-in date";
            }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }
    @Override
    public String toString(){
        return "Rom "
                + roomNumver
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                +", "
                + duration()
                + " nights";
    }
}
