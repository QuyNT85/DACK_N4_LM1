
import java.util.regex.Pattern;

public class Dangki {
    public String register(String ten,String ho,String email,String password){

        if ((ten==null)||(ho==null)||(email==null)||(password==null) ){
            return "Khong duoc de trong";
        } else {

            String TEN_PARTENT=".[{(*+?^$|]";
            if (Pattern.matches(TEN_PARTENT,ten)){
                return "ten error";
            }


            String H0_PARTENT=".[{(*+?^$|]";
            if (Pattern.matches(H0_PARTENT,ho)){
                return "ho error";
            }

           String EMAIL_PARTENT="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            if(!Pattern.matches(EMAIL_PARTENT,email)){
                return "email error";
            }


            String PASS_PARTENT="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";
            if (!Pattern.matches(PASS_PARTENT,password)){
                return "pass error";
            }

        }
        return "dang ki thanh cong" ;
    }

}
