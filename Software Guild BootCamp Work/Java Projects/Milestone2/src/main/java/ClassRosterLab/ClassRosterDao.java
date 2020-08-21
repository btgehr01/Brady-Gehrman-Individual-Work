/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRosterLab;

/**
 *
 * @author 19bgehrman
 */
public interface ClassRosterDao {
    
}
//This interface defines the methods that must be implemented by any class that 
//wants to play the role of DAO in the application.  We will implement a text 
//file-based DAO in the code-along.  You could imagine, however, an implementation 
//that only stored student data in memory, or one that stored student data in a database.  
//Each class would be different but all would implement that same interface, 
//ensuring that they are all well encapsulated.  Note that the ClassRosterController 
//only uses this interface to reference the DAO — it is completely unaware of the 
//implementation details.