import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDangnhap {
    Dangnhap ktDangnhap=new Dangnhap();
    String result;
    @Test
    public void testDangnhap1(){
        result= ktDangnhap.Dangnhap("vana@gmail.com","Vana#123456");
        assertEquals(result,"Login successfully");
    }
    @Test
    public void testDangnhap2(){
        result= ktDangnhap.Dangnhap(null,"Vana#123456");
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangnhap3(){
        result= ktDangnhap.Dangnhap("vana@gamil.com",null);
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangnhap4(){
        result= ktDangnhap.Dangnhap(null,null);
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangnhap5(){
        result= ktDangnhap.Dangnhap("Vana@@@@.vn","Van@123456");
        assertEquals(result,"email error");
    }
    @Test
    public void testDangnhap6(){
        result= ktDangnhap.Dangnhap(".","Van@123456");
        assertEquals(result,"email error");
    }
    @Test
    public void testDangnhap7(){
        result= ktDangnhap.Dangnhap("AnaGau@gmail.vn","Van");
        assertEquals(result,"password error");
    }
    @Test
    public void testDangnhap8(){
        result= ktDangnhap.Dangnhap("AnaGau@gmail.vn","!@#$%^&*()");
        assertEquals(result,"password error");
    }
}
