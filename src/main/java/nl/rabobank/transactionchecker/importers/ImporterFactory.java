package nl.rabobank.transactionchecker.importers;

/**
 * Produces Importer instances based on filetype
 */
public class ImporterFactory {
    /**
     * Returns importer instance based on file type. Works for xml and csv files
     * @param fileType extension of file
     * @return new Importer instance
     */
    public static TransactionImporter getImporter(String fileType){
        if(fileType == null){
            return null;
        }

        if(fileType.equalsIgnoreCase("xml")){
            return new XmlImporter();
        } else if(fileType.equalsIgnoreCase("csv")){
            return new CsvImporter();
        }

        return null;
    }
}
