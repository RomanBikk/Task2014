import java.util.stream.IntStream;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        distance += Math.random() * speed;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0,(int)distance).forEach(i->{
            builder.append(".");
        });
        builder.append(name);
        System.out.println(builder.toString());


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
