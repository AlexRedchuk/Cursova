package edu.lex.cursova.dao.productType.impls;

import edu.lex.cursova.dao.productType.interfaces.IProductTypeDao;
import edu.lex.cursova.dataSet.DataSet;
import edu.lex.cursova.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTypeDaoImplFake implements IProductTypeDao {

    @Autowired
    DataSet dataSet;

    @Override
    public ProductType save(ProductType productType) {
        return null;
    }

    @Override
    public ProductType get(String id) {
        return null;
    }

    @Override
    public List<ProductType> getAll() {
        return dataSet.getProductTypes();
    }

    @Override
    public ProductType edit(ProductType productType) {
        return null;
    }

    @Override
    public ProductType delete(String id) {
        return null;
    }
}
