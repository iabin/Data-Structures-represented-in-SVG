package mx.unam.ciencias.graficador;
import mx.unam.ciencias.edd.*;

/**
 * Clase que permite dibujar estructas de tipo
 *ArbolBinario
 */
public class ArbolSVG<T> implements ImprimeSVG{ 

    /** Atributo Interno*/
    ArbolBinario<T> arbol;
    

    /**
     * Constructor único que recibe un elemehnto.
     * @param arbol El arbolBinario que se desea imprimir
     */
    public ArbolSVG(ArbolBinario<T> arbol) {
	this.arbol=arbol;
	
    }
    
    /**Metodo privado Para permitir la recursion e inpresion del arbol*/
    private void imprimeRecursivo(Vector2D centro,int n,VerticeArbolBinario<T> vertice){
	CirculoSVG raiz = new CirculoSVG(25,centro,vertice.get().toString());
	
	
	int k = (int)(Math.pow(2,n)*(20));
	int minimo = centro.getX() + k;
	int minimo2 = centro.getX() - k;
		
	if(minimo-minimo2<50){ 
	    minimo = centro.getX() + 30;
	    minimo2 = centro.getX()-30;
	    
	}
	
	
	
	
	if(vertice.hayDerecho()){ 
	    int i = n-1;
	    VerticeArbolBinario<T> derecho = vertice.getDerecho();
	    Vector2D centroDerecho = new Vector2D(minimo,centro.getY()+150);
	    LineaSVG linea = new LineaSVG(centro,centroDerecho);
	    linea.imprimeSVG();
	    imprimeRecursivo(centroDerecho,i,derecho);
	    
	}

	if(vertice.hayIzquierdo()) {
	    int j = n-1;
	    VerticeArbolBinario<T> izquierdo = vertice.getIzquierdo();
	    Vector2D centroIzquierdo = new Vector2D(minimo2,centro.getY()+150);
	    LineaSVG linea = new LineaSVG(centro,centroIzquierdo);
	    linea.imprimeSVG();
	    imprimeRecursivo(centroIzquierdo,j,izquierdo);
	}
	
	
	raiz.imprimeSVG();
	
	
	
    } 
    
    /**
     * Metodo que SobreEscribe imprimeSVG de
     * la interfaz ImprimeSVG
     */
    @Override
    public void imprimeSVG(){
	VerticeArbolBinario<T> raiz = arbol.raiz();
  	int f = (int) (Math.pow(2, arbol.profundidad()) * 90);
  	imprimeRecursivo(new Vector2D(f/2,80),arbol.profundidad(),raiz);
    }
    
    
    
    

}
