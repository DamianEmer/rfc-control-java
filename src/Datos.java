
public class Datos {

	protected String nomb, apeP, apeM,x,y,rfc;
	protected int dia,mes,a�o;
	protected String fecha;
	public Datos(String nomb, String apeP,String  apeM,int dia,int  mes, int a�o,String x,String y,String rfc) {
		 this.nomb=nomb;
		 this.apeP=apeP;
		 this.apeM=apeM;
		 this.dia=dia;
		 this.mes=mes;
		 this.a�o=a�o;
		 this.x=x;
		 this.y=y;
		 this.rfc=rfc;
	}
	
	public void setFecha(String fecha) {this.fecha=fecha;}
	public String getFecha() {return this.fecha;}
	
	public void setNomb(String nomb) {this.nomb=nomb;}
	public String getNomb() {return this.nomb;}
	
	public void setApeP(String apeP) {this.apeP=apeP;}
	public String getApeP() {return this.apeP;}

	public void setApeM(String apeM) {this.apeM=apeM;}
	public String getApeM() {return this.apeM;}

	public void setDia(int dia) {this.dia=dia;}
	public int getDia() {return this.dia;}

	public void setMes(int mes) {this.mes=mes;}
	public int getMes() {return this.mes;}
	
	public void setA�o(int a�o) {this.a�o=a�o;}
	public int getA�o() {return this.a�o;}
	
	public void setX(String x) {this.x=x;}
	public String getx() {return this.x;}
	
	public void setY(String y) {this.y=y;}
	public String getY() {return this.y;}
	
	public void setRfc(String rfc) {this.rfc=rfc;}
	public String getRfc() {return this.rfc;}
}
