
package data;

import java.util.List;
import tools.MyTool;

public class AccountChecker {
    private String accFile;
    private static String SEPARATOR=",";
    public AccountChecker() {
        setupAccFile();
    }

    private void setupAccFile() {
        Config cR= new Config();
        accFile = cR.getAccountFile();
    }
    
    public boolean check(Account acc) {
        List<String> lines = MyTool.readLinesFromFile(accFile);
        for (String line: lines) {
            String[] parts= line.split(this.SEPARATOR);
            if(parts.length<3) return false;
            if( parts[0].equalsIgnoreCase(acc.getAccName()) && 
                parts[1].equals(acc.getPwd()) &&
                parts[2].equalsIgnoreCase(acc.getRole()))
            return true;
        }
        return false;
    }
    
    public static void main(String[]args){
        AccountChecker aChk = new AccountChecker();
        Account acc = new Account("E001", "12345678", "BOSS");
        boolean valid = aChk.check(acc);
        System.out.println("Needs Ok, OK?: " + valid);
        acc = new Account("E002", "23456789", "ACC-1");
        valid = aChk.check(acc);
        System.out.println("Needs Ok, OK?: " + valid);
        acc = new Account("E003", "123456789", "ACC-2");
        valid = aChk.check(acc);
        System.out.println("Needs Ok, OK?: " + valid);
    }
}
