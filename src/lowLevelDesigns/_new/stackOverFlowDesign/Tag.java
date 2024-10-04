package lowLevelDesigns._new.stackOverFlowDesign;

public class Tag {
    private int tagId;
    private String tagName;
    public Tag(String tag) {
        this.tagId=generateId();
        this.tagName = tag;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }
}
