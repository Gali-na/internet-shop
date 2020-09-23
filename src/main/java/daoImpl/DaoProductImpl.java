package daoImpl;

import Storage.StorageProduct;
import dao.DaoProduct;
import model.Product;

public class DaoProductImpl implements DaoProduct {
    @Override
    public void add(Product product) {
        StorageProduct.products.add(product);
    }
}
