package pavyzdys.startas;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Visi {

	private List<Lengvieji> lengvieji;
	private List<Krovininiai> krovininiai;
	private List<Specialus> specialus;
	private List<Mikroautobusai> mikroautobusai;
	private List<ObjectNode> visigamintojai;
//	private List<ObjectNode> visosmarkes;
	
	public Visi() {
		
	}
	/**
	 * @return the lengvieji
	 */
	public List<Lengvieji> getLengvieji() {
		return lengvieji;
	}
	/**
	 * @param lengvieji the lengvieji to set
	 */
	public void setLengvieji(List<Lengvieji> lengvieji) {
		this.lengvieji = lengvieji;
	}
	/**
	 * @return the krovininiai
	 */
	public List<Krovininiai> getKrovininiai() {
		return krovininiai;
	}
	/**
	 * @param krovininiai the krovininiai to set
	 */
	public void setKrovininiai(List<Krovininiai> krovininiai) {
		this.krovininiai = krovininiai;
	}
	/**
	 * @return the specialus
	 */
	public List<Specialus> getSpecialus() {
		return specialus;
	}
	/**
	 * @param specialus the specialus to set
	 */
	public void setSpecialus(List<Specialus> specialus) {
		this.specialus = specialus;
	}
	/**
	 * @return the mikroautobusai
	 */
	public List<Mikroautobusai> getMikroautobusai() {
		return mikroautobusai;
	}
	/**
	 * @param mikroautobusai the mikroautobusai to set
	 */
	public void setMikroautobusai(List<Mikroautobusai> mikroautobusai) {
		this.mikroautobusai = mikroautobusai;
	}
	/**
	 * @return the visigamintojai
	 */
	public List<ObjectNode> getVisigamintojai() {
		return visigamintojai;
	}
	/**
	 * @param visigamintojai the visigamintojai to set
	 */
	public void setVisigamintojai(List<ObjectNode> visigamintojai) {
		this.visigamintojai = visigamintojai;
	}
	/**
	 * @return the visosmarkes
 */
	
/*	public List<ObjectNode> getVisosmarkes() {
		return visosmarkes;
	}
	/**
	 * @param visosmarkes the visosmarkes to set
	 */
/*	public void setVisosmarkes(List<ObjectNode> visosmarkes) {
		this.visosmarkes = visosmarkes;
	}	*/
	
}