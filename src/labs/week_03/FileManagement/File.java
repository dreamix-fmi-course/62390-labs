package labs.week_03.FileManagement;

import java.time.LocalDate;

abstract class File {
    private String name;
    private String location;
    private LocalDate creationDate;
    private Boolean isDeleted;

    public File(String name, String location)
    {
        this.name = name;
        this.location = location;
        this.creationDate = LocalDate.now();
        this.isDeleted = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void move(String newLocation)
    {
        this.location = newLocation;
    }

    abstract <T> T copy(String newLocation);

    public void delete()
    {
        this.isDeleted = true;
    }

    public void execute()
    {
        return;
    }

    public void modify(String data) { return; }

    abstract String getInfo();
}
