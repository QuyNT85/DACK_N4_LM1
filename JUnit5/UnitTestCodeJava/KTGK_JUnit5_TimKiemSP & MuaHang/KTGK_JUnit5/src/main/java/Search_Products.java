import java.util.ArrayList;

public class Search_Products {
    ArrayList<Product_Model> products = Products_List.products;

    Boolean searchProducts(String tenSP){
        for (Product_Model sp : products) {
            if(sp.getTenSP().toLowerCase().contains(tenSP.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
