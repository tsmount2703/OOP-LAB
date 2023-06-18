
package data;

public class Account {
    private String accName;
    private String pwd;
    private String role;

    // Constructor
    public Account(String accName, String pwd, String role) {
        this.accName = accName;
        this.pwd = pwd;
        this.role = role;
    }

    // Getters
    public String getAccName() {
        return accName;
    }
    public String getPwd() {
        return pwd;
    }
    public String getRole() {
        return role;
    }
    
}
