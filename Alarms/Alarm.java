package Alarms;

import java.util.Scanner;

public class Alarm{
	private String type;
	private String resorce;
	private Integer alarmPorcentage;
	private Boolean highLow;
	private String email;
	private String module;
	private String memory;
	private String cpu;

	public Alarm() {
	}

	public Alarm(String type, String resorce, Integer alarmPorcentage, Integer threshold, String email, String module, String memory, String cpu) {
		this.type = type;
		this.resorce = resorce;
		this.alarmPorcentage = alarmPorcentage;
		this.threshold = threshold;
		this.email = email;
	}
	
	
	private void newMessage() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Module: ");
		this.module=scanner.nextLine();
		System.out.print("Memory porcentage used: ");
		this.memory=scanner.nextLine();
		System.out.print("Cpu porcentage used: ");
		this.cpu=scanner.nextLine();
		scanner.close();
		System.out.println("module: " + this.module);
		System.out.println("memory: " + this.memory);
		System.out.println("cpu: " + this.cpu);
	}


	private void settings() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------Settings-------\n");
		System.out.println("1. Type of alarm(Message, Mail, SMS)");
		System.out.println("2. Module");
		System.out.println("3. Resource if affects(CMU, memory or bouth)");
		System.out.println("4. Alarm triger porcentage");
		System.out.println("5. High or low(triger if above or below the porcentage)");
		System.out.println("6. Email");
		System.out.print("--->");
		String option=scanner.nextLine();
		System.out.println("---------");
		System.out.println("New value: ");
		switch(option){
			case "1":
				this.type=scanner.nextLine();
			break;
			case "2":
				this.module=scanner.nextLine();
			break;
			case "3":
				this.resorce=scanner.nextLine();
			break;
			case "4":
				this.alarmPorcentage=scanner.nextInt();
			break;
			case "5":
				this.highLow=scanner.nextBoolean();
			break;
			case "6":
				this.email=scanner.nextLine();
			break;
		}
		scanner.close();
	}
	public static void main(String[] args) {
		Alarm alarm = new Alarm();
		alarm.newMessage();
	}
}