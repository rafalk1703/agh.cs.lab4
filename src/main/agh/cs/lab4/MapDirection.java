package agh.cs.lab4;

public enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public static void main(String [] args){
       /* String x = SOUTH.toString();
        System.out.println(x);
        MapDirection s = NORTH.next();
        System.out.println(s);*/
        MapDirection s = NORTH;
        Position poz= new Position(4,1);
        System.out.println(poz.toString());
        Position poz2 = s.getPosition();
        System.out.println(poz2.toString());
        System.out.println(poz2.add(poz).toString());

    }

    public  String toString(){
        switch(this){

            case NORTH: return "północ";
            case SOUTH: return "południe";
            case EAST: return "wschód";
            case WEST: return "zachód";
            default: return "nic";

        }

    }

    public MapDirection  next(){
        switch(this){

            case NORTH: return EAST;
            case SOUTH: return WEST;
            case EAST: return SOUTH;
            case WEST: return NORTH;
            default: return NORTH;

        }

    }
    public MapDirection  previous(){
        switch(this){

            case NORTH: return WEST;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            case WEST: return SOUTH;
            default: return NORTH;

        }

    }
    /*public Position getPosition(){

        Position position1;

        if(this==MapDirection.NORTH)
            position1=new Position(1,0);
        else if(this==MapDirection.SOUTH)
            position1=new Position(-1,0);
        else if(this==MapDirection.WEST)
            position1=new Position(0,-1);
        else if (this==MapDirection.EAST)
            position1=new Position(0,1);
        else
            position1=new Position(0,0);

        return position1;
    }*/

    public Position getPosition(){
        switch (this){
            case NORTH: return new Position(0,1);
            case SOUTH: return new Position(0,-1);
            case WEST: return new Position(-1,0);
            case EAST: return new Position(1,0);
            default: return new Position(5,0);

        }
    }





}

