package Services;

import Util.*;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class TerrainData_Remote {
    int i;
    int n=0;
    int m=0;
    public OutList getData(int start, int end, int substance) {
        OutList out = new OutList();
        substance = substance + 5;

        List<int[]> pieList = new ArrayList<int[]>();

        if (start == end) {
            String file1 = FilePath.WQPath + start + ".DAT";
            System.out.println(file1);

            ColorCount colorCount = new ColorCount();

            OutputData_Remote outputData = new OutputData_Remote(file1);

            List<String[]> strings = outputData.getListPerLine();

            List<int[]> outList = new ArrayList<int[]>();

            for (String[] str : strings) {

                colorCount = CountUtil_Remote.getColorCount(Float.parseFloat(str[substance - 1]), colorCount, substance);

                Color color = colorCount.getColor();
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                int[] output = {x, y, r, g, b};
//                outList[i]=output;
                outList.add(output);
//                i++;
            }


            //将有饼状图的数据装入数组里面

            int[] pieData1 = new int[]{ColorGrade.LEVEL1.getRed(), ColorGrade.LEVEL1.getGreen(), ColorGrade.LEVEL1.getBlue(), colorCount.getCountOfLevel1()};
            pieList.add(pieData1);

            int[] pieData2 = new int[]{ColorGrade.LEVEL2.getRed(), ColorGrade.LEVEL2.getGreen(), ColorGrade.LEVEL2.getBlue(), colorCount.getCountOfLevel2()};
            pieList.add(pieData2);

            int[] pieData3 = new int[]{ColorGrade.LEVEL3.getRed(), ColorGrade.LEVEL3.getGreen(), ColorGrade.LEVEL3.getBlue(), colorCount.getCountOfLevel3()};
            pieList.add(pieData3);

            int[] pieData4 = new int[]{ColorGrade.LEVEL4.getRed(), ColorGrade.LEVEL4.getGreen(), ColorGrade.LEVEL4.getBlue(), colorCount.getCountOfLevel4()};
            pieList.add(pieData4);

            int[] pieData5 = new int[]{ColorGrade.LEVEL5.getRed(), ColorGrade.LEVEL5.getGreen(), ColorGrade.LEVEL5.getBlue(), colorCount.getCountOfLevel5()};
            pieList.add(pieData5);

            out.setTerrainList(outList);
            out.setPieList(pieList);

            return out;
        }

        if (start < end) {
//    在此目录中找文件
            String baseDIR = "D:\\RSM_TH\\DAT_IN";

            String fileName = "WQ_2D_FIG"+"*"+".DAT";
            List resultList = new ArrayList();
            findFiles(baseDIR, fileName, resultList);
            if (resultList.size() == 0) {
                System.out.println("No File Fount.");
            } else {
                for ( i = 0; i < resultList.size(); i++) {
                    System.out.println(resultList.get(i));//显示查找结果。
                    if (("WQ_2D_FIG"+start+".DAT").equals(resultList.get(i).toString())){
                        n = i;
                    }
                    if(("WQ_2D_FIG"+end+".DAT").equals(resultList.get(i).toString())){
                        m = i;
                    }
                }
            }
            System.out.println(n);
            System.out.println(m);
            String file1 = ""+resultList.get(n);
            System.out.println(file1);

            ColorCount colorCount = new ColorCount();

            OutputData_Remote outputData = new OutputData_Remote(file1);

            List<String[]> strings = outputData.getListPerLine();

            List<int[]> outList = new ArrayList<int[]>();

            for (String[] str : strings) {

                colorCount = CountUtil_Remote.getColorCount(Float.parseFloat(str[substance - 1]), colorCount, substance);

                Color color = colorCount.getColor();
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                int[] output = {x, y, r, g, b};

                outList.add(output);

            }


            //将有饼状图的数据装入数组里面

            int[] pieData1 = new int[]{ColorGrade.LEVEL1.getRed(), ColorGrade.LEVEL1.getGreen(), ColorGrade.LEVEL1.getBlue(), colorCount.getCountOfLevel1()};
            pieList.add(pieData1);

            int[] pieData2 = new int[]{ColorGrade.LEVEL2.getRed(), ColorGrade.LEVEL2.getGreen(), ColorGrade.LEVEL2.getBlue(), colorCount.getCountOfLevel2()};
            pieList.add(pieData2);

            int[] pieData3 = new int[]{ColorGrade.LEVEL3.getRed(), ColorGrade.LEVEL3.getGreen(), ColorGrade.LEVEL3.getBlue(), colorCount.getCountOfLevel3()};
            pieList.add(pieData3);

            int[] pieData4 = new int[]{ColorGrade.LEVEL4.getRed(), ColorGrade.LEVEL4.getGreen(), ColorGrade.LEVEL4.getBlue(), colorCount.getCountOfLevel4()};
            pieList.add(pieData4);

            int[] pieData5 = new int[]{ColorGrade.LEVEL5.getRed(), ColorGrade.LEVEL5.getGreen(), ColorGrade.LEVEL5.getBlue(), colorCount.getCountOfLevel5()};
            pieList.add(pieData5);

            out.setTerrainList(outList);
            out.setPieList(pieList);

            return out;
        }

        return null;
    }

    public static void main(String[] args) {
        int i;
        int start=20190406;
        int end=20190504;
        int n=0;
        int m=0;
        String baseDIR = "D:\\RSM_TH\\DAT_IN";

        String fileName = "WQ_2D_FIG"+"*"+".DAT";
        List resultList = new ArrayList();
        findFiles(baseDIR, fileName, resultList);
        if (resultList.size() == 0) {
            System.out.println("No File Fount.");
        } else {
            for ( i = 0; i < resultList.size(); i++) {
                System.out.println(resultList.get(i));//显示查找结果。
                if ((FilePath.WQPath+start+".DAT").equals(resultList.get(i).toString())){
                    n = i;
                }
                if((FilePath.WQPath+end+".DAT" ).equals(resultList.get(i).toString())){
                    m = i;
                }
            }
        }
        System.out.println(n);
        System.out.println(m);
        String file1 = resultList.get(n).toString();
        System.out.println(file1);

    }


    /**
     * 递归查找文件
     *
     * @param baseDirName    查找的文件夹路径
     * @param targetFileName 需要查找的文件名
     * @param fileList       查找到的文件集合
     */
    public static void findFiles(String baseDirName, String targetFileName, List fileList) {

        File baseDir = new File(baseDirName);        // 创建一个File对象
        if (!baseDir.exists() || !baseDir.isDirectory()) {    // 判断目录是否存在
            System.out.println("文件查找失败：" + baseDirName + "不是一个目录！");
        }
        String tempName = null;
        //判断目录是否存在
        File tempFile;
        File[] files = baseDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            tempFile = files[i];
            if (tempFile.isDirectory()) {
                findFiles(tempFile.getAbsolutePath(), targetFileName, fileList);
            } else if (tempFile.isFile()) {
                tempName = tempFile.getName();
                if (wildcardMatch(targetFileName, tempName)) {
                    // 匹配成功，将文件名添加到结果集
                    fileList.add(tempFile.getAbsoluteFile());
                }
            }
        }
    }

    /**
     * 通配符匹配
     *
     * @param pattern 通配符模式
     * @param str     待匹配的字符串
     * @return 匹配成功则返回true，否则返回false
     */
    private static boolean wildcardMatch(String pattern, String str) {
        int patternLength = pattern.length();
        int strLength = str.length();
        int strIndex = 0;
        char ch;
        for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
            ch = pattern.charAt(patternIndex);
            if (ch == '*') {
                //通配符星号*表示可以匹配任意多个字符
                while (strIndex < strLength) {
                    if (wildcardMatch(pattern.substring(patternIndex + 1),
                            str.substring(strIndex))) {
                        return true;
                    }
                    strIndex++;
                }
            } else if (ch == '?') {
                //通配符问号?表示匹配任意一个字符
                strIndex++;
                if (strIndex > strLength) {
                    //表示str中已经没有字符匹配?了。
                    return false;
                }
            } else {
                if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }

}






