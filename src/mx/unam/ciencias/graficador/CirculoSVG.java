package mx.unam.ciencias.graficador;
import mx.unam.ciencias.edd.Color;

/**
 * Clase que Modela e imprime un circulo en SVG
 */
public class CirculoSVG extends DibujaSVG{ 
    private int radio;
    private TextoSVG texto;
    private Color color;

    /**
     * Constructor Vacio, genera un circulo de radio 0
     * en el origen, sin color.
     */
    public CirculoSVG() {
	color = Color.NINGUNO;
	radio  = 0;
	centro = new Vector2D();
	texto = new TextoSVG();
    }


    /**
     * Inicializa el circulo en el centro dado, con el radio dado
     * @param radio el radio del circulo
     * @param centro el centro del Circulo
     */
    public CirculoSVG(int radio,Vector2D centro) {
	this.radio = radio;
	this.centro = centro;
	this.texto = new TextoSVG();
	this.color = Color.NINGUNO;
    }


    /**
     * Inicializa el circulo con los elementos dados, y un color asignado,
     * puede ser negro o rojo.
     * @param radio el radio del circulo
     * @param centro el centro del circulo
     * @param texto	el texto dentro del criculo
     * @param color	el color del circulo
     */
    public CirculoSVG(int radio,Vector2D centro,String texto,Color color) {
	this.centro = centro;
	this.radio = radio;
	this.color = color;
	if(color==Color.NINGUNO) {
	    this.texto = texto.length()<7 ?  new TextoSVG(texto,radio,new Vector2D(centro.getX(),centro.getY()+radio/6)) :
		new TextoSVG(texto,radio/3,new Vector2D(centro.getX(),centro.getY()+radio/8)); //If line, para reescalar el texto dentro del rectangulo
	} else { 
	    this.texto = texto.length()<7 ?  new TextoSVG(texto,radio,new Vector2D(centro.getX(),centro.getY()+radio/6),"white") :
		new TextoSVG(texto,radio/3,new Vector2D(centro.getX(),centro.getY()+radio/8),"white"); //If line, para reescalar el texto dentro del rectangulo
	    
	}
    }

    /**
     * Constructor, que genera un circulo con String en el medio
     * @param radio el radio del circulo
     * @param centro el centro del circulo
     * @param texto el contenido en string del circulo
     */
    public CirculoSVG(int radio,Vector2D centro,String texto) {
	this.centro = centro;
	this.radio = radio;
	this.color = Color.NINGUNO;
	this.texto = texto.length()<7 ?  new TextoSVG(texto,radio,new Vector2D(centro.getX(),centro.getY()+radio/6)) :
	    new TextoSVG(texto,radio/2,new Vector2D(centro.getX(),centro.getY()+radio/8)); //If line, para reescalar el texto dentro del rectangulo
    }
    
    
    /**
     *Regresa el lado izquierdo del rectangulo
     *@return Vector2D el izquerdo del rectangulo
     */
    @Override
    public Vector2D getIzquierdo(){
    	return new Vector2D(centro.getX()-radio,centro.getY());

    }
    
    
    /**
     *Regresa el lado derecho del rectangulo
     * @return Vector2D el derecho del rectangulo
     */
    @Override
    public Vector2D getDerecho() {
	return new Vector2D(centro.getX()+radio,centro.getY());

    }


    /**
     * ImprimeSVG, implementado de la interfaz, ImprimeSVG
     * Imprime en la entrada Standard la representacion en SVG
     */
    @Override
    public void imprimeSVG(){
	String coloracion,strike;
	if(color == Color.NINGUNO){ 
	    coloracion = "white";
	    strike = "black";
	}else {
	    coloracion = (color == Color.ROJO) ? "red":"black";
	    strike = coloracion;
	}
	
	
	System.out.println("<circle cx='" +centro.getX()+ "' cy='" +centro.getY()+ "' r='" +radio+ "' stroke='" +strike+ "' stroke-width='1' fill='" +coloracion+ "' />");
	texto.imprimeSVG();
	
    }
    
    

}
