package pdfconverter.converters;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @Author: Alisher Urunov
 * 
 * Copyright � 2019, Alisher Urunov, ALL RIGHTS RESERVED
 * This code is protected by International copyright laws.
 * Reproduction and distribution of the compiled software,
 * source code, and any related assets without written per-
 * mission of author is prohibited!
 *
 */
public class PDFToTextConverter {
	
	//Accepts pdf and converts to text 
	//replacing extra spaces, line breaks and intends
	public String convert(File currentPdfFile) {
		
		try {
			PDDocument pdf = PDDocument.load(currentPdfFile);
			pdf.getClass();
			if (!pdf.isEncrypted()) {
				
				PDFTextStripper textStripper = new PDFTextStripper();
				
				String result = textStripper.getText(pdf);
				result = result.trim().replaceAll("\r+", "");
				result = result.trim().replaceAll(" +", " ");
				result = result.trim().replaceAll("\n+", "\n");
				
				pdf.close();
				
				return result;
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
