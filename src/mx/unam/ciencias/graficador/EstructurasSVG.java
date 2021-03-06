package mx.unam.ciencias.graficador;
import mx.unam.ciencias.edd.*;

/**
 *Clase que dibuja las estructuras de datos en SVG;
 * @param <T> El tipo de que contendra la estructura
 */
public final class EstructurasSVG<T>{

    /**
     * Imprime el monticulo minimo en SVG
     * @param arbol Monticulo minimo de enteros, se le asocia su mismo numero
     *              como parametro del indexable
     */
    public void monticuloMinimoSVG(MonticuloMinimo<Indexable<Integer>> arbol){
	ArbolBinarioCompleto<Integer> g = new ArbolBinarioCompleto<>();
	while(!arbol.esVacio()){ 
	    g.agrega(arbol.elimina().getElemento());
	}
	arbolBinarioSVG(g);
    }

    /**
     *Imprime ARREGLO ROJINEGRO en SVG
     * @param arreglo Arreglo de enteros que imprime usando SVG
     */
    //LA ESTRUCTURA MAS EPICA DEL UNIVERSO
    public void arregloRojinegroSVG(Integer[] arreglo){
	String color = "red";
	int n = 0;
	for(Integer elemento:arreglo){ 
	    String texto = elemento.toString();
	    String aux = color;
	    RectanguloSVG ang = new RectanguloSVG(45,20,new Vector2D(n+45,20),texto,color);
		    
	    double ran = Math.random()*100;
	    if(ran>50&&!
	       color.equals("red")){ 
		color = "red";
	    }else{ 

		color = "black";
	    }
		    
	    n = n+45;	
	    ang.imprimeSVG(); 
		    
	} 
    }

    /**
     *Imprime el arbolAVL dado en SVG
     * @param arbol ArbolAVL de enteros
     */
    public void arbolAVL_SVG(ArbolAVL<Integer> arbol){
	ArbolAVL_SVG ar = new ArbolAVL_SVG(arbol);
	ar.imprimeSVG();
    }

    /**
     *Imprime el ArbolRojoNegro de enteros en SVG
     * @param arbol ArbolRojoNegro a imprimir
     */
    public void arbolRojinegroSVG(ArbolRojinegro<Integer> arbol){ 
	ArbolRojinegroSVG ar = new ArbolRojinegroSVG(arbol);
	ar.imprimeSVG();
    }

    /**
     * Imprime un ArbolBinario de enteros en la SVG
     * @param arbol ArbolBinario a imprimir
     */
    public void arbolBinarioSVG(ArbolBinario<Integer> arbol){ 
	ArbolSVG<Integer> h =  new ArbolSVG<Integer>(arbol);
	h.imprimeSVG();
	    
    }


    /**
     *Imprime en SVG una pila o una cola
     * @return int Regresa 1 si el metodo se ejecuto correctamente
     * @param meteSaca Metesaca a imprimir en SVG
     */
    public int meteSacaSVG(MeteSaca<T> meteSaca) {
	RectanguloSVG aux = new RectanguloSVG(45,20,new Vector2D(195,20));
	Vector2D v = aux.getIzquierdo();
	int n = 0;
	while(!meteSaca.esVacia()){ 
	    String texto = meteSaca.saca().toString();
	    RectanguloSVG ang = new RectanguloSVG(45,20,new Vector2D(195,n+20),texto);
	    aux = ang;
	    n = n+20;	
	    RectanguloSVG primero =  new RectanguloSVG(80,30,new Vector2D(55,20),"Siguiente en salir","cyan");
	    Flecha flecha = new Flecha(new Vector2D(45,20),v);
	    flecha.imprimeSVG();
	    primero.imprimeSVG();
	    
	    ang.imprimeSVG();
	    
	}
	return 1;
    }

    /**
     * Imprime una Lista en SVG
     * @return int Regresa 1 si el metodo se ejecuto correctamente
     * @param lista a Imprimir en SVG
     */
    public int listaSVG(Lista<T> lista) {
	
	RectanguloSVG aux = new RectanguloSVG(45,20,new Vector2D(45,20));
	int n = 0;
	int i = 0;
	for(T elemento:lista){ 
	    String texto = elemento.toString();
	    RectanguloSVG ang = new RectanguloSVG(45,20,new Vector2D(n+96,20),texto);
	    Flecha fl = new Flecha(aux.getDerecho(),ang.getIzquierdo());
	    aux=ang;
	    i++;
	    if(i!=1&&i<lista.getElementos()+1)
      		fl.imprimeSVG();
	    
	    
	    n = n+75;	
	    ang.imprimeSVG();
	    
	    
	}
	return 1;
	
    }
}
