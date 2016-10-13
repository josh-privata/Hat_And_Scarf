/*
 * Copyright (c) 2015, josh
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package Beans;

import Beans.utility.Messanger;
import Entities.Hat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 * Managed Bean for Hat Entity
 *
 * @author josh
 */
@Named("hatController")
@SessionScoped
public class HatController implements Serializable {

    String search = ""; // Used as search string
    private List<Hat> s = new ArrayList(); // Search results
    private Hat hat;
    @EJB
    private HatProducer producer;

    // Constructor
    public HatController() {
    }

    // Initialize Hat
    public void initializeHat() {
        hat = new Hat();
    }

    // Get Producer
    private HatProducer getProducer() {
        return producer;
    }

    // Get Hat
    public Hat getSelected() {
        if (hat == null) {
            hat = new Hat();
        }
        return hat;
    }

    // Clear list of Hats s
    public void clearS() {
        this.s.clear();
    }

    // get Seach string
    public String getSearch() {
        return search;
    }

    // Set Search string
    public void setSearch(String search) {
        this.search = search;
    }

    // Get list of Hats s
    public List<Hat> getS() {
        return s;
    }

    // Set list of Hats s
    public void setS(List<Hat> s) {
        this.s = s;
    }

    // Find Hat by item_name
    public void findName() {
        s = producer.findName(search);
    }

    // Find All
    public List<Hat> findAll() {
        return producer.findAll();
    }

    // Find Hat
    public void findHat() {
        hat = producer.find(hat.getId());
    }

    // Persist Hat
    public String persistHat() {
        try {
            getProducer().create(hat);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemCreated"));
            initializeHat();
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Update Hat
    public String updateHat() {
        try {
            getProducer().edit(hat);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemUpdated"));
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Delete Hat 
    public String deleteHat() {
        hat = getSelected();
        try {
            getProducer().remove(hat);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemDeleted"));
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return "List";
    }

}
