package labs.week_03.FileManagement;

import java.time.LocalDate;
import java.util.List;

public class ExecutableFile extends File{
    private List<String> requiredResources;
    private LocalDate lastExecutionDate;


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
    <T> T copy(String newLocation) {
        return null;
    }

    @Override
    public void execute()
    {
        System.out.println("Executing " + this.name);
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
        str.append("Last execution date: " + this.getLastExecutionDate().toString() + "\n");
        str.append("Required resources: \n");

        for(String s)

        return str.toString();
    }
}
