
package oop.miroljubis619;

public class Stock extends Product{
    
    private boolean nastanju;
    private int kolicina;
    
    public Stock(int SKU, String naziv, double cena,int kol) {
        super(SKU, naziv, cena);
        if(kol>0){
            kolicina=kol;
            nastanju=true;
        }
        else{
            kolicina=0;
            nastanju=false;
        }
    }

    void smanjiKol(int k){
        if(k>kolicina || k<1)
            System.out.println("Losa kolicina!");
        else if(k<=kolicina && k>0){
            kolicina-=k;
            if (kolicina<1){
                kolicina=0;
                nastanju=false;
            }
            System.out.println("Uspesno");
        }
    }
    
    void povecajKol(int k){
        if(k>0){
            kolicina+=k;
            nastanju=true;
            System.out.println("Uspesna akcija!");
        }
        else
            System.out.println("Nije ispravan broj!");
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getKolicina() {
        return kolicina;
    }
    
    
    
    @Override
    public String toString() {
        return getSKU()+". "+getNaziv()+" Cena: "+getCena()+" Kolicina: "+((nastanju)? kolicina : "Nema na stanju");
    }
    
    public String printStock(){
        return getSKU()+";"+getNaziv()+";"+getCena()+";"+kolicina;
    }
    
}
