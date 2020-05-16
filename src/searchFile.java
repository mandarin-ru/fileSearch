import java.util.ArrayList;

public class searchFile {

    public static void main(String[] args)  {
        ArrayList<String> fileList = null;
        FileClass file = new FileClass("qwe");
        fileList = file.searchFile();
        System.out.println("Строка найдена в файлах:");
        for (int i = 0; i < fileList.size(); i++) {
           System.out.println(fileList.get(i));
        }
    }
}
