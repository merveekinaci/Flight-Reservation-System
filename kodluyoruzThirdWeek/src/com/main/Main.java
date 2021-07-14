package com.main;

import com.main.reservation.airlines.PegasusReservationSystem;
import com.main.reservation.airlines.THYReservationSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Koltuk sayısı giriniz");
        int koltuksayisi = scanner.nextInt();
        THYReservationSystem thy = new THYReservationSystem(koltuksayisi);
        PegasusReservationSystem pega = new PegasusReservationSystem(koltuksayisi);
        System.out.println("THY için 1'e Pegasus için 2'ye tıklayınız");
        int airline = scanner.nextInt();
        switch (airline) {
            case 1:
                thy.rezervasyonAl();
                break;
            case 2:
                pega.rezervasyonAl();
                break;
        }
        System.out.println("Tekrar işlem için 1'e basınız");
        int tekrar = scanner.nextInt();
        if(tekrar == 1){
            System.out.println("THY için 1'e Pegasus için 2'ye tıklayınız");
            airline = scanner.nextInt();
            switch (airline) {
                case 1:
                    thy.rezervasyonAl();
                    break;
                case 2:
                    pega.rezervasyonAl();
                    break;
            }
        }
    }
}

