package agh.cs.lab4;

public class Car {

    private MapDirection kierunek;
    private Position pozycja;
    private IWorldMap map;


    public Car(IWorldMap map) {
        this.map=map;

    }

    public Car(IWorldMap map, Position initialPosition) {
        this.map = map;
        pozycja = initialPosition;
        kierunek = MapDirection.NORTH;
    }

    public Position getPosition() {
        return pozycja;
    }

    public String toString() {

        switch (kierunek) {
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
            default:
                return "nic";
        }

    }


    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        Position pos = new Position(3,4);
        map.place(new Car(map, pos));
        map.run(directions);

        System.out.println(map.toString());

    }


    public void move(MoveDirection direction) {
        if (direction == MoveDirection.LEFT)
            kierunek = kierunek.previous();

        else if (direction == MoveDirection.RIGHT)
            kierunek = kierunek.next();

        else if (direction == MoveDirection.FORWARD) {
            Position move1 = kierunek.getPosition();
            Position newPosition = pozycja.add(move1);
            if (map.canMoveTo(newPosition))
                pozycja = newPosition;

        } else if (direction == MoveDirection.BACKWARD) {
            Position move1 = kierunek.getPosition();
            Position newPosition = pozycja.subtract(move1);
            if (map.canMoveTo(newPosition))
                pozycja = newPosition;


        }
    }
}



