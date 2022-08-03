package Racing;

public class CarFactory {
    private Car car;

    private boolean isPossibleName(String carName){
        return (carName.length() <= Car.NAME_LEN_LIMIT) ;
    }

    public Car createCar(String carName){
        if( isPossibleName(carName) ){
            return new Car(carName);
        }
        return null;
    }
}
