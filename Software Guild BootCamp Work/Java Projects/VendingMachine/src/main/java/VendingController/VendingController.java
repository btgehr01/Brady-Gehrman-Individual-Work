/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingController;

import Vending.Dto.ChangePurse;
import Vending.Dto.Item;
import VendingMachineView.VendingMachineView;
import VendingServiceLayer.VendingInsufficientFundsException;
import VendingServiceLayer.VendingNoItemInventoryException;
import VendingServiceLayer.VendingPersistenceException;
import VendingServiceLayer.VendingService;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class VendingController {

    private VendingMachineView view;
    private VendingService service;

    public VendingController(VendingMachineView view, VendingService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        loadMachine();
        while (keepGoing) {
            getAllItems();
            int menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    BigDecimal userMoney = getUserMoney();
                    int comparision = userMoney.compareTo(new BigDecimal("0"));
                    if (comparision <= 0) {
                        view.noChangePutIntoTheMachine();
                    } else {
                        Item wantedItem = getAnItem();
                        if (wantedItem == null || wantedItem.getNumOfItems() == 0) {
                            view.unknownItem();
                            view.giveChange(new ChangePurse(userMoney));
                        } else {
                            this.sellAnItem(wantedItem, userMoney);
                        }
                    }
                    break;

                case 2:
                    keepGoing = false;
                    break;
                default:
                    view.unknownCommand();
                    break;
            }

        }

        view.displayExitBanner();
    }

    public int getMenuSelection() {
        int selection = view.menuSelection();
        return selection;
    }

    public void loadMachine() {
        try {
            service.loadMachine();
        } catch (VendingPersistenceException ex) {
            view.couldntLoadItems();
        }
    }

    public void getAllItems() {
        List<Item> itemList = service.getAllItemsInMachine();
        view.showInventory(itemList);
    }

    public BigDecimal getUserMoney() {
        String userInput = view.getUserMoneyInput();
        BigDecimal userBDInput = new BigDecimal(userInput);
        return userBDInput;
    }

    public Item getAnItem() {
        String SlotIDOfWantedItem = view.getAnItem();
        Item wantedItem = service.getOneItem(SlotIDOfWantedItem);
        return wantedItem;
    }

    public void sellAnItem(Item wantedItem, BigDecimal userInputedMoney) {
        boolean noErrors = true;
        BigDecimal itemCost = wantedItem.getCost();
        String wantedItemSlotID = wantedItem.getSlotID();
        do {
            try {
                ChangePurse change = service.purchaseItem(wantedItemSlotID, userInputedMoney);
                view.purchaseSucessful(wantedItem);
                view.giveChange(change);
                noErrors = true;
            } catch (VendingInsufficientFundsException ex) {
                noErrors = false;
                view.ShowVendingInsufficientFundsException(userInputedMoney, itemCost);
                String shouldContinue = view.keepGoing();
                if (shouldContinue.contains("coin") || shouldContinue.contains("return")) {
                    noErrors = true;
                    view.giveChange(new ChangePurse(userInputedMoney));
                } else {
                    String moneyAdded = view.userMoneyToAdd();
                    userInputedMoney = userInputedMoney.add(new BigDecimal(moneyAdded));
                }

            } catch (VendingNoItemInventoryException ex) {
                view.unknownItem();
            } catch (VendingPersistenceException ex) {
                view.couldntSave();
            }
        } while (!(noErrors));

    }

}
