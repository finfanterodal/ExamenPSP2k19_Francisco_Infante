package com.finfanterodal.Problema3;

public class Problema3_Main extends Thread {
    static int cont=2;
    Problema3_Main hilo;

    public Problema3_Main(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (cont<=3){
            hilo= new Problema3_Main("Hilo"+cont);
            hilo.start();
            cont++;
        }

        for (int i = 1; i <= 25; i++) {
            System.out.println(i + " : " + getName());
            try {
                sleep((long) Math.random() * 1000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //El método yield da apaso a otro hilo al ser llamado
            yield();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Problema3_Main h1 = new Problema3_Main("Hilo1");
        h1.start();
        h1.join();
        System.out.println("Terminated Thread main");
    }
}
