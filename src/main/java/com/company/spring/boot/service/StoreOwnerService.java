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

import com.company.spring.boot.dao.StoreOwnerRepository;
import com.company.spring.boot.domain.StoreOwner;

/**
 * @author NevinChen
 *
 */
@Service
public class StoreOwnerService {
    
    private static final Logger logger = LoggerFactory.getLogger(StoreOwnerService.class);

    @Autowired
    private StoreOwnerRepository storeOwnerRepository;

    public StoreOwner createStoreOwner(StoreOwner storeOwner) {
        if (storeOwner == null) {
            throw new ServiceException(ServiceException.BAD_PARAMETER_ERROR, "Store owner is null.");
        }
        logger.debug("Create store owner {}.", storeOwner);
        return storeOwnerRepository.save(storeOwner);
    }

    public StoreOwner updateStoreOwner(StoreOwner storeOwner) {
        if (storeOwner == null) {
            throw new ServiceException(ServiceException.BAD_PARAMETER_ERROR, "Store owner is null.");
        }
        if (storeOwnerRepository.findOne(storeOwner.getId()) == null) {
            throw new ServiceException(ServiceException.ENTITY_NOT_FOUND_ERROR, "Store owner is not found.");
        }
        logger.debug("Update store owner {}.", storeOwner);
        return storeOwnerRepository.save(storeOwner);
    }

    public void deleteStoreOwner(long storeOwnerId) {
        if (storeOwnerRepository.findOne(storeOwnerId) == null) {
            throw new ServiceException(ServiceException.ENTITY_NOT_FOUND_ERROR, "Store owner is not found.");
        }
        logger.debug("Delete store owner by id {}.", storeOwnerId);
        storeOwnerRepository.delete(storeOwnerId);
    }

    public StoreOwner getStoreOwner(long storeOwnerId) {
        logger.debug("Get store owner by id {}.", storeOwnerId);
        return storeOwnerRepository.findOne(storeOwnerId);
    }

    public Page<StoreOwner> listStoreOwner(Pageable pageable) {
        logger.debug("Query store owner by page {}.", pageable);
        return storeOwnerRepository.findAll(pageable);
    }

}
