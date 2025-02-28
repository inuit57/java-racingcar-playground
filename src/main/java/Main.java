import Racing.Car;
import Racing.CarFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final CarFactory carFactory = new CarFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 자동차 이름 입력받기
        String inputNameText = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        System.out.println(inputNameText);
        String carNames = sc.nextLine();
        ArrayList<Car> carList = new ArrayList<>();
        for(String name : carNames.split(",")){
            carList.add(carFactory.createCar(name));
        }
        
        // 시도 횟수 입력
        String inputTryNumberText = "시도할 회수는 몇회인가요?";
        System.out.println(inputTryNumberText);
        int tryNumber = sc.nextInt();

        // 경기 진행
        System.out.println("실행결과");
        StringBuilder sb = new StringBuilder();
        printFirstState(carList, sb);
        int winMove = 0;
        for(int i=0 ; i< tryNumber; i++){
            winMove = printCarList(carList, sb);
            sb.append("\n");
        }
        System.out.println(sb);

        // 최종 우승 정보 정리
        StringBuilder winner = new StringBuilder();
        for(Car car : carList){
            if(car.isWinner(winMove)){
                appendWinner(winner, car);
            }
        }
        winner.append("가 최종우승했습니다.");
        System.out.println(winner);

    }

    private static void appendWinner(StringBuilder winner, Car car) {
        if( !winner.toString().isEmpty()){
            winner.append(", ");
        }
        winner.append(car.getName());
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
