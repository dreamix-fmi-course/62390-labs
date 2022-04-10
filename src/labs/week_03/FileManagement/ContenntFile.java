package labs.week_03.FileManagement;

import java.time.LocalDate;

class ContenntFile extends File{
    private String content;
    private LocalDate lastModificationDate;

    public ContenntFile(String name, String location, String content) {
        super(name, location);
        this.content = content;
        this.lastModificationDate = null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDate lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public void modify(String data)
    {
        this.setContent(data);
        this.setLastModificationDate(LocalDate.now());
    }

    @Override
    public File copy(String newLocation) {
        ContenntFile f = new ContenntFile(this.getName(), newLocation, this.getContent());
        f.setLocation(newLocation);
        return f;
    }

    @Override
    String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append("Name: " + this.getName());
        if(this.getDeleted() == true)
        {
            str.append(" [[DELETED]]\n");
        }
        else
        {
            str.append("\n");
        }
        str.append("Creation day: " + this.getCreationDate().toString() + "\n");
        if(this.getLastModificationDate()!=null) {
            str.append("Last modification date: " + this.getLastModificationDate().toString() + "\n");
        }

        return str.toString();
    }
}
