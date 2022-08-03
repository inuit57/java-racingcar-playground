package Racing;

public class Car {
    public static final int CAN_MOVE_NUM = 4;
    private final String name;
    private int move ;

    protected Car(String name) {
        this.name = name ;
        move = 1;
    }

    public void setMove(int move) {
        this.move = move;
    }

//    public int getMove() {
//        return move;
//    }

    public boolean isWinner(int move){
        return (this.move == move) ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name);
        sb.append(" : ");
        for(int i=0; i< this.move; i++){
            sb.append("-");
        }

        return sb.toString();
    }

    /**
     *  이동 가능 여부를 확인한다.
     *  move를 증가시킨다.
     * @param random 랜덤으로 입력된 수치값
     * @return 이동가능 여부를 리턴
     */
    public boolean isMove(int random) {
        return (random >= CAN_MOVE_NUM );
    }

    /**
     * move 를 업데이트하자
     * 이렇게 하면 getMove()를 안써도 된다.
     * @param random 랜덤 입력값
     * @return 변경된 이동값을 리턴
     */
    public int updateMove(int random){
        if(isMove(random)){
            move++;
        }
        return move;
    }
}
