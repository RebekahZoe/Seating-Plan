package plan2.main;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class App {
	private static String[] columns = {"1", "2", "3", "4", "5", "6"};

	public static void main(String[] args) throws IOException, InvalidFormatException {
		SeatingPlan p = new SeatingPlan(4, 6);
		
		Workbook seatingWorkbook = new XSSFWorkbook();
		
		Sheet sheet = seatingWorkbook.createSheet("Seating plan");
		
		
	    Row headerRow = sheet.createRow(0);
	    
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
                    }
		
		p.assignSeat();
		
		int rowNum = 1;
		
		for ( int i = 0; i < p.getPlan().length; i++) {
			Row row = sheet.createRow(i+1);
			for (int j = 0; j < p.getPlan()[i].length; j++) {
				row.createCell(j).setCellValue(p.getPlan()[i][j]);
			}
			
			System.out.println();
		}
		
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Seating Plan.xlsx");
        seatingWorkbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        seatingWorkbook.close();

	}

}
