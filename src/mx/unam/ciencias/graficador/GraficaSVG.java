package mx.unam.ciencias.graficador;
import mx.unam.ciencias.edd.*;

/**
 * Clase que Imprime una grafica en SVG
 */
public class GraficaSVG implements ImprimeSVG{
    /** Grafica interna a imprimir*/
    private Grafica<Integer> grafica;

    /**
     * Constructor Vacio, inicializa una grafica vacia
     */
    public GraficaSVG(){ 
	grafica = new Grafica<>();
    }

    /**
     * Constructor que recibe una grafica
     * @param grafica la Grafica recibida
     */
    public GraficaSVG(Grafica<Integer> grafica){
	this.grafica = grafica;
    }

    /**
     * Metodo privado que calcula puntos en el circulo unitario
     * @return Vector2D[] Arreglo de vectores2D con los centros
     */
    private Vector2D[] calculaCentros() {
	double argumento,radio,aux;
	int n = (2*(int)((grafica.getElementos()*50)/Math.PI)+50)/2;
	radio = (grafica.getElementos()*50)/Math.PI;
	argumento = aux = 2*Math.PI/grafica.getElementos();
	Vector2D[] centros = new Vector2D[grafica.getElementos()];
	int e = 0;
	for(Integer i:grafica){ 
	    centros[e] = new Vector2D((int)(radio*Math.cos(argumento)+n),(int)(radio*Math.sin(argumento))+n);
	    argumento = argumento + aux;
	    e++;
	}
	return centros;
    }


    /**
     * Imprime SVG imprime la estructura en SVG
     */
    @Override
    public void imprimeSVG(){ 
	Integer[] elementos = new Integer[grafica.getElementos()];
	int contador = 0;
	for(Integer i:grafica){ 
	    elementos[contador] = i;
	    contador++;
	}

	Vector2D[] centros = calculaCentros();
	//Imprime las aristas
	for(int i = 0;i<elementos.length;i++) {
	    VerticeGrafica<Integer> vertice = grafica.vertice(elementos[i]);
	    vertice.setColor(Color.ROJO);
	    for(VerticeGrafica<Integer> vecino:vertice.vecinos()) {
		if(vecino.getColor()!=Color.ROJO){ 
		    for(int j =0;j<elementos.length;j++){ 
			if(vecino.getElemento().equals(elementos[j])) {
			    LineaSVG line = new LineaSVG(centros[i],centros[j]);
			    line.imprimeSVG();
			}
		    }
		    
		}
		
	    }

	}
	//Imprime los circulos
	for(int i = 0;i<grafica.getElementos();i++){ 
	    CirculoSVG circle = new CirculoSVG(20,calculaCentros()[i],elementos[i].toString());
	    circle.imprimeSVG();
	    
	}
    }
    
    
    
}
