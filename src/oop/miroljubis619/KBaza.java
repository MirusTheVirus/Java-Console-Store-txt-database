
package oop.miroljubis619;

import java.util.*;
import java.io.*;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class KBaza {
    private ArrayList<User> userBase;
    File f;
    FileWriter fw;
    FileReader fr;
    int IDc=0;

    public KBaza() throws FileNotFoundException, IOException {
        userBase=new ArrayList<>();
        f=new File("UserBase.txt");
        if(f.exists() && f.canRead()){
            fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null){
                String niz[]=line.split(";");
                User u=new User(parseInt(niz[0]),niz[1],niz[2],niz[3]+" "+niz[4],parseInt(niz[5]), parseBoolean(niz[6]));
                userBase.add(u);
            }
            IDc=userBase.get(userBase.size()-1).getID()+1;
            fr.close();
            br.close();
        }
    }
    
    void addUser(User u){
        User pom=u;
        pom.setID(IDc);
        IDc++;
        userBase.add(pom);
    }
    
    void addUsers(ArrayList<User> ulist){
        for(int i=0;i<userBase.size();i++){
            User pom=ulist.get(i);
            pom.setID(IDc);
            IDc++;
            userBase.add(pom);
        }
    }
    
    void addUsers(User[] ulist){
        for(int i=0;i<userBase.size();i++){
            User pom=ulist[i];
            pom.setID(IDc);
            IDc++;
            userBase.add(pom);
        }
    }
    
    void saveUsers() throws IOException{
        fw=new FileWriter(f);
        for(int i=0;i<userBase.size();i++){
            fw.write(userBase.get(i).printUser()+"\n");
        }
        fw.close();
    }

    public int getIDc() {
        return IDc;
    }

    public ArrayList<User> getUserBase() {
        return userBase;
    }

    public void setUserBase(ArrayList<User> userBase) {
        this.userBase = userBase;
    }
    
    public void printBase(){
        for(User u:userBase)
            System.out.println(u.toString());
    }
    
}
