
package proyecto.resources.idioma;

import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{
    
    private static final long serialVersionUID = 1L;
	        
    public Idioma(String idioma){
    	switch(idioma){
	    case "1": getProperties("espanol.properties"); break;
            case "0": getProperties("ingles.properties"); break;
	    default: getProperties("espanol.properties"); break;
	}
    }

    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {}
   }
}
