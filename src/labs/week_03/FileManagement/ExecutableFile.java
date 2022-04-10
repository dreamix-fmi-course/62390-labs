package labs.week_03.FileManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExecutableFile extends File{
    private List<String> requiredResources;
    private LocalDate lastExecutionDate;

    public ExecutableFile(String name, String location, List<String> requiredResources) {
        super(name, location);
        this.requiredResources = requiredResources;
        this.lastExecutionDate = null;
    }

    public List<String> getRequiredResources() {
        return requiredResources;
    }

    public void setRequiredResources(List<String> requiredResources) {
        this.requiredResources = requiredResources;
    }

    public LocalDate getLastExecutionDate() {
        return lastExecutionDate;
    }

    public void setLastExecutionDate(LocalDate lastExecutionDate) {
        this.lastExecutionDate = lastExecutionDate;
    }

    @Override
    public File copy(String newLocation)
    {
        ExecutableFile f = new ExecutableFile(this.getName(), newLocation, this.getRequiredResources());
        f.setLocation(newLocation);
        return f;
    }

    @Override
    public void execute()
    {
        System.out.println("Executing " + this.getName());
        this.setLastExecutionDate(LocalDate.now());
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
        if(this.getLastExecutionDate()!=null) {
            str.append("Last execution date: " + this.getLastExecutionDate().toString() + "\n");
        }
        str.append("Required resources: \n");

        for(String s: this.requiredResources)
        {
            str.append(s + "\n");
        }

        return str.toString();
    }
}
