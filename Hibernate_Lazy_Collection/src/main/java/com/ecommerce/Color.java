package com.ecommerce;

public class Color {
    private long COLORID;
    private String name;
    
    public Color() {
            
    }
    public Color(String name) {
            this.COLORID = 0;
            this.name = name;
    }
    
    public long getCOLORID() {return this.COLORID; }
    public String getName() { return this.name;}
    public void setCOLORID(long id) { this.COLORID = id;}
    public void setName(String name) { this.name = name;}
    
    
}


Step 3.6.5: Creating a class EProduct
●	In the Project Explorer, expand HibernateLazyCollections->Java Resources
●	Right click on src and choose New->Class
●	In Package, enter com.ecommerce and in Name enter EProduct and click on Finish
●	Enter the following code:
package com.ecommerce;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Map;


public class EProduct {
    private long ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;
    private List<Color> colors;
    private Set<Finance> finance;
    private PDescription pdescrip;
    
    public EProduct() {
            
    }
    
    public long getID() {return this.ID; }
    public String getName() { return this.name;}
    public BigDecimal getPrice() { return this.price;}
    public Date getDateAdded() { return this.dateAdded;}
    public List<Color> getColors() { return this.colors;}
    public Set<Finance> getFinance() { return this.finance;}
    public PDescription getPdescrip() { return this.pdescrip;}
    
    public void setID(long id) { this.ID = id;}
    public void setName(String name) { this.name = name;}
    public void setPrice(BigDecimal price) { this.price = price;}
    public void setDateAdded(Date date) { this.dateAdded = date;}
    public void setColors(List<Color> colors) { this.colors = colors;}
    public void setFinance(Set<Finance> finance) { this.finance = finance;}
    public void setPdescrip(PDescription pdescrip) { this.pdescrip = pdescrip;}
}

