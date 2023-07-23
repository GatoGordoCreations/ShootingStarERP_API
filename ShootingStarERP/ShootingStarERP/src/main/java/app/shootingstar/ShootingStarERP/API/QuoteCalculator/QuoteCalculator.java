package app.shootingstar.ShootingStarERP.API.QuoteCalculator;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name="QUOTE_CALCULATOR")
@Setter
@Getter
public class QuoteCalculator {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "QuoteCalculator_Sequence")
    @SequenceGenerator(name = "QuoteCalculator_Sequence", schema = "dbo", sequenceName = "seq_quote_calc", allocationSize = 1)
    private int id;

    @Column(name="f_name")
    private String f_name;

    @Column(name="l_name")
    private String l_name;

    @Column(name="phone1")
    private String phone1;

    @Column(name="phone2")
    private String phone2;

    @Column(name="phone3")
    private String phone3;

    @Column(name="email")
    private String email;

    @Column(name="venue_name")
    private String venue_name;

    @Column(name="venue_city")
    private String venue_city;

    @Column(name="venue_state")
    private String venue_state;

    @Column(name="num_of_guests")
    private int num_of_guests;

    @Column(name="num_of_photographers")
    private int num_of_photographers;

    @Column(name="num_of_videographers")
    private int num_of_videographers;

    @Column(name="created")
    private Date created;

    @Column(name="active")
    private Boolean active;


    public QuoteCalculator () {
        this.active = true;
        this.created = Calendar.getInstance().getTime();
    }

    @Override
    public String toString () {
        String returnValues = "CONGRADULATIONS! \nYou have a new Inquiry: \n\n\n"+
                "Name: " + f_name + " " + l_name + "\n" +
                "Phone Number: " + "(" + phone1 + ") " + phone2 + "-" + phone3 + "\n" +
                "Email: " + email + "\n" +
                "\n" +
                "Venue Information: " + "\n" +
                venue_name + "\n" +
                venue_city + ", " + venue_state + "\n" +
                "\n" +
                "Event Information: " + "\n" +
                "Guest count: " + num_of_guests + "\n" +
                "\n" +
                "Package Information: " + "\n" +
                "Photographers: " + num_of_photographers + "\n" +
                "Videographers: " + num_of_videographers + "\n" +
                "\n" +
                "Created: " + created;

        return returnValues;


    }

}
