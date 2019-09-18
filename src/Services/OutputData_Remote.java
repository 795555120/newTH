package Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OutputData_Remote {
    private File file1 ;
    private File file2 ;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String line;
    private String[] stringsList;
    private List<String[]> stringArray;

    public OutputData_Remote(String inputFilePath, String outFilePath){
        this.file1 = new File(inputFilePath);
        this.file2 = new File(outFilePath);
    }

    public OutputData_Remote(String inputFilePath) {
        this.file1 = new File(inputFilePath);
    }
    //获取每行数据去空白的数组，并将其放入List数组中输出

    public List<String[]> getListPerLine(){
        try {
            stringArray=new ArrayList<String[]>();
            bufferedReader = new BufferedReader(new FileReader(file1));
//            跳过文件前3行代码
            line=bufferedReader.readLine();
            line=bufferedReader.readLine();
            line=bufferedReader.readLine();
//
            while ((line=bufferedReader.readLine())!=null){
                stringsList=line.trim().split("\\s+");
                if(Integer.parseInt(stringsList[2])!=0)
                    stringArray.add(stringsList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader!=null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringArray;
    }

    //    得到每列的数组并输出
    public void outputData_RemotePerColumn(int[] columns){
        List<String[]> strings=getListPerLine();
        try {
            bufferedWriter=new BufferedWriter(new FileWriter(file2,true));
            for (String[] str:strings) {
                if (Integer.parseInt(str[2]) != 0) {
                    for (int i = 0; i < columns.length; i++) {
                        bufferedWriter.write(str[columns[i]-1] + "  ");
                    }
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedWriter!=null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        String path1 = "D:\\RSM_TH\\DAT_IN\\WQ_2D_FIG20190406.DAT";
        String path2 = "D:\\RSM_TH\\DAT_IN\\WQ_2D_FIG20190406.txt";
        OutputData_Remote o=new OutputData_Remote(path1,path2);
        int[] co={1,2,6,7,8,9,10,11,12,13,14,15};
        o.outputData_RemotePerColumn(co);
    }
}
