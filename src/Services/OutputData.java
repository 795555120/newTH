package Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OutputData {
    private File file1 ;
    private String filename;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String line;
    private String[] stringsList;
    private List<String[]> stringArray;
    private static int[] skips=new int[21];


    public OutputData(String inputFilePath) {
        this.filename = inputFilePath;
    }
    //获取每行数据去空白的数组，并将其放入List数组中输出

    public List<String[]> getListPerLine(){
        long l = System.currentTimeMillis();
        try {
            stringArray = read(filename, 20);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long l1 = System.currentTimeMillis();
        System.out.println((l1-l)/1000.0);
//        System.out.println(stringArray.size());



        return stringArray;
    }

    //    得到每列的数组并输出
//    public void outputDataPerColumn(int[] columns){
//        List<String[]> strings=getListPerLine();
//        try {
//            bufferedWriter=new BufferedWriter(new FileWriter(file2,true));
//            for (String[] str:strings) {
//                if (Integer.parseInt(str[2]) == 2) {
//                    for (int i = 0; i < columns.length; i++) {
//                        bufferedWriter.write(str[columns[i]-1] + "  ");
//                    }
//                    bufferedWriter.newLine();
//                    bufferedWriter.flush();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(bufferedWriter!=null)
//                    bufferedWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public static void main(String[] args) {
//        for (int i=1;i<6;i++) {
//            String path1 = "C:\\Users\\Administrator\\Desktop\\太湖项目文件\\Data\\RES000"+i+".DAT";
//            String path2 = "C:\\Users\\Administrator\\Desktop\\太湖项目文件\\Data\\output"+i+".txt";
//            OutputData o=new OutputData(path1,path2);
//            int[] co={1,2,3,4,5,6,7,8,9};
//            o.outputDataPerColumn(co);
//        }
//    }
    //返回文件总共有多少行
    private static int length(String name) throws IOException {
        int length=0;
        FileReader reader=new FileReader(name);
        LineNumberReader lineNumberReader=new LineNumberReader(reader);
        String s=lineNumberReader.readLine();
        while (s!=null){
            length++;
            s=lineNumberReader.readLine();
        }
        return length;
    }


    public static List<String[]> read(String filename, int group) throws IOException, InterruptedException {
        readSkips("C:\\Users\\Administrator\\Desktop\\太湖项目\\newTH\\src\\Util\\count.txt");
        int length=length(filename);
//        System.out.println("文件总共有 "+length+" 行");
        Host host=new Host();
        int cap=length/group;
//        System.out.println("创建"+group+" 个线程，每个线程读取"+cap+" 行");
        int variable=cap;
        int plus=length%group;

        int last=length;

        Data[] datas=new Data[group];
        int skip=1;
        for (int i=0;i<group;i++){
            if (skips[i]==0){
                datas[i]=host.request(filename,skip,variable,0);
            }
            else {
                datas[i]=host.request(filename,skip,variable,skips[i]);
            }
            skip+=cap;
            variable+=cap;
        }
        Data lastData=null;
        if (plus!=0){
            lastData=host.request(filename,skip,last,skips[group]);
        }

        List<String[]> list=new ArrayList<>();

        for (int i=0;i<group;i++){
            if (skips[i+1]==0){ //如果是第一次读取，则skips[i+1]=0,此时需要将skips[i+1]的值更新
                skips[i+1]=datas[i].getContent().getLength();
            }
            list.addAll(datas[i].getContent().getList());
        }

        if (lastData!=null){
//            System.out.println("lastData->"+lastData.getContent().size());
            list.addAll(lastData.getContent().getList());
        }

        //将得到的skips数组写入到文件中
        int index=0;
        List<String> count=new ArrayList<>();
        for (Integer i:skips){
            count.add(i.toString());
        }
        String skipfile="C:\\Users\\Administrator\\Desktop\\太湖项目\\newTH\\src\\Util\\count.txt";
        File file=new File(skipfile);
        if (!file.exists()){
            write(skipfile, count);
        }
        return list;
    }

    public static void write(String filename,List<String> list) throws IOException {

        FileWriter fileWriter=new FileWriter(filename);
        for (String s:list){
            if (s!=null){
                fileWriter.write(s+"\n");
            }
        }
        fileWriter.close();
    }

    private static void readSkips(String filename) throws IOException {
        File file=new File(filename);
        boolean exists = file.exists();
        if (!exists){
            return;
        }
        FileReader fileReader=new FileReader(filename);
        LineNumberReader lineNumberReader=new LineNumberReader(fileReader);
        String s = lineNumberReader.readLine();
        int row=lineNumberReader.getLineNumber();
        while (s!=null){
            skips[row]=Integer.parseInt(s);
            row=lineNumberReader.getLineNumber();
            s=lineNumberReader.readLine();
        }
        fileReader.close();
        lineNumberReader.close();
    }

}