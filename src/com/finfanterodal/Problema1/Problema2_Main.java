package com.finfanterodal.Problema1;

public class Problema2_Main extends Thread {

    public Problema2_Main(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " : " + getName());
            try {
                sleep((long) Math.random() * 1000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Problema2_Main h1 = new Problema2_Main("Hilo1");
        Problema2_Main h2 = new Problema2_Main("Hilo2");
        Problema2_Main h3 = new Problema2_Main("Hilo3");

        h1.start();
        h2.start();
        h3.start();
        //Utilizamos join para que no terminen antes que el Thread main
        h1.join();
        h2.join();
        h3.join();
        System.out.println("Thread main terminated");
    }
}
