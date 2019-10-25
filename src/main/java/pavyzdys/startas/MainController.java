package pavyzdys.startas;

import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller    
@RequestMapping(path="/restfull")
public class MainController {

	@Autowired 
	EntityManagerFactory factory;
	
	@Autowired
	private LengviejiRepository LengviejiRepository;
	
	@Autowired
	private KrovininiaiRepository KrovininiaiRepository;
	
	@Autowired
	private SpecialusRepository SpecialusRepository;
	
	@Autowired
	private MikroautobusaiRepository MikroautobusaiRepository;
	
	// ---------- Atiduodam visus  --------------
	
	@GetMapping(path="/all_duomenys")
	public @ResponseBody Visi pirmas() {
		
		VisiGamintojai visigamintojai = new VisiGamintojai(factory);
		
		Visi visi = new Visi();
		
		visi.setLengvieji((List<Lengvieji>) LengviejiRepository.findAll());
		visi.setKrovininiai((List<Krovininiai>) KrovininiaiRepository.findAll());
		visi.setSpecialus((List<Specialus>) SpecialusRepository.findAll());
		visi.setMikroautobusai((List<Mikroautobusai>) MikroautobusaiRepository.findAll());
		visi.setVisigamintojai(visigamintojai.visiGamintojaiList());
//		visi.setVisosmarkes(visigamintojai.visosMarkesList());
		
		return visi;
	}	
	
	@GetMapping(path="/all_marke")
	public @ResponseBody List gamintojoModeliaiPagalTipa(@RequestParam String id, String t_id) {
		
		VisiGamintojai visigamintojai = new VisiGamintojai(factory);
		
		return visigamintojai.visosMarkesList(id, t_id);
	}
	
	@GetMapping(path="/all_savybe")
	public @ResponseBody List gamintojoModelioSavybes(@RequestParam String id, String t_id, String m_id) {
		
		VisiGamintojai visigamintojai = new VisiGamintojai(factory);
		
		return visigamintojai.savybesList(id, t_id, m_id);
	}
	
	@GetMapping(path="/vienas_parametras")
	public @ResponseBody List gamintojoModeliaiPagalParametra(@RequestParam String parametras) {
		
		VisiGamintojai visigamintojai = new VisiGamintojai(factory);
		
		return visigamintojai.VienasParametrasList(parametras);
	}
	
	@GetMapping(path="/pagal_metus")
	public @ResponseBody List ModeliaiPagalMetus(@RequestParam String parametras) {
		
		VisiGamintojai visigamintojai = new VisiGamintojai(factory);
		
		return visigamintojai.MetuFiltrasList(parametras);
	}
	
	// ------- Lengvieji --------
	@GetMapping(path="/all_lengvieji")
	public @ResponseBody Iterable<Lengvieji> getAllLengvieji() {
			
		return LengviejiRepository.findAll();
	}
	
	@GetMapping(path="/lengvasis")
	public @ResponseBody Optional<Lengvieji> Lengvieji(@RequestParam Integer id) {
		
		return LengviejiRepository.findById (id);
	}
	
	@GetMapping(path="/prideti") 
	public @ResponseBody String addNewLengvasis (@RequestParam String marke
			, @RequestParam String modelis
			, @RequestParam Integer metai
			, @RequestParam String savybe
			, @RequestParam Integer galia
			, @RequestParam String tipas
			, @RequestParam String nuotrauka) {
		
		if (tipas.equals("lengvieji")) {
			
			Lengvieji n = new Lengvieji();
			n.setMarke(marke);
			n.setModelis(modelis);
			n.setMetai(metai);
			n.setSavybe(savybe);
			n.setNuotrauka(nuotrauka);
			LengviejiRepository.save(n);
			
		}
		
		if (tipas.equals("krovininiai")) {
			
			Krovininiai n = new Krovininiai();
			n.setMarke(marke);
			n.setModelis(modelis);
			n.setMetai(metai);
			n.setGalia(galia);
			n.setNuotrauka(nuotrauka);
			KrovininiaiRepository.save(n);
			
		}
		
		if (tipas.equals("mikroautobusai")) {
			
			Mikroautobusai n = new Mikroautobusai();
			n.setMarke(marke);
			n.setModelis(modelis);
			n.setMetai(metai);
			n.setVietos(galia);
			n.setNuotrauka(nuotrauka);
			MikroautobusaiRepository.save(n);
			
		}

		if (tipas.equals("specialus")) {
			
			Specialus n = new Specialus();
			n.setMarke(marke);
			n.setModelis(modelis);
			n.setMetai(metai);
			n.setPaskirtis(savybe);
			n.setNuotrauka(nuotrauka);
			SpecialusRepository.save(n);
			
		}
		
		return "Saved";
	}	
	
	@GetMapping(path="/redaguoti_lengvaji") 
	public @ResponseBody String redaguotiklienta (@RequestParam Integer id
			, @RequestParam String marke
			, @RequestParam String modelis
			, @RequestParam Integer metai
			, @RequestParam String savybe) {
				
		Optional <Lengvieji> found = LengviejiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			Lengvieji n = found.get();
			n.setId(id);
			n.setMarke(marke);
			n.setModelis(modelis);
			n.setMetai(metai);
			n.setSavybe(savybe);
			LengviejiRepository.save(n);	
			 
			   			}
		return res;
	}

	@GetMapping(path="/trinti_lengvaji") 
	public @ResponseBody String lengvieji (@RequestParam Integer id ) {
				
		Optional <Lengvieji> found = LengviejiRepository.findById( id );
		
		String res = "Not done";
		Lengvieji n = found.get();
		n.setId(id);
		LengviejiRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
}