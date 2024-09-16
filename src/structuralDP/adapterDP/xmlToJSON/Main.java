package structuralDP.adapterDP.xmlToJSON;

public class Main {
    public static void main(String[] args) {
        LegacyXMLHandler legacyXMLHandler= new LegacyXMLHandler();

        JSONHandler jsonHandler = new XMLToJSONAdapter(legacyXMLHandler);

        System.out.println("JSON Data: " + jsonHandler.getJSONData());
    }
}
