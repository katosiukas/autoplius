package pavyzdys.startas;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;	
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@WebServlet("/upload")
public class UploadFoto extends HttpServlet {
	
	private static final long serialVersionUID = 8872285618245830120L;
	
	@Override
	@RequestMapping(path="/upload")	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Part filePart = request.getPart("file");								
		InputStream fileInputStream = filePart.getInputStream();
		String failo_vardas = filePart.getSubmittedFileName(); 
		File fileToSave = new File("C:\\Users\\keturioliktas\\Desktop\\perkeltas_eklipse\\startas\\src\\main\\resources\\static\\" + failo_vardas); 	
  		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
	  		
	}

}