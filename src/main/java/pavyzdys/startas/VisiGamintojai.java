package pavyzdys.startas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

public class VisiGamintojai {

	protected Session em;
	protected EntityManagerFactory factory;	
		
	public SessionFactory sessionFactory() {
			
		if (this.factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
			return this.factory.unwrap(SessionFactory.class);
	}	
	  
	public VisiGamintojai(EntityManagerFactory factory) {
		  
		this.factory = factory; 
		this.em = this.sessionFactory().openSession(); 
				
	}				
	
	public String VisosMarkes() {
		  
		String formuojam =
	  				
			" SELECT "
			+ "`marke`"
			+ "FROM `lengvieji` "
			+ "UNION ( "
			+ "SELECT "
			+ "`marke`"  
			+ "FROM `krovininiai`"
	  		+ ") UNION ("
			+ "SELECT"
	  		+ "`marke`"
	  		+ "FROM `mikroautobusai`"
	  		+ ") UNION ("
	  		+ "SELECT"
	  		+ "`marke`"
	  		+ "FROM `specialus`"
	  		+ ")";
		
		return formuojam;
	}
	
	public String VienasParametras(String parametras) {
		  
		String formuojam =
	  				
			" SELECT "
			+ "`" + parametras + "`"
			+ "FROM `lengvieji` "
			+ "UNION ( "
			+ "SELECT "
			+ "`" + parametras + "`"  
			+ "FROM `krovininiai`"
	  		+ ") UNION ("
			+ "SELECT"
			+ "`" + parametras + "`"
	  		+ "FROM `mikroautobusai`"
	  		+ ") UNION ("
	  		+ "SELECT"
	  		+ "`" + parametras + "`"
	  		+ "FROM `specialus`"
	  		+ ")";
		
		return formuojam;
	}
	
	public String VisiModeliai(String marke_id, String tipas_id) {
		
		String formuojam =
  				
				" SELECT "
				+ "`modelis`"
				+ "FROM `" + tipas_id + "`"
				+ "WHERE `" + tipas_id + "`.`marke` ='" + marke_id + "' ";
				
		
		return formuojam;
	}	
	
	public String savybes(String marke_id, String tipas_id, String modelis_id) {
		
		String formuojam =
  				
				" SELECT "
				+ " * "
				+ "FROM `" + tipas_id + "`"
				+ "WHERE `" + tipas_id + "`.`marke` ='" + marke_id + "' AND `" + tipas_id + "`.`modelis` ='" + modelis_id + "' ";
				
		
		return formuojam;
	}	
	
	public String MetuFiltras(String metai_id) {
		  
		String formuojam =
	  				
			" SELECT "
			+ " * "
			+ "FROM `lengvieji`"
			+ "WHERE `lengvieji`.`metai` ='" + metai_id + "' "
			+ "UNION ( "
			+ "SELECT "
			+ " * "  
			+ "FROM `krovininiai`"
			+ "WHERE `krovininiai`.`metai` ='" + metai_id + "' "
	  		+ ") UNION ("
			+ "SELECT"
			+ " * "
	  		+ "FROM `mikroautobusai`"
	  		+ "WHERE `mikroautobusai`.`metai` ='" + metai_id + "' "
	  		+ ") UNION ("
	  		+ "SELECT"
	  		+ " * "
	  		+ "FROM `specialus`"
	  		+ "WHERE `specialus`.`metai` ='" + metai_id + "' "
	  		+ ")";
		
		return formuojam;
	}
	
	
	public List<ObjectNode> visosMarkesList(String marke_id, String tipas_id) {
		
		List vmod = uzklausa(VisiModeliai(marke_id, tipas_id));
		
	    return vmod;
	}	
	    
	public List<ObjectNode> VienasParametrasList(String parametras) {
		
		List vparam = uzklausa(VienasParametras(parametras));
		
	    return vparam;
	}	
	
	public List<ObjectNode> visiGamintojaiList() {
	
		List vmark = uzklausa(VisosMarkes());
		
	    return vmark;
	}	  		
	
	public List<ObjectNode> savybesList(String marke_id, String tipas_id, String modelis_id) {
		
		List sav = uzklausa(savybes(marke_id, tipas_id, modelis_id));
		
	    return sav;
	}
	
	public List<ObjectNode> MetuFiltrasList(String metai) {
		
		List mmetai = uzklausa(MetuFiltras(metai));
		
	    return mmetai;
	}
	
	public List<ObjectNode> uzklausa(String param) {
		
		Query query = em.createNativeQuery ( param, Tuple.class );
		List<Tuple> rs = query.getResultList();
		List<ObjectNode> json = _toJson(rs);
		
		em.close();
		
		return json;
		
	}
	
	private List<ObjectNode> _toJson(List<Tuple> results) {

		List<ObjectNode> json = new ArrayList<ObjectNode>();

		ObjectMapper mapper = new ObjectMapper();

		for (Tuple t : results)
		{
		    List<TupleElement<?>> cols = t.getElements();

		    ObjectNode one = mapper.createObjectNode();
		    		    
		    for (TupleElement col : cols)
		    {
		    	one.put(
		    			col.getAlias()
		    			, t.get(col.getAlias()
		    	).toString());
		    }

		    json.add(one);
		}

		return json;
	}
	
}
