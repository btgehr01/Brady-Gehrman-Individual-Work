/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingServiceLayer;

import Vending.Dto.Item;
import VendingDao.VendingDao;
import Vending.Dto.ChangePurse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class VendingServiceFileImpl implements VendingService {

    private VendingDao dao;

    public VendingServiceFileImpl(VendingDao Dao) {
        this.dao = Dao;
    }

    @Override
    public void loadMachine() throws VendingPersistenceException {
        dao.loadAllItems();
    }

    @Override
    public List<Item> getAllItemsInMachine() {
        return dao.getAllItems();
    }

    @Override
    public Item getOneItem(String itemCode) {
        return dao.getAnItem(itemCode);
    }

    @Override
    public ChangePurse purchaseItem(String itemCode, BigDecimal money) throws VendingInsufficientFundsException, VendingNoItemInventoryException, VendingPersistenceException {
        ChangePurse numOfEachCoin;
        Item item = this.getOneItem(itemCode);
        validateItem(item);
        int numOfItems = item.getNumOfItems();
        BigDecimal itemCost = item.getCost();
        validateMoney(money, itemCost);
        numOfEachCoin = getChange(itemCost, money);
        item.setNumOfItems(numOfItems - 1);
        dao.saveAllChanges();
        return numOfEachCoin;

    }

    private void validateItem(Item searchedItem) throws VendingNoItemInventoryException {
        if (searchedItem == null || searchedItem.getNumOfItems() == 0) {
            throw new VendingNoItemInventoryException("no such item in our system");
        }
    }

    private void validateMoney(BigDecimal money, BigDecimal cost) throws VendingInsufficientFundsException {
        int comparision = money.compareTo(cost);
        //if int commparision is 0 they are equal, if it is positive the customer has more money than what the item costs
        if (comparision < 0) {
            throw new VendingInsufficientFundsException("Not enough money to pruchase this item");
        }
    }

    private ChangePurse getChange(BigDecimal cost, BigDecimal customerMoney) {
        BigDecimal change;
        change = customerMoney.subtract(cost);
        change = change.setScale(2);
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        int greaterThanDollar = change.compareTo(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanDollar > -1) {
            change = change.subtract(new BigDecimal(1.00));
            greaterThanDollar = change.compareTo(new BigDecimal(1.00));
            dollars++;
        }
        int greaterThanQuarter = change.compareTo(new BigDecimal(0.25).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanQuarter > -1) {
            change = change.subtract(new BigDecimal(0.25));
            greaterThanQuarter = change.compareTo(new BigDecimal(0.25));
            quarters++;
        }
        int greaterThanDime = change.compareTo(new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanDime > -1) {
            change = change.subtract(new BigDecimal(0.10));
            greaterThanDime = change.compareTo(new BigDecimal(0.10));
            dimes++;
        }
        int greaterThanNickel = change.compareTo(new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP));
        while (greaterThanNickel > -1) {
            change = change.subtract(new BigDecimal(0.05));
            greaterThanNickel = change.compareTo(new BigDecimal(0.05));
            nickels++;
        }
        /*
        int greaterThanPenny = change.compareTo(new BigDecimal(0.01).setScale(2, RoundingMode.CEILING));
        while (greaterThanPenny > -1) {
            change = change.subtract(new BigDecimal(0.01));
            greaterThanPenny = change.compareTo(new BigDecimal(0.01));
            pennies++;
        }
         */
        change = change.multiply(new BigDecimal(100.00)).setScale(0, RoundingMode.HALF_UP);
        int numOfPennies = change.intValue();
        while (numOfPennies >= 1) {
            numOfPennies = numOfPennies - 1;
            pennies++;
        }

        ChangePurse amountOfEachCoin = new ChangePurse(dollars, quarters, dimes, nickels, pennies);

        return amountOfEachCoin; //BG

    }

}
