package general;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelToDataProviderClass {
	@DataProvider
	public Object[][] dataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/User_IDs.xlsx");
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet("Sheet1");
		int lastRow = sheet.getPhysicalNumberOfRows();
		short lastCell = sheet.getRow(0).getLastCellNum();
		System.out.println(lastRow);
		System.out.println(lastCell);
		Object[][] data = new Object[lastRow][lastCell];

		for (int i = 1; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				CellType cellTyp = sheet.getRow(i).getCell(j).getCellType();
				System.out.println(cellTyp);

				if (cellTyp.toString().equalsIgnoreCase("String")) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					if(value.equalsIgnoreCase("null")) {
						
						break;
					}else {
					data[i - 1][j] = value;
					}
					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				} else if (cellTyp.toString().equalsIgnoreCase("NUMERIC")) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).getNumericCellValue();
					System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
				}
			}
		}

		return data;
	}

	@Test(dataProvider = "dataFromExcel")
	public void runData(Object name, Object number) {
		System.out.println("UserName " + name + " Password " + number);
	}
}
