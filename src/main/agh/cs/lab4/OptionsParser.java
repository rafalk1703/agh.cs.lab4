package agh.cs.lab4;

public class OptionsParser {

    public MoveDirection[] parse(String [] argumets){

        MoveDirection tab[] = new MoveDirection[10];

        for(int i=0; i<argumets.length; i++) {
            if (argumets[i].equals("f") || argumets[i].equals("forward")) tab[i++] = MoveDirection.FORWARD;
            if (argumets[i].equals("b") || argumets[i].equals("backward")) tab[i++] = MoveDirection.BACKWARD;
            if (argumets[i].equals("r") || argumets[i].equals("right")) tab[i++] = MoveDirection.RIGHT;
            if (argumets[i].equals("l") || argumets[i].equals("left")) tab[i++] = MoveDirection.LEFT;


        }


       return tab;

    }
}
