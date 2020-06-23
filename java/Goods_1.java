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
@Table(name = "goods", catalog = "trade", schema = "")
@NamedQueries({
    @NamedQuery(name = "Goods_1.findAll", query = "SELECT g FROM Goods_1 g")
    , @NamedQuery(name = "Goods_1.findByGoodName", query = "SELECT g FROM Goods_1 g WHERE g.goodName = :goodName")
    , @NamedQuery(name = "Goods_1.findByQuantity", query = "SELECT g FROM Goods_1 g WHERE g.quantity = :quantity")
    , @NamedQuery(name = "Goods_1.findByExportingCountry", query = "SELECT g FROM Goods_1 g WHERE g.exportingCountry = :exportingCountry")
    , @NamedQuery(name = "Goods_1.findByExportingNo", query = "SELECT g FROM Goods_1 g WHERE g.exportingNo = :exportingNo")})
public class Goods_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "good_name")
    private String goodName;
    @Basic(optional = false)
    @Column(name = "quantity")
    private String quantity;
    @Basic(optional = false)
    @Column(name = "exporting_country")
    private String exportingCountry;
    @Id
    @Basic(optional = false)
    @Column(name = "exporting_no")
    private String exportingNo;

    public Goods_1() {
    }

    public Goods_1(String exportingNo) {
        this.exportingNo = exportingNo;
    }

    public Goods_1(String exportingNo, String goodName, String quantity, String exportingCountry) {
        this.exportingNo = exportingNo;
        this.goodName = goodName;
        this.quantity = quantity;
        this.exportingCountry = exportingCountry;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        String oldGoodName = this.goodName;
        this.goodName = goodName;
        changeSupport.firePropertyChange("goodName", oldGoodName, goodName);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public String getExportingCountry() {
        return exportingCountry;
    }

    public void setExportingCountry(String exportingCountry) {
        String oldExportingCountry = this.exportingCountry;
        this.exportingCountry = exportingCountry;
        changeSupport.firePropertyChange("exportingCountry", oldExportingCountry, exportingCountry);
    }

    public String getExportingNo() {
        return exportingNo;
    }

    public void setExportingNo(String exportingNo) {
        String oldExportingNo = this.exportingNo;
        this.exportingNo = exportingNo;
        changeSupport.firePropertyChange("exportingNo", oldExportingNo, exportingNo);
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
        if (!(object instanceof Goods_1)) {
            return false;
        }
        Goods_1 other = (Goods_1) object;
        if ((this.exportingNo == null && other.exportingNo != null) || (this.exportingNo != null && !this.exportingNo.equals(other.exportingNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "foreign_trade.Goods_1[ exportingNo=" + exportingNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
