import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestBuy_Products {

    long result;

    Buy_Products BUY = new Buy_Products();

    @BeforeAll
    static void setupData(){
        Products_List.loadProducts();
    }

    @Test
    void testBuyProducts1(){
        BUY.buyProducts("H603075C", 3);
        result = BUY.getTongTien();
        assertEquals(result, 2099000*3);
    }

    @Test
    void testBuyProducts2(){
        BUY.buyProducts("H603075C", 3);
        BUY.buyProducts("C700016TC110", 1);
        result = BUY.getTongTien();
        assertEquals(result, 2099000*3 +1099000);
    }

    @Test
    void testBuyProducts3(){
        BUY.buyProducts("H603075C", 1);
        BUY.buyProducts("H604014D", 1);
        BUY.removeProducts("H603075C");
        result = BUY.getTongTien();
        assertEquals(result, 1799000);
    }

    @Test
    void testBuyProducts4(){
        BUY.buyProducts("H603075C", 1);
        BUY.buyProducts("H604014D", 1);
        BUY.removeProducts("H603075C");
        BUY.changeProducts("H604014D", "H331075", 3);
        result = BUY.getTongTien();
        assertEquals(result, 1099000*3);
    }

    @Test
    void testBuyProducts5(){
        BUY.buyProducts("C700016TC110", 1);
        BUY.buyProducts("H604014D", 1);
        BUY.removeProducts("C700016TC110");
        BUY.changeProducts("C700016TC110", "H331075", 3);
        result = BUY.getTongTien();
        assertEquals(result,  1799000);
    }
}
