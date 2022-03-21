package labs.week_03.FileManagement;

public class DocumentContentFile extends ContenntFile{
    public DocumentContentFile(String name, String location, String content) {
        super(name, location, content);
    }

    @Override
    public File copy(String newLocation) {
        DocumentContentFile f = new DocumentContentFile(this.getName(), newLocation, this.getContent());
        f.setLocation(newLocation);
        return f;
    }
}
