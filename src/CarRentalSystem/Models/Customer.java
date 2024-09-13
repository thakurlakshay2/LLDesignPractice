package CarRentalSystem.Models;

import java.util.Date;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private Date dob;  //save epoch values
    private final int licenceNo;
    private final int phoneNumber;

    public Customer(String id, int licenceNo, int phoneNumber, Date dob, String lastName, String firstName) {
        this.id=id;
        this.licenceNo = licenceNo;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getId() {
        return this.id;
    }
}
