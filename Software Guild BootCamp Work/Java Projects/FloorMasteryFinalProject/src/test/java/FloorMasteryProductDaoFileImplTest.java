/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FloorMasteryDao.ProductInfoDao;
import FloorMasteryDao.ProductInfoDaoFileImpl;
import FloorMasteryDto.ProductInfo;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryProductDaoFileImplTest {

    public FloorMasteryProductDaoFileImplTest() {
    }
    ProductInfoDao dao;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        String testFile = "ProductDaoTest.txt";
        new FileWriter(testFile);
        dao = new ProductInfoDaoFileImpl(testFile);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestAddGetProduct() {
        String productType = "Wood";
        BigDecimal costPerSquareFoot = new BigDecimal("4.00");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.00");

        ProductInfo product = new ProductInfo(productType, costPerSquareFoot, laborCostPerSquareFoot);

        dao.addProduct(product);

        ProductInfo gottenProduct = dao.getProduct(productType);

        Assert.assertNotNull("Making sure the gotten product isn't null", gottenProduct);
        Assert.assertEquals("Making sure the ProductType hasn't changed", product.getProductType(), gottenProduct.getProductType());
        Assert.assertEquals("Making sure the Cost Per Square Foot hasn't changed", product.getCostPerSquareFoot(), gottenProduct.getCostPerSquareFoot());
        Assert.assertEquals("Making sure the LaborCostPerSquareFoot hasn't changed", product.getLaborCostPerSquareFoot(), gottenProduct.getLaborCostPerSquareFoot());
    }

    @Test
    public void TestGetAllProducts() {
        String productType = "Wood";
        BigDecimal costPerSquareFoot = new BigDecimal("4.00");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.00");

        String productType2 = "Tile";
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.50");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("2.00");

        ProductInfo product = new ProductInfo(productType, costPerSquareFoot, laborCostPerSquareFoot);
        ProductInfo product2 = new ProductInfo(productType2, costPerSquareFoot2, laborCostPerSquareFoot2);

        dao.addProduct(product);
        dao.addProduct(product2);

        List<ProductInfo> productsList = dao.getAllProducts();

        Assert.assertNotNull("makng sure the List isnt null", productsList);
        Assert.assertEquals("making sure that there are 2 items in the list", 2, productsList.size());
        Assert.assertTrue("making sure product is included in the system", productsList.contains(product));
        Assert.assertTrue("making sure product2 is included in the system", productsList.contains(product2));
    }

    @Test
    public void TestUpdateProduct() {
        String productType = "Wood";
        BigDecimal costPerSquareFoot = new BigDecimal("4.00");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.00");

        String productType2 = "Tile";
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.50");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("2.00");

        ProductInfo product = new ProductInfo(productType, costPerSquareFoot, laborCostPerSquareFoot);
        ProductInfo newProduct = new ProductInfo("Laminate", costPerSquareFoot, new BigDecimal("2.25"));
        ProductInfo product2 = new ProductInfo(productType2, costPerSquareFoot2, laborCostPerSquareFoot2);
        ProductInfo newProduct2 = new ProductInfo(productType2, new BigDecimal("4.00"), laborCostPerSquareFoot2);

        dao.addProduct(product);
        dao.addProduct(product2);

        dao.editProduct(productType, newProduct);
        dao.editProduct(productType2, newProduct2);

        ProductInfo editedProduct = dao.getProduct("Laminate");
        ProductInfo editednewProduct2 = dao.getProduct(productType2);

        org.junit.Assert.assertNotSame("making sure the productType changed", editedProduct.getProductType(), product.getProductType());
        org.junit.Assert.assertEquals("making sure the sqftcost didn't changed", editedProduct.getCostPerSquareFoot(), product.getCostPerSquareFoot());
        org.junit.Assert.assertNotSame("making sure the laborCost changed", editedProduct.getLaborCostPerSquareFoot(), product.getLaborCostPerSquareFoot());

        org.junit.Assert.assertSame("making sure the proucttype hasn't changed", editednewProduct2.getProductType(), product2.getProductType());
        org.junit.Assert.assertNotSame("making sure the costpersqft has changed", editednewProduct2.getCostPerSquareFoot(), product2.getCostPerSquareFoot());
        org.junit.Assert.assertSame("making sure the laborcostpersqft hasn't changed", editednewProduct2.getLaborCostPerSquareFoot(), product2.getLaborCostPerSquareFoot());
    }

    @Test
    public void TestRemoveProduct() {
        String productType = "Wood";
        BigDecimal costPerSquareFoot = new BigDecimal("4.00");
        BigDecimal laborCostPerSquareFoot = new BigDecimal("2.00");

        String productType2 = "Tile";
        BigDecimal costPerSquareFoot2 = new BigDecimal("3.50");
        BigDecimal laborCostPerSquareFoot2 = new BigDecimal("2.00");

        ProductInfo product = new ProductInfo(productType, costPerSquareFoot, laborCostPerSquareFoot);
        
        ProductInfo product2 = new ProductInfo(productType2, costPerSquareFoot2, laborCostPerSquareFoot2);
        

        dao.addProduct(product);
        dao.addProduct(product2);
        
        ProductInfo removedProduct = dao.removeProduct(productType);

        org.junit.Assert.assertEquals("making sure the product was the removed object", removedProduct, product);

        List<ProductInfo> listOfProducts = dao.getAllProducts();

        org.junit.Assert.assertNotNull("making sure the list isn't null", listOfProducts);
        org.junit.Assert.assertEquals("making sure that there is only one tem left in the array", 1, listOfProducts.size());
        org.junit.Assert.assertTrue("making sure that product2 is still in the list", listOfProducts.contains(product2));
        org.junit.Assert.assertFalse("making sure that product was removed from the list", listOfProducts.contains(product));

        ProductInfo removedProduct2 = dao.removeProduct(productType2);

        org.junit.Assert.assertEquals("making sure that product2 was the removed object", removedProduct2, product2);

        listOfProducts = dao.getAllProducts();

        org.junit.Assert.assertTrue("making sure the list ofitems in now empty", listOfProducts.isEmpty());
        org.junit.Assert.assertFalse("making sure that product is not still in the list", listOfProducts.contains(product));
        org.junit.Assert.assertFalse("making sure that product2 was removed from the list", listOfProducts.contains(product2));

        ProductInfo hopefullyNullProduct = dao.getProduct(productType);
        ProductInfo hopefullyNullProduct2 = dao.getProduct(productType2);

        org.junit.Assert.assertNull("making sure product is not in the system anymore", hopefullyNullProduct);
        org.junit.Assert.assertNull("making sure product2 is not in the system anymore", hopefullyNullProduct2);

    }

}
