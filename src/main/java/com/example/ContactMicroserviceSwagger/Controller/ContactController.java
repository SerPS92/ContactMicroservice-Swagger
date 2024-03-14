package com.example.ContactMicroserviceSwagger.Controller;


import com.example.ContactMicroserviceSwagger.Model.Contact;
import com.example.ContactMicroserviceSwagger.Service.IContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Contacts CRUD")
public class ContactController {

    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @ApiOperation(value = "Return the list of contacts", response = List.class)
    @GetMapping(value = "contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> show(){
        return contactService.findAll();
    }

    @ApiOperation(value = "Return a contact by id", response = Contact.class)
    @GetMapping(value = "contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact show(@ApiParam(value = "Contact id", required = true)
                            @PathVariable(name = "id") int id){
        return contactService.showContact(id);
    }

    @ApiOperation(value = "Add a contact received in the request body")
    @PostMapping(value = "contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String addContact(@ApiParam(value = "JSON object to add", required = true)@RequestBody Contact contact){
        return String.valueOf(contactService.addContact(contact));
    }

    @ApiOperation(value = "Update a contact received in request body")
    @PutMapping(value = "contacts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@ApiParam(value = "JSON object to update", required = true)@RequestBody Contact contact){
        contactService.updateContact(contact);
    }

    @ApiOperation(value = "Delete a contact by id")
    @DeleteMapping(value = "contacts/{id}")
    public void deleteById(@ApiParam(value = "Contact id to delete", required = true) @PathVariable(name = "id") int id){
        contactService.deleteContact(id);
    }

}
