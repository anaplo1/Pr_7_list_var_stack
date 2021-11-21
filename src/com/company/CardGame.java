package com.company;
import java.util.*;

public class CardGame {
    private Stack<Integer> Deck1 = new Stack<Integer>();
    private Stack<Integer> Deck2 = new Stack<Integer>();
    private int count = 1;
    int a, b;
    Scanner field = new Scanner(System.in);

    public CardGame() {
        for (int i = 0;i<5;i++)
            Deck1.push(field.nextInt());
        for (int i=0;i<5;i++)
            Deck2.push(field.nextInt());
    }

    public void pushBack(Stack<Integer> t,int a){
        Stack<Integer> temp = new Stack<Integer>();
        while (t.empty() == false){
            temp.push(t.pop());
        }
        temp.push(a);
        while (temp.empty() == false){
            t.push(temp.pop());
        }
    }

    public void game() {
        while (!Deck1.isEmpty() && !Deck2.isEmpty()) {
            if (count ==106) {
                System.out.print("botva");
                break;
            }
            System.out.println("Ход №"+count);
            a = Deck1.pop();
            b = Deck2.pop();
            //System.out.print(a + " " + b);
            if (a > b && a != 0 && b!=0) {
                System.out.println("В раздаче выиграл первый игрок!");
                pushBack(Deck1,a);
                pushBack(Deck1,b);
            } else if (a == 0){
                System.out.println("В раздаче выиграл первый игрок!");
                pushBack(Deck1,a);
                pushBack(Deck1,b);
            }
            else if (b == 0)
            {
                System.out.println("В раздаче выиграл второй игрок!");
                pushBack(Deck2, a);
                pushBack(Deck2, b);
            }
            else {
                System.out.println("В раздаче выиграл второй игрок!");
                pushBack(Deck2, a);
                pushBack(Deck2, b);
            }
            count++;
            System.out.println();
        }
        if (Deck1.isEmpty())
            System.out.print("Выиграл второй игрок!");
        else if (Deck2.isEmpty())
            System.out.print("Выиграл первый игрок!");
    }
}
