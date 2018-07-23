/**
 * 
 */
package com.company.spring.boot.controller.v1;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.company.spring.boot.controller.v1.dto.StoreDto;
import com.company.spring.boot.domain.Store;
import com.company.spring.boot.util.BeanMapper;

/**
 * @author NevinChen
 *
 */
@Component(value="storeConverter")
public class StoreConverter implements Converter<Store, StoreDto> {

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public StoreDto convert(Store store) {
        StoreDto storeDto = BeanMapper.map(store, StoreDto.class);
        storeDto.setCreateDate(new Date(store.getCreateTimestamps()));
        storeDto.setLastModifiedDate(new Date(store.getLastModifiedTimestamps()));
        if (store.getStoreOwner() != null) {
            storeDto.setStoreOwnerId(store.getStoreOwner().getId());
            storeDto.setStoreOwnerName(store.getStoreOwner().getName());
        }
        return storeDto;
    }

}
