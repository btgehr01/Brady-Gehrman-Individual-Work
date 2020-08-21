/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingServiceLayer;

import Vending.Dto.Item;
import Vending.Dto.ChangePurse;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface VendingService {

    public void loadMachine()
            throws VendingPersistenceException;

    public List<Item> getAllItemsInMachine();

    public Item getOneItem(String itemCode);

    public ChangePurse purchaseItem(String itemCode, BigDecimal money)
            throws VendingInsufficientFundsException,
            VendingNoItemInventoryException,
            VendingPersistenceException;
}
