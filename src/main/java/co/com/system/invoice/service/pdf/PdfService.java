package co.com.system.invoice.service.pdf;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.constants.PdfTemplate;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.InvoiceDetail;
import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class PdfService {


    public String generatePdfFromHtml(PdfTemplate templateName, Map<String,Object> parameters, String namePdf) throws AppException, FileNotFoundException {
        String outputFolder = GeneralConstans.URI_FILES_PDF.concat(File.separator).concat(namePdf).concat(GeneralConstans.PDF_EXT);
        OutputStream outputStream = new FileOutputStream(outputFolder);
        try {
            String html = parseThymeleafTemplate(templateName.name(), parameters);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            return Base64.getEncoder().encodeToString(createByteFile(outputFolder));
        }catch (Exception ex ) {
            ex.printStackTrace();
            throw new AppException(CodeExceptions.PDF_ERROR);
        }finally {
            try {
                outputStream.close();
                File file = new File(outputFolder);
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private String parseThymeleafTemplate(String templateName, Map<String,Object> parameters) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(GeneralConstans.HTML_EXT);
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        parameters.forEach((k,v)->context.setVariable(k,v));
        return templateEngine.process(templateName, context);
    }



    private byte[] createByteFile(String path) throws IOException {
        File file = new File(path);
        return Files.readAllBytes(file.toPath());
    }

}
