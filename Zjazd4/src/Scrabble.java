import java.util.Scanner;

public class Scrabble {
    private enum Letters {
        A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,R,S,T,Q,U,V,W,X,Y,Z
    }

    private int getPoints(char letter) {
        int result;
        switch (Letters.valueOf(String.valueOf(letter).toUpperCase())) {
            case A:
            case E:
            case I:
            case O:
            case U:
            case L:
            case N:
            case R:
            case S:
            case T:
                result = 1;
                break;
            case D:
            case G:
                result = 2;
                break;
            case B:
            case C:
            case M:
            case P:
                result = 3;
                break;
            case F:
            case H:
            case V:
            case W:
            case Y:
                result = 4;
                break;
            case K:
                result = 5;
                break;
            case J:
            case X:
                result = 8;
                break;
            case Q:
            case Z:
                result = 10;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    public int calculatePoints(String word) {
        int sum = 0;

        for(int letterIndex=0; letterIndex<word.length(); letterIndex++) {
            sum += getPoints(word.charAt(letterIndex));
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scrabble scrabble = new Scrabble();
        while(true) {
            System.out.println("Aby wyjść wciśnij wpisz quit.");
            System.out.println("Podaj wyraz: ");
            String word = scanner.next();

            if("quit".equals(word)) {
                break;
            }

            System.out.println("Liczba otrzymanych punktów: " + scrabble.calculatePoints(word));
        }
    }
}
