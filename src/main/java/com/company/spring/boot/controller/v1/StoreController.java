/**
 * 
 */
package com.company.spring.boot.controller.v1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.spring.boot.controller.v1.dto.StoreDto;
import com.company.spring.boot.domain.Store;
import com.company.spring.boot.service.ServiceException;
import com.company.spring.boot.service.StoreService;
import com.company.spring.boot.util.BeanMapper;

/**
 * @author NevinChen
 *
 */
@RestController
@RequestMapping(value = StoreController.STORE_PATH)
public class StoreController {

    public static final String STORE_PATH = "/api/v1/stores";

    @Autowired
    private StoreService storeService;

    @Autowired
    @Qualifier("storeConverter")
    private Converter<Store, StoreDto> converter;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> createStore(@RequestBody StoreDto storeDto, UriComponentsBuilder uriComponentsBuilder) {
        Store store = BeanMapper.map(storeDto, Store.class);
        Store createdStore = storeService.createStore(store);
        URI location = uriComponentsBuilder.path(STORE_PATH + "/{id}").buildAndExpand(createdStore.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<StoreDto> updateStore(@PathVariable("id") Long id, @RequestBody StoreDto storeDto) {
        Store store = storeService.getStore(id);
        if (store == null) {
            return ResponseEntity.notFound().build();
        }
        if (id != storeDto.getId()) {
            throw new ServiceException(ServiceException.BAD_PARAMETER_ERROR, "Id in request body doesn't equal to the one in the path.");
        }
        BeanMapper.map(storeDto, store);
        storeService.updateStore(store);
        return ResponseEntity.ok(converter.convert(store));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable("id") Long id) {
        Store store = storeService.getStore(id);
        if (store == null) {
            return ResponseEntity.notFound().build();
        }
        storeService.deleteStore(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<StoreDto> getStore(@PathVariable("id") Long id) {
        Store store = storeService.getStore(id);
        if (store == null) {
            return ResponseEntity.notFound().build();
        }
        StoreDto storeDto = converter.convert(store);
        if (store.getStoreOwner() != null) {
            storeDto.setStoreOwnerId(store.getStoreOwner().getId());
            storeDto.setStoreOwnerName(store.getStoreOwner().getName());
        }
        return ResponseEntity.ok(storeDto);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<StoreDto>> listStore(
            @PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Store> page = storeService.listStore(pageable);
        if (page.hasContent()) {
            return ResponseEntity.ok(page.map(converter));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
