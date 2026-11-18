package productsales;

public interface IProductCalculations {
    double GetVat(int productPrice);
    double GetCommission(int productPrice);
    double GetTotal(int productPrice);
}
