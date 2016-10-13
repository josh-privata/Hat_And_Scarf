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
import javax.validation.constraints.NotNull;

/**
 * Creates Scarf Subclass Object
 *
 * @author josh
 */
@Entity
public class Scarf extends Item implements Serializable {

    // Attributes
    public static final String SCARFS = "Scarf.findAllScarfs";
    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(nullable = false)
    private String style;
    @NotNull
    @Column(nullable = false)
    private String colour;
    @NotNull
    @Column(nullable = false)
    private String material;
    @NotNull
    @Column(nullable = false)
    private int s_length;

    /**
     * Empty Constructor
     */
    public Scarf() {
    }

    /**
     * Constructor with Data
     *
     * @param style
     * @param manufacturer
     * @param material
     * @param colour
     * @param item_name
     * @param length
     * @param description
     * @param item_price
     * @param item_qty
     * @param order_code
     */
    public Scarf(String style, String colour, String material, int length, String manufacturer, String item_name,
            String description, double item_price,
            int item_qty, int order_code) {
        super(manufacturer, item_name, description, item_price, item_qty, order_code);
        this.style = style;
        this.colour = colour;
        this.material = material;
        this.s_length = length;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String m) {
        this.material = m;
    }

    public int getS_length() {
        return s_length;
    }

    public void setS_length(int l) {
        this.s_length = l;
    }

    /**
     * ToString Override Method
     */
    @Override
    public String toString() {
        return String.format(
                "%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
                "Item ID: ", Long.toString(this.item_id),
                "Manufacturer: ", this.manufacturer,
                "Item Name: ", this.item_name,
                "Description: ", this.description,
                "Item Price: ", Double.toString(item_price),
                "Qty in Stock: ", Integer.toString(item_qty),
                "Order Code: ", Integer.toString(order_code),
                "Scarf Style: ", this.style,
                "Scarf Colour: ", this.colour,
                "Material: ", this.material,
                "Scarf Length: ", Integer.toString(s_length)
        );
    }

}
