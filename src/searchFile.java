import java.util.ArrayList;

public class searchFile {

    public static void main(String[] args)  {
        ArrayList<String> fileList = null;
        System.out.println("Введите папку поиска. Для выхода введите q:");

        Parameters parameters = new Parameters();
        parameters.setPath(Input.inputText());
        System.out.println("Введите строку поиска. Для выхода введите q:");

         do{
            parameters.setSearch(Input.inputText());
            FileClass file = new FileClass(parameters);
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
        }while (!parameters.getSearch().equals("q:"));
    }
}
