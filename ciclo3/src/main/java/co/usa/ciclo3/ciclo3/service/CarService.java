package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Car;
import co.usa.ciclo3.ciclo3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car>getAll(){
        return carRepository.getAll();
    }

    public Optional<Car>getCar(int id){
        return carRepository.getCar(id);
    }

    public Car save(Car car){
        if(car.getIdCar()==null){
            return carRepository.save(car);
        }else{
            Optional<Car> Carauxiliar=carRepository.getCar(car.getIdCar());
            if(Carauxiliar.isEmpty()){
                return carRepository.save(car);
            }else{
                return car;
            }
        }
    }
}
