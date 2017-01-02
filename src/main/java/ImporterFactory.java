//todo: nog invullen en gebruiken in main method.
public class ImporterFactory {
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
