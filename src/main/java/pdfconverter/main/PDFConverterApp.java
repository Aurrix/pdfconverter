package pdfconverter.main;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FilenameUtils;

import pdfconverter.converters.PDFToTextConverter;

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
public class PDFConverterApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PDFToTextConverter converter = new PDFToTextConverter();
		
		File[] listOFPdfs = new File(args[0]).getAbsoluteFile().listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".pdf");
			}
		});
		
		File outPutDirFile = new File(args[1]); 
		
		outPutDirFile.mkdirs();
		
		String outputFolder = outPutDirFile.getAbsolutePath();
		
		for (File file : listOFPdfs) {
						
			try {
				File finalOutput = new File(outputFolder+File.separator+FilenameUtils.removeExtension(file.getName())+".txt");
				System.out.println(outputFolder+File.separator+FilenameUtils.removeExtension(file.getName())+".txt");
				file.createNewFile();
				PrintWriter newTextFile = new PrintWriter(finalOutput,"ASCII");
				newTextFile.print(converter.convert(file));
				newTextFile.close();
			} catch (IOException e) {
			
				System.out.println("Can't write file!");
				
			} 			
			
		}

	}
	
}
