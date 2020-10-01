package daoImpl;

import Storage.StorageProduct;
import dao.DaoProduct;
import model.Product;

import java.util.List;
import java.util.Optional;

public class DaoProductImpl implements DaoProduct {

    @Override
    public Product create(Product product) {
        StorageProduct.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> getById(Long ProductId) {
        return StorageProduct.products.stream()
                .filter(i -> i.getId().equals(ProductId))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        StorageProduct.products.stream()
                .filter(i -> i.getId().equals(product.getId()))
                .map(i -> StorageProduct.products.indexOf(i))
                .forEach(i -> StorageProduct.products.set(i, product));
        return product;
    }

    @Override
    public boolean deleteById(Long productId) {
        Optional<Integer> index = StorageProduct.products.stream()
                .filter(i -> i.getId().equals(productId))
                .map(i -> StorageProduct.products.indexOf(i))
                .findFirst();
        int indexForProducts = 0;
        if (index.isPresent()) {
            indexForProducts = index.get();
        }
        StorageProduct.products.remove(indexForProducts);
        return true;
    }

    @Override
    public boolean delete(Product product) {
        return StorageProduct.products.remove(product);

    }

    @Override
    public List<Product> getAllProduct() {
        return StorageProduct.products;
    }
}
