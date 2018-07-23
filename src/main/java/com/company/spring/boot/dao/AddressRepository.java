/**
 * 
 */
package com.company.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.spring.boot.domain.Address;

/**
 * @author NevinChen
 *
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
