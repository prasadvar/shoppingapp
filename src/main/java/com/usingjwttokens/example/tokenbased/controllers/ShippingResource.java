package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.models.Profileuser;
import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.models.UserShipping;
import com.usingjwttokens.example.tokenbased.payload.response.MessageResponse;
import com.usingjwttokens.example.tokenbased.service.impl.UserShippingService;
import com.usingjwttokens.example.tokenbased.service.impl.UserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/shipping")
public class ShippingResource {
	@Autowired
	private UserrService userService;
	@Autowired
	private UserShippingService userShippingService;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> addNewUserShippingPost(
			@RequestBody UserShipping userShipping, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		userService.updateUserShipping(userShipping, user);
		return ResponseEntity.ok(new MessageResponse("Shipping Added(Updated) Successfully!"));
	}
	@RequestMapping("/getUserShippingList")
	public List<UserShipping> getUserShippingList(
			Principal principal
			){
		User user = userService.findByUsername(principal.getName());
		List<UserShipping> userShippingList = user.getUserShippingList();
		return userShippingList;
	}
	@RequestMapping("/default/{id}")
	public ResponseEntity<?> findme(@PathVariable(value = "id",required = false) String id, Principal principal)
	{
		User user = userService.findByUsername(principal.getName());
		userService.setUserDefaultShipping(Long.parseLong(id), user);
		return ResponseEntity.ok(new MessageResponse("default"));
	}
	@RequestMapping("username")
	public Profileuser findname(@PathVariable(value = "id",required = false) String id, Principal principal)
	{
		User user = userService.findByUsername(principal.getName());
		Profileuser profileuser=new Profileuser();
		profileuser.setEmail(user.getEmail());
		profileuser.setFirstname(user.getFirstname());
		profileuser.setUsername(user.getUsername());
		return profileuser;
	}
	@RequestMapping("/delete/{id}")
	public ResponseEntity<?> deleteme(@PathVariable(value = "id",required = false) String id, Principal principal)
	{
		User user = userService.findByUsername(principal.getName());
		userService.delete(Long.parseLong(id), user);
		return ResponseEntity.ok(new MessageResponse("deleted Shipping Successfully!"));
	}
}
