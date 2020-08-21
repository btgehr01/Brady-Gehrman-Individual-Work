/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author 19bgehrman
 */
public class CustomerOrder {

    private int orderNumber;
    private String customerName;
    private String stateAbbreviation;
    private BigDecimal taxRate;
    private String productType;
    private double area;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;
    private LocalDate date;

    public CustomerOrder() {
    }
    
    public CustomerOrder(LocalDate date) {
        this.date = date;
    }

//    public CustomerOrder(String CustomerName) {
//        this.customerName = CustomerName;
//    }

    public CustomerOrder(int OrderNumber) {
        this.orderNumber = OrderNumber;
    }

    public CustomerOrder(int orderNumber, String customerName, String state, BigDecimal taxRate, String productType, double area, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot, BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax, BigDecimal total, LocalDate date) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.stateAbbreviation = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.costPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.tax = tax;
        this.total = total;
        this.date = date;
    }

    public CustomerOrder(String customerName, String state, BigDecimal taxRate, String productType, double area, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot, LocalDate date) {
        this.customerName = customerName;
        this.stateAbbreviation = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.costPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
        this.date = date;
        this.materialCost = costPerSquareFoot.multiply(new BigDecimal(area)).setScale(2);
        this.laborCost = laborCostPerSquareFoot.multiply(new BigDecimal(area)).setScale(2);
        this.tax = (materialCost.add(laborCost).setScale(2)).multiply((taxRate.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)).setScale(2));
        this.tax = this.tax.setScale(2, RoundingMode.HALF_UP);
        this.total = materialCost.add(laborCost).add(tax).setScale(2);
    }
    

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int OrderNumber) {
        this.orderNumber = OrderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String CustomerName) {
        this.customerName = CustomerName;
    }

    public String getState() {
        return stateAbbreviation;
    }

    public void setState(String State) {
        this.stateAbbreviation = State;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal TaxRate) {
        this.taxRate = TaxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String ProductType) {
        this.productType = ProductType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double Area) {
        this.area = Area;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal CostPerSquareFoot) {
        this.costPerSquareFoot = CostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal LaborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = LaborCostPerSquareFoot;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal MaterialCost) {
        this.materialCost = MaterialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal LaborCost) {
        this.laborCost = LaborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal Tax) {
        this.tax = Tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal Total) {
        this.total = Total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" + "OrderNumber=" + orderNumber + ", CustomerName=" + customerName + ", State=" + stateAbbreviation + ", TaxRate=" + taxRate + ", ProductType=" + productType + ", Area=" + area + ", CostPerSquareFoot=" + costPerSquareFoot + ", LaborCostPerSquareFoot=" + laborCostPerSquareFoot + ", MaterialCost=" + materialCost + ", LaborCost=" + laborCost + ", Tax=" + tax + ", Total=" + total + '}';
    }

}
