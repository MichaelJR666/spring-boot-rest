package com.company.spring.boot.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author NevinChen
 *
 */
@Entity
@Table(name="store")
public class Store {

	@Id
	@GeneratedValue
	private long id;
	@Column(name="store_code", unique=true)
	private String storeCode;
	private String name;
	@JoinColumn(name="address_id")
	@OneToOne(cascade=CascadeType.ALL, optional=true, fetch=FetchType.LAZY)
	private Address address;
	@Column(name="store_tier")
	private StoreTier storeTier;
	private StoreStatus status;
	@JoinColumn(name="store_owner_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private StoreOwner storeOwner;
	@Column(name="create_timestamp")
	private long createTimestamps;
	@Column(name="last_modified_timestamp")
	private long lastModifiedTimestamps;
	
	public Store() {
	    createTimestamps = System.currentTimeMillis();
	    lastModifiedTimestamps = createTimestamps;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
	 * @return the storeOwner
	 */
	public StoreOwner getStoreOwner() {
		return storeOwner;
	}
	
	/**
	 * @param storeOwner the storeOwner to set
	 */
	public void setStoreOwner(StoreOwner storeOwner) {
		this.storeOwner = storeOwner;
	}

	/**
	 * @return the createTimestamps
	 */
	public long getCreateTimestamps() {
		return createTimestamps;
	}

	/**
	 * @return the lastModifiedTimestamps
	 */
	public long getLastModifiedTimestamps() {
		return lastModifiedTimestamps;
	}
	
	/**
	 * @param lastModifiedTimestamps the lastModifiedTimestamps to set
	 */
	public void setLastModifiedTimestamps(long lastModifiedTimestamps) {
		this.lastModifiedTimestamps = lastModifiedTimestamps;
	}
	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
}
