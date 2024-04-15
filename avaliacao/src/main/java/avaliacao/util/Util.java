package avaliacao.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util implements Serializable {

	private static final long serialVersionUID = -7339516557203100876L;
	
	public static Date converterStringDate(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date();
		try {
			date = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


	public static String nvl(String valor) {
		if ((valor == null) || ("".equals(valor))) {
			valor = null;
		}
		return valor;
	}
}
