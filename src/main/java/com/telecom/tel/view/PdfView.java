package com.telecom.tel.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.telecom.tel.Model.Customer;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"admin-report.pdf\"");

        List<Customer> customers = (List<Customer>) model.get("customers");
        document.add(new Paragraph("Report Generated on " + LocalDate.now()));

        PdfPTable table = new PdfPTable(customers.stream().findAny().get().getColumnCount());
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Government ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Telecom Circle", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Value Added Service", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("No. of Pending Bills", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Customer Type", font));
        table.addCell(cell);

        for(Customer customer : customers){
            table.addCell(((Integer)customer.getGovtID()).toString());
            table.addCell(customer.getCustName());
            table.addCell(customer.getTelecomCircle());
            table.addCell(customer.getVas());
            table.addCell(((Integer)customer.getPBills()).toString());
            table.addCell(customer.getCustType());
        }

        document.add(table);
    }
}