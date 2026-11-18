package productsales;

public class ProductCalculations implements IProductCalculations {

    private String customerName;
    private String productName;
    private double VAT;
    private double commission;
    private double total;

    public ProductCalculations(){
    }

    public ProductCalculations(String customerName, String productName,
                       double VAT, double commission, double total) {
        this.customerName = customerName;
        this.productName = productName;
        this.VAT = VAT;
        this.commission = commission;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    @Override
    public double GetVat(int productPrice) {
        VAT = 0.15*productPrice;
        return VAT;
    }

    public void setVAT(double VAT) { this.VAT = VAT; }

    @Override
    public double GetCommission(int productPrice) {
        commission = 0.05*productPrice;
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }


    @Override
    public double GetTotal(int productPrice) {
        double totalSalesAmount = productPrice + GetVat(productPrice) + GetCommission(productPrice);
        return totalSalesAmount;
    }

    
}
