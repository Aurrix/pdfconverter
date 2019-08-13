package pdfconverter;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import pdfconverter.main.PDFConverterApp;

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

public class PDFConverterAppTest {

	@Test
	public void testFileIOMain() {
	
		File outputFile = new File("./src/test/resources/out/table.txt");
		outputFile.delete();
		String input = "./src/test/resources";
		String output = "./src/test/resources/out";
		PDFConverterApp.convert(new String[]{input,output});
		Assert.assertTrue(outputFile.exists());
		
	}
	
}
