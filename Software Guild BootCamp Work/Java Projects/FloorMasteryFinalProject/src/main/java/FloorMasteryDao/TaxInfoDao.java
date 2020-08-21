/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.TaxInfo;
import FloorMasteryService.TaxInfoPersistenceException;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface TaxInfoDao {
    public TaxInfo addTaxInfo(TaxInfo taxInfo);
    public void editTaxInfo(String oldStateAbbriviation, TaxInfo newTaxInfo);
    public TaxInfo getTaxInfo(String stateAbbriviation);
    public List<TaxInfo> getAllOfTheTaxInfo();
    public TaxInfo removeTaxInfo(String stateAbbriviation);
    public void loadAllTaxInfo() throws TaxInfoPersistenceException;
    public void saveAllTaxInfo() throws TaxInfoPersistenceException;
}
