/**
 * 
 */
package com.company.spring.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.spring.boot.domain.StoreOwner;

/**
 * @author NevinChen
 *
 */
public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {

	List<StoreOwner> findByName(String name);
	
}
