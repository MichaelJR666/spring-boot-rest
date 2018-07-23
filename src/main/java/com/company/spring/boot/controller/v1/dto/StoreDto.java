package com.company.spring.boot.controller.v1.dto;

import java.util.Date;

import com.company.spring.boot.domain.Address;
import com.company.spring.boot.domain.StoreStatus;
import com.company.spring.boot.domain.StoreTier;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author NevinChen
 *
 */
public class StoreDto {

	private long id;
	private String storeCode;
	private String name;
	private Address address;
	private StoreTier storeTier;
	private StoreStatus status;
	private long storeOwnerId;
	private String storeOwnerName;
	private Date createDate;
	private Date lastModifiedDate;
	
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
     * @return the storeCode
     */
    public String getStoreCode() {
        return storeCode;
    }
    
    /**
     * @param storeCode the storeCode to set
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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
    
    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }
    
    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
    /**
     * @return the storeTier
     */
    public StoreTier getStoreTier() {
        return storeTier;
    }
    
    /**
     * @param storeTier the storeTier to set
     */
    public void setStoreTier(StoreTier storeTier) {
        this.storeTier = storeTier;
    }
    
    /**
     * @return the status
     */
    public StoreStatus getStatus() {
        return status;
    }
    
    /**
     * @param status the status to set
     */
    public void setStatus(StoreStatus status) {
        this.status = status;
    }
    
    /**
     * @return the storeOwnerId
     */
    public long getStoreOwnerId() {
        return storeOwnerId;
    }
    
    /**
     * @param storeOwnerId the storeOwnerId to set
     */
    public void setStoreOwnerId(long storeOwnerId) {
        this.storeOwnerId = storeOwnerId;
    }
    
    /**
     * @return the storeOwnerName
     */
    public String getStoreOwnerName() {
        return storeOwnerName;
    }
    
    /**
     * @param storeOwnerName the storeOwnerName to set
     */
    public void setStoreOwnerName(String storeOwnerName) {
        this.storeOwnerName = storeOwnerName;
    }
    
    /**
     * @return the createDate
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getCreateDate() {
        return createDate;
    }
    
    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    /**
     * @return the lastModifiedDate
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    
    /**
     * @param lastModifiedDate the lastModifiedDate to set
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
	
}
