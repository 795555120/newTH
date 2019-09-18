package Util;

public class CountUtil {
    public static ColorCount getColorCount(float concentration, ColorCount colorCount, int substant){

        //(8)氨氮NH3-N（mg/L） ","（9）硝氮NO3-N（mg/L）","10无机磷MINP（mg/L） ","11叶绿素Chla（mg/L）" ," 12生化需氧量BOD（mg/L） ","13溶解氧DO（mg/L）","14有机氮ORGN（mg/L） ","15有机磷ORGP（mg/L） ","16水温TEM(℃)

        //氨氮
        if (substant == 8) {
            if ( concentration <= 0.15) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 0.15 && concentration <= 0.5) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 0.5 && concentration <= 1) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 1 && concentration <= 1.5) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }
//（9）硝氮NO3-N（mg/L）
        if (substant == 9) {
            if (concentration > 0 && concentration <= 10) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 10 && concentration <= 15) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 15 && concentration <= 20) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 20 && concentration <= 30) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

        //    无机磷
        if (substant == 10) {
            if (concentration > 0 && concentration <= 0.02) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 0.01 && concentration <= 0.1) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 0.1 && concentration <= 0.2) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 0.2 && concentration <= 0.3) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

//        叶绿素
        if (substant == 11) {
            if (concentration > 0 && concentration <= 1) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 1&& concentration <= 5) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 5 && concentration <= 10) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 10 && concentration <= 50) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

        //    生化需氧量
        if (substant == 12) {
            if (concentration > 0 && concentration <= 2) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 2 && concentration <= 3) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 3 && concentration <= 4) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 4 && concentration <= 6) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

        //    溶解氧
        if (substant == 13) {
            if (concentration > 0 && concentration <= 1) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 1 && concentration <= 5) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 5 && concentration <= 10) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 10 && concentration <= 50) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }
        //有机氮
        if (substant == 14) {
            if (concentration <= 0.2) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 0.2 && concentration <= 0.5) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 0.5 && concentration <= 1.0) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 1.0 && concentration <= 1.5) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

        //    有机磷
        if (substant == 15) {
            if (concentration > 0 && concentration <= 0.02) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 0.02 && concentration <= 0.1) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 0.1 && concentration <= 0.2) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 0.2 && concentration <= 0.3) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

        //    水温
        if (substant == 16) {
            if (concentration > 0 && concentration <= 1) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 1 && concentration <= 5) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 5 && concentration <= 10) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 10 && concentration <= 50) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }

//    总氮
        if (substant == 17) {
            if (concentration <= 0.2) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 0.2 && concentration <= 0.5) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 0.5 && concentration <= 1.0) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 1.0 && concentration <= 1.5) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }
//    总磷
        if (substant == 18) {
            if (concentration > 0 && concentration <= 0.02) {
                colorCount.CountOfLevel1++;
                colorCount.setColor(ColorGrade.LEVEL1);
            } else if (concentration > 0.01 && concentration <= 0.1) {
                colorCount.CountOfLevel2++;
                colorCount.setColor(ColorGrade.LEVEL2);
            } else if (concentration > 0.1 && concentration <= 0.2) {
                colorCount.CountOfLevel3++;
                colorCount.setColor(ColorGrade.LEVEL3);
            } else if (concentration > 0.2 && concentration <= 0.3) {
                colorCount.CountOfLevel4++;
                colorCount.setColor(ColorGrade.LEVEL4);
            } else {
                colorCount.CountOfLevel5++;
                colorCount.setColor(ColorGrade.LEVEL5);
            }

        }
        return colorCount;
    }
}
