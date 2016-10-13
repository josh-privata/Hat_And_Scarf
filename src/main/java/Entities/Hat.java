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
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

/**
 * Creates Hat Subclass Object
 *
 * @author josh
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Hat extends Item implements Serializable {

    // Attributes
    public static final String HATS = "Hat.findAllHats";
    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(nullable = false)
    public String style;
    @NotNull
    @Column(nullable = false)
    public String colour;
    @NotNull
    @Column(nullable = false)
    public String hat_size;

    /**
     * Empty Constructor
     */
    public Hat() {
    }

    /**
     * Constructor with Data
     *
     * @param style
     * @param manufacturer
     * @param colour
     * @param item_name
     * @param size
     * @param description
     * @param item_price
     * @param item_qty
     * @param order_code
     */
    public Hat(String style, String colour, String size, String manufacturer,
            String item_name, String description,
            double item_price, int item_qty, int order_code) {
        super(manufacturer, item_name, description, item_price, item_qty, order_code);
        this.style = style;
        this.colour = colour;
        this.hat_size = size;
    }

    /**
     * Get and Set Methods
     *
     * @return
     */
    public String getStyle() {
        return style;
    }

    public void setStyle(String s) {
        this.style = s;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String c) {
        this.colour = c;
    }

    public String getSize() {
        return hat_size;
    }

    public void setSize(String s) {
        this.hat_size = s;
    }

    /**
     * ToString Override Method
     */
    @Override
    public String toString() {
        return String.format(
                "%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
                "Item ID: ", Long.toString(this.item_id),
                "Manufacturer: ", this.manufacturer,
                "Item Name: ", this.item_name,
                "Description: ", this.description,
                "Item Price: ", Double.toString(item_price),
                "Qty in Stock: ", Integer.toString(item_qty),
                "Order Code: ", Integer.toString(order_code),
                "Hat Style: ", this.style,
                "Hat Colour: ", this.colour,
                "Hat Size: ", this.hat_size);
    }
}
