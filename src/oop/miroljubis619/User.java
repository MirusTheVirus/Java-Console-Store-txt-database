
package oop.miroljubis619;

public class User extends Korisnik{
    
    private String ime,prezime;
    private int godiste;
    private boolean admin;
    
    
    public User(int ID, String username, String password, String imeprez, int godiste, boolean admin) {
        super(ID, username, password);
        String[] naziv=imeprez.split(" ");
        ime=naziv[0].trim();
        if(naziv.length>1)
            prezime=naziv[1].trim();
        else
            prezime="";
        this.godiste=godiste;
        this.admin=admin;
    }
    
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }
    
    String printUser(){
        return getID()+";"+getUsername()+";"+getPassword()+";"+ime+";"+prezime+";"+godiste+";"+admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return  getID()+". "+ime+" "+prezime+" ("+godiste+") "+((admin) ? "ADMIN" : "");
    }
    
    public String printIme(){
        return ime+" "+prezime;
    }
    
}
