/**Viernes, 28 de abril 2017
 * Pruebas Unitarias de la Clase Predictor
 * Se indica casos de pruebas para validar el correcto funcionamiento del
 * programa realizado referente al Pico y Placa.
 */
package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.PicoPlaca;

/**
 * @author Ximena
 *
 */
public class PicoPlacaTest {
	
	/**
	 * Test metodo IdentificarDia
	 * resultadoReal 		7
	 * resultadoEsperado	7
	 */
	@Test
	public void testIdentificarDia1() {
		int resultadoReal=PicoPlaca.identificarDia("29/04/2017");
		int resultadoEsperado = 7;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * Test metodo IdentificarDia
	 * resultadoReal 		6
	 * resultadoEsperado	7
	 */
	@Test
	public void testIdentificarDia2() {
		int resultadoReal=PicoPlaca.identificarDia("28/04/2017");
		int resultadoEsperado = 7;
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Test metodo identificarUltimoDigito
	 * resultadoReal 		4
	 * resultadoEsperado	4
	 */
	@Test
	public void testIdentificarUltimoDigito1() {
		int resultadoReal = PicoPlaca.identificarUltimoDigito("AAN-1234");
		int resultadoEsperado= 4;
		assertEquals(resultadoEsperado, resultadoReal);
	}

	/**
	 * Test metodo identificarUltimoDigito
	 * resultadoReal 		10		El numero de placa esta incorrecto
	 * resultadoEsperado	4
	 */
	@Test
	public void testIdentificarUltimoDigito2() {
		int resultadoReal = PicoPlaca.identificarUltimoDigito("AAN-123");
		int resultadoEsperado= 3;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * Test metodo identificarUltimoDigito
	 * resultadoReal 		10		El numero de placa esta incorrecto
	 * resultadoEsperado	4
	 */
	@Test
	public void testIdentificarUltimoDigito3() {
		int resultadoReal = PicoPlaca.identificarUltimoDigito("AAN-12345");
		int resultadoEsperado= 5;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * Test metodo validarHora
	 * resultadoReal		true
	 * resultadoEsperado	true
	 */
	@Test
	public void testValidarHora1() {
		boolean resultadoReal=PicoPlaca.validarHora("08:47:00");
		boolean resultadoEsperado=true;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * Test metodo validarHora
	 * resultadoReal		false
	 * resultadoEsperado	true
	 */
	@Test
	public void testValidarHora2() {
		boolean resultadoReal=PicoPlaca.validarHora("09:31:00");
		boolean resultadoEsperado=true;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * Test metodo validarHora
	 * resultadoReal		false
	 * resultadoEsperado	true
	 */
	@Test
	public void testValidarHora3() {
		boolean resultadoReal=PicoPlaca.validarHora("15:59:59");
		boolean resultadoEsperado=true;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	/**
	 * Test metodo validarHora
	 * resultadoReal		true
	 * resultadoEsperado	true
	 */
	@Test
	public void testValidarHora4() {
		boolean resultadoReal=PicoPlaca.validarHora("18:54:00");
		boolean resultadoEsperado=true;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * testPermitirCirculacion1
	 * @param 6  Dia de la semana
	 * 		  0  Numero de placa
	 * 		  true esta dentro del horario de Pico y Placa
	 * @return true Para Viernes el Pico y Placa es para el 
	 * 				numero de placa 9 y 0
	 */
	@Test
	public void testPermitirCirculacion1() {
		Boolean resultadoReal=PicoPlaca.permitirCirculacion(6,0,true);
		Boolean resultadoEsperado=true;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	/**
	 * testPermitirCirculacion2
	 * @param 1  Dia de la semana
	 * 		  0  Numero de placa
	 * 		  true esta dentro del horario de Pico y Placa
	 * @return false Fin de semana no se aplica Pico y Placa
	 */
	@Test
	public void testPermitirCirculacion3() {
		Boolean resultadoReal=PicoPlaca.permitirCirculacion(1,0,true);
		Boolean resultadoEsperado=true;
		assertEquals(resultadoEsperado, resultadoReal);
	}
}
