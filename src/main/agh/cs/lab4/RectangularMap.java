package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private Position upperRight;
    private Position lowerLeft= new Position(0,0);
    private List<Car> cars = new ArrayList<>();



    public RectangularMap(int width, int height){
        if(width>0 && height>0)
        upperRight=new Position(width, height);

    }

    public String toString(){

        return new MapVisualizer(this).draw(lowerLeft,upperRight);
    }

    @Override
    public boolean canMoveTo(Position position) {

        if(position.smaller(lowerLeft) && upperRight.smaller(position) && !isOccupied(position))
            return true;
        return  false;
    }

    @Override
    public boolean place(Car car) {

        if(isOccupied(car.getPosition()))
            return false;

        Car car1 = new Car(this);
        cars.add(car1);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {

        if(cars.size()==0) return;
        int i=0;
        for (MoveDirection direct : directions){
            cars.get((i++)%cars.size()).move(direct);
        }
    }

    @Override
    public boolean isOccupied(Position position) {

        for(Car i : cars){
            if(i.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {

        if(isOccupied(position))
            return position;

        return null;
    }
}
