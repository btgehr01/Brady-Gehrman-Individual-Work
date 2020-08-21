/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Llama.dao;

import Llama.dto.Llama;
import java.util.List;
import org.junit.Assert;

/**
 *
 * @author 19bgehrman
 */
public class LlamaDaoFileImplTest {
    
    public LlamaDaoFileImplTest() {
    }

    @org.junit.Test
    public void testSomeMethod() {
        //build the dao
        LlamaDao myTestDao;
        myTestDao = new LlamaDaoFileImpl();
        
        Llama llamaOne = new Llama();
        llamaOne.setId(1);
        Llama llamaTwo = new Llama();
        llamaTwo.setId(2);
        Llama llamaThree = new Llama();
        llamaThree.setId(3);
        
        myTestDao.addLlama(llamaOne);
         myTestDao.addLlama(llamaTwo);
          myTestDao.addLlama(llamaThree);
        
          //Now check it
          List<Llama> daoLlamas = myTestDao.getAllLlamas();
          Assert.assertEquals("There Should be three llamas!", 3, daoLlamas.size());
        
        
    }
    
}
