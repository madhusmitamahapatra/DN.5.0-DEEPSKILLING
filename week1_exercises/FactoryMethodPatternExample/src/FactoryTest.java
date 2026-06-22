public class FactoryTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document doc1 = wordFactory.createDocument();
        Document doc2 = pdfFactory.createDocument();
        Document doc3 = excelFactory.createDocument();

        doc1.open();
        doc2.open();
        doc3.open();

        System.out.println("doc1 type: " + doc1.getType());
        System.out.println("doc2 type: " + doc2.getType());
        System.out.println("doc3 type: " + doc3.getType());
    }
}
