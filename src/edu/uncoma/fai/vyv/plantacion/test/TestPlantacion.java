package edu.uncoma.fai.vyv.plantacion.test;


import static org.junit.Assert.*;

import org.junit.Test;

import edu.uncoma.fai.vyv.plantacion.Plantacion;

public class TestPlantacion {

	/*
	 * Esta clase tiene como objetivo testear las funcionalidades y comportamientos basicps que deben proveer
	 * los metodos de la clase Plantacion.
	 * 
	 * */
	@Test
	public void test() {
		
		Plantacion p = new Plantacion();
		
		p.addCultivos(4);
		assertTrue("Los cultivos no se pueden añadir de a mas de 3 a la vez", p.getCultivos() == 0);
		assertTrue("Los cultivos no se pueden añadir de a mas de 3 a la vez. Metros Ocupados deberian ser 0 y es "+p.getMetrosOcupados(), p.getMetrosOcupados()== 0);
		
		p.addCultivos(-1);
		assertTrue("No se pueden ingresar cultivos menores a 0 ", p.getCultivos() == 0);
		assertTrue("No se pueden ingresar cultivos menores a 0 . Metros Ocupados deberian ser 0 y es "+p.getMetrosOcupados(), p.getMetrosOcupados()== 0);
		
		
		p.deleteCultivos(1);
		assertTrue("No se pueden quitar mas cultivos de los que se tienen ", p.getCultivos() == 0);
		assertTrue("No se pueden quitar mas cultivos de los que se tienen . Metros Ocupados deberian ser 0 y es "+p.getMetrosOcupados(), p.getMetrosOcupados()== 0);
		
		
		p.addCultivos(3);
		p.addCultivos(1);
		p.deleteCultivos(4);
		assertTrue("No se pueden quitar de a mas de 3 cultivos ", p.getCultivos() == 4);
		assertTrue("No se pueden quitar de a mas de 3 cultivos. Metros Ocupados deberian ser 8000 y es "+p.getMetrosOcupados(), p.getMetrosOcupados()== 8000);
		
		p.deleteCultivos(-1);
		assertTrue("No se pueden quitar cantidad negativa de cultivos ", p.getCultivos() == 4);
		assertTrue("No se pueden quitar de a mas de 3 cultivos. Metros Ocupados deberian ser 8000 y es "+p.getMetrosOcupados(), p.getMetrosOcupados()== 8000);
		
		double valorViejo = p.getMetrosTotales();
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser:  "+ valorViejo + 2000, p.getMetrosTotales() == valorViejo + 2000);
		
		p.deleteParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser:  "+ valorViejo , p.getMetrosTotales() == valorViejo);
		
		double valorViejo2 = p.getMetrosTotales();
		p.addParcela(Plantacion.PARCELA_MEDIANA);
		assertTrue("Debe ser:  "+ valorViejo2 + 4000, p.getMetrosTotales() == valorViejo2 + 4000);
		
		p.deleteParcela(Plantacion.PARCELA_MEDIANA);
		assertTrue("Debe ser:  "+ valorViejo2 , p.getMetrosTotales() == valorViejo2);
		
		double valorViejo3 = p.getMetrosTotales();
		p.addParcela(Plantacion.PARCELA_GRANDE);
		assertTrue("Debe ser:  "+ valorViejo3 + 5000, p.getMetrosTotales() == valorViejo3 + 5000);
		
		p.deleteParcela(Plantacion.PARCELA_GRANDE);
		assertTrue("Debe ser:  "+ valorViejo3 , p.getMetrosTotales() == valorViejo3);
		
		//En los siguientes metodos se encontraron errores:
		//p.addParcela(123);
		assertTrue("No se puede agregar cualquier tipo de parcela. Deberia tener 8000 metros y tengo "+p.getMetrosTotales(), p.getMetrosTotales() == 8000);
		assertTrue("No se puede agregar cualquier tipo de parcela. Deberia tener 2 y tengo "+p.getParcelas(), p.getParcelas() == 2);
	
		//p.addParcela(-1);
		assertTrue("No se puede agregar una parcela como un numero negativo. Deberia tener 8000 metros y tengo "+p.getMetrosTotales(), p.getMetrosTotales() == 8000);
		assertTrue("No se puede agregar una parcela como un numero negativo. Deberia tener 2 y tengo "+p.getParcelas(), p.getParcelas() == 2);
	
		//p.deleteParcela(123);
		assertTrue("No se puede agregar cualquier tipo de parcela. Deberia tener 8000 metros y tengo "+p.getMetrosTotales(), p.getMetrosTotales() == 8000);
		assertTrue("No se puede agregar cualquier tipo de parcela. Deberia tener 2 y tengo "+p.getParcelas(), p.getParcelas() == 2);
			
		//p.deleteParcela(-1);
		assertTrue("No se puede agregar una parcela como un numero negativo. Deberia tener 8000 metros y tengo "+p.getMetrosTotales(), p.getMetrosTotales() == 8000);
		assertTrue("No se puede agregar una parcela como un numero negativo. Deberia tener 2 y tengo "+p.getParcelas(), p.getParcelas() == 2);
			
	}
	
	

}
