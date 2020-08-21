/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface DVDDao {

    public DVD addDVD(String title, DVD a)
            throws DVDDaoException;

    public DVD removeDVD(String title)
            throws DVDDaoException;

    public void editDVD(String oldtitle, DVD newDVD)
            throws DVDDaoException;

    public List<String> getAllDVDs()
            throws DVDDaoException;

    public DVD getDVD(String title)
            throws DVDDaoException;
    public List<DVD> getAllDVDsOutOfMap()
            throws DVDDaoException;

}
