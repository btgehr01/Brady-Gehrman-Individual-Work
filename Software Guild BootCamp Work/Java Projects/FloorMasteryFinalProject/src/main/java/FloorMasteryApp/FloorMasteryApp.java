/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryApp;

import FloorMasteryController.FloorMasteryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryApp {
    public static void main(String[] args) {
//        FloorMasteryDao orderDao = new FloorMasteryDaoFileImpl();
//        ProductInfoDao productDao = new ProductInfoDaoFileImpl();
//        TaxInfoDao taxDao = new TaxInfoDaoFileImpl();
//        111ProductionDao productionDao = new ProductionDaoFileImpl();
//        FloorMasteryService service = new FloorMasteryServiceFileImpl(orderDao, productDao, taxDao, productionDao);
//        UserIO io = new UserIOConsoleImpl();
//        FloorMasteryView view = new FloorMasteryView(io);
//        FloorMasteryController controller = new FloorMasteryController(service, view);
//        controller.run();

       ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       FloorMasteryController controller = ctx.getBean("controller", FloorMasteryController.class);
       controller.run();
    }
    
}
