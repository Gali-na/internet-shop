package dao;

import model.Product;

public interface DaoProduct  extends GenericDao <Product,Long>{
     boolean delete(Product product);
}
