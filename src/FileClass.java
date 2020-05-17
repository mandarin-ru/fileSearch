import java.io.*;
import java.util.ArrayList;

class FileClass {

    private String searchString;
    private String searchToDirectory;
    private  ArrayList<String> returnFiles = new ArrayList<>();

    FileClass (String searchTitle){
        searchString = searchTitle;
    }

    ArrayList<String> searchFile () {
        ArrayList<String> arrFiles = getListFilesLog();

        for (String arrFile : arrFiles) {
            if (getTypeFile(arrFile).equals(".log")) {
                searchTextToFile(arrFile);
            }
        }
         return returnFiles;
    }

    /**/
    private ArrayList<String> getListFilesLog(){
        ArrayList<String> returnFilesSeach = new ArrayList<>();
        File folder = new File(System.getProperty("user.dir") );
        File[] listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                returnFilesSeach.add(listOfFile.getName());
            } else if (listOfFile.isDirectory()) {

            }
        }
        return returnFilesSeach;
    }

    private void searchTextToFile (String fileName){

        try{
            FileInputStream fstream = new FileInputStream(System.getProperty("user.dir")+ "\\"+fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                if (strLine.lastIndexOf(searchString) >= 0 ){
                    returnFiles.add(fileName);
                    break;
                }
            }
            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private String getTypeFile (String file) {
        return file.substring(file.indexOf("."));
    }
}
