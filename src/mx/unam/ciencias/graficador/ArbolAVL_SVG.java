package mx.unam.ciencias.graficador;
import mx.unam.ciencias.edd.*;

/**
 * Clase que permite dibujar estructas de tipo
 *ArbolAVL
 */
public class ArbolAVL_SVG implements ImprimeSVG{

    /** Atributo Interno*/
    private ArbolAVL<Integer> arbol;

    /**
     * Constructor único que recibe un elemento.
     * @param arbol El arbolAVL que se desea imprimir
     * */
    public ArbolAVL_SVG(ArbolAVL<Integer> arbol){
	this.arbol = arbol;
    }

    /**
     * Metodo que SobreEscribe imprimeSVG de
     * la interfaz ImprimeSVG
     */
    @Override
    public void imprimeSVG(){
	VerticeArbolBinario<Integer> raiz = arbol.raiz();
  	int f = (int) (Math.pow(2, arbol.profundidad()) * 90);
  	imprimeRecursivo(new Vector2D(f/2,80),arbol.profundidad(),raiz);
    }


    /**Metodo privado Para permitir la recursion e impresion del arbol*/
    private void imprimeRecursivo(Vector2D centro,int n,VerticeArbolBinario<Integer> vertice){
	ArbolAVL<Integer> arbol = new ArbolAVL<>();

	CirculoSVG raiz = new CirculoSVG(25,centro,vertice.get().toString());

	int altura = arbol.getAltura(vertice);
	int alturaDerecho=-1;
	int alturaIzquierdo=-1;
	int k = (int)(Math.pow(2,n)*(20));
	int minimo = centro.getX() +k;
	int minimo2 = centro.getX() - k;

	if(minimo-minimo2<50){
	    minimo = centro.getX() + 30;
	    minimo2 = centro.getX() -30;

	}

	if(vertice.hayDerecho()){
	    int i = n-1;
	    VerticeArbolBinario<Integer> derecho = vertice.getDerecho();
	    Vector2D centroDerecho = new Vector2D(minimo,centro.getY()+150);
	    LineaSVG linea = new LineaSVG(centro,centroDerecho);
	    linea.imprimeSVG();
	    alturaDerecho = arbol.getAltura(derecho);
	    imprimeRecursivo(centroDerecho,i,derecho);

	}

	if(vertice.hayIzquierdo()) {
	    int j = n-1;
	    VerticeArbolBinario<Integer> izquierdo = vertice.getIzquierdo();
	    Vector2D centroIzquierdo = new Vector2D(minimo2,centro.getY()+150);
	    LineaSVG linea = new LineaSVG(centro,centroIzquierdo);
	    alturaIzquierdo = arbol.getAltura(izquierdo);
	    linea.imprimeSVG();
	    imprimeRecursivo(centroIzquierdo,j,izquierdo);
	}

	raiz.imprimeSVG();
	String bal = Integer.toString(alturaIzquierdo-alturaDerecho);
	TextoSVG balance =  new TextoSVG(altura+
					 "/"+bal,15,new Vector2D(centro.getX()-38,centro.getY()));
	balance.imprimeSVG();
    }
}
