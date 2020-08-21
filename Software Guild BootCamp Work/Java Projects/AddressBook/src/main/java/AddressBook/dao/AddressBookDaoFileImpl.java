/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.dao;

import AddressBook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 19bgehrman
 */
public class AddressBookDaoFileImpl implements AddressDao {

    public static final String ROSTER_FILE = "Address.txt";
    public static final String DELIMITER = "::";

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String fullName, Address address) 
        throws AddressDaoException {
        loadAddresses();
        Address newAddress = addresses.put(fullName, address);
        writeAddresses();
        return newAddress;
    }

    @Override
    public Address removeAddress(String fullName)
            throws AddressDaoException {
        loadAddresses();
        Address removedAddress = addresses.remove(fullName);
        writeAddresses();
        return removedAddress;
    }

    @Override
    public Address getAddress(String fullName)
            throws AddressDaoException {
        loadAddresses();
        Address gottenAddress = addresses.get(fullName);
        return gottenAddress;
    }

    @Override
    public int getCount() 
        throws AddressDaoException {
        loadAddresses();
        int size = addresses.size();
        return size;
    }

    @Override
    public List<Address> getAllAddresses()
            throws AddressDaoException {
        List<Address> listOfAddresses = new ArrayList<>();
        loadAddresses();
        Set<String> keys = addresses.keySet();
        for (String fullName : keys) {
            Address correspondingAddress = addresses.get(fullName);
            listOfAddresses.add(correspondingAddress);
        }
        return listOfAddresses;
    }

    @Override
    public void editAddress(String oldName, Address address)
        throws AddressDaoException{
        String fullName = address.getFullName();
        if (fullName == oldName) {
            addresses.replace(fullName, address);
            this.writeAddresses();
            
        } else {
            //oh no the ids are diffrent
            //remove the old one and put in the new one
            addresses.remove(oldName);
            //store it under a new box
            addresses.put(fullName, address);
            this.writeAddresses();
        }
    }

        Scanner scanner;
    private void loadAddresses() throws AddressDaoException {

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressDaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            Address currentAddress = unmarshallAddress(currentLine);

            addresses.put(currentAddress.getFullName(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    private void writeAddresses() throws AddressDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new AddressDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // write the Address object to the file
            String AddressAsText = marshallAddress(currentAddress);
            // write the Address object to the file
            out.println(AddressAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    private String marshallAddress(Address address) {
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 
        // Start with the student id, since that's supposed to be first.
        String addressAsText = address.getFirstName() + DELIMITER;

        // add the rest of the properties in the correct order:
        

        // LastName
        addressAsText += address.getLastName() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        addressAsText += address.getState() + DELIMITER;

        addressAsText += address.getCity() + DELIMITER;

        addressAsText += address.getStreetAddress() + DELIMITER;

        addressAsText += address.getZipcode();

        // We have now turned a student to text! Return it!
        return addressAsText;

    }

    private Address unmarshallAddress(String addressFromFile) {

        String[] addressTokens = addressFromFile.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Address addressesFromFile = new Address();

        // However, there are 6 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.
        // Index 1 - FirstName
        addressesFromFile.setFirstName(addressTokens[0]);

        // Index 2 - LastName
        addressesFromFile.setLastName(addressTokens[1]);

        // Index 3 - State
        addressesFromFile.setState(addressTokens[2]);
        //city
        addressesFromFile.setCity(addressTokens[3]);
        //street
        addressesFromFile.setStreetAddress(addressTokens[4]);
        //zipcode
        addressesFromFile.setZipcode(addressTokens[5]);

        // We have now created a student! Return it!
        return addressesFromFile;
    }
}

/*String firstName = correspondingAddress.getFirstName();
        String lastName = correspondingAddress.getLastName();
        String wholeName = correspondingAddress.getFullName(firstName, lastName);
        String streetAddress = correspondingAddress.getStreetAddress();
        String city = correspondingAddress.getCity();
        String zipCode = correspondingAddress.getZipcode();
 */
