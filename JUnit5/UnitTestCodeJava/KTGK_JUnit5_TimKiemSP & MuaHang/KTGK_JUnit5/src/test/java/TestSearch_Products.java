
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestSearch_Products {
    Boolean result;
    Search_Products SEARCH = new Search_Products();

    @BeforeAll
    static void setupData(){
        Products_List.loadProducts();
    }

    @Test
    void testSearchProducts1(){
        result = SEARCH.searchProducts("Đầm xòe tay");
        assertTrue(result);
    }

    @Test
    void testSearchProducts2(){
        result = SEARCH.searchProducts("Đầm dài");
        assertFalse(result);
    }

    @Test
    void testSearchProducts3(){
        result = SEARCH.searchProducts("Áo khoác lửng tay");
        assertTrue(result);
    }

    @Test
    void testSearchProducts4(){
        result = SEARCH.searchProducts("Áo sơ mi");
        assertFalse(result);
    }

    @Test
    void testSearchProducts5(){
        result = SEARCH.searchProducts("Quần");
        assertTrue(result);
    }

    @Test
    void testSearchProducts6(){
        result = SEARCH.searchProducts("Quần dài");
        assertFalse(result);
    }

    @Test
    void testSearchProducts7(){
        result = SEARCH.searchProducts("Váy");
        assertTrue(result);
    }

    @Test
    void testSearchProducts8(){
        result = SEARCH.searchProducts("Váy hoa");
        assertFalse(result);
    }

    @Test
    void testSearchProducts9(){
        result = SEARCH.searchProducts("Juyp");
        assertTrue(result);
    }

    @Test
    void testSearchProducts10(){
        result = SEARCH.searchProducts("C700016TC110");
        assertTrue(result);
    }
}
