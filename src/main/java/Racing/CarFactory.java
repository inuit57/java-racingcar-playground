package Racing;

public class CarFactory {
    public static final int NAME_LEN_LIMIT = 5;
    private Car car;

    private boolean isPossibleName(String carName){
        return (carName.length() <= NAME_LEN_LIMIT) ;
    }

    public Car createCar(String carName){
        if( isPossibleName(carName) ){
            return new Car(carName);
        }else{
            return null;
        }
    }
}
