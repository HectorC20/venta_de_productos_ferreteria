package C.V.Ventas;

import M.P.DE.Implements.ConjuntoVentaDaoImpl;
import V.I.P.Ventas.FrmDetalleVenta;
import V.I.P.Ventas.pnVentaF;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

public final class ContFacturaPDF extends JFrame {

    private final FrmDetalleVenta vista;
    private static String fechaActual = "";
    private static String nombreArchivoPDFVenta = "";
    public static int idCVentaRegistrada;

    public ContFacturaPDF(FrmDetalleVenta vista) {
        this.vista = vista;
    }

    public static void generarFacturaPDF(FrmDetalleVenta vista) {
        try {
            ContFacturaPDF facturaPDF = new ContFacturaPDF(vista);  // Crear una instancia
            fechaActual = vista.jlbFecha.getText();
            nombreArchivoPDFVenta = "Venta_" + vista.txtCliente.getText() + "_" + fechaActual.replace("/", "_") + ".pdf";
            File file = new File("src\\pdfCreados\\" + nombreArchivoPDFVenta); // Corregido: Se agregó "\\" en lugar de "\"

            try (FileOutputStream archivo = new FileOutputStream(file)) {
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();

                facturaPDF.agregarEncabezado(doc);
                facturaPDF.agregarProductosYTotal(doc);

                doc.close();
            }

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    private void agregarEncabezado(Document doc) throws DocumentException, IOException {
        //init y dirección de la imagen
        Image img = Image.getInstance("C:\\Users\\Héctor\\Desktop\\appEnaCristinaV2\\appEnaCristina\\src\\V\\R\\Iconos\\InEC-100x100.png");

        Paragraph fecha = new Paragraph("Factura: " + ConjuntoVentaDaoImpl.idCVentaRegistrada + "\nFecha: " + vista.jlbFecha.getText() + "\n\n");

        PdfPTable encabezado = new PdfPTable(4);
        encabezado.setWidthPercentage(100);
        encabezado.getDefaultCell().setBorder(0);
        float[] columnasEncabezado = new float[]{20f, 30f, 70f, 40f};
        encabezado.setWidths(columnasEncabezado);
        encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
        encabezado.addCell(img);
        encabezado.addCell("");
        encabezado.addCell("RUC: 0987654321001\nNOMBRE: Ena Cristina\nTELEFONO: 0987654321\nDIRECCION: Dirección cualquiera \nRAZON SOCIAL: ----");
        encabezado.addCell(fecha);
        doc.add(encabezado);
    }

    private void agregarProductosYTotal(Document doc) throws DocumentException {
        PdfPTable tablaProducto = new PdfPTable(new float[]{15f, 50f, 15f, 20f});
        tablaProducto.setWidthPercentage(100);
        tablaProducto.getDefaultCell().setBorder(0);
        Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);

        PdfPCell producto1 = crearCelda("PRODUCTO: ", negrita);
        PdfPCell producto2 = crearCelda("P. UNITARIO: ", negrita);
        PdfPCell producto3 = crearCelda("CANTIDAD: ", negrita);
        PdfPCell producto4 = crearCelda("IMPORTE: ", negrita);

        tablaProducto.addCell(producto1);
        tablaProducto.addCell(producto2);
        tablaProducto.addCell(producto3);
        tablaProducto.addCell(producto4);

        for (int i = 0; i < vista.tbMostrar.getRowCount(); i++) {
            String producto = vista.tbMostrar.getValueAt(i, 0).toString();
            String precio = vista.tbMostrar.getValueAt(i, 1).toString();
            String cantidad = vista.tbMostrar.getValueAt(i, 2).toString();
            String total = vista.tbMostrar.getValueAt(i, 6).toString(); 

            tablaProducto.addCell(producto);
            tablaProducto.addCell(precio);
            tablaProducto.addCell(cantidad +" UND");
            tablaProducto.addCell(total);
        }

        doc.add(tablaProducto);

        Paragraph info = new Paragraph("Total a pagar: " + vista.txtTotalGeneral.getText());
        info.setAlignment(Element.ALIGN_RIGHT);
        doc.add(info);
    }

    private PdfPCell crearCelda(String contenido, Font estilo) {
        PdfPCell celda = new PdfPCell(new Phrase(contenido, estilo));
        celda.setBorder(0);
        celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
        return celda;
    }
}