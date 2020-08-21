/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarService;

import CarDao.CarDao;
import CarDto.Car;
import CarDto.CarKey;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class CarDealershipServiceFileImpl implements CarDealershipService {

    private CarDao dao;

    public CarDealershipServiceFileImpl(CarDao carDao) {
        this.dao = carDao;
    }

    @Override
    public Car getACar(String VIN) {
        Car gottenCar = dao.getCar(VIN);
        return gottenCar;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> carList = dao.getCars();
        return carList;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> carRightColorList = new ArrayList<>();
        List<Car> carList = this.getAllCars();
        for (Car viewedCar : carList) {
            String carColor = viewedCar.getColor();
            if (carColor.equals(color)) {
                carRightColorList.add(viewedCar);
            }
        }
        return carRightColorList;
    }

    @Override
    public List<Car> getCarsByPrice(BigDecimal maxPrice) {
        List<Car> wantedCarsBasedOnPrice = new ArrayList<>();
        List<Car> carList = this.getAllCars();
        for (Car viewedCar : carList) {
            BigDecimal carPrice = viewedCar.getPrice();
            int comparision = carPrice.compareTo(maxPrice);
            if (comparision < 1) {
                wantedCarsBasedOnPrice.add(viewedCar);
            }
        }
        return wantedCarsBasedOnPrice;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal discount) throws NoSuchCarException {
        BigDecimal discountMath = discount.subtract(new BigDecimal("100.00"));
        BigDecimal discountFactor = discountMath.divide(new BigDecimal("-100.00"), 2, RoundingMode.HALF_UP);
        Car gottenCar = this.getACar(VIN);
        validateCar(gottenCar);
        BigDecimal price = gottenCar.getPrice();
        BigDecimal discountedPrice = price.multiply(discountFactor);
        gottenCar.setPrice(discountedPrice);
        dao.editCar(VIN, gottenCar);
        return discountedPrice;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        Car carToSell = this.getACar(VIN);
        validateCar(carToSell);
        BigDecimal price = carToSell.getPrice();
        priceValidation(price, cashPaid);
        CarKey correspondingKey = carToSell.getKey();
        dao.removeCar(VIN);
        return correspondingKey;

    }

    private void validateCar(Car carToValidate) throws NoSuchCarException {
        if (carToValidate == null) {
            throw new NoSuchCarException("No such car with that VIN in our dealership");
        }
    }

    private void priceValidation(BigDecimal price, BigDecimal cashPaid) throws OverpaidPriceException, UnderpaidPriceException {
        int comparision = price.compareTo(cashPaid);
        if (comparision < 0) {
            throw new OverpaidPriceException("You have gave too much money for this car");
        }
        if (comparision > 0) {
            throw new UnderpaidPriceException("The car costs more than the money you have tried paid for it");
        }
    }

}
