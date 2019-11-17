package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses=new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
       List<Horse> horses=new ArrayList();
       horses.add(new Horse("one",3,0));
       horses.add(new Horse("two",3,0));
       horses.add(new Horse("three",3,0));
        game=new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
    void run() throws InterruptedException {
        for(int i=0;i<100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
   protected void print(){
       for (int i=0;i<10;i++)
           System.out.println("");
       for (Horse horse:horses)
           horse.print();

   }
   protected void move(){
        for (Horse horse:horses)
            horse.move();
   }
    public Horse getWinner(){
        Horse winter=null;
        double maxdistance=0;
        for (Horse horse:horses){
            if(horse.getDistance()>maxdistance){
                maxdistance=horse.getDistance();
                winter=horse;
            }
        }
        return winter;
    }
    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
