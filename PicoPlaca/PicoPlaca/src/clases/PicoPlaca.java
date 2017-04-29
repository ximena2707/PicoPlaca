/** Viernes, 28 de abril 2017
 * Clase que permite identificar si un auto
 * segun su numero de placa, la fecha y la hora
 * puede o no circular.
 */
package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Ximena
 *
 */
public class PicoPlaca  implements Serializable{

	private static final long serialVersionUID = -1185530430593455215L;
	
	private static String numeroPlaca;
	private static String fecha;
	private static String tiempo;
	private static Boolean respuesta;
	
	/**
	 * 	Constructor
	 */
	public PicoPlaca() {
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese el numero de placa: ");
		numeroPlaca= entrada.readLine();
		System.out.println("Ingrese la fecha (dd/mm/aaaa): ");
		fecha= entrada.readLine();
		System.out.println("Ingrese la hora (hh:mm): ");
		tiempo = entrada.readLine();
		System.out.println("\nLos datos ingresados son: \n\nPlaca numero: \t\t" + numeroPlaca +"\n" + 
		"Fecha: \t\t\t" + fecha +"\n" + "Hora: \t\t\t" + tiempo);
		permitirCirculacion(identificarDia(fecha),identificarUltimoDigito(numeroPlaca),validarHora(tiempo));
	}
	
	/**
	 * Metodo identificarDia
	 * 			permite identificar el dia de la semana
	 * @param 	fecha2 		es la fecha que se ingresa
	 * @return 	int  		el numero de la semana
	 * 		1 --> Domingo
	 * 		2 --> Lunes
	 * 		3 --> Martes
	 * 		4 --> Miercoles
	 * 		5 --> Jueves
	 * 		6 --> Viernes
	 * 		7 --> Sabado
	 */
	public static Integer identificarDia(String fecha2) {
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
		Date fecha=null;
		try{
			fecha=formato.parse(fecha2);
			GregorianCalendar calendario= new GregorianCalendar();
			calendario.setTime(fecha);
			return calendario.get(Calendar.DAY_OF_WEEK);						
		}
		catch(ParseException ex){
			ex.printStackTrace();
			return 0;
		}		
	}
	
	/**
	 * Metodo identificarUltimoDigito
	 * 			permite identificar el numero de la placa
	 * @param 	numero 		es el numero de placa completa
	 * @return 	int  		el ultimo digito de la placa
	 */
	public static Integer identificarUltimoDigito(String numero) {
		if(numero.length()==8)
		{			
			return Integer.parseInt(numero.substring(numero.length()-1,numero.length()));		
		}
		else
		{	
			System.out.println("El numero de placa ingresada es incorrecto");
			return 10;
		}		
	}
	
	/**
	 * Metodo validarHora
	 * 			permite identificar si esta dentro del rango de
	 * 			fechas establecidas
	 * @param 	tiempo2 	es la hora ingresada
	 * @return 	Boolean  	indica si esta o no esta dentro del 
	 * 						rango de fechas
	 */
	public static Boolean validarHora(String tiempo2) {
		SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
		Date horaDia=null;
		try {
			horaDia=(Date) formatoHora.parse(tiempo2);		    
		    GregorianCalendar calendario= new GregorianCalendar();
			calendario.setTime(horaDia);
			int hora=calendario.get(Calendar.HOUR_OF_DAY);
			int min=calendario.get(Calendar.MINUTE);
			int resultadoHora= ((hora*60) + min) * 60;
						
			if((resultadoHora>= 25200 && resultadoHora <= 34200) || (resultadoHora>=57600 && resultadoHora<= 68400)){
				return true;
			}
			else {
				return false;
			}		    
		} catch (ParseException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo permitirCirculacion
	 * 			permite validar si puede o no circular libremente
	 * @param 	identificarDia 				dia de la semana
	 * 			identificarUltimoDigito		Numero de la placa
	 * 			hora						hora
	 * @return 	Boolean  	indica si puede o no circular libremente
	 */
	public static Boolean permitirCirculacion(Integer identificarDia,
			Integer identificarUltimoDigito, Boolean hora) {
		if(identificarDia== 1 || identificarDia==7)
		{
			System.out.println("\nNo aplica Pico y Placa porque es fin de seamana.\nPuede circular libremente.");
			return false;
		}
		else if (identificarDia == 2 && (identificarUltimoDigito ==1 || identificarUltimoDigito==2)  && hora==true)
		{
			System.out.println("\nUsted esta en el horario de 'Pico y Placa'\nNo puede circular.\nGRACIAS");
			return true;
		}	
		else if (identificarDia == 3 && (identificarUltimoDigito ==3 || identificarUltimoDigito==4)  && hora==true)
		{
			System.out.println("\nUsted esta en el horario de 'Pico y Placa'\nNo puede circular.\nGRACIAS");
			return true;
		}	
		else if (identificarDia == 4 && (identificarUltimoDigito ==5 || identificarUltimoDigito==6)  && hora==true)
		{
			System.out.println("\nUsted esta en el horario de 'Pico y Placa'\nNo puede circular.\nGRACIAS");
			return true;
		}
		else if (identificarDia == 5 && (identificarUltimoDigito ==7 || identificarUltimoDigito==8) && hora==true)
		{
			System.out.println("\nUsted esta en el horario de 'Pico y Placa'\nNo puede circular.\nGRACIAS");
			return true;
		}
		else if (identificarDia == 6 && (identificarUltimoDigito ==9 || identificarUltimoDigito==0)  && hora==true)
		{
			System.out.println("\nUsted esta en el horario de 'Pico y Placa'\nNo puede circular.\nGRACIAS");
			return true;
		}
		else
		{
			System.out.println("Usted puede circular libremente");
			return false;
		}
	}
	/**
	 * @return the numeroPlaca
	 */
	public static String getNumeroPlaca() {
		return numeroPlaca;
	}

	/**
	 * @param numeroPlaca the numeroPlaca to set
	 */
	public static void setNumeroPlaca(String numeroPlaca) {
		PicoPlaca.numeroPlaca = numeroPlaca;
	}

	/**
	 * @return the fecha
	 */
	public static String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public static void setFecha(String fecha) {
		PicoPlaca.fecha = fecha;
	}

	/**
	 * @return the tiempo
	 */
	public static String getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public static void setTiempo(String tiempo) {
		PicoPlaca.tiempo = tiempo;
	}

	/**
	 * @return the respuesta
	 */
	public static Boolean getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public static void setRespuesta(Boolean respuesta) {
		PicoPlaca.respuesta = respuesta;
	}
}