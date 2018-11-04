package agh.cs.lab4;

public class Position {

    public int x;
    public int y;


    public static void main(String [] args){
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

    }

    public Position(int x, int y){

        this.x = x;
        this.y = y;
    }

    public String toString(){
        int x=this.x;
        int y=this.y;

        return "(" + x + "," + y + ")";
    }

    public boolean smaller(Position other){
        if((other.x <= this.x) && (other.y <= this.y))

            return true;
        return false;
    }

    public boolean larger(Position other){
        if((other.x > this.x) && (other.y > this.y))
            return true;
        return false;
    }

    public Position upperRight(Position other){
        Position pos = new Position(x , y);
        if(this.x>other.x) pos.x=this.x;
        else {
            pos.x=other.x;
        }

        if(this.y>other.y) pos.y=this.y;
        else {
            pos.y=other.y;
        }

        return pos;

    }

    public Position lowerLeft(Position other){
        Position pos = new Position(x , y);
        if(this.x>other.x) pos.x=other.x;
        else {
            pos.x=this.x;
        }

        if(this.y>other.y) pos.y=other.y;
        else {
            pos.y=this.y;
        }
        return pos;



    }

    public Position add(Position other){

        Position pos = new Position(x , y);
        pos.x=this.x+other.x;
        pos.y=this.y+other.y;

        return pos;


    }

    public Position subtract(Position other){

        Position pos = new Position(x , y);
        pos.x=this.x-other.x;
        pos.y=this.y-other.y;

        return pos;


    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        else
            return false;


    }
    public Position getPosition(MapDirection kierunek){

        Position position1;

        if(kierunek==MapDirection.NORTH)
            position1=new Position(1,0);
        else if(kierunek==MapDirection.SOUTH)
            position1=new Position(-1,0);
        else if(kierunek==MapDirection.WEST)
            position1=new Position(0,-1);
        else if (kierunek==MapDirection.EAST)
            position1=new Position(0,1);
        else
            position1=new Position(0,0);

        return position1;
    }


}
