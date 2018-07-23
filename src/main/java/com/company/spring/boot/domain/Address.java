/**
 * 
 */
package com.company.spring.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author NevinChen
 *
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private String id;
    private String country;
    private String province;
    private String city;
    @Column(name="detail_address")
    private String detailAddress;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * @return the detailAddress
     */
    public String getDetailAddress() {
        return detailAddress;
    }
    
    /**
     * @param detailAddress the detailAddress to set
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
