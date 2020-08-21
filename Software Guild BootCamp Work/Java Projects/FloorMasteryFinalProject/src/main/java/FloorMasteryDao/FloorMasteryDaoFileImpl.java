/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.CustomerOrder;
import FloorMasteryService.OrderPersistenceException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryDaoFileImpl implements FloorMasteryDao {

    private final Map<Integer, CustomerOrder> orderMap = new HashMap<>();
    private final List<LocalDate> listOfAllDatesEver = new ArrayList<>();
    final String FILE;

    public FloorMasteryDaoFileImpl(String fileName) {
        this.FILE = fileName;
    }

    public FloorMasteryDaoFileImpl() {
        this.FILE = "Orders/";
    }
    
    
    

    @Override
    public CustomerOrder addOrder(CustomerOrder order) {
        int orderNum = order.getOrderNumber();
        LocalDate orderDate = order.getDate();
        listOfAllDatesEver.add(orderDate);
        CustomerOrder customerOrder = orderMap.put(orderNum, order);
        return customerOrder;
    }

    @Override
    public void editOrder(int oldOrderNumber, CustomerOrder newCustomerOrder, LocalDate oldDate) {
        LocalDate newDate = newCustomerOrder.getDate();
        int newCustomerOrderNum = newCustomerOrder.getOrderNumber();
        if (newCustomerOrderNum == oldOrderNumber) {
            orderMap.replace(oldOrderNumber, newCustomerOrder);
        } else {
            orderMap.remove(oldOrderNumber);

            orderMap.put(newCustomerOrderNum, newCustomerOrder);
        }
        if (!(newDate.equals(oldDate))) {
            listOfAllDatesEver.add(newDate);
        }

    }

    @Override
    public CustomerOrder getOrder(int orderNum) {
        CustomerOrder correspondingOrder = orderMap.get(orderNum);
        return correspondingOrder;
    }

    @Override
    public List<CustomerOrder> getAllOrders(LocalDate date) {
        List<CustomerOrder> ordersList = new ArrayList<>();
        Collection<CustomerOrder> orders = orderMap.values();
        for (CustomerOrder order : orders) {
            if (order.getDate().equals(date)) {
                ordersList.add(order);
            }
        }
        return ordersList;
    }

    @Override
    public CustomerOrder removeOrder(int orderNum) {
        CustomerOrder removedOrder = orderMap.remove(orderNum);
        return removedOrder;
    }

    @Override
    public List<LocalDate> getAllDates() {
        List<LocalDate> listOfOrderDates = new ArrayList();
        Collection<CustomerOrder> orders = orderMap.values();
        for (CustomerOrder anOrder : orders) {
            LocalDate date = anOrder.getDate();
            if (!(listOfOrderDates.contains(date))) {
                listOfOrderDates.add(date);
            }
        }
        return listOfOrderDates;
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        List<CustomerOrder> ordersList = new ArrayList<>();
        Collection<CustomerOrder> orders = orderMap.values();
        for (CustomerOrder order : orders) {
            ordersList.add(order);
        }
        return ordersList;
    }

    @Override
    public void saveAllChanges() throws OrderPersistenceException {
        //could just blank file before but that 
        PrintWriter out;
        String nameOfFile;
        List<LocalDate> removedDatesList = new ArrayList<>();
        List<LocalDate> dateList = this.getAllDates();
        for (LocalDate orderDate : listOfAllDatesEver) {
            if (dateList.contains(orderDate)) {
                DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MMddyyyy");
                String date = orderDate.format(formatOutput);
                nameOfFile = "Orders_" + date + ".txt";

                try {
                    out = new PrintWriter(new FileWriter("Orders/" + nameOfFile));
                    //if a file of that name if there it will replace that file
                } catch (IOException ex) {
                    throw new OrderPersistenceException("could not save Order Data", ex);
                }

                List<CustomerOrder> newOrderList = this.getAllOrders(orderDate);
                out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,"
                        + "CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
                //print out the header for the file
                for (CustomerOrder newOrder : newOrderList) {
                    String stringNewOrder = marshallOrder(newOrder);
                    out.println(stringNewOrder);
                    out.flush();
                }
                out.close();

            } else {
                DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MMddyyyy");
                String date = orderDate.format(formatOutput);
                String nameOfFileToDelete = "Orders_" + date + ".txt";
                File fileToDelete = new File("Orders/" + nameOfFileToDelete);
                fileToDelete.delete();
                removedDatesList.add(orderDate);
            }
        }
        for (LocalDate removeDate : removedDatesList) {
            listOfAllDatesEver.remove(removeDate);
        }

    }

    public String marshallOrder(CustomerOrder newOrder) {
        final String COMA = ",";
        String newOrderAsString;

        int orderNum = newOrder.getOrderNumber();
        newOrderAsString = orderNum + COMA;

        String orderName = newOrder.getCustomerName();
        newOrderAsString += orderName + COMA;

        String state = newOrder.getState();
        newOrderAsString += state + COMA;

        BigDecimal taxRate = newOrder.getTaxRate();
        newOrderAsString += taxRate + COMA;

        String productType = newOrder.getProductType();
        newOrderAsString += productType + COMA;

        double area = newOrder.getArea();
        newOrderAsString += area + COMA;

        BigDecimal costPerSquareFoot = newOrder.getCostPerSquareFoot();
        newOrderAsString += costPerSquareFoot + COMA;

        BigDecimal laborCostPerSquareFoot = newOrder.getLaborCostPerSquareFoot();
        newOrderAsString += laborCostPerSquareFoot + COMA;

        BigDecimal materialCost = newOrder.getMaterialCost();
        newOrderAsString += materialCost + COMA;

        BigDecimal laborCost = newOrder.getLaborCost();
        newOrderAsString += laborCost + COMA;

        BigDecimal tax = newOrder.getTax();
        newOrderAsString += tax + COMA;

        BigDecimal total = newOrder.getTotal();
        newOrderAsString += total;

        return newOrderAsString;

    }

    @Override
    public void loadAllOrders() throws OrderPersistenceException {
        Scanner scanner;
        File allFiles = new File("Orders/");
        for (File aFile : allFiles.listFiles()) {
            String fileName = aFile.getName();
            try {
                scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(aFile)));

            } catch (FileNotFoundException ex) {
                throw new OrderPersistenceException("Unable to load orders", ex);
            }
            String[] smallerFileNameWithoutOrder = fileName.split("_");
            String fileNameWithoutOrderInFront = smallerFileNameWithoutOrder[1];
            // now 06022013.txt
            fileNameWithoutOrderInFront = fileNameWithoutOrderInFront.replace('.', ':');
            String[] smallerFileNameWithoutTxt = fileNameWithoutOrderInFront.split(":");
            String dateWithoutDashes = smallerFileNameWithoutTxt[0];
            // now 06022013
            DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MMddyyyy");
            DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate localDate = LocalDate.parse(dateWithoutDashes, formatInput);
            String stringDate = localDate.format(formatOutput);
            LocalDate date = LocalDate.parse(stringDate, formatOutput);
            String currentLine;
            scanner.nextLine(); //skips first line of file
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                CustomerOrder retrivedOrder = unMarshallOrder(currentLine);
                retrivedOrder.setDate(date);
                orderMap.put(retrivedOrder.getOrderNumber(), retrivedOrder);
                listOfAllDatesEver.add(date);
            }
            scanner.close();
        }
    }

    public CustomerOrder unMarshallOrder(String stringOrder) {
        //OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,
        //LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total
        CustomerOrder order = new CustomerOrder();
        String[] orderArray = stringOrder.split(",");

        String orderNumber = orderArray[0];
        int orderNum = Integer.parseInt(orderNumber);
        order.setOrderNumber(orderNum);

        String orderName = orderArray[1];
        order.setCustomerName(orderName);

        String state = orderArray[2];
        order.setState(state);

        String taxRateString = orderArray[3];
        BigDecimal taxRate = new BigDecimal(taxRateString);
        order.setTaxRate(taxRate);

        String productType = orderArray[4];
        order.setProductType(productType);

        String stringArea = orderArray[5];
        double area = Double.parseDouble(stringArea);
        order.setArea(area);

        String stringCostPerSquareFoot = orderArray[6];
        BigDecimal costPerSquareFoot = new BigDecimal(stringCostPerSquareFoot);
        order.setCostPerSquareFoot(costPerSquareFoot);

        String stringLaborCostPerSquareFoot = orderArray[7];
        BigDecimal laborCostPerSquareFoot = new BigDecimal(stringLaborCostPerSquareFoot);
        order.setLaborCostPerSquareFoot(laborCostPerSquareFoot);

        String stringMaterialCost = orderArray[8];
        BigDecimal materialCost = new BigDecimal(stringMaterialCost);
        order.setMaterialCost(materialCost);

        String stringLaborCost = orderArray[9];
        BigDecimal laborCost = new BigDecimal(stringLaborCost);
        order.setLaborCost(laborCost);

        String stringTax = orderArray[10];
        BigDecimal tax = new BigDecimal(stringTax);
        order.setTax(tax);

        String stringTotal = orderArray[11];
        BigDecimal total = new BigDecimal(stringTotal);
        order.setTotal(total);

        return order;
    }

}
