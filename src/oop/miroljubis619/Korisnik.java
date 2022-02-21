
package oop.miroljubis619;

public abstract class Korisnik implements UserI{
    private int ID;
    private String username,password;

    public Korisnik(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    @Override
    public void stampajUser() {
        System.out.println(username+" "+password+"\n");
    }
    
}
