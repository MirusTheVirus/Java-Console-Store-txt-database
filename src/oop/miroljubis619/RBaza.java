
package oop.miroljubis619;

import java.util.*;
import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class RBaza {
    private ArrayList<Racun> billBase;
    File f;
    FileWriter fw;
    FileReader fr;
    
    public RBaza() throws FileNotFoundException, IOException {
        f=new File("BillBase.txt");
        billBase=new ArrayList<>();
        if(f.exists() && f.canRead()){
            fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null){
                String niz[]=line.split("-");
                Racun r=new Racun(parseInt(niz[0]));
                r.setSuma(parseDouble(niz[1]));
                if(niz[2].contains(":")){
                    String niz2[]=niz[2].split(":");
                    for(int i=0;i<niz2.length;i++){
                        String nizs[]=niz2[i].split(";");
                        Stock s=new Stock(parseInt(nizs[0]),nizs[1],parseDouble(nizs[2]),parseInt(nizs[3]));
                        r.obnoviNamirnicu(s);
                    }
                }
                else{
                    String nizs[]=niz[2].split(";");
                    Stock s=new Stock(parseInt(nizs[0]),nizs[1],parseDouble(nizs[2]),parseInt(nizs[3]));
                    r.obnoviNamirnicu(s);
                }
                billBase.add(r);
            }
            fr.close();
            br.close();
        }
    }
    
    void addRacun(Racun r){
        billBase.add(r);
    }
    
    void saveRacun() throws IOException{
        fw=new FileWriter(f);
        for(int i=0;i<billBase.size();i++){
            fw.write(billBase.get(i).printRacun()+"\n");
        }
        fw.close();
    }

    public ArrayList<Racun> getBillBase() {
        return billBase;
    }
    
    public void printBillKupca(int ID){
        for(Racun r:billBase)
            if(r.getIDkupca()==ID)
                System.out.println(r.toString());
    }
    
    public void printBill(){
        for(Racun r:billBase)
            System.out.println(r.toString());
    }
}
