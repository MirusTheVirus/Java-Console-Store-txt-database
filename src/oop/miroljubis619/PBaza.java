
package oop.miroljubis619;

import java.util.*;
import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class PBaza {
    private ArrayList<Stock> productBase;
    File f;
    FileWriter fw;
    FileReader fr;
    int IDc=0;
    
    public PBaza() throws FileNotFoundException, IOException {
        f=new File("ProductBase.txt");
        productBase=new ArrayList<>();
        if(f.exists() && f.canRead()){
            fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null){
                String niz[]=line.split(";");
                Stock s=new Stock(parseInt(niz[0]),niz[1],parseDouble(niz[2]),parseInt(niz[3]));
                productBase.add(s);
            }
            IDc=productBase.get(productBase.size()-1).getSKU()+1;
            fr.close();
            br.close();
        }
    }
    
    void addStock(Stock s){
        Stock pom=s;
        pom.setSKU(IDc);
        IDc++;
        productBase.add(pom);
    }
    
    void addStocks(ArrayList<Stock> slist){
        for(int i=0;i<productBase.size();i++){
            Stock pom=slist.get(i);
            pom.setSKU(IDc);
            IDc++;
            productBase.add(pom);
        }
    }
    
    void addStocks(Stock[] slist){
        for(int i=0;i<productBase.size();i++){
            Stock pom=slist[i];
            pom.setSKU(IDc);
            IDc++;
            productBase.add(pom);
        }
    }
    
    void saveStock() throws IOException{
        fw=new FileWriter(f);
        for(int i=0;i<productBase.size();i++){
            fw.write(productBase.get(i).printStock()+"\n");
        }
        fw.close();
    }

    public ArrayList<Stock> getProductBase() {
        return productBase;
    }

    public void setProductBase(ArrayList<Stock> productBase) {
        this.productBase = productBase;
    }
    
    public void printBase(){
        for(Product p:productBase)
            System.out.println(p.toString());
    }
    
}
