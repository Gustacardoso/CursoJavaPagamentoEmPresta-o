package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValeu;
	//instanciamos uma lista de prestacão
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
		
	}
	
	public Contract(Integer number, Date date, Double totalValeu) {
		this.number = number;
		this.date = date;
		this.totalValeu = totalValeu;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValeu() {
		return totalValeu;
	}

	public void setTotalValeu(Double totalValeu) {
		this.totalValeu = totalValeu;
	}
	
	public List<Installment> getInstallments(){
		return installments;
	}
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	
	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
	
	
	
	

}
