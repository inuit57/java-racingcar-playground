import Racing.Car;
import Racing.CarFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final CarFactory carFactory = new CarFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputNameText = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        System.out.println(inputNameText);
        String carNames = sc.nextLine();
        ArrayList<Car> carList = new ArrayList<>();
        for(String name : carNames.split(",")){
            carList.add(carFactory.createCar(name));
        }

        String inputTryNumberText = "시도할 회수는 몇회인가요?";
        System.out.println(inputTryNumberText);
        int tryNumber = sc.nextInt();


        System.out.println("실행결과");
        StringBuilder sb = new StringBuilder();
        printFirstState(carList, sb);

        int winMove = 0;
        for(int i=0 ; i< tryNumber; i++){
            winMove = printCarList(carList, sb);
            sb.append("\n");
        }

        System.out.println(sb);

//        String winners = "";
        StringBuilder winner = new StringBuilder();
        for(Car car : carList){
            if(car.isWinner(winMove)){
                if( !winner.toString().isEmpty()){
//                    winners +=", ";
                    winner.append(", ");
                }
//                winners += car.getName();
                winner.append(car.getName());
            }
        }

        winner.append("가 최종우승했습니다.");
        System.out.println(winner);
//        System.out.println(winners+"가 최종우승했습니다.");

    }

    private static void printFirstState(ArrayList<Car> carList, StringBuilder sb) {
        for(Car car : carList){
            sb.append(car.toString());
            sb.append("\n");
        }
        sb.append("\n");
    }

    private static int printCarList(ArrayList<Car> carList, StringBuilder sb) {
        int max = -1;
        for(Car car : carList){
            int random = new Random().nextInt(9)+1;
            int move = car.updateMove(random);
            sb.append(car);
            sb.append("\n");

            max = Math.max(move,max);
        }

        return max;
    }
}
