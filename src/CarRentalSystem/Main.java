package CarRentalSystem;

import CarRentalSystem.Controllers.BookingController;
import CarRentalSystem.Controllers.CarController;
import CarRentalSystem.Controllers.CustomerController;
import CarRentalSystem.Controllers.RentalController;
import CarRentalSystem.Models.Booking;
import CarRentalSystem.Models.Car;
import CarRentalSystem.Models.Customer;

import java.util.Date;
import java.util.UUID;

public class Main {
    public static String idGenerator(){
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(15);
    }

    public static void main(String[] args) {

        CustomerController customerController=new CustomerController();

        Customer customer1=new Customer(idGenerator(),1,111,new Date(),"thakur","lakshay");
        customerController.addCustomer(customer1);
//        customerController.addCustomer(customer1);  //TEST CASE 1: ADDING SAME CUSTOMER AGAIN


        Customer customer2=new Customer(idGenerator(),2,222,new Date(),"thakur","lakshay");
        customerController.addCustomer(customer2);

        Customer customer3=new Customer(idGenerator(),3,333,new Date(),"thakur","lakshay");
        customerController.addCustomer(customer3);

        CarController carController=new CarController();

        Car car1=new Car(idGenerator(),"tata","nexon","green",2024,121,4,0,"petrol");
        carController.addCar(car1);
//        carController.addCar(car1);  //TEST CASE 2: ADDING SAME CAR AGAIN

        Car car2=new Car(idGenerator(),"maruti","breeza","grey",2024,122,4,0,"petrol");
        carController.addCar(car2);

        BookingController bookingController=new BookingController(carController,customerController);

        Booking b1=new Booking(idGenerator(),car1.getId(),customer1.getId(),new Date(2024,9,12), new Date(2024,9,13));
        bookingController.createBooking(b1);
//        bookingController.createBooking(b1);   //        TEST CASE 3: ADDING SAME BOOKING AGAIN

        //Test CASE 4: OTHER BOOKING OVERLAPPING FOR THE SAME CAR
//        Booking b2=new Booking(idGenerator(),car1.getId(),customer2.getId(),new Date(2024,9,12), new Date(2024,9,13));
//        bookingController.createBooking(b2);

        Booking b3=new Booking(idGenerator(),car2.getId(),customer2.getId(),new Date(2024,9,12), new Date(2024,9,13));
        bookingController.createBooking(b3);

        Booking b4=new Booking(idGenerator(),car1.getId(),customer2.getId(),new Date(2024,9,14), new Date(2024,9,15));
        bookingController.createBooking(b4);

        //TEST CASE 5: IN CASE WE WANT HISTORY OF THE CAR
        //GETTING HISTORY FOR CAR 1
        System.out.println(car1.getId()+": Car History : "+ carController.getBookingHistory(car1));


        //TEST CASE 6 : IN CASE WE WANT BOOKING HISTORY OF THE CUSTOMER
        System.out.println(customer1.getId()+" : Customer History : "+ customerController.getBookingHistory(customer1));


        //THIS IS LOGIC FOR PICK UP (TBD , when picked up )  (we can easily merge this into booking);
        RentalController rentalController=new RentalController();
    }
}
