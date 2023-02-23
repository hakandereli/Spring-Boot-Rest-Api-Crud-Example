package com.hd.phone.service;

import com.hd.phone.exceptions.ResourceNotFoundException;
import com.hd.phone.model.Contact;
import com.hd.phone.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> findAllContact() {
        return (List<Contact>) contactRepository.findAll();
    }

    public ResponseEntity<Contact> updateContact(Contact currentContact, Long id) {

        Contact updateContact = contactRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id: " + id));

        updateContact.setName(currentContact.getName());
        updateContact.setNumber(currentContact.getNumber());

        contactRepository.save(updateContact);

        return ResponseEntity.ok(updateContact);

    }

}
