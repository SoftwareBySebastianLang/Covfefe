package test;

import covfefe.*;

public class VoltageDividerTest {

	public static void main(String[] args) {
		
/*		VoltageDivider test = new VoltageDivider();
		InputParameter parameters = new InputParameter();
		int Wert = 0b000000000;
		int WertA = 0b0000000000;
		
		int e = 0;
		int var = 0;
		int varr = 0;
		
		for(int i = 0; i < 512; i++) {
			e = (int) (Wert & WertA);
			if (e == 1) {
				parameters.setRatio(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 2) {
				parameters.setTotalVoltage(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 4) {
				parameters.setVoltage1(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 8) {
				parameters.setVoltage2(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 16) {
				parameters.setTotalResistor(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 32) {
				parameters.setResistor1(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 64) {
				parameters.setResistor2(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 128) {
				parameters.setMinResistor1(true);
			}
			WertA = WertA << 1;
			e = (int) (Wert & WertA);
			if (e == 256) {
				parameters.setMinResistor2(true);
			}
			
			if(test.isValidInput(parameters) == true) {
				System.out.print(Wert + " ist " + test.isValidInput(parameters) + "  ");
				var++;
				binaerDarstellenVonBits(Wert);
			}
				int counterVoltage = 0;
				int counterResistor = 0;
				int counterMinResistor = 0;
				int counterRatio = 0;
				
				if(parameters.getTotalVoltage() == true) counterVoltage++;
				if(parameters.getVoltage1() == true) counterVoltage++;
				if(parameters.getVoltage2() == true) counterVoltage++;
				
				if(parameters.getTotalResistor() == true) counterResistor++;
				if(parameters.getResistor1() == true) counterResistor++;
				if(parameters.getResistor2() == true) counterResistor++;
				
				if(parameters.getMinResistor1() == true) counterMinResistor++;
				if(parameters.getMinResistor2() == true) counterMinResistor++;
				
				if(parameters.getRatio() == true) counterRatio++;

				if ((counterRatio==1 && counterVoltage==1 && counterResistor==0 && counterMinResistor==0)||
					(counterRatio==1 && counterVoltage==1 && counterResistor==1 && counterMinResistor==0)||
					(counterRatio==1 && counterVoltage==1 && counterResistor==0 && (counterMinResistor==1 || counterMinResistor==2))||
					(counterRatio==0 && counterVoltage==2 && counterResistor==0 && counterMinResistor==0)||
					(counterRatio==0 && counterVoltage==2 && counterResistor==1 && counterMinResistor==0)||
					(counterRatio==0 && counterVoltage==2 && counterResistor==0 && (counterMinResistor==1 || counterMinResistor==2))||
					(counterRatio==0 && counterVoltage==1 && counterResistor==2 && counterMinResistor==0)) {
					System.out.println("alles korrekt");
					varr++;
				}
				
				if(Wert == 488) {
					System.out.println(counterRatio + " "  + counterVoltage + " "  + counterResistor + " "  + counterMinResistor);
					if(parameters.getMinResistor1() == true) System.out.println("1");
					if(parameters.getMinResistor2() == true) System.out.println("2");
				}
				
			
				 counterVoltage = 0;
				 counterResistor = 0;
				 counterMinResistor = 0;
				 counterRatio = 0;
			WertA = 0b000000001;
			Wert++;
			parameters.setRatio(false);	
			parameters.setTotalVoltage(false);		
			parameters.setVoltage1(false);		
			parameters.setVoltage2(false);		
			parameters.setTotalResistor(false);			
			parameters.setResistor1(false);			
			parameters.setResistor2(false);			
			parameters.setMinResistor1(false);
			parameters.setMinResistor2(false);	
			
		}
		System.out.println(var);
		System.out.println(varr);*/

		//Test der Methode calculate Values, da mit den InputParameters gesichert ist das nur richtige Eingaben berechnet werden, werden nur diese überprüft
		
		VoltageDivider VD = new VoltageDivider();
		System.out.println(VD.toString());
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		
		
		
		InputParameter IP = new InputParameter();
		Voltage voltage = new Voltage();
		Voltage voltage1 = new Voltage();
		Resistance resistance = new Resistance();
		Resistance resistance1 = new Resistance();
		ESeriesTemplate EST = new ESeriesTemplate(24,5);
		Resistor resistor = new Resistor(resistance, EST);
		Resistor resistor1 = new Resistor(resistance1, EST);
		
		
		
		
		//1.: Ratio, 1 Voltage und kein Resistor gegeben
		System.out.println("1.1:");
		VD.setRatioResistor1toResistor2(5.0);
		IP.setRatio(true);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		�berpr�fen(VD, IP);
		IP.setVoltage1(false);
		
		System.out.println("1.2:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1, voltage);
		IP.setVoltage2(true);				
		�berpr�fen(VD, IP);
		IP.setVoltage2(false);
		
		System.out.println("1.3:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);				
		�berpr�fen(VD, IP);
		IP.setTotalVoltage(false);
		
		//2.: Ratio, 1 Voltage und 1 Resistor
		System.out.println("2.1:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		resistance.setValue(10);
		resistor.chooseResistor(resistance);
		IP.setResistor1(true);
		VD.setResistor(0, resistor);
		�berpr�fen(VD, IP);
		IP.setResistor1(false);
		
		System.out.println("2.2:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		resistance.setValue(2);
		resistor.chooseResistor(resistance);
		IP.setResistor2(true);
		VD.setResistor(1, resistor);
		�berpr�fen(VD, IP);
		IP.setResistor2(false);
		
		System.out.println("2.3:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		resistance.setValue(12);
		IP.setTotalResistor(true);
		VD.setTotalResistor(resistance);
		�berpr�fen(VD, IP);
		IP.setTotalResistor(false);
		IP.setVoltage1(false);
		
		System.out.println("2.4:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1 , voltage);
		IP.setVoltage2(true);
		resistance.setValue(10);
		resistor.chooseResistor(resistance);
		IP.setResistor1(true);
		VD.setResistor(0, resistor);
		�berpr�fen(VD, IP);
		IP.setResistor1(false);
		
		System.out.println("2.5:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1 , voltage);
		IP.setVoltage2(true);
		resistance.setValue(2);
		resistor.chooseResistor(resistance);
		IP.setResistor2(true);
		VD.setResistor(1, resistor);
		�berpr�fen(VD, IP);
		IP.setResistor2(false);
		
		System.out.println("2.6:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1 , voltage);
		IP.setVoltage2(true);
		resistance.setValue(12);
		IP.setTotalResistor(true);
		VD.setTotalResistor(resistance);
		�berpr�fen(VD, IP);
		IP.setTotalResistor(false);
		IP.setVoltage2(false);
		
		System.out.println("2.7:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);
		resistance.setValue(10);
		resistor.chooseResistor(resistance);
		IP.setResistor1(true);
		VD.setResistor(0, resistor);
		�berpr�fen(VD, IP);
		IP.setResistor1(false);
		
		System.out.println("2.8:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);
		resistance.setValue(2);
		resistor.chooseResistor(resistance);
		IP.setResistor2(true);
		VD.setResistor(1, resistor);
		�berpr�fen(VD, IP);
		IP.setResistor2(false);
		
		System.out.println("2.9:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);
		resistance.setValue(12);
		IP.setTotalResistor(true);
		VD.setTotalResistor(resistance);
		�berpr�fen(VD, IP);
		IP.setTotalResistor(false);
		IP.setTotalVoltage(false);
		
		//3.: Ratio, 1 Voltage und 1/2 Min Resistor
		System.out.println("3.1:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		resistance.setValue(10);
		IP.setMinResistor1(true);
		VD.setMinResistor(0, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor1(false);
		
		System.out.println("3.2:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		resistance.setValue(2);
		IP.setMinResistor2(true);
		VD.setMinResistor(1, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor2(false);
		
		System.out.println("3.3:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		resistance.setValue(10);
		IP.setMinResistor1(true);
		VD.setMinResistor(0, resistance);
		resistance.setValue(2);
		IP.setMinResistor2(true);
		VD.setMinResistor(1, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor1(false);
		IP.setMinResistor2(false);
		IP.setVoltage1(false);
		
		System.out.println("3.4:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1 , voltage);
		IP.setVoltage2(true);
		resistance.setValue(10);
		IP.setMinResistor1(true);
		VD.setMinResistor(0, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor1(false);
		
		System.out.println("3.5:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1 , voltage);
		IP.setVoltage2(true);
		resistance.setValue(2);
		IP.setMinResistor2(true);
		VD.setMinResistor(1, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor2(false);
		
		System.out.println("3.6:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(2.02);
		VD.setVoltage(1 , voltage);
		IP.setVoltage2(true);
		resistance.setValue(10);
		IP.setMinResistor1(true);
		VD.setMinResistor(0, resistance);
		resistance.setValue(2);
		IP.setMinResistor2(true);
		VD.setMinResistor(1, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor1(false);
		IP.setMinResistor2(false);
		IP.setVoltage2(false);
		
		System.out.println("3.7:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);
		resistance.setValue(10);
		IP.setMinResistor1(true);
		VD.setMinResistor(0, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor1(false);
		
		System.out.println("3.8:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);
		resistance.setValue(2);
		IP.setMinResistor2(true);
		VD.setMinResistor(1, resistance);
		�berpr�fen(VD, IP);
		IP.setMinResistor2(false);
		
		System.out.println("3.9:");
		VD = new VoltageDivider();
		VD.setRatioResistor1toResistor2(5.0);
		voltage.setValue(12.12);
		VD.setTotalVoltage(voltage);
		IP.setTotalVoltage(true);
		resistance.setValue(10);
		IP.setMinResistor1(true);
		VD.setMinResistor(0, resistance);
		resistance.setValue(2);
		IP.setMinResistor2(true);
		VD.setMinResistor(1, resistance);
		�berpr�fen(VD, IP);		
		
		IP = new InputParameter();
		//4. 2 Voltages kein Resistor
		System.out.println("4.1:");
		VD = new VoltageDivider();
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		voltage1.setValue(2.02);
		VD.setVoltage(1, voltage1);
		IP.setVoltage2(true);	
		�berpr�fen(VD, IP);
		IP.setVoltage1(false);
		IP.setVoltage2(false);
		
		System.out.println("4.2:");
		VD = new VoltageDivider();		
		voltage.setValue(2.02);
		VD.setVoltage(1, voltage);
		IP.setVoltage2(true);
		voltage1.setValue(12.12);
		VD.setTotalVoltage(voltage1);
		IP.setTotalVoltage(true);
		�berpr�fen(VD, IP);
		IP.setVoltage2(false);
		IP.setTotalVoltage(false);
		
		System.out.println("4.3:");
		VD = new VoltageDivider();
		voltage.setValue(10.1);
		VD.setVoltage(0 , voltage);
		IP.setVoltage1(true);
		voltage1.setValue(12.12);
		VD.setTotalVoltage(voltage1);
		IP.setTotalVoltage(true);				
		�berpr�fen(VD, IP);
		IP.setVoltage1(false);
		IP.setTotalVoltage(false);
		
		//5.: 2 Voltage und 1 Resistor
				System.out.println("5.1:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(2.02);
				VD.setVoltage(1, voltage1);
				IP.setVoltage2(true);
				resistance.setValue(10);
				resistor.chooseResistor(resistance);
				IP.setResistor1(true);
				VD.setResistor(0, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setVoltage2(false);
				IP.setResistor1(false);
				
				
				System.out.println("5.2:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				resistor.chooseResistor(resistance);
				IP.setResistor1(true);
				VD.setResistor(0, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalVoltage(false);
				IP.setResistor1(false);
				
				System.out.println("5.3:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				resistor.chooseResistor(resistance);
				IP.setResistor1(true);
				VD.setResistor(0, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalVoltage(false);
				IP.setResistor1(false);
				
				System.out.println("5.4:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(2.02);
				VD.setVoltage(1, voltage1);
				IP.setVoltage2(true);
				resistance.setValue(2);
				resistor.chooseResistor(resistance);
				IP.setResistor2(true);
				VD.setResistor(1, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setVoltage2(false);
				IP.setResistor2(false);
				
				System.out.println("5.5:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(2);
				resistor.chooseResistor(resistance);
				IP.setResistor2(true);
				VD.setResistor(1, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalVoltage(false);
				IP.setResistor2(false);
				
				System.out.println("5.6:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(2);
				resistor.chooseResistor(resistance);
				IP.setResistor2(true);
				VD.setResistor(1, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalVoltage(false);
				IP.setResistor2(false);
				
				System.out.println("5.7:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(2.02);
				VD.setVoltage(1, voltage1);
				IP.setVoltage2(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setVoltage2(false);
				IP.setTotalResistor(false);
				
				System.out.println("5.8:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalVoltage(false);
				IP.setTotalResistor(false);
				
				System.out.println("5.9:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalVoltage(false);
				IP.setTotalResistor(false);
				
				//6.: 2 Voltage und 1/2 MinResistor
				System.out.println("6.1:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(2.02);
				VD.setVoltage(1, voltage1);
				IP.setVoltage2(true);
				resistance.setValue(10);
				IP.setMinResistor1(true);
				VD.setMinResistor(0, resistance);
				VD.setResistor(0, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setVoltage2(false);
				IP.setMinResistor1(false);
				
				
				System.out.println("6.2:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				IP.setMinResistor1(true);
				VD.setMinResistor(0, resistance);
				VD.setResistor(0, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalVoltage(false);
				IP.setMinResistor1(false);
				
				System.out.println("6.3:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				IP.setMinResistor1(true);
				VD.setMinResistor(0, resistance);
				VD.setResistor(0, resistor);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalVoltage(false);
				IP.setMinResistor1(false);
				
				System.out.println("6.4:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(2.02);
				VD.setVoltage(1, voltage1);
				IP.setVoltage2(true);
				resistance.setValue(2);
				IP.setMinResistor2(true);
				VD.setMinResistor(1, resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setVoltage2(false);
				IP.setResistor2(false);
				
				System.out.println("6.5:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(2);
				IP.setMinResistor2(true);
				VD.setMinResistor(1, resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalVoltage(false);
				IP.setResistor2(false);
				
				System.out.println("6.6:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(2);
				IP.setMinResistor2(true);
				VD.setMinResistor(1, resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalVoltage(false);
				IP.setResistor2(false);
				
				System.out.println("6.7:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(2.02);
				VD.setVoltage(1, voltage1);
				IP.setVoltage2(true);
				resistance.setValue(10);
				IP.setMinResistor1(true);
				VD.setMinResistor(0, resistance);
				resistance.setValue(2);
				IP.setMinResistor2(true);
				VD.setMinResistor(1, resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setVoltage2(false);
				IP.setResistor1(false);
				IP.setResistor2(false);
				
				System.out.println("6.8:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				IP.setMinResistor1(true);
				VD.setMinResistor(0, resistance);
				resistance.setValue(2);
				IP.setMinResistor2(true);
				VD.setMinResistor(1, resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalVoltage(false);
				IP.setResistor1(false);
				IP.setResistor2(false);
				
				System.out.println("6.9:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);
				voltage1.setValue(12.12);
				VD.setTotalVoltage(voltage1);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				IP.setMinResistor1(true);
				VD.setMinResistor(0, resistance);
				resistance.setValue(2);
				IP.setMinResistor2(true);
				VD.setMinResistor(1, resistance);
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalVoltage(false);
				IP.setResistor1(false);
				IP.setResistor2(false);
				
				//7. 1 Voltage und 2 Resistoren
				System.out.println("7.1:");
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);				
				resistance.setValue(10);
				resistor.chooseResistor(resistance);
				IP.setResistor1(true);
				VD.setResistor(0, resistor);				
				resistance1.setValue(2);
				resistor1.chooseResistor(resistance1);
				IP.setResistor2(true);
				VD.setResistor(1, resistor1);					
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setResistor1(false);
				IP.setResistor2(false);				
				
				System.out.println("7.2:");
				VD = new VoltageDivider();				
				voltage.setValue(10.1);
				VD.setVoltage(0, voltage);
				IP.setVoltage1(true);				
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);				
				resistance1.setValue(2);
				resistor1.chooseResistor(resistance1);
				IP.setResistor2(true);
				VD.setResistor(1, resistor1);				
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalResistor(false);
				IP.setResistor2(false);
				
				System.out.println("7.3:");	
				VD = new VoltageDivider();
				voltage.setValue(10.1);
				VD.setVoltage(0 , voltage);
				IP.setVoltage1(true);				
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);				
				resistance1.setValue(10);
				resistor1.chooseResistor(resistance1);
				IP.setResistor1(true);
				VD.setResistor(0, resistor1);				
				�berpr�fen(VD, IP);
				IP.setVoltage1(false);
				IP.setTotalResistor(false);
				IP.setResistor1(false);		
				
				System.out.println("7.4:");
				VD = new VoltageDivider();				
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				resistance.setValue(10);
				resistor.chooseResistor(resistance);
				IP.setResistor1(true);
				VD.setResistor(0, resistor);		
				resistance1.setValue(2);
				resistor1.chooseResistor(resistance1);
				IP.setResistor2(true);
				VD.setResistor(1, resistor1);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setResistor1(false);
				IP.setResistor2(false);
				
				System.out.println("7.5:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);
				resistance1.setValue(2);
				resistor1.chooseResistor(resistance1);
				IP.setResistor2(true);
				VD.setResistor(1, resistor1);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalResistor(false);
				IP.setResistor2(false);
				
				System.out.println("7.6:");
				VD = new VoltageDivider();
				voltage.setValue(2.02);
				VD.setVoltage(1, voltage);
				IP.setVoltage2(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);				
				resistance1.setValue(10);
				resistor1.chooseResistor(resistance1);
				IP.setResistor1(true);
				VD.setResistor(0, resistor1);
				�berpr�fen(VD, IP);
				IP.setVoltage2(false);
				IP.setTotalResistor(false);
				IP.setResistor1(false);
				
				System.out.println("7.7:");
				VD = new VoltageDivider();
				voltage.setValue(12.12);
				VD.setTotalVoltage(voltage);
				IP.setTotalVoltage(true);
				resistance.setValue(10);
				resistor.chooseResistor(resistance);
				IP.setResistor1(true);
				VD.setResistor(0, resistor);				
				resistance1.setValue(2);
				resistor1.chooseResistor(resistance1);
				IP.setResistor2(true);
				VD.setResistor(1, resistor1);
				�berpr�fen(VD, IP);
				IP.setTotalVoltage(false);
				IP.setResistor1(false);
				IP.setResistor2(false);
				
				System.out.println("7.8:");
				VD = new VoltageDivider();
				VD = new VoltageDivider();
				voltage.setValue(12.12);
				VD.setTotalVoltage(voltage);
				IP.setTotalVoltage(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);				
				resistance1.setValue(2);
				resistor1.chooseResistor(resistance1);
				IP.setResistor2(true);
				VD.setResistor(1, resistor1);
				�berpr�fen(VD, IP);
				IP.setTotalVoltage(false);
				IP.setTotalResistor(false);
				IP.setResistor2(false);
				
				System.out.println("7.9:");
				VD = new VoltageDivider();
				VD = new VoltageDivider();
				voltage.setValue(12.12);
				VD.setTotalVoltage(voltage);
				IP.setTotalVoltage(true);
				resistance.setValue(12);
				IP.setTotalResistor(true);
				VD.setTotalResistor(resistance);				
				resistance1.setValue(10);
				resistor1.chooseResistor(resistance1);
				IP.setResistor1(true);
				VD.setResistor(0, resistor1);
				�berpr�fen(VD, IP);
				IP.setTotalVoltage(false);
				IP.setTotalResistor(false);
				IP.setResistor1(false);
	}

	private static void binaerDarstellenVonBits (int zahl) {		  
		  int maske = 0b000000001;
		  char[] bitfolge = new char[9];

		  for (int i = 0; i < 9; i++) 
		  {
		   bitfolge[8 - i] = (zahl & maske) == 0 ? '0' : '1';
		   maske = (int) (maske << 1);
		  }
		  System.out.println(bitfolge);
		 }	
	
	private static void �berpr�fen (VoltageDivider VD, InputParameter IP){	
		VD.isValidInput(IP);
		VD.calculateValues();
		if(roundToDecimals(VD.getRatioResistor1toResistor2(),2) != 5) System.out.println("Fehler 1");
		if(roundToDecimals(VD.getResistor(0).getResistance().getValue(),2) != 10) System.out.println("Fehler 2");
		if(roundToDecimals(VD.getResistor(1).getResistance().getValue(),2) != 2) System.out.println("Fehler 3");
		if(roundToDecimals(VD.getVoltage(0).getValue(),2) != 10.1) System.out.println("Fehler 4");
		if(roundToDecimals(VD.getVoltage(1).getValue(),2) != 2.02) System.out.println("Fehler 5");		
	}
	
	private static double roundToDecimals(double number, int decimal) {
		return (int)(number * Math.pow(10, decimal) + 0.5) / (double)Math.pow(10, decimal);  
	}
}