package CarRentalSystem.Controllers;

import CarRentalSystem.Database.CarRepository;
import CarRentalSystem.Exceptions.CarAlreayExistsException;
import CarRentalSystem.Exceptions.CarNotFoundException;
import CarRentalSystem.Models.Booking;
import CarRentalSystem.Models.Car;

import java.util.Date;
import java.util.List;

public class CarController {
    private CarRepository carRepository;

    public CarController() {
        this.carRepository = new CarRepository();
    }

    public Car getCarrById(String carId) throws  CarNotFoundException{
        Car car= carRepository.getCarById(carId);
        if(car == null){

            throw  new CarNotFoundException();
        }
        return  car;
    }

    public void addCar(Car car) throws CarAlreayExistsException{
        Car duplicateCar= carRepository.getCarById(car.getId());
        if(duplicateCar == null){
            carRepository.save(car);
            System.out.println(car.getId()+ " :: Added Car");
        }else{
            throw new CarAlreayExistsException();
        }

    }

    public void removeCar(Car car) throws  CarNotFoundException{
        if(carRepository.getCarById(car.getId()  ) !=null){
                carRepository.remove(car);
        }else{
            throw new CarNotFoundException();
        }
    }


    public boolean isCarAvailable(Car car, Date startDate, Date endDate){
        List<Booking> booking= carRepository.getcarBookingList(car);

        return !checkOverlap(startDate,endDate,booking);
    }

    public void addBooking(Booking booking){
        Car car=carRepository.getCarById(booking.getCarId());
        carRepository.addCarBooking(car,booking);

    }

    public List<Booking> getBookingHistory(Car car){
        return carRepository.getcarBookingList(car);
    }




    private static boolean overlaps(Date startOne, Date endOne, Date startTwo, Date endTwo) {

        return !endOne.before(startTwo) && !endTwo.before(startOne);
    }
    private  static boolean checkOverlap( Date startDate, Date endDate,  List<Booking> bookingList) {


        if (bookingList == null || bookingList.isEmpty()) {
            return false; // No date ranges for this id
        }

        // Iterate from the end of the list to the beginning
        for (int i = bookingList.size() - 1; i >= 0; i--) {


            Booking booking=bookingList.get(i);

            boolean isOverlap=overlaps(startDate,endDate,booking.getStartDate(),booking.getEndDate());

            if (isOverlap) {
                return true; // Overlap found
            }
        }

        return false; // No overlap found
    }
}
