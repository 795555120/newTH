package Util;

public class CountUtil_Remote {
    public static ColorCount getColorCount(float concentration, ColorCount colorCount, int substant){

    //叶绿素
        if (substant == 6) {
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
//     透明度
        if (substant == 7) {
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

    //    化学需氧量COD
        if (substant == 8) {
        if (concentration > 0 && concentration <= 15) {
            colorCount.CountOfLevel1++;
            colorCount.setColor(ColorGrade.LEVEL1);
        } else if (concentration >15 && concentration <= 20) {
            colorCount.CountOfLevel2++;
            colorCount.setColor(ColorGrade.LEVEL2);
        } else if (concentration > 20 && concentration <= 30) {
            colorCount.CountOfLevel3++;
            colorCount.setColor(ColorGrade.LEVEL3);
        } else if (concentration > 30 && concentration <= 40) {
            colorCount.CountOfLevel4++;
            colorCount.setColor(ColorGrade.LEVEL4);
        } else {
            colorCount.CountOfLevel5++;
            colorCount.setColor(ColorGrade.LEVEL5);
        }

    }

//        氨氮NH3-N
        if (substant == 9) {
        if (concentration > 0 && concentration <= 0.15) {
            colorCount.CountOfLevel1++;
            colorCount.setColor(ColorGrade.LEVEL1);
        } else if (concentration > 0.15&& concentration <= 0.5) {
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

    //    总氮TN
        if (substant == 10) {
        if (concentration > 0 && concentration <= 0.2) {
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

    //    总磷TP
        if (substant == 11) {
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
    //溶解氧DO
        if (substant == 12) {
        if (concentration >= 7.5) {
            colorCount.CountOfLevel1++;
            colorCount.setColor(ColorGrade.LEVEL1);
        } else if (concentration >= 6 && concentration < 7.5) {
            colorCount.CountOfLevel2++;
            colorCount.setColor(ColorGrade.LEVEL2);
        } else if (concentration >= 5 && concentration < 6) {
            colorCount.CountOfLevel3++;
            colorCount.setColor(ColorGrade.LEVEL3);
        } else if (concentration >= 3 && concentration < 5) {
            colorCount.CountOfLevel4++;
            colorCount.setColor(ColorGrade.LEVEL4);
        } else {
            colorCount.CountOfLevel5++;
            colorCount.setColor(ColorGrade.LEVEL5);
        }

    }

    //    生化需氧量BOD
        if (substant == 13) {
        if (concentration > 0 && concentration <= 3) {
            colorCount.CountOfLevel1++;
            colorCount.setColor(ColorGrade.LEVEL1);
        } else if (concentration > 3 && concentration <= 4) {
            colorCount.CountOfLevel2++;
            colorCount.setColor(ColorGrade.LEVEL2);
        } else if (concentration > 4 && concentration <= 6) {
            colorCount.CountOfLevel3++;
            colorCount.setColor(ColorGrade.LEVEL3);
        } else if (concentration > 6 && concentration <= 10) {
            colorCount.CountOfLevel4++;
            colorCount.setColor(ColorGrade.LEVEL4);
        } else {
            colorCount.CountOfLevel5++;
            colorCount.setColor(ColorGrade.LEVEL5);
        }

    }

    //    水温TEM
        if (substant == 14) {
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

//    ph
        if (substant == 15) {
        if (concentration >= 6.5 && concentration <= 7.5) {
            colorCount.CountOfLevel1++;
            colorCount.setColor(ColorGrade.LEVEL1);
        } else if (concentration >= 6 && concentration <= 8) {
            colorCount.CountOfLevel2++;
            colorCount.setColor(ColorGrade.LEVEL2);
        } else if (concentration >= 5.5 && concentration <= 8.5) {
            colorCount.CountOfLevel3++;
            colorCount.setColor(ColorGrade.LEVEL3);
        } else if (concentration >= 5 && concentration <= 9) {
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
