package com.ku.business.entity;

public class Storage {
    private Long id;
    private Integer quantity;
    private Company companyId;
    private Service serviceId;

    public Storage() {
    }

    public Storage(Long id, Integer quantity, Company companyId, Service serviceId) {
        this.id = id;
        this.quantity = quantity;
        this.companyId = companyId;
        this.serviceId = serviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        Storage aThat = (Storage) obj;
        if ((this.id==null && aThat.id != null) || (this.id != null && aThat.id == null)) {return false;}
        if ((this.quantity==null && aThat.quantity != null) || (this.quantity != null && aThat.quantity == null)) {return false;}
        if ((this.companyId==null && aThat.companyId != null) || (this.companyId != null && aThat.companyId == null)) {return false;}
        if ((this.serviceId==null && aThat.serviceId != null) || (this.serviceId != null && aThat.serviceId == null)) {return false;}
        return (((this.id == aThat.id) && (aThat.id == null)) || (this.id.equals(aThat.id))) &&
                (((this.quantity == aThat.quantity) && (aThat.quantity == null)) || (this.quantity.equals(aThat.quantity))) &&
                (((this.companyId == aThat.companyId) && (aThat.companyId == null)) || (this.companyId.equals(aThat.companyId))) &&
                (((this.serviceId == aThat.serviceId) && (aThat.serviceId == null)) || (this.serviceId.equals(aThat.serviceId)));
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (quantity == null ? 0 : quantity.hashCode());
        result = prime * result + (companyId.getId() == null ? 0 : companyId.hashCode());
        result = prime * result + (serviceId.getId() == null ? 0 : serviceId.hashCode());
        return result;
    }
    public String toString() {
        return this.getClass().getSimpleName() + " [" +
                "id=" + id +
                "quantity=" + quantity +
                ", companyId=" + companyId.toString() +
                ", serviceId=" + serviceId.toString() + "]";
    }
}
