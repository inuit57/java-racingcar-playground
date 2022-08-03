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
}
