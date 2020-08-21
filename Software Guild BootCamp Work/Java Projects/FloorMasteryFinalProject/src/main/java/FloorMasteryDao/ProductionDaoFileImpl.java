/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloorMasteryDao;

import FloorMasteryService.ProductionModePersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author 19bgehrman
 */
public class ProductionDaoFileImpl implements ProductionDao {

    private String productionMode = "Training";

    @Override
    public boolean getProductionMode() {
        boolean isInProductionMode;
        if (productionMode.equals("Training")) {
            isInProductionMode = false;
        } else {
            isInProductionMode = true;
        }
        return isInProductionMode;
    }

    @Override
    public void loadProductionMode() throws ProductionModePersistenceException {
        Scanner scanner;
        final String FILE_NAME = "Data/Mode.txt";

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILE_NAME)));
        } catch (FileNotFoundException ex) {
            throw new ProductionModePersistenceException("Could not load data from the file", ex);
        }
        String currentLine = scanner.nextLine();
        productionMode = unMarshallProductionMode(currentLine);

        scanner.close();
    }

    private String unMarshallProductionMode(String fileLine) {
        String DELIMITER = "::";
        String[] productionModeParts = fileLine.split(DELIMITER);
        String stringProductionMode = productionModeParts[1];
        return stringProductionMode;
    }
}
