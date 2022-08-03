import Racing.Car;
import Racing.CarFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    public void 자동차_생성하기(){
        //given
        String longName = "longNameCar";
        String shortName = "car12";
        CarFactory carFactory = new CarFactory();

        //when
        Car longNameCar = carFactory.createCar(longName);
        Car shortNameCar = carFactory.createCar(shortName);

        //then
        assertThat(longNameCar).isNull();
        assertThat(shortNameCar).isNotNull();
    }
}
