import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class FileClass {

    private String searchString;
    private String searchToDirectory;
    private  ArrayList<String> returnFiles = new ArrayList<>();

    FileClass (String searchTitle){
        searchString = searchTitle;
    }

    ArrayList<String> searchFile () {
        ArrayList<String> arrFiles = getListFilesLog();


        for (int i = 0; i < arrFiles.size(); i++) {
            if (getTypeFile(arrFiles.get(i)).equals(".log")){
                searchTextToFile(arrFiles.get(i));
            }
        }
         return returnFiles;
    }

    /**/
    private ArrayList<String> getListFilesLog(){
        ArrayList<String> returnFilesSeach = new ArrayList<>();
        File folder = new File(System.getProperty("user.dir") );
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                returnFilesSeach.add(listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {

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
