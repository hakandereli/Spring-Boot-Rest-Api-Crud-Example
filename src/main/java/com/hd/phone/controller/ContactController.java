package com.hd.phone.controller;

import com.hd.phone.model.Contact;
import com.hd.phone.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    //List
    @GetMapping(path = "/findAll")
    public List<Contact> findAllContact() {
        return contactService.findAllContact();
    }

    //Add
    @PostMapping(path = "/save")
    public Contact saveContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    //Delete
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(OK);
    }

    //Update
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact currentContact, @PathVariable Long id) {
        return contactService.updateContact(currentContact , id);
    }

}
