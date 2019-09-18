package Services;

import Util.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TerrainData {

    public OutList getData(int start, int end, int substance) {

        OutList out = new OutList();
        substance = substance + 7;

        List<int[]> pieList = new ArrayList<int[]>();


        if (start == end) {

            String file1 = FilePath.inputFilePath + start + ".DAT";


            ColorCount colorCount = new ColorCount();
//
            OutputData outputData = new OutputData(file1);

            List<String[]> strings = outputData.getListPerLine();

            List<int[]> outList = new ArrayList<int[]>();

            for (String[] str : strings) {
//                int i=0;

                if (substance > 7 && substance < 17) {
                    colorCount = CountUtil.getColorCount(Float.parseFloat(str[substance - 1]), colorCount, substance);
                }
                if (substance == 17) {
                    colorCount = CountUtil.getColorCount(Float.parseFloat(str[7]) + Float.parseFloat(str[8]) + Float.parseFloat(str[13]), colorCount, substance);
                }
                if (substance == 18) {
                    colorCount = CountUtil.getColorCount(Float.parseFloat(str[9]) + Float.parseFloat(str[14]), colorCount, substance);
                }

                Color color = colorCount.getColor();
                int x = (int) Double.parseDouble(str[21]);
                int y = (int) Double.parseDouble(str[22]);
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
            String file1 = FilePath.inputFilePath + start + ".DAT";

            ColorCount colorCount = new ColorCount();
//
            OutputData outputData = new OutputData(file1);

            List<String[]> strings = outputData.getListPerLine();

            List<int[]> outList = new ArrayList<int[]>();

            for (String[] str : strings) {
//                int i=0;

                if (substance > 7 && substance < 17) {
                    colorCount = CountUtil.getColorCount(Float.parseFloat(str[substance - 1]), colorCount, substance);
                }
                if (substance == 17) {
                    colorCount = CountUtil.getColorCount(Float.parseFloat(str[7]) + Float.parseFloat(str[8]) + Float.parseFloat(str[13]), colorCount, substance);
                }
                if (substance == 18) {
                    colorCount = CountUtil.getColorCount(Float.parseFloat(str[9]) + Float.parseFloat(str[14]), colorCount, substance);
                }

                Color color = colorCount.getColor();
                int x = (int) Double.parseDouble(str[21]);
                int y = (int) Double.parseDouble(str[22]);
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
        return null;
    }

}
