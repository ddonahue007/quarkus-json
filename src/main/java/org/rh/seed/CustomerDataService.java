package org.rh.seed;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerDataService {
    private static CustomerDataService ourInstance = new CustomerDataService();

    public static CustomerDataService getInstance() {
        return ourInstance;
    }

    // For now just store contacts in memory.
    private static List<Contact> customerList = new ArrayList<>();

    public String addCustomer(Contact customer) {
        String newId =  UUID.randomUUID().toString();
        customer.setId(newId);
        customerList.add(customer);
        return newId;
    }

    public String deleteCustomer(String custId) {
        for(Contact cust : customerList) {
            if(cust.getId().equals(custId)) {
                customerList.remove(customerList.indexOf(cust));
                return "removed customer: " + custId;
            }
        }

        return "customer " + custId + " does not exists";
    }

    public List<Contact> getCustomerList() {
        return customerList;
    }

    public Contact getCustomerById(String id) {
        for (Contact customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }
}
