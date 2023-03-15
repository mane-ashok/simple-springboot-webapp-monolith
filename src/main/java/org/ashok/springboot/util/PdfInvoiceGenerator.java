package org.ashok.springboot.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.ashok.springboot.entity.Invoice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class PdfInvoiceGenerator implements InvoiceGenerator {

	private final TemplateEngine templateEngine;
	
	@Autowired
	public PdfInvoiceGenerator(TemplateEngine templateEngine) {
	    this.templateEngine = templateEngine;
	    
	}
		
	@Override
	public Invoice generate(String userId, String month) {

		Invoice invoice = new Invoice();
        invoice.setId(new Date().getTime());
        invoice.setAmount(6500);
        invoice.setPdfUrl(invoice.getId()+".pdf");
        invoice.setUserId(userId);
        invoice.setMonth(month);
		
		String html = templateEngine.process("invoiceTemplate.html", getInvoiceContext(userId, month));
		String xhtml = html2xhtml(html);
				
		Path invoicePath = Paths.get(System.getProperty("user.home"),"invoices");
		try {
			Files.createDirectories(invoicePath);
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		try(OutputStream outputStream = new FileOutputStream(invoicePath.resolve(invoice.getId()+".pdf").toFile())){

			
			ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocumentFromString(xhtml);
		    renderer.layout();
		    renderer.createPDF(outputStream);
	    }
	    catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return invoice;
	    
	}
	
	private String html2xhtml(String html)
	{
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
	}

	private IContext getInvoiceContext(String userId, String month) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		LocalDate now = LocalDate.now();
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("userId", userId);
		map.put("userAddress", "796 Silver Harbour, TX 79273, US");
		map.put("month", month);
		map.put("today", dtf.format(now));
		map.put("dueDate", dtf.format(now.plusMonths(1)));
		
		Context context = new Context(Locale.getDefault(),map);
				
		return context;
		
	}

}
