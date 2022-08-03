package Racing;

public class Car {
    private final String name;
    private int move ;

    protected Car(String name) {
        this.name = name ;
        move = 1;
    }

    public void setMove(int move) {
        this.move = move;
    }

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

    public boolean isMove(int random) {
        if(random >= 4){
            this.move++;
            return true;
        }
        return false;
    }
}
