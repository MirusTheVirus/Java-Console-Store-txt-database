
package oop.miroljubis619;

import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) throws IOException {
        KBaza kb=new KBaza();
        PBaza pb=new PBaza();
        RBaza rb=new RBaza();
        Scanner scan=new Scanner(System.in);
        
        if(kb.getUserBase().isEmpty())
            kb.addUser(new User(0,"mirus","1234","Miroljub Djokic",2000,true));
        String un;
        String pass;
        int logID=-1;
        boolean admin;
        ArrayList<User> log=new ArrayList<User>();
        try{
            System.out.println("Prijava Kupca! Username:");
            un=scan.nextLine();
            System.out.println("Password:");
            pass=scan.nextLine();
            admin=false;
            log=new ArrayList<User>();
            logID=-1;
        
            for(int i=0; i< kb.getUserBase().size();i++){
                if(kb.getUserBase().get(i).getUsername().compareTo(un) == 0 && kb.getUserBase().get(i).getPassword().compareTo(pass) ==0){
                    log.add(kb.getUserBase().get(i));
                }
            }
        
            if(log.size()<1){
                System.out.println("Ovaj korisnik ne postoji! Pravljenje naloga pokrenuto!");
                System.out.println("Ime i prezime");
                String ipr=scan.nextLine();
                System.out.println("Godiste: ");
                int god=scan.nextInt();
                User u=new User(0,un,pass,ipr,god,false);
                kb.addUser(u);
                logID=kb.getIDc()-1;
            }
        
            else if(log.size()>1){
                for(User u:log){
                    System.out.println(u.toString());
                }
                System.out.println("Unesite ID naloga koji je vas (Unosenje ne navedenog broja zavrsava program): ");
                logID=scan.nextInt();
                boolean inLog=false;
                for(User u:kb.getUserBase()){
                    if (logID==u.getID())
                        inLog=true;
                }
                if(!inLog){
                    System.out.println("ID nije korektan!");
                    logID=-1;
                }
                
            }
            else if(log.size()==1){
                logID=log.get(0).getID();
            }
        }
        catch(Exception e){
            System.out.println("Greska pri unosu");
            return;
        }
        
        if(logID>-1){
            int option;
            User current=new User(-1,"","","",0,false);
            for(User u:kb.getUserBase()){
                if(u.getID()==logID)
                    current=u;
            }
               
            System.out.println("Zdravo "+current.printIme());
            try{
                if(current.isAdmin()){
                    System.out.println("Unesite Admin PIN");
                    int pin=scan.nextInt();
                    if(pin==1111){
                        System.out.println("PIN je tacan!");
                    }
                    else{
                        System.out.println("PIN nije ispravan, program se zatvara");
                        return;
                    }
                }
            do{
                if(current.isAdmin()){
                    System.out.println("1-Print UserBase 2-Print ProductBase 3-Dodaj Korisnika 4-Dodaj Proizvod 5-Obrisi Korisnika 6-Obrisi Proizvod 7-Povecaj kolicinu proizvoda 8-Promeni cenu proizvoda 9-Odstampaj Racune kupca 0-Izlaz");
                    option=scan.nextInt();
                    if(option==0)
                        break;
                    else if(option==1)
                        kb.printBase();
                    else if(option==2)
                        pb.printBase();
                    else if(option==3){
                        System.out.println("Username (Nema razmaka):");
                        String name=scan.next();
                        System.out.println("Password (Nema razmaka):");
                        String pw=scan.next();
                        scan.nextLine();
                        System.out.println("Ime i Prezime:");
                        String imepre=scan.nextLine();
                        System.out.println("Godiste:");
                        int god=scan.nextInt();
                        System.out.println("Admin(1-DA 2-NE):");
                        int x=scan.nextInt();
                        boolean ad=(x==1 ? true : false);
                        User u=new User(0,name,pw,imepre,god,ad);
                        kb.addUser(u);
                    }
                    else if(option==4){
                        System.out.println("Naziv:");
                        scan.nextLine();
                        String naz=scan.nextLine();
                        System.out.println("Cena:");
                        double c=scan.nextDouble();
                        System.out.println("Kolicina:");
                        int kol=scan.nextInt();
                        Stock s=new Stock(0,naz,c,kol);
                        pb.addStock(s);
                    }
                    else if(option==5){
                        System.out.println("Unesite ID korisnika kojeg brisete:");
                        int IDe=scan.nextInt();
                        if (IDe==current.getID())
                            System.out.println("Ne mozete da obrisete sami sebe!");
                        else{
                            for(int i=0;i< kb.getUserBase().size();i++)
                                if(IDe==kb.getUserBase().get(i).getID()){
                                    System.out.println(kb.getUserBase().get(i).toString());
                                    kb.getUserBase().remove(i);
                                    System.out.println("Uspesno izbacen korisnik!");
                                }
                        }
                    }
                    else if(option==6){
                        System.out.println("Unesite ID proizvoda kojeg brisete:");
                        int IDe=scan.nextInt();
                        for(int i=0;i< pb.getProductBase().size();i++)
                            if(IDe==pb.getProductBase().get(i).getSKU()){
                                System.out.println(pb.getProductBase().get(i).toString());
                                pb.getProductBase().remove(i);
                                System.out.println("Uspesno izbacen proizvod!");
                            }
                    }
                    else if(option==7){
                        System.out.println("Unesite ID proizvoda kome menjate kolicinu:");
                        int IDe=scan.nextInt();
                        for(int i=0;i< pb.getProductBase().size();i++)
                            if(IDe==pb.getProductBase().get(i).getSKU()){
                                System.out.println(pb.getProductBase().get(i).toString());
                                System.out.println("Za koliko se povecava kolicina:");
                                int k=scan.nextInt();
                                pb.getProductBase().get(i).povecajKol(k);
                            }
                    }
                    else if(option==8){
                        System.out.println("Unesite ID proizvoda kome menjate cenu:");
                        int IDe=scan.nextInt();
                        for(int i=0;i< pb.getProductBase().size();i++)
                            if(IDe==pb.getProductBase().get(i).getSKU()){
                                System.out.println(pb.getProductBase().get(i).toString());
                                System.out.println("Koja je nova cena:");
                                double k=scan.nextDouble();
                                pb.getProductBase().get(i).setCena(k);
                            }
                    }
                    else if(option==9){
                        System.out.println("Unesite ID korisnika:");
                        int IDe=scan.nextInt();
                        rb.printBillKupca(IDe);
                    }
                }
                    
                else if(!current.isAdmin()){
                    System.out.println("1-Kupovina 2-Promeni licne informacije 0-Izlaz");
                    option=scan.nextInt();
                    if(option==0)
                        break;
                    else if(option==1){
                        int suboption=0;
                        Racun r=new Racun(current.getID());
                        do{
                            pb.printBase();
                            System.out.println("Unesite ID proizvoda:");
                            int IDe=scan.nextInt();
                            for(int i=0;i< pb.getProductBase().size();i++)
                                if(IDe==pb.getProductBase().get(i).getSKU()){
                                    System.out.println("Unesite kolicinu (mora biti manja od dostupne):");
                                    int k=scan.nextInt();
                                    pb.getProductBase().get(i).smanjiKol(k);
                                    r.dodajNamirnicu(pb.getProductBase().get(i), k);
                                }
                            System.out.println("Uneste jos? 1-DA");
                            suboption=scan.nextInt();
                        }while(suboption==1);
                        if(r.getNamirnice().size()>0){
                            rb.addRacun(r);
                            System.out.println("Sacuvan racun! Ukupna cena = "+r.getSuma());
                        }
                        else{
                            System.out.println("Racun nije sacuvan");
                        }
                    }
                    else if(option==2){
                        int index=0;
                        for(int i=0;i<kb.getUserBase().size();i++){
                            if(kb.getUserBase().get(i).getID()==current.getID())
                                index=i;
                        }
                        int suboption=0;
                        current.toString();
                        System.out.println("1-Promeni Username/Sifru 2-Promeni Licne informacije");
                        suboption=scan.nextInt();
                        if(suboption==1){
                            System.out.println("Unesi novi username:");
                            kb.getUserBase().get(index).setUsername(scan.next());
                            System.out.println("Unesi novu sifru:");
                            kb.getUserBase().get(index).setPassword(scan.next());
                        }
                        else if(suboption==2){
                            System.out.println("Unesi ime:");
                            kb.getUserBase().get(index).setIme(scan.next());
                            System.out.println("Unesi prezime:");
                            kb.getUserBase().get(index).setPrezime(scan.next());
                            System.out.println("Unesi godiste:");
                            kb.getUserBase().get(index).setGodiste(scan.nextInt());
                        }
                        break;
                    }
                }
            
            }while(true);
            }
            catch(Exception e){
                System.out.println("Greska u unosu!");
            }
        System.out.println("Program se zatvara");
        kb.saveUsers();
        pb.saveStock();
        rb.saveRacun();
        }
    }
}
