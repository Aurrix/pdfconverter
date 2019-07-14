package pdfconverter.converters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.CompositeParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.microsoft.OfficeParser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * @Author: Alisher Urunov
 * 
 * Copyright © 2019, Alisher Urunov, ALL RIGHTS RESERVED
 * This code is protected by International copyright laws.
 * Reproduction and distribution of the compiled software,
 * source code, and any related assets without written per-
 * mission of author is prohibited!
 *
 */
public class PDFConverter {
	
	
	public String convertWithFormatting(File currentPdfFile) {
		
		ContentHandler handler = new BodyContentHandler();
		
		Metadata metadata = new Metadata();
		
		ParseContext pcontext = new ParseContext();
		
		PDFParser parser = new PDFParser();
		
			
		try {
		parser.parse(new FileInputStream(currentPdfFile), handler, metadata,pcontext);
		String result = handler.toString();
		result = result.trim().replaceAll(" +", " ");
		result = result.trim().replaceAll("\n+", "\n");
			return result;
		} catch (IOException | SAXException | TikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public String convert(File currentPdfFile) {
		
		try {
			PDDocument pdf = PDDocument.load(currentPdfFile);
			pdf.getClass();
			if (!pdf.isEncrypted()) {
				
				PDFTextStripper textStripper = new PDFTextStripper();
				
				String text = textStripper.getText(pdf);
				
				return text;
			}
			
			else {System.out.println("Document is encrypted!!!");}
			
		} catch (InvalidPasswordException e) {
			System.out.println("PDF File has a password protection. Unsupported feature");
		} catch (IOException e) {
			System.out.println("Can't find supplied file");
		} 
		System.out.println("Something went wrong during conversion!");
		return null;
	}
	
}
