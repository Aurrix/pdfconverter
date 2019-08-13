/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pdfconverter.converters;

import java.io.File;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alisher Urunov
 *
 */
public class PDFToTextConverterTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	PDFToTextConverter pdfConverter;
	File pdfTest;
	@Before
	public void setUp() throws Exception {
		
		pdfConverter = new PDFToTextConverter();
		URL fileUri = getClass().getClassLoader().getResource("table.pdf");
		pdfTest = new File(fileUri.getFile());
		
		
	}

	/**
	 * Test method for {@link pdfconverter.converters.PDFToTextConverter#convert(java.io.File)}.
	 */
	@Test
	public void testPDFConvertFormatting() {
		String result = pdfConverter.convert(pdfTest);
		//System.out.println(result);
		Assert.assertTrue(result.startsWith("Example table \n"));
		Assert.assertTrue(result.endsWith("\nMobility 3 3 0 95.4%, n=3 1416 sec, n=3"));
	}

}
