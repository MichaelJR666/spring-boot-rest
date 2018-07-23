/**
 * 
 */
package com.company.spring.boot.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author NevinChen
 *
 */
@Entity
@Table(name="store_owner")
public class StoreOwner {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy="storeOwner", fetch=FetchType.LAZY)
	private Set<Store> Stores = new HashSet<>();
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
	 * @return the stores
	 */
	public Set<Store> getStores() {
		return Stores;
	}
	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
}
