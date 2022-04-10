package labs.week_03.FileManagement;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileManagement {

    private Map<String, File> fs = new ConcurrentHashMap<>();

    private void make(String[] args)
    {
        if(args.length != 4)
        {
            System.out.println("Wrong    number of parameters");
            return;
        }
        if(args[3].startsWith("CONTENT"))
        {
            String[] extension = args[1].split("\\.");
            if(extension.length == 2 && (extension[1].equals("avi") || extension[1].equals("mp3")))
            {
                MediaContentFile file = new MediaContentFile(args[1], args[2], args[3].split("=")[1]);
                this.fs.put(file.getName(), file);
            }
            else
            {
                DocumentContentFile file = new DocumentContentFile(args[1], args[2], args[3].split("=")[1]);
                this.fs.put(file.getName(), file);
            }
        }
        else
        {
            List<String> str = Arrays.asList(args[3].substring(1, args[3].length()-2).split(","));
            ExecutableFile file = new ExecutableFile(args[1], args[2], str);
            this.fs.put(file.getName(), file);
        }
    }

    private void move(String[] args)
    {
        if(args.length != 3)
        {
            System.out.println("Wrong number of parameters");
        }
        File file = this.fs.get(args[1]);
        if(file!=null)
        {
            file.setLocation(args[2]);
            this.fs.put(file.getName(), file);
        }
        else
        {
            System.out.println("No such file");
        }
    }

    private void mod(String[] args)
    {
        if(args.length != 3)
        {
            System.out.println("Wrong number of parameters");
        }
        File file = this.fs.get(args[1]);
        if(file!=null)
        {
            file.modify(args[2]);
            this.fs.put(file.getName(), file);
        }
        else
        {
            System.out.println("No such file");
        }
    }

    private void del(String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("Wrong number of parameters");
        }
        File file = this.fs.get(args[1]);
        if(file!=null)
        {
            file.delete();
            this.fs.put(file.getName(), file);
        }
        else
        {
            System.out.println("No such file");
        }
    }

    private void exec(String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("Wrong number of parameters");
        }
        File file = this.fs.get(args[1]);
        if(file!=null)
        {
            file.execute();
        }
        else
        {
            System.out.println("No such file");
        }
    }

    private void info(String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("Wrong number of parameters");
        }
        File file = this.fs.get(args[1]);
        if(file!=null)
        {
            System.out.println(file.getInfo());
        }
        else
        {
            System.out.println("No such file");
        }
    }

    private void copy(String[] args)
    {
        if(args.length != 3)
        {
            System.out.println("Wrong number of parameters");
        }
        File file = this.fs.get(args[1]);
        if(file!=null)
        {
            File fileCopy = file.copy(args[2]);
            fileCopy.setName(fileCopy.getName() + UUID.randomUUID().toString());
            this.fs.put(fileCopy.getName(), fileCopy);
        }
        else
        {
            System.out.println("No such file");
        }
    }

    public void processCommand(String command) {
        String[] str = command.split(" ");

        if (str[0].equals("MAKE")) {
            this.make(str);
        }
        else if (str[0].equals("MOVE"))
        {
            this.move(str);
        }
        else if (str[0].equals("MOD"))
        {
            this.mod(str);
        }
        else if (str[0].equals("DEL"))
        {
            this.del(str);
        }
        else if (str[0].equals("EXEC"))
        {
            this.exec(str);
        }
        else if (str[0].equals("INFO"))
        {
            this.info(str);
        }
        else if (str[0].equals("COPY"))
        {
            this.copy(str);
        }
    }

    public static void main(String[] args)
    {
        ExecutableFile a = new ExecutableFile("name", "/e/folder", new ArrayList<>(Arrays.asList("a1", "a2")));
        System.out.println(a.getInfo());
    }
}
