/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.TaxInfo;
import FloorMasteryService.TaxInfoPersistenceException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryTaxInfoDaoStubFileImpl implements TaxInfoDao {

    String stateName = "Kentucky";
    String stateAbbreviation = "KY";
    BigDecimal taxRate = new BigDecimal("6.00");

    List<TaxInfo> taxList = new ArrayList<>();
    TaxInfo introTaxInfo;

    public FloorMasteryTaxInfoDaoStubFileImpl() {
        introTaxInfo = new TaxInfo(stateAbbreviation, stateName, taxRate);
        taxList.add(introTaxInfo);
    }

    @Override
    public TaxInfo addTaxInfo(TaxInfo taxInfo) {
        if (taxInfo.equals(introTaxInfo)) {
            return taxInfo;
        } else {
            return null;
        }
    }

    @Override
    public void editTaxInfo(String oldStateAbbriviation, TaxInfo newTaxInfo) {
        if (newTaxInfo.equals(introTaxInfo)) {

        } else {
            introTaxInfo.equals(newTaxInfo);
        }
    }

    @Override
    public TaxInfo getTaxInfo(String stateAbbriviation) {
        if (stateAbbriviation.equals(introTaxInfo.getStateAbbreviation())) {
            return introTaxInfo;
        } else {
            return null;
        }
    }

    @Override
    public List<TaxInfo> getAllOfTheTaxInfo() {
        return taxList;
    }

    @Override
    public TaxInfo removeTaxInfo(String stateAbbriviation) {
        if (stateAbbriviation.equals(introTaxInfo.getStateAbbreviation())) {
            return introTaxInfo;
        } else {
            return null;
        }
    }

    @Override
    public void loadAllTaxInfo() throws TaxInfoPersistenceException {
        
    }

    @Override
    public void saveAllTaxInfo() throws TaxInfoPersistenceException {
        
    }

}
