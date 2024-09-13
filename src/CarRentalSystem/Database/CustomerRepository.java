package CarRentalSystem.Database;


import CarRentalSystem.Models.Booking;
import CarRentalSystem.Models.Customer;
import CarRentalSystem.Models.Rental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private final Map<String, Customer> customerDB = new HashMap<>();
    private final Map<String, List<Rental>> customerRentalDb=new HashMap<>();
    private final Map<String, List<Booking>> customerBookinglDb=new HashMap<>();

    
    public void save(Customer customer) {
        customerDB.put(customer.getId(), customer);
        customerRentalDb.put(customer.getId(),new ArrayList<>());
        customerBookinglDb.put(customer.getId(),new ArrayList<>());
    }

    public Customer getCustomerById(String id) {
        return customerDB.get(id);
    }

    public void remove(Customer customer){
         customerDB.remove(customer.getId());
         customerRentalDb.remove(customer.getId());
    }
    public void addRental(Customer customer, Rental rental){
       customerRentalDb.get(customer.getId()).add(rental);

    }
    public void addBooking(Customer customer, Booking booking){
         customerBookinglDb.get(customer.getId()).add(booking);

    }

    public List<Booking> getCustomerBookingList(Customer customer){
        return customerBookinglDb.get(customer.getId());
    }

}
