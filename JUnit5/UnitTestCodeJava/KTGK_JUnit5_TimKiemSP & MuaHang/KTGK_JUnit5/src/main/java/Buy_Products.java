import java.util.ArrayList;

public class Buy_Products {
    ArrayList<Product_Model> products = Products_List.products;
    ArrayList<Product_Model> cart = new ArrayList<>();

    long gia = 0;

    void buyProducts(String maSP, int soluong){
        for (Product_Model sp : products) {
            if(sp.getTenSP().toLowerCase().contains(maSP.toLowerCase())){
                sp.setSoluong(soluong);
                cart.add(sp);
            }
        }
    }

    void removeProducts(String maSP){
        for (Product_Model product : cart) {
            if(product.getMaSP().toLowerCase().equals(maSP.toLowerCase())){
                cart.remove(product);
            }
        }
    }

    void changeProducts(String maSPCu, String maSPMoi, int soLuongMoi ){
        for (int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getMaSP().toLowerCase().equals(maSPCu.toLowerCase())){
                cart.remove(i);
                buyProducts(maSPMoi, soLuongMoi);
            }
        }
    }

    long getTongTien(){
        for (Product_Model product : cart) {
            gia += product.getGiaSP()*product.getSoluong();
        }
        return gia;
    }

}
