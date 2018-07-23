/**
 * 
 */
package com.company.spring.boot.controller.v1.dto;

/**
 * @author NevinChen
 *
 */
public class StoreOwnerDto {

    private long id;
    private String name;
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
