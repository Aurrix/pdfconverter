# pdfconverter
 Converts PDF to Text file
 
Simple console command that accepts two arguments:
Argument 1: Root path of pdf files
Argument 2: Output directory for txt files.

**Requirements:**

*Runtime:*

- Java 1.7 JRE and above

*Compilation:*

- Java 1.7 JDK and above

- Maven 2.97 and above

**How application works:**
Application accpects a call with at least 2 arguments through cmd line e.g.: java pdfconverter C:\input\ C:\output\
Then pdfconverter searches for pdf files in provided directory and writes them to ourput directory with same name but changed extension .txt
If output directory not found, one created automatically.

**Limitations:**
1. Assumes access to read/write files to disk grated and unlocked
2. PDF files is not protected with password
3. PDF file not encrypted

*Failure reasons are outputed to console.*
