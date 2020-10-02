package daoImpl;

import Storage.StorageProduct;
import dao.DaoProduct;
import lib.DaoInjectProduct;
import model.Product;

import java.util.List;
import java.util.Optional;

@DaoInjectProduct
public class DaoProductImpl implements DaoProduct {

    @Override
    public Product create(Product product) {
        StorageProduct.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> get(Long id) {
        return StorageProduct.products.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
      Optional<Integer> numberProductForreplace= StorageProduct.products.stream()
                .filter(i -> i.getId().equals(product.getId()))
                .map(i -> StorageProduct.products.indexOf(i))
                .findFirst();
      if(numberProductForreplace.isPresent()) {
          StorageProduct.products.set(numberProductForreplace.get(),product);
          return product;
      } else {
          return null;
      }
    }

    @Override
    public List<Product> getAll() {
        return StorageProduct.products;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Integer> index = StorageProduct.products.stream()
                .filter(i -> i.getId().equals(id))
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
}

