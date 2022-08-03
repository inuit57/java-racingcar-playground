import Racing.Car;
import Racing.CarFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private final CarFactory carFactory = new CarFactory();

    @Test
    @DisplayName("차량생성 테스트")
    public void createCarTest(){

        //given
        String longName = "longNameCar";
        String shortName = "car12";

        //when
        Car longNameCar = carFactory.createCar(longName);
        Car shortNameCar = carFactory.createCar(shortName);

        //then
        assertThat(longNameCar).isNull();
        assertThat(shortNameCar).isNotNull();
    }
    
    @Test
    @DisplayName("차량정보 출력 테스트")
    public void carInfoPrintTest() {
        //given
        Car car = carFactory.createCar("test");

        //when
        System.out.println(car);

        //car.setMove(3);
        car.updateMove(4);
        car.updateMove(4);

        System.out.println(car);
    }

    @Test
    @DisplayName("이동 테스트")
    public void moveTest(){
        //given
        Car mover = carFactory.createCar("mover");

        //when
//        assertThat(mover.isMove(4)).isTrue();
//        assertThat(mover.isMove(3)).isFalse();

        int expectMove = 2;
        assertThat(mover.updateMove(4)).isEqualTo(expectMove);
        assertThat(mover.updateMove(3)).isEqualTo(expectMove);
    }

    @Test
    public void generateRandomTest() {
        //given
        int bound = 9 ;
        for(int i =0 ; i< 1000; i++) {
            int n = new Random().nextInt(bound)+1;
            assertThat(n).isLessThan(bound+1);
        }

    }
}
