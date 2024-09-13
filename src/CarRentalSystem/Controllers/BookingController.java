package CarRentalSystem.Controllers;

import CarRentalSystem.Database.BookingRepository;
import CarRentalSystem.Exceptions.BookingException;
import CarRentalSystem.Exceptions.CarNotFoundException;
import CarRentalSystem.Exceptions.DuplicateBooking;
import CarRentalSystem.Exceptions.SlotNotAvailableException;
import CarRentalSystem.Models.Booking;
import CarRentalSystem.Models.Car;

public class BookingController {
    public BookingRepository bookingRepository;
    private CarController carController ;
    private CustomerController customerController;

    public BookingController(CarController carController, CustomerController customerController) {
        this.bookingRepository = new BookingRepository();
        this.carController=carController;
        this.customerController=customerController;
    }

    public synchronized   void  createBooking(Booking booking) throws DuplicateBooking, CarNotFoundException, SlotNotAvailableException {
        Booking duplicateBooking = bookingRepository.getBookingById(booking.getId());
        if (duplicateBooking == null) {
            Car car= carController.getCarrById(booking.getCarId());

            //Check if no overlap
            boolean isAvailable = carController.isCarAvailable(car,booking.getStartDate(),booking.getEndDate());
            if(isAvailable) {
//payment check

                bookingRepository.save(booking);
                carController.addBooking(booking);
                customerController.addBooking(booking);
                System.out.println("Booking for:  "+booking.getCarId()+ " Is complete for Customer: "+ booking.getCustomerId());
//                carController.setCarAvailability(booking.getCarId(), false);
            }else{
                throw new SlotNotAvailableException();
            }

        }else{
            throw new DuplicateBooking();
        }
    }

    public Booking getBookingById(String bookingId) throws  BookingException{
        Booking booking = bookingRepository.getBookingById(bookingId);
        if (booking == null) {
            throw new BookingException();
        }
        return booking;
    }

    public void removeBooking(Booking booking) throws  BookingException{
        if(bookingRepository.getBookingById(booking.getId()  ) !=null){
            bookingRepository.remove(booking);
        }else{
            throw new BookingException();
        }
    }
}
