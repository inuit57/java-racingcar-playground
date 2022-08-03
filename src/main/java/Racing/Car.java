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

    // 최댓 이동거리 판정을 위해서 필요하다.
    public int getMove() {
        return move;
    }

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
        if(random >= CAN_MOVE_NUM){
            this.move++;
            return true;
        }
        return false;
    }
}
