/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryService.ProductionModePersistenceException;

/**
 *
 * @author 19bgehrman
 */
public class FloorMasteryProductionDaoStubFileImpl implements ProductionDao{

    @Override
    public boolean getProductionMode() {
        return true;
    }

    @Override
    public void loadProductionMode() throws ProductionModePersistenceException {
        
    }
    
}
