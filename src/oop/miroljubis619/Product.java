
package oop.miroljubis619;

public class Product {
    private int SKU;
    private String naziv;
    private double cena;

    public Product(int SKU, String naziv, double cena) {
        this.SKU = SKU;
        this.naziv = naziv;
        this.cena = cena;
    }

    public int getSKU() {
        return SKU;
    }

    public void setSKU(int SKU) {
        this.SKU = SKU;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double c) {
        if(c>0){
            this.cena = c;
            System.out.println("Uspesno promenjena cena!");
        }
        else
            System.out.println("Unesena cena nije validna!");
    }

    @Override
    public String toString() {
        return "Product{" + "SKU=" + SKU + ", naziv=" + naziv + ", cena=" + cena + '}';
    }

    
    
}
