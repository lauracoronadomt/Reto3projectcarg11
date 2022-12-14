package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Car;
import co.usa.ciclo3.ciclo3.repository.crud.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<Car>getAll(){
       return (List<Car>) carCrudRepository.findAll();
    }
    public Optional<Car>getCar(int id){
        return carCrudRepository.findById(id);
    }

    public Car save(Car car){
        return carCrudRepository.save(car);
    }
}
