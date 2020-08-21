/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Llama.dao;

import Llama.dto.Llama;
import java.util.List;

/**
 *
 * @author 19bgehrman
 */
public interface LlamaDao {
    
public Llama addLlama(Llama llama); //C

public List<Llama> getAllLlamas(); //R

public Llama getLlama(int id);

public void editLlama(int id, Llama llama); //U

public Llama removeLlama(int id); //D

    
    
}
