package CarRentalSystem.Controllers;

import CarRentalSystem.Database.CustomerRepository;
import CarRentalSystem.Exceptions.CustomerAlreadyExistsException;
import CarRentalSystem.Exceptions.CustomerNotFoundException;
import CarRentalSystem.Models.Booking;
import CarRentalSystem.Models.Customer;
import CarRentalSystem.Models.Rental;

import java.util.List;

public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController() {
        this.customerRepository=new CustomerRepository();

    }

    public Customer getCustomerById(String customerId) throws  CustomerNotFoundException{
        Customer customer = customerRepository.getCustomerById(customerId);
        if(customer==null){
            throw new CustomerNotFoundException();
        }
        return  customer;
    }

    public void addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        Customer findCustomer = customerRepository.getCustomerById(customer.getId());
        if(findCustomer==null){
            customerRepository.save(customer);
            //can be converted to enum and a seperate print clas
            System.out.println(customer.getId()+" :: Added Customer");
        }else{
            throw new CustomerAlreadyExistsException();
        }

    }

        public void addBooking( Booking booking){
                Customer customer =getCustomerById(booking.getCustomerId());
                customerRepository.addBooking(customer,booking);
        }
    public void removeCustomer(Customer customer) throws  CustomerNotFoundException{
        if(customerRepository.getCustomerById(customer.getId())!=null){
            throw  new CustomerNotFoundException();
        }
        customerRepository.remove(customer);
    }

    public List<Booking> getBookingHistory(Customer customer){
        return customerRepository.getCustomerBookingList(customer);
    }
    public void updateCustomerRental(Customer customer, Rental rental){

    }




}
