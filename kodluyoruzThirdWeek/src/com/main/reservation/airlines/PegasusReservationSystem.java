package com.main.reservation.airlines;

import com.main.reservation.AbstractFlightReservationSystem;

import java.util.Scanner;

public class PegasusReservationSystem extends AbstractFlightReservationSystem {

    public PegasusReservationSystem() {

    }

    public PegasusReservationSystem(int koltukSayisi) {
        super(koltukSayisi);
    }

    @Override
    public void rezervasyonAl() {
        System.out.println("Pegasus rezervasyon sistemine hoşgeldiniz.");
        System.out.println("Buseniss için 1'e, ekonomi için 2'ye basınız.");

        Scanner scanner = new Scanner(System.in);
        int flightType = scanner.nextInt();

        System.out.println("Rezerve etmek istediğiniz koltuk numarasını giriniz : ");
        int rezervasyonKoltukNumarası = scanner.nextInt();

        if (rezervasyonKoltukNumarası > koltukSayisi) {
            System.out.println("Yanlış koltuk numarası girdiniz");
        } else if (ucakDoluMu()) {
            System.out.println("Ucak Doludur");
        }
        switch (flightType) {
            case 1:
                if (businessDoluMu()) {
                    System.out.println("Business Doludur");
                } else if (rezervasyonKoltukNumarası <= 5) {
                    if (koltuklar[rezervasyonKoltukNumarası - 1]) {
                        System.out.println("Seçtiğiniz Koltuk Doludur");
                    } else {
                        System.out.println("Koltuk numaranız : " + rezervasyonKoltukNumarası);
                        koltuklar[rezervasyonKoltukNumarası - 1] = true;
                    }
                }else {
                    System.out.println("Seçtiğiniz Koltuk Numarası Business'a ait değildir.");
                }
                break;
            case 2:
                if (ekonomiDoluMu()) {
                    System.out.println("Ekonomi Doludur");
                } else if (rezervasyonKoltukNumarası > 5) {
                    if (!koltuklar[rezervasyonKoltukNumarası - 1]) {
                        System.out.println("Koltuk numaranız : " + rezervasyonKoltukNumarası);
                    } else {
                        for (int i = 5; i < koltuklar.length; i++) {
                            if (!koltuklar[i]) {
                                System.out.println("Koltuk numaranız : " + (i + 1));
                                koltuklar[i] = true;
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }
}
