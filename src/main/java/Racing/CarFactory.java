package Racing;

public class CarFactory {
    private Car car;

    private boolean isPossibleName(String carName){
        return (carName.length() <= 5) ;
    }

    public Car createCar(String carName){
        if( isPossibleName(carName) ){
            return new Car(carName);
        }else{
            return null;
        }
    }
}
