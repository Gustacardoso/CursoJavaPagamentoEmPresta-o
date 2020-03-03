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
		
		System.out.print("Enter number of installment(informe o numero  de prestação): ");
		int n = sc.nextInt();
		//fizemos isso para pegar os serviços d paypal
		ContractService contractService = new ContractService(new Paypal());
		
		contractService.processContract(contract, n);
		
		System.out.println("Installments:(prestação): ");
	    //para cada prestação da lista x  mostras get das prestação
		for (Installment prestaçao : contract.getInstallments()) {
			System.out.println(prestaçao);
			
		}
		
		sc.close();

	}

}
