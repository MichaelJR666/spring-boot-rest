/**
 * 
 */
package com.company.spring.boot.controller.v1;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.company.spring.boot.controller.v1.dto.StoreOwnerDto;
import com.company.spring.boot.domain.StoreOwner;
import com.company.spring.boot.service.ServiceException;
import com.company.spring.boot.service.StoreOwnerService;
import com.company.spring.boot.util.BeanMapper;

/**
 * @author NevinChen
 *
 */
@RestController
@RequestMapping(value = StoreOwnerController.STORE_OWNER_PATH)
public class StoreOwnerController {
    
    public static final String STORE_OWNER_PATH = "/api/v1/storeOwners";

	@Autowired
	private StoreOwnerService storeOwnerService;

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> createStoreOwner(@RequestBody StoreOwnerDto storeOwnerDto, UriComponentsBuilder uriComponentsBuilder) {
	    StoreOwner storeOwner = BeanMapper.map(storeOwnerDto, StoreOwner.class);
	    StoreOwner createdStoreOwner = storeOwnerService.createStoreOwner(storeOwner);
		URI location = uriComponentsBuilder.path(STORE_OWNER_PATH + "/{id}").buildAndExpand(createdStoreOwner.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StoreOwnerDto> updateStoreOwner(@PathVariable("id") Long id, @RequestBody StoreOwnerDto storeOwnerDto) {
		StoreOwner storeOwner = storeOwnerService.getStoreOwner(id);
		if (storeOwner == null) {
			return ResponseEntity.notFound().build();
		}
		if (id != storeOwnerDto.getId()) {
            throw new ServiceException(ServiceException.BAD_PARAMETER_ERROR, "Id in request body doesn't equal to the one in the path.");
        }
		BeanMapper.map(storeOwnerDto, storeOwner);
		StoreOwner updatedStoreOwner = storeOwnerService.updateStoreOwner(storeOwner);
		return ResponseEntity.ok(BeanMapper.map(updatedStoreOwner, StoreOwnerDto.class));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStoreOwner(@PathVariable("id") Long id) {
	    storeOwnerService.deleteStoreOwner(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StoreOwnerDto> getStoreOwner(@PathVariable("id") Long id) {
		StoreOwner storeOwner = storeOwnerService.getStoreOwner(id);
		if (storeOwner == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(BeanMapper.map(storeOwner, StoreOwnerDto.class));
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<StoreOwnerDto>> listStoreOwner(
            @PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		Page<StoreOwner> page = storeOwnerService.listStoreOwner(pageable);
		if (page.hasContent()) {
		    return ResponseEntity.ok(page.map(storeOwner -> BeanMapper.map(storeOwner, StoreOwnerDto.class)));
		} else {
		    return ResponseEntity.noContent().build();
		}
	}
	
}
