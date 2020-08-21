/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface AddressDao {
//create
public Address addAddress(String fullName, Address a)
throws AddressDaoException;
//adds an address give a fullName and an Address object

public Address removeAddress(String fullName)
throws AddressDaoException;
//removes an address that is stores in the map addresses when given the fullName (key)
public Address getAddress(String fullName)
throws AddressDaoException;
//an address is shown when the user gives theie fullName
public int getCount()
throws AddressDaoException;
//the user recieves how many addresses are in the address book/database
public List<Address> getAllAddresses()
throws AddressDaoException;
//the user can see all of the addresses in the address book at one time
public void editAddress(String fullName, Address address)
throws AddressDaoException;

}

