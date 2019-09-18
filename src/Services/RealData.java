package Services;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class RealData implements Data {

    private static String lock="lock";
//    private List<String[]> list=new ArrayList<>();
    private Mydata mydata;


    public RealData(String name,int start,int end,int skip) throws IOException {
        FileReader reader=new FileReader(name);
        LineNumberReader lineNumberReader=new LineNumberReader(reader);
//            lineNumberReader.setLineNumber(start);
        lineNumberReader.skip(skip);
        String s=lineNumberReader.readLine();
        int lineNumber=0;

        List<String[]> list=new ArrayList<>();
        int length=0;

        while (s!=null){
            lineNumber= lineNumberReader.getLineNumber();
            length+=s.length();
            if (start<=lineNumber && end>=lineNumber){
                String[] split = s.trim().split("\\s+");
                if (split.length==25){
                    list.add(split);
                }
//                    list.add(s);
            }
            if (end<lineNumber){
                break;
            }
            s=lineNumberReader.readLine();
        }
        reader.close();
        lineNumberReader.close();
        mydata=new Mydata(list,length+1);
    }


    @Override
    public Mydata getContent() {
        return mydata;
    }
}
