package labs.week_03.FileManagement;

public class MediaContentFile extends ContenntFile{
    public MediaContentFile(String name, String location, String content) {
        super(name, location, content);
    }

    @Override
    public File copy(String newLocation) {
        MediaContentFile f = new MediaContentFile(this.getName(), newLocation, this.getContent());
        f.setLocation(newLocation);
        return f;
    }
}
