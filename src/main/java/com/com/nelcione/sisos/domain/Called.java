package com.com.nelcione.sisos.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.com.nelcione.sisos.domain.enums.Priority;
import com.com.nelcione.sisos.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Called implements Serializable {	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate openingDate = LocalDate.now(); //data de abertura
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate cosingDate; //data de fechamento
	
	private Priority priority;
	private Status status;
	private String title;
	private String observation;
	
	@ManyToOne //muitos chamatos para um tecnico muitos para 1
	@JoinColumn(name = "technical_id")
	private Technical technical;
//	private Technical technical; // pode causar erro de serialização
	
	@ManyToOne // um cliente tem muitos chamados
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Called() {
		super();
	}

	public Called(Integer id, Priority priority, Status status, String title, String observation, Technical technical,
			Client client) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.observation = observation;
		this.technical = technical;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDate getCosingDate() {
		return cosingDate;
	}

	public void setCosingDate(LocalDate cosingDate) {
		this.cosingDate = cosingDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Technical getTechnical() {
		return technical;
	}

	public void setTechnical(Technical technical) {
		this.technical = technical;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Called other = (Called) obj;
		return Objects.equals(id, other.id);
	}
}
