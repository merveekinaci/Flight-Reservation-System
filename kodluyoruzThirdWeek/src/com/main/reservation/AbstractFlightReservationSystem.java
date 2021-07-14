package com.main.reservation;

public abstract class AbstractFlightReservationSystem {
    protected int koltukSayisi;
    protected boolean[] koltuklar;

    public AbstractFlightReservationSystem() {

    }

    public AbstractFlightReservationSystem(int koltukSayisi) {
        if(koltukSayisi < 10){
            koltukSayisi = 10;
            System.out.println("Koltuk sayısı hatalı otomatik olarak 10 yapıldı.");
        }
        this.koltukSayisi = koltukSayisi;
        this.koltuklar  = new boolean[koltukSayisi];
    }

    public boolean[] getKoltuklar() {
        return koltuklar;
    }

    public void setKoltuklar(boolean[] koltuklar) {
        this.koltuklar = koltuklar;
    }

    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    public void setKoltukSayisi(int koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }

    public boolean ekonomiDoluMu(){
        for(int i =  5; i<koltuklar.length; i++){
            if(koltuklar[i] == false){
                return false;
            }
        }
        return true;
    }

    public boolean businessDoluMu(){
        for(int i = 0; i<5; i++){
           if(koltuklar[i] == false){
               return false;
           }
        }
        return true;
    }

    public boolean ucakDoluMu(){
        if(businessDoluMu() && ekonomiDoluMu()){
            return true;
        }
        return false;
    }

    public abstract void rezervasyonAl();
}
