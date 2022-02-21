
package oop.miroljubis619;

import java.util.*;

public class Racun {
    private ArrayList<Stock> namirnice;
    private double suma;
    private int IDkupca;

    public Racun(int IDkupca) {
        suma = 0;
        this.IDkupca = IDkupca;
        namirnice=new ArrayList<>();
    }

    public ArrayList<Stock> getNamirnice() {
        return namirnice;
    }

    public double getSuma() {
        return suma;
    }

    public int getIDkupca() {
        return IDkupca;
    }
    
    public void dodajNamirnicu(Stock s,int kol){
        if(s.getKolicina()>=kol){
            s.setKolicina(kol);
            namirnice.add(s);
            suma+=s.getCena()*kol;
        }
    }
    
    public void obnoviNamirnicu(Stock s){
        namirnice.add(s);
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }
    
    public String printRacun(){
        String x=String.valueOf(IDkupca)+"-"+String.valueOf(suma)+"-";
        for(int i=0;i<namirnice.size();i++){
            x+=namirnice.get(i).printStock();
            if(i<namirnice.size()-1)
                x+=":";
        }
        return x;
    }

    @Override
    public String toString() {
        String s="L I S T A NAMIRNICA(ID KUPCA="+IDkupca+"):\n";
        for(Stock n:namirnice){
            s+=n.toString()+"\n";
        }
        s+="Ukupna cena: "+suma+"\n------------------------------------------------\n";
        return s;
    }
    
    
}
