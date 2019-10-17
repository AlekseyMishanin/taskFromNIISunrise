package com.phonebook.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private ApplicationHeart applicationHeart;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {

//		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		System.out.println("Доступные команды:\n" +
//				"addUser \'username\' \'phone\' .... \'phone\'\n" +
//				"addPhone \'username\' \'phone\'\n" +
//				"deleteUser \'username\' \n" +
//				"deletePhoneUser \'username\' \'phone\'\n"+
//				"printAll\n" +
//				"exportXML\n" +
//				"exit\n\n");
//
//		while(true){
//			System.out.print("Введите команду: ");
//			String strCmd = buf.readLine();
//			String[] arrArg = strCmd.split(" ");
//			try {
//				switch (arrArg[0]){
//					case "addUser":{
//						sb.setLength(0);
//						for (int i = 2; i < arrArg.length; i++) {
//							sb.append(arrArg[i]);
//							if((i+1)!=arrArg.length) sb.append(", ");
//						}
//						applicationHeart.addUser(arrArg[1], sb.toString());
//						System.out.println("OK");
//						break;
//					}
//					case "addPhone":{
//						applicationHeart.addPhoneToUser(arrArg[1], arrArg[2]);
//						System.out.println("OK");
//						break;
//					}
//					case "deleteUser":{
//						applicationHeart.deleteUser(arrArg[1]);
//						System.out.println("OK");
//						break;
//					}
//					case "deletePhoneUser":{
//						applicationHeart.deletePhoneUser(arrArg[1], arrArg[2]);
//						System.out.println("OK");
//						break;
//					}
//					case "exportXML":{
//						applicationHeart.saveAllUsersToXml();
//						System.out.println("OK");
//						break;
//					}
//					case "printAll":{
//						applicationHeart.findAll().forEach(o->System.out.println(o));
//						System.out.println("OK");
//						break;
//					}
//					case "exit":{
//						System.out.println("Good luck");
//						return;
//					}
//					default:{
//						throw new Exception();
//					}
//				}
//			} catch (Exception e){
//				System.out.println("Некорректная команда или аргумент");
//			}
//		}
	}
}
