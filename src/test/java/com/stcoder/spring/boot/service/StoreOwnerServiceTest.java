/**
 * 
 */
package com.stcoder.spring.boot.service;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.spring.boot.dao.StoreOwnerRepository;
import com.company.spring.boot.domain.StoreOwner;
import com.company.spring.boot.service.ServiceException;
import com.company.spring.boot.service.StoreOwnerService;

/**
 * @author NevinChen
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StoreOwnerServiceTest {

    @InjectMocks
    private StoreOwnerService storeOwnerService = new StoreOwnerService();
    
    @Mock
    private StoreOwnerRepository storeOwnerRepository;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void testCreateStoreOwnerWithNullInput() {
        expectedException.expect(ServiceException.class);
        expectedException.expectMessage("Store owner is null.");
        // It must execute the exception point after ExpectedException.
        storeOwnerService.createStoreOwner(null);
    }
    
    @Test
    public void testCreateStoreOwner() {
        StoreOwner storeOwner = new StoreOwner();
        storeOwner.setName("Tom");
        when(storeOwnerRepository.save(any(StoreOwner.class))).thenReturn(storeOwner);
        StoreOwner result = storeOwnerService.createStoreOwner(storeOwner);
        assertEquals("Store owner name", "Tom", result.getName());
    }
    
}
