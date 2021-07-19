package com.ctsousa.stoom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctsousa.stoom.assembler.AddressAssembler;
import com.ctsousa.stoom.assembler.AddressDisassembler;
import com.ctsousa.stoom.controller.dto.AddressDto;
import com.ctsousa.stoom.controller.input.AddressInput;
import com.ctsousa.stoom.entity.Address;
import com.ctsousa.stoom.exception.AddressNotFoundException;
import com.ctsousa.stoom.exception.BusinessException;
import com.ctsousa.stoom.service.AddressService;

@RestController
@RequestMapping("/v1/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressAssembler addressAssembler;
	
	@Autowired
	private AddressDisassembler addressDisassembler;
	
	@GetMapping
	public List<AddressDto> listAll() {
		return addressAssembler.to(addressService.searchAll());
	}
	
	@GetMapping("/{id}")
	public AddressDto searchById(@PathVariable Long id) {
		return addressAssembler.to(addressService.searchById(id));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public AddressDto add(@RequestBody @Valid AddressInput addressInput) {
		Address address = addressDisassembler.toAddress(addressInput);
		return addressAssembler.to(addressService.save(address));
	}
	
	@PutMapping("/{id}")
	public AddressDto update(@PathVariable Long id, @RequestBody @Valid AddressInput addressInput) {
		try {
			addressService.exist(id);
			Address address = addressDisassembler.toAddress(addressInput);
			address.setId(id);
			
			return addressAssembler.to(addressService.save(address));
		}
		catch(AddressNotFoundException e) {
			throw new BusinessException(e.getMessage(), e);
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		addressService.remove(id);
	}	
}
