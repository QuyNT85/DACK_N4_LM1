import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDangki {
    Dangki ktDangki=new Dangki();
    String result;
    @Test
    public void testDangki1(){
        result=ktDangki.register("Van","tran","quy@gmail.com","Vana@123456");
        assertEquals(result,"dang ki thanh cong");
    }
    @Test
    public void testDangki2(){
        result=ktDangki.register(null,"tran","quy@gmail.com","Vana@123456");
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangki3(){
        result=ktDangki.register("van",null,"quy@gmail.com","Vana@123456");
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangki4(){
        result=ktDangki.register("van","tran",null,"Vana@123456");
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangki5(){
        result=ktDangki.register("van","tran","test123@gmail.com",null);
        assertEquals(result,"Khong duoc de trong");
    }
    @Test
    public void testDangki6(){
        result=ktDangki.register("van","tran","test123@gmail.com","Vana@123456");
        assertEquals(result,"dang ki thanh cong");
    }
    @Test
    public void testDangki7(){
        result=ktDangki.register("van","tran",".","Vana@123456");
        assertEquals(result,"email error");
    }
    @Test
    public void testDangki8(){
        result=ktDangki.register("van@","tran","test123@gmail.com","Vana@123456");
        assertEquals(result,"dang ki thanh cong");
    }
    @Test
    public void testDangki9(){
        result=ktDangki.register("van@","tran","test123@@@gmail.com","Vana@123456");
        assertEquals(result,"email error");
    }
    @Test
    public void testDangki10(){
        result=ktDangki.register("van@","tran","test123@gmail.com","Vana123456");
        assertEquals(result,"pass error");
    }
    @Test
    public void testDangki11(){
        result=ktDangki.register("van@","tran","test123@gmail.com","3456");
        assertEquals(result,"pass error");
    }
    @Test
    public void testDangnhap12(){
        result=ktDangki.register("van@","tran","test123@gmail.com","Van");
        assertEquals(result,"pass error");
    }
    @Test
    public void testDangnhap13(){
        result=ktDangki.register("van","tran","test123@gmail.com","!@#$%%^&&*()");
        assertEquals(result,"pass error");
    }
}
