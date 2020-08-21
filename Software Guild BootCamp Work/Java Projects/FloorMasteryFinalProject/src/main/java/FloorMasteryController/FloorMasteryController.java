/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryController;

import FloorMasteryDto.CustomerOrder;
import FloorMasteryDto.ProductInfo;
import FloorMasteryDto.TaxInfo;
import FloorMasteryService.FloorMasteryService;
import FloorMasteryService.OrderAreaValidationException;
import FloorMasteryService.OrderDateValidationException;
import FloorMasteryService.OrderNameValidationException;
import FloorMasteryService.OrderPersistenceException;
import FloorMasteryService.OrderValidationExceptionNull;
import FloorMasteryService.ProductPersistenceException;
import FloorMasteryService.ProductionModePersistenceException;
import FloorMasteryService.TaxInfoPersistenceException;
import FloorMasteryUI.FloorMasteryView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryController {

    private final FloorMasteryService service;
    private final FloorMasteryView view;

    public FloorMasteryController(FloorMasteryService service, FloorMasteryView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {

        boolean keepGoing = true;

        try {
            service.loadAllOrders();
        } catch (ProductPersistenceException | TaxInfoPersistenceException | OrderPersistenceException | ProductionModePersistenceException ex) {
            view.showPersistenceError();
            keepGoing = false;
        }

        while (keepGoing) {
            boolean isInProductionMode = service.getProductionMode();
            int menuSelection = view.getMenuSelection(isInProductionMode);
            switch (menuSelection) {
                case 1:
                    this.displayOrder();
                    break;
                case 2:
                    this.addOrder();
                    break;
                case 3:
                    this.editOrder();
                    break;
                case 4:
                    this.removeOrder();
                    break;
                case 5:
                    if (isInProductionMode) {
                        keepGoing = this.saveCurrentData();
                        if (!(keepGoing)) {
                            view.couldntSave();
                        }
                    } else {
                        view.inTrainingModeCannotSave();
                    }
                    break;
                case 6:
                    if (isInProductionMode) {
                        boolean wouldLikeToSave = view.askIfTheCustomerIsSure();
                        if (wouldLikeToSave) {
                            boolean savedTheData = this.saveCurrentData();
                            if (!(savedTheData)) {
                                view.couldntSave();
                            }
                        }
                    }
                    keepGoing = false;
                    break;
                default:
                    view.unknownCommand();
                    break;
            }
        }
        view.thankYou();
    }

    private void displayOrder() {
        String stringDate = view.getDateForDisplayOrder();
        if (!(stringDate.equals("q"))) {
            DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate date = LocalDate.parse(stringDate, formatInput);
            List<CustomerOrder> orderListForWantedDate = service.getAllOrders(date);
            if (orderListForWantedDate.isEmpty()) {
                view.showNoOrdersOnThatDate();
            } else {
                view.displayOrdersFromAList(orderListForWantedDate);
            }
        } else {
            view.returningToMain();
        }
    }

    private void addOrder() {
        List<ProductInfo> products = service.getAllProducts();
        String wantedProductType = view.showAndGetFromProductList(products);
        ProductInfo product = service.getProduct(wantedProductType);
        BigDecimal costPerSquareFoot = product.getCostPerSquareFoot();
        BigDecimal laborCostPerSquareFoot = product.getLaborCostPerSquareFoot();
        double area = view.getOrderArea(product);
        String customerName = view.getCustomerName();
        List<TaxInfo> allTaxInfoList = service.getAllTaxInfo();
        String deliveryStateAbbreviation = view.getDeliveryLocation(area, product, allTaxInfoList);
        TaxInfo stateInfo = service.getTaxInfo(deliveryStateAbbreviation);
        BigDecimal taxRate = stateInfo.getTaxRate();
        String stringDate = view.getWantedDeliveryDate();
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatInput);
        CustomerOrder soonAddedOrder = new CustomerOrder(customerName, deliveryStateAbbreviation, taxRate, wantedProductType,
                area, costPerSquareFoot, laborCostPerSquareFoot, date);

        boolean noErrors = true;
        do {
            try {
                boolean isSure = view.customerIsSureAboutTheirOrder(soonAddedOrder);
                if (isSure) {
                    CustomerOrder placedCustomerOrder = service.addOrder(soonAddedOrder);
                    noErrors = true; //end loop
                    view.displayOrderPlacedSucessBanner(placedCustomerOrder);
                } else {
                    view.customerDoesntWantToSaveOrder();
                    noErrors = true; //end loop
                }
            } catch (OrderValidationExceptionNull ex) {
                view.orderIsNull(); //should never happen but..
            } catch (OrderDateValidationException ex) {
                noErrors = false;
                view.orderDateIsInThePast();
                String stringhopefullyCorrectedDate = view.getWantedDeliveryDate();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate HopefullyCorrectedDate = LocalDate.parse(stringhopefullyCorrectedDate, format);
                soonAddedOrder.setDate(HopefullyCorrectedDate);
            } catch (OrderNameValidationException ex) {
                noErrors = false;
                view.orderNameWasLeftEmpty();
                String hopeullyCorrectedcustomerName = view.getCustomerName();
                soonAddedOrder.setCustomerName(hopeullyCorrectedcustomerName);
            } catch (OrderAreaValidationException ex) {
                noErrors = false;
                view.orderAreaValidationException();
                double hopefullyCorrectedarea = view.getOrderArea(product);
                soonAddedOrder.setArea(hopefullyCorrectedarea);
                BigDecimal newMaterialCost = costPerSquareFoot.multiply(new BigDecimal(hopefullyCorrectedarea)).setScale(2);
                BigDecimal newLaborCost = laborCostPerSquareFoot.multiply(new BigDecimal(hopefullyCorrectedarea)).setScale(2);
                BigDecimal newTax = (newMaterialCost.add(newLaborCost).setScale(2)).multiply((taxRate.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)));
                newTax = newTax.setScale(2, RoundingMode.HALF_UP);
                BigDecimal newTotal = newMaterialCost.add(newLaborCost).add(newTax).setScale(2);
                soonAddedOrder.setMaterialCost(newMaterialCost);
                soonAddedOrder.setLaborCost(newLaborCost);
                soonAddedOrder.setTax(newTax);
                soonAddedOrder.setTotal(newTotal);
            }
        } while (!(noErrors));
    }

    private void editOrder() {
        int orderNumberForEdit = view.getOrderNumberForEdit();
        if (!(orderNumberForEdit == 0)) {
            String stringDateForEdit = view.getDateForEdit();
            DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate dateForEdit = LocalDate.parse(stringDateForEdit, formatInput);
            CustomerOrder soonToBeEditedOrder = service.getOneOrder(orderNumberForEdit);
            List<TaxInfo> stateList = service.getAllTaxInfo();
            List<ProductInfo> allProducts = service.getAllProducts();
            if (soonToBeEditedOrder != null) {
                if (dateForEdit.equals(soonToBeEditedOrder.getDate())) {
                    CustomerOrder userEditedOrder = view.editOrder(soonToBeEditedOrder, stateList, allProducts);

                    String possiblyNewCustomerName = userEditedOrder.getCustomerName();
                    String possiblyNewProductType = userEditedOrder.getProductType();
                    String possiblyNewStateAbbreviation = userEditedOrder.getState();
                    LocalDate possiblyNewDate = userEditedOrder.getDate();
                    double possiblyNewArea = userEditedOrder.getArea();

                    ProductInfo possiblyNewProduct = service.getProduct(possiblyNewProductType);
                    TaxInfo possiblyNewTaxInfo = service.getTaxInfo(possiblyNewStateAbbreviation);

                    //String customerName, String state, BigDecimal taxRate, String productType, 
                    //double area, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot, String date)
                    CustomerOrder editedOrder = new CustomerOrder(possiblyNewCustomerName, possiblyNewTaxInfo.getStateName(),
                            possiblyNewTaxInfo.getTaxRate(), possiblyNewProductType, possiblyNewArea, possiblyNewProduct.getCostPerSquareFoot(),
                            possiblyNewProduct.getLaborCostPerSquareFoot(), possiblyNewDate);
                    editedOrder.setOrderNumber(orderNumberForEdit);
                    //make sure in view, show order
                    boolean wouldLikeToSaveEdit = view.wouldLikeToSaveEdit(editedOrder);
                    if (wouldLikeToSaveEdit) {
                        service.editOrder(orderNumberForEdit, editedOrder, dateForEdit);
                    } else {
                        view.changesDiscarded();
                    }

                } else {
                    view.showThatTheDateDoesntMatchTheObject();
                    view.returningToMain();
                }
            } else {
                view.showThatTheOrderDoesntExistInOurProgram();
                view.returningToMain();
            }
        } else {
            view.returningToMain();
        }
    }

    private void removeOrder() {
        int removedOrderNumber = view.getOrdersNumberToRemove();
        if (!(removedOrderNumber == 0)) {
            String removedOrderDate = view.getOrdersDateToRemove(); //see if the order number correlates to the order gotten
            CustomerOrder soonToBeRemovedCustomerOrder = service.getOneOrder(removedOrderNumber);
            if (soonToBeRemovedCustomerOrder != null) {
                DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                if (removedOrderDate.equals(soonToBeRemovedCustomerOrder.getDate().format(formatInput))) {
                    boolean isSure = view.askIfTheCustomerIsSure(soonToBeRemovedCustomerOrder);
                    if (isSure) {
                        CustomerOrder removedOrder = service.removedOrder(removedOrderNumber);
                        view.displayRemovedSucess(removedOrder);
                    }
                } else {
                    view.showThatTheDateDoesntMatchTheObject();
                    view.returningToMain();
                }
            } else {
                view.showThatTheOrderDoesntExistInOurProgram();
                view.returningToMain();
            }
        }else{
            view.returningToMain();
        }

    }

    private boolean saveCurrentData() {
        boolean dataWasSaved = true;
        try {
            service.SaveAllChanges();
            view.displayThatTheSaveWasSucessful();
        } catch (OrderPersistenceException ex) {
            dataWasSaved = false;
        }
        return dataWasSaved;
    }
}
