package CarRentalSystem.Controllers;

import CarRentalSystem.Database.RentalRepository;
import CarRentalSystem.Exceptions.CustomerNotFoundException;
import CarRentalSystem.Models.Customer;
import CarRentalSystem.Models.Rental;

import java.util.Objects;

public class RentalController {
    public RentalRepository rentalRepository;
    public CustomerController customerController;
    public RentalController() {
        this.rentalRepository = new RentalRepository();
    }

    public void addRental(Rental rental, Customer customer){
        Customer customerId=customerController.getCustomerById(customer.getId());
        if(Objects.equals(customerId.getId(), customer.getId())) {
            rentalRepository.save(rental);
            customerController.updateCustomerRental(customer, rental);
        }
    }
    public Rental getRentalByRentalId(String rentalId){
        Rental rental = rentalRepository.getRentalById(rentalId);
        if(rental==null){
            throw new CustomerNotFoundException();
        }
        return  rental;
    }




}
