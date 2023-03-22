import java.util.regex.Pattern;

public class Dangnhap {
   public String Dangnhap(String email,String password){
       if ((email==null)||(password==null) ){
           return "Khong duoc de trong";
       } else {
           String EMAIL_PARTENT="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
           if(!Pattern.matches(EMAIL_PARTENT,email)){
               return "email error";
           }


           String PASS_PARTENT="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";
           if (!Pattern.matches(PASS_PARTENT,password)){
               return "password error";
           }
       }
       return "Login successfully";
   }
}
