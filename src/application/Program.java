package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.Paypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date dd/MM/yyyy: ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract valeu: ");
		double totalValue = sc.nextDouble();
		
		// agora vamos mandar os atributos para o contruct da classe
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installment(informe o numero  de presta��o): ");
		int n = sc.nextInt();
		//fizemos isso para pegar os servi�os d paypal
		ContractService contractService = new ContractService(new Paypal());
		
		contractService.processContract(contract, n);
		
		System.out.println("Installments:(presta��o): ");
	    //para cada presta��o da lista x  mostras get das presta��o
		for (Installment presta�ao : contract.getInstallments()) {
			System.out.println(presta�ao);
			
		}
		
		sc.close();

	}

}
