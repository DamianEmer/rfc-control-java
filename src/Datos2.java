
public class Datos2 extends Datos{
	protected String nomCom;
	
	public Datos2(String nomCom,String nomb, String apeP,String  apeM,int dia,int mes, int a�o,String x,String y,String rfc) {
		super( nomb, apeP, apeM,dia, mes, a�o,x,y,rfc);
		this.nomCom=nomCom;
	}
	public void setNomCom(String nomCom) {this.nomCom=nomCom;}
	public String getNomCom() {return this.nomCom;}
	
}
