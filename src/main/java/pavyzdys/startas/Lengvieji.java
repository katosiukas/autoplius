package pavyzdys.startas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lengvieji {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String marke;
	private String modelis;
	private Integer metai;
	private String savybe;
	private String nuotrauka;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the marke
	 */
	public String getMarke() {
		return marke;
	}
	/**
	 * @param marke the marke to set
	 */
	public void setMarke(String marke) {
		this.marke = marke;
	}
	/**
	 * @return the modelis
	 */
	public String getModelis() {
		return modelis;
	}
	/**
	 * @param modelis the modelis to set
	 */
	public void setModelis(String modelis) {
		this.modelis = modelis;
	}
	/**
	 * @return the metai
	 */
	public Integer getMetai() {
		return metai;
	}
	/**
	 * @param metai the metai to set
	 */
	public void setMetai(Integer metai) {
		this.metai = metai;
	}
	/**
	 * @return the savybe
	 */
	public String getSavybe() {
		return savybe;
	}
	/**
	 * @param savybe the savybe to set
	 */
	public void setSavybe(String savybe) {
		this.savybe = savybe;
	}
	/**
	 * @return the nuotrauka
	 */
	public String getNuotrauka() {
		return nuotrauka;
	}
	/**
	 * @param nuotrauka the nuotrauka to set
	 */
	public void setNuotrauka(String nuotrauka) {
		this.nuotrauka = nuotrauka;
	}

}