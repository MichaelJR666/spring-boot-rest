/**
 * 
 */
package com.company.spring.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.spring.boot.dao.StoreRepository;
import com.company.spring.boot.domain.Store;

/**
 * @author NevinChen
 *
 */
@Service
public class StoreService {
    
    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);
    
    @Autowired
    private StoreRepository storeRepository;

	public Store createStore(Store store) {
	    if (storeRepository.findByStoreCode(store.getStoreCode()) != null) {
	        throw new ServiceException(ServiceException.ENTITY_CONFLICT_ERROR, "Store already exists.");
	    }
	    logger.debug("Create store {}.", store);
		return storeRepository.save(store);
	}
	
	public Store updateStore(Store store) {
	    if (storeRepository.findOne(store.getId()) == null) {
	        throw new ServiceException(ServiceException.ENTITY_NOT_FOUND_ERROR, "Store is not found.");
	    }
	    store.setLastModifiedTimestamps(System.currentTimeMillis());
	    logger.debug("Update store {}.", store);
	    return storeRepository.save(store);
	}
	
	public void deleteStore(long storeId) {
	    if (storeRepository.findOne(storeId) == null) {
            throw new ServiceException(ServiceException.ENTITY_NOT_FOUND_ERROR, "Store is not found.");
        }
	    logger.debug("Delete store by id {}.", storeId);
	    storeRepository.delete(storeId);
	}
	
	public Store getStore(long storeId) {
	    logger.debug("Get store {}.", storeId);
		return storeRepository.findOne(storeId);
	}
	
	public Page<Store> listStore(Pageable pageable) {
	    logger.debug("Query store by page {}.", pageable);
		return storeRepository.findAll(pageable);
	}
	
}
