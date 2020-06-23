/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreign_trade;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author super
 */
@Entity
@Table(name = "confirmed_orders", catalog = "trade", schema = "")
@NamedQueries({
    @NamedQuery(name = "ConfirmedOrders.findAll", query = "SELECT c FROM ConfirmedOrders c")
    , @NamedQuery(name = "ConfirmedOrders.findByGoodName", query = "SELECT c FROM ConfirmedOrders c WHERE c.goodName = :goodName")
    , @NamedQuery(name = "ConfirmedOrders.findByCountry", query = "SELECT c FROM ConfirmedOrders c WHERE c.country = :country")
    , @NamedQuery(name = "ConfirmedOrders.findByQuantity", query = "SELECT c FROM ConfirmedOrders c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "ConfirmedOrders.findByExportingNo", query = "SELECT c FROM ConfirmedOrders c WHERE c.exportingNo = :exportingNo")
    , @NamedQuery(name = "ConfirmedOrders.findByUsername", query = "SELECT c FROM ConfirmedOrders c WHERE c.username = :username")})
public class ConfirmedOrders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "good_name")
    private String goodName;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Id
    @Basic(optional = false)
    @Column(name = "exporting_no")
    private String exportingNo;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    public ConfirmedOrders() {
    }

    public ConfirmedOrders(String exportingNo) {
        this.exportingNo = exportingNo;
    }

    public ConfirmedOrders(String exportingNo, String goodName, String country, int quantity, String username) {
        this.exportingNo = exportingNo;
        this.goodName = goodName;
        this.country = country;
        this.quantity = quantity;
        this.username = username;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        String oldGoodName = this.goodName;
        this.goodName = goodName;
        changeSupport.firePropertyChange("goodName", oldGoodName, goodName);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        changeSupport.firePropertyChange("country", oldCountry, country);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getExportingNo() {
        return exportingNo;
    }

    public void setExportingNo(String exportingNo) {
        String oldExportingNo = this.exportingNo;
        this.exportingNo = exportingNo;
        changeSupport.firePropertyChange("exportingNo", oldExportingNo, exportingNo);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exportingNo != null ? exportingNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfirmedOrders)) {
            return false;
        }
        ConfirmedOrders other = (ConfirmedOrders) object;
        if ((this.exportingNo == null && other.exportingNo != null) || (this.exportingNo != null && !this.exportingNo.equals(other.exportingNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "foreign_trade.ConfirmedOrders[ exportingNo=" + exportingNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
