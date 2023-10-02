import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;





@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("/uploads"); // Specify the directory where files will be saved
        Files.createDirectories(Path.of(uploadPath)); 

        Part passportPart = request.getPart("passport");
        Part certificatesPart = request.getPart("certificates");

        // Save Passport Picture
        String passportFileName = getFileName(passportPart);
        if (passportFileName != null && !passportFileName.isEmpty()) {
            try (InputStream passportInputStream = passportPart.getInputStream()) {
                Files.copy(passportInputStream, Path.of(uploadPath, passportFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        }

        // Save Certificates
        String certificatesFileName = getFileName(certificatesPart);
        if (certificatesFileName != null && !certificatesFileName.isEmpty()) {
            try (InputStream certificatesInputStream = certificatesPart.getInputStream()) {
                Files.copy(certificatesInputStream, Path.of(uploadPath, certificatesFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        }
        
        
        // Redirect or show success message to the user
        response.sendRedirect("success.jsp");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return null;
    }
}
