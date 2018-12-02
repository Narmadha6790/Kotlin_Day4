package misc
 
import java.io.FileOutputStream
import java.io.IOException
import java.util.Arrays
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.Font
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
 
private val COLUMNs = arrayOf<String>("Id", "Name", "Address", "Age")
private val customers = Arrays.asList(
		Customer("1", "Jack Smith", "Massachusetts", 23),
		Customer("2", "Adam Johnson", "New York", 27),
		Customer("3", "Katherin Carter", "Washington DC", 26),
		Customer("4", "Jack London", "Nevada", 33),
		Customer("5", "Jason Bourne", "California", 36))
 
@Throws(IOException::class)
fun main(args: Array<String>?) {
 
	println("Executed -1")
	val workbook = XSSFWorkbook()
	val createHelper = workbook.getCreationHelper()
 
	println("Executed -2")
	val sheet = workbook.createSheet("Customers")
 
	val headerFont = workbook.createFont()
	headerFont.setBold(true)
	headerFont.setColor(IndexedColors.BLUE.getIndex())
 
	val headerCellStyle = workbook.createCellStyle()
	headerCellStyle.setFont(headerFont)
 
	
	// Row for Header
	val headerRow = sheet.createRow(0)
 
	// Header
	for (col in COLUMNs.indices) {
		val cell = headerRow.createCell(col)
		cell.setCellValue(COLUMNs[col])
		cell.setCellStyle(headerCellStyle)
	}
	
	println("Executed -3")
	// CellStyle for Age
	val ageCellStyle = workbook.createCellStyle()
	ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"))
	
	println("Executed -4")
	var rowIdx = 1
	for (customer in customers) {
		val row = sheet.createRow(rowIdx++)
		row.createCell(0).setCellValue(customer.id)
		row.createCell(1).setCellValue(customer.name)
		row.createCell(2).setCellValue(customer.address)
		val ageCell = row.createCell(3)
		ageCell.setCellValue(customer.age.toDouble())
		ageCell.setCellStyle(ageCellStyle)
	}
	
	println("Executed -5")
	val fileOut = FileOutputStream("customers.xlsx")
	workbook.write(fileOut)
	fileOut.close()
	workbook.close()
}