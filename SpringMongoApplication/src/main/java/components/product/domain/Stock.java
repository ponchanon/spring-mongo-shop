package components.product.domain;

public class Stock {
    private int nrInStock;
    private String locationCode;

    public Stock(int nrInStock, String locationCode) {
        this.nrInStock = nrInStock;
        this.locationCode = locationCode;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "number in stock='" + nrInStock + '\'' +
                ", location code='" + locationCode + '\'' +
                '}';
    }
}
