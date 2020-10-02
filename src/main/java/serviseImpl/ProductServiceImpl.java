package serviseImpl;

import Storage.StorageProduct;
import dao.DaoProduct;
import lib.Inject;
import model.Product;
import service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Inject
    DaoProduct daoProduct;

    @Override
    public Product create(Product product) {
        Optional < Product> productCheckID=StorageProduct.products.stream()
                .filter(productCurrent->productCurrent.getId().equals(product.getId()))
                .findFirst();
        if(productCheckID.isPresent()) {
            System.out.println("The product has an incorrect identifier, please re-enter this product");
            return null;
        }
        if(product==null) {
           System.out.println("The specified product is not in the store list");
           return null;
       }
        if (product.getId() == 0) {
            System.out.println("The product has an incorrect identifier, please re-enter this product");
            return null;
        }
        if (product.getName().length()==0 || product.getName()==" " || product.getName().length()>20) {
            System.out.println("You entered an incorrect name, an incorrect name please " +
                    "try again, the name must not contain 0 characters or must " +
                    "have more than 20 characters");
            return null;
        }
        if(product.getPrice()==0 || product.getPrice()<0) {
            System.out.println("The value of the goods is incorrectly indicated");
            return null;
        }
        daoProduct.create(product);
        return product;
    }

    @Override
    public Optional<Product> get(Long id) {
       return StorageProduct.products.stream()
                .filter(p->p.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Product> getAll() {

        return daoProduct.getAll();
    }

    @Override
    public Product update(Product product) {

        if (product.getName().length()==0 || product.getName()==" " || product.getName().length()>20) {
            System.out.println("You entered an incorrect name, an incorrect name please " +
                    "try again, the name must not contain 0 characters or must " +
                    "have more than 20 characters");
            return null;
        } else {
        return daoProduct.update(product);
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<Product> productCheckId = StorageProduct.products.stream()
                .filter(productForStream -> productForStream.getId().equals(id))
                .findFirst();
        if (!productCheckId.isPresent()) {
            System.out.println("The product has an incorrect identifier, please re-enter this product");
            return false;
        }
      return daoProduct.delete(id);
    }
}
