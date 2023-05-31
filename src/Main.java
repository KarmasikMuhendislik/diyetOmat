import java.sql.SQLException;
import java.util.Scanner;

import entity.Entries.DirectEntry;
import entity.Entries.ManuelEntry;
import entity.Entries.OtomaticEntry;
import  entity.Entry;

public class Main  {
    public static void call(Entry entry){
        entry.run();
    }
    public static void main(String[] args) throws SQLException {
        boolean out =false;
        while (true){
            System.out.println("Diyet türünüzü belirtiniz: 1 direk, 2 oto diyet, 3 manuel diyet, çıkış için herhangi bir tuşa basın");
            Scanner sc = new Scanner(System.in);
            int c   = sc.nextInt();
            switch (c){
                case 1:
                    call(new DirectEntry());
                    break;
                case 2:
                    call(new OtomaticEntry());
                    break;
                case 3:
                    call(new ManuelEntry());
                    break;
                default:
                    out=true;
            }
            if (out==true){
                break;
            }
        }


    }
}