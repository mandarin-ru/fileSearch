import java.util.ArrayList;

public class searchFile {

    public static void main(String[] args)  {
        ArrayList<String> fileList = null;
        String line = "";
        String path = "";

        System.out.println("Введите строку поиска. Для выхода введите q:");

        while (!line.equals("q:")) {
            line = Input.inputText();
            FileClass file = new FileClass(line);
            fileList = file.searchFile();

            if (fileList.size() == 0) {
                System.out.println("Заданная строка не найдена ни в одном файле");
            }else {
                System.out.println("Строка найдена в файлах:");
                for (String s : fileList) {
                    System.out.println(s);
                }
            }
            System.out.println("Для выхода введите q: либо повторите поиск");
        }
    }
}
