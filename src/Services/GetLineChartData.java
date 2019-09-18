package Services;

import Util.FilePath;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class GetLineChartData {

//    private List<String[]> listPerLine;
//
//    public float[] getData(int start, int x, int y, int substance) {
//        substance = substance + 7;
//        float[] datas = new float[15];
//        if (x >= 0 && x < 902 && y >= 0 && y < 836) {
//            System.out.println("x:" + x + " Y:" + y);
//            BufferedReader bufferedReader = null;
//            String line = null;
//            int count = 0;
//
//            //for循环遍历15文件，将所需要的点取出来存在数组中
//            for (int i = start; i < start + 15; i++) {
//                String[] stringsPerLine = null;
//                File file = new File(FilePath.inputFilePath + i + ".DAT");
//
//                if (file.exists()) {
//
//                    //去掉第一行
//
////                        while ((line = bufferedReader.readLine()) != null) {
//                    listPerLine = new OutputData(FilePath.inputFilePath + i + ".DAT").getListPerLine();
//
////                            if (Integer.parseInt(stringsPerLine[2]) == 2 && Integer.parseInt(stringsPerLine[0]) == x && Integer.parseInt(stringsPerLine[1]) == y) {
//                    //对应的是程序中的文件读取
//
//                    Iterator<String[]> list = listPerLine.listIterator();
//        System.out.println("到达读取折线图文件内部");
//                    if (list.hasNext()) {
//                        stringsPerLine = list.next();
//                        if ((int) Double.parseDouble(stringsPerLine[21]) == x && (int) Double.parseDouble(stringsPerLine[22]) == y) {
//
//                            if (substance > 7 && substance < 17) {
//                                datas[count] = Float.parseFloat(stringsPerLine[substance - 1]);
//                                count++;
//                                break;
//                            }
//                            if (substance == 17) {
//                                datas[count] = Float.parseFloat(stringsPerLine[7]) + Float.parseFloat(stringsPerLine[8]) + Float.parseFloat(stringsPerLine[13]);
//                            }
//                            if (substance == 18) {
//                                datas[count] = Float.parseFloat(stringsPerLine[9]) + Float.parseFloat(stringsPerLine[14]);
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (bufferedReader != null) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//
//        }
//
//        return datas;
//    }
//






    public float[] getData(int start, int x, int y, int substance) {
        substance = substance + 7;
        float[] datas = new float[15];
        if (x >= 0 && x < 902 && y >= 0 && y < 836) {
            System.out.println("x:" + x + " Y:" + y);
            BufferedReader bufferedReader = null;
            String line = null;
            int count = 0;

            //for循环遍历15文件，将所需要的点取出来存在数组中
            for (int i = start; i < start + 15; i++) {
                String[] stringsPerLine = null;
                File file = new File(FilePath.inputFilePath + i + ".DAT");

                if (file.exists()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        //去掉第一行
                        line = bufferedReader.readLine();
                        while ((line = bufferedReader.readLine()) != null) {
                            stringsPerLine = line.trim().split("\\s+");
//                            if (Integer.parseInt(stringsPerLine[2]) == 2 && Integer.parseInt(stringsPerLine[0]) == x && Integer.parseInt(stringsPerLine[1]) == y) {
                                //对应的是程序中的文件读取
                            if (stringsPerLine.length == 25 && (int) Double.parseDouble(stringsPerLine[21]) == x && (int) Double.parseDouble(stringsPerLine[22])==y) {

                                datas[count] = Float.parseFloat(stringsPerLine[substance - 1]);
                                count++;
                                break;

                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

        return datas;
    }
}
