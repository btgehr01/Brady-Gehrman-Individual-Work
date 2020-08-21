/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryDto.TaxInfo;
import FloorMasteryService.TaxInfoPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
public class TaxInfoDaoFileImpl implements TaxInfoDao{

    private final Map<String, TaxInfo> taxInfoMap = new HashMap<>();
    
    final String FILE;

    public TaxInfoDaoFileImpl(String fileName) {
        this.FILE = fileName;
    }

    public TaxInfoDaoFileImpl() {
        this.FILE = "Data/Taxes.txt";
    }
    
    @Override
    public TaxInfo addTaxInfo(TaxInfo taxInfo) {
       TaxInfo addedTaxInfo = taxInfoMap.put(taxInfo.getStateAbbreviation(), taxInfo);
       return addedTaxInfo;
    }

    @Override
    public void editTaxInfo(String oldStateAbbreviaton, TaxInfo newTaxInfo) {
        String newStateName = newTaxInfo.getStateAbbreviation();
        if (newStateName.equals(oldStateAbbreviaton)) {
            taxInfoMap.replace(oldStateAbbreviaton, newTaxInfo);
        } else {
            taxInfoMap.remove(oldStateAbbreviaton);

            taxInfoMap.put(newStateName, newTaxInfo);
        }
    }

    @Override
    public TaxInfo getTaxInfo(String stateAbbreviation) {
       TaxInfo gottenTaxInfo = taxInfoMap.get(stateAbbreviation);
       return gottenTaxInfo;
    }

    @Override
    public List<TaxInfo> getAllOfTheTaxInfo() {
        List<TaxInfo> taxInfoList = new ArrayList<>();
        Set<String> stateAbbreviation = taxInfoMap.keySet();
        for(String oneStateAbbreviation : stateAbbreviation){
            TaxInfo taxInfo = taxInfoMap.get(oneStateAbbreviation);
            taxInfoList.add(taxInfo);
        }
        return taxInfoList;
    }

    @Override
    public TaxInfo removeTaxInfo(String stateAbbreviation) {
        TaxInfo removedTaxInfo = taxInfoMap.remove(stateAbbreviation);
        return removedTaxInfo;
    }

    @Override
    public void loadAllTaxInfo() throws TaxInfoPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILE)));
        } catch (FileNotFoundException ex) {
            throw new TaxInfoPersistenceException("Could not load data from the file", ex);
        }
        String currentLine;
        scanner.nextLine(); //skips first line of file
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            TaxInfo retrivedTaxInfo = unMarshallTaxInfo(currentLine);
            taxInfoMap.put(retrivedTaxInfo.getStateAbbreviation(), retrivedTaxInfo);
        }
        scanner.close();
    }
    
    private TaxInfo unMarshallTaxInfo(String taxInfoAsString){
        TaxInfo unmarshallTaxInfo = new TaxInfo(); 
        String[] taxInfoParts = taxInfoAsString.split(",");
        //Abbreviation,State,TaxRate
        
        String stateAbbreviation= taxInfoParts[0];
        unmarshallTaxInfo.setStateAbbreviation(stateAbbreviation);
        
        String state = taxInfoParts[1];
        unmarshallTaxInfo.setStateName(state);
        
        String stringTaxRate = taxInfoParts[2];
        BigDecimal taxRate = new BigDecimal(stringTaxRate);
        unmarshallTaxInfo.setTaxRate(taxRate);
        
        return unmarshallTaxInfo;
    }

    @Override
    public void saveAllTaxInfo() throws TaxInfoPersistenceException {
        PrintWriter out;
        final String FILE_NAME = "Data/Taxes.txt";
        
        try {
            out = new PrintWriter(new FileWriter(FILE_NAME));
        } catch (IOException ex) {
            throw new TaxInfoPersistenceException("could not save TaxInfo Data", ex);
        }
        out.println("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");
        List<TaxInfo> taxInfoList = this.getAllOfTheTaxInfo();
        for (TaxInfo taxInfoToSave : taxInfoList) {
            String allTaxInfo = marshallTaxInfo(taxInfoToSave);
            out.println(allTaxInfo);
            out.flush();
        }
        out.close();
    }
    
    private String marshallTaxInfo(TaxInfo taxInfoToSave){
        final String COMA = ",";
        String allTaxInfo;
        
        //Abbreviation,State,TaxRate
        
        allTaxInfo = taxInfoToSave.getStateAbbreviation() + COMA;
        
        allTaxInfo += taxInfoToSave.getStateName() + COMA;
        
        allTaxInfo += taxInfoToSave.getTaxRate();
                
        return allTaxInfo;
        
    }
    
}
