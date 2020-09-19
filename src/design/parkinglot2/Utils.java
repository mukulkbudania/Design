package design.parkinglot2;

import java.util.Collection;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class Utils {
    public static boolean isEmpty(Collection c){
        return c==null || c.isEmpty();
    }
    public static String print(Collection records) {
        return print(records,", ",false);
    }
    public static String print(Collection records,String delimiter,boolean withNumbers) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(Object o: records){
            if(withNumbers)sb.append(++i + ". ");
            sb.append(o.toString() + delimiter);
        }
        int x = sb.length();
        if(x>0){
            sb.delete(sb.lastIndexOf(delimiter),x);
        }
        sb.append('\n');
        return sb.toString();
    }
}
