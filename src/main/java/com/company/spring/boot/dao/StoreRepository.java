/**
 * 
 */
package com.company.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.spring.boot.domain.Store;

/**
 * @author NevinChen
 *
 */
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByStoreCode(String storeCode);
    
}
