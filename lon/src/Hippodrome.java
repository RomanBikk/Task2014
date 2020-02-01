import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {

        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("Bombx",3.0,0.0);
        Horse horse2 = new Horse("Caramba",3.0,0.0);
        Horse horse3 = new Horse("Goon",3.0,0.0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        try {
            game.run();
            game.printWinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public List<Horse> getHorses() {
        return horses;
    }
    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        IntStream.range(0,10).forEach(i ->{
            System.out.println();
        });
    }

    public Horse getWinner(){
        double maxDistance = 0.0;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
            }
        }
        for (Horse horse : horses) {
            if (horse.getDistance() == maxDistance){
                return horse;
            }
        }
        return null;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName()+"!");
    }
}
