package structuralDP.adapterDP.xmlToJSON;

public class XMLToJSONAdapter implements JSONHandler{
    private LegacyXMLHandler legacyXMLHandler;

    public XMLToJSONAdapter(LegacyXMLHandler legacyXMLHandler) {
        this.legacyXMLHandler = legacyXMLHandler;
    }

    @Override
    public String getJSONData() {
        String xmlData = legacyXMLHandler.getXMLData();
        // Convert XML data to JSON data
        return "{ \"data\": \"" + xmlData.replaceAll("<[^>]+>", "") + "\" }";
    }
}
