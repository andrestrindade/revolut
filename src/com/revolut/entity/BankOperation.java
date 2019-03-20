package com.revolut.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "bank_operation")
public class BankOperation {
	
	@Column(name = "id_operation")
	@Id
	private Long id;
	
	@CreationTimestamp
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operation_timestamp")
	private Date operationTimestamp;
	
	@Column(name = "operation_value", nullable = false)
	private BigDecimal operationValue;
	
	@ManyToOne
	@JoinColumn(name = "fk_operation_type", insertable = false, nullable = false)
	private OperationType operationType;
	
	@ManyToMany
    @JoinColumn(name = "fk_id_account_from", insertable = false, nullable = false)
	private Account accountFrom;
	
	@ManyToMany
    @JoinColumn(name = "fk_id_account_to", insertable = false, nullable = false)
	private Account accountTo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOperationTimestamp() {
		return operationTimestamp;
	}

	public void setOperationTimestamp(Date operationTimestamp) {
		this.operationTimestamp = operationTimestamp;
	}

	public BigDecimal getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(BigDecimal operationValue) {
		this.operationValue = operationValue;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Account getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}

	public Account getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}
		
}
