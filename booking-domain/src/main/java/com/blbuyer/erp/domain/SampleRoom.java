package com.blbuyer.erp.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "sample_room")
public class SampleRoom{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String status;
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Id
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @PrePersist
    public void prePersist() {
        if ((this.id == null) || (this.id.equals(""))) {
            this.id = UUID.randomUUID().toString().replaceAll("-", "");
        }
    }
	
}
