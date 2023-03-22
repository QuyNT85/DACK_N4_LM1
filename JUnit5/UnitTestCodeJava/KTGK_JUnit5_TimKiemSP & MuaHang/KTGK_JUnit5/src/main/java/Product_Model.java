public class Product_Model {
    private String tenSP, maSP, chitietSP;
    private long giaSP;

    private int soluong=0;

    public Product_Model(String tenSP, String maSP, long giaSP, String chitietSP) {
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.chitietSP = chitietSP;
        this.giaSP = giaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getChitietSP() {
        return chitietSP;
    }

    public void setChitietSP(String chitietSP) {
        this.chitietSP = chitietSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public long getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(long giaSP) {
        this.giaSP = giaSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

}
