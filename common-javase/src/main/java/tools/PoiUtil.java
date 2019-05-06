package tools;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/28 11:58
 */
public class PoiUtil {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DELL\\Desktop\\a5564ded3074c69672bab5c178ae850e.xlsx");
        try {
            String[][] result = readExcelData(file, 0);
            int rowLength = result.length;
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.err.println(result[i][j] + "\t\t");
                }
                System.err.println("$$$$$$$$$$$$$");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[][] readExcelData(File file, int ignoreRows) throws Exception{
        List<String[]> result = new ArrayList<String[]>();
        int rowSize = 0;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        //打开HSSWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFCell cell = null;
        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
            HSSFSheet st = wb.getSheetAt(sheetIndex);
            //从规定位置，开始逐行读取内容
            for (int rowIndex = ignoreRows; rowIndex < st.getLastRowNum(); rowIndex++) {
                HSSFRow row = st.getRow(rowIndex);
                if(row == null){
                    continue;
                }
                int tempRowSize = row.getLastCellNum() + 1;
                if(tempRowSize > rowSize){
                    rowSize = tempRowSize;
                }
                String[] values = new String[rowSize];
                Arrays.fill(values, "");
                boolean hasValue = false;
                for (short columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
                    String value = "";
                    cell = row.getCell(columnIndex);
                    if(cell != null){
                        //设置字体编码
                        //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                        switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_STRING:
                                value = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                if(HSSFDateUtil.isCellDateFormatted(cell)){
                                    Date date = cell.getDateCellValue();
                                    if(date != null){
                                        value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                    }else{
                                        value = "";
                                    }
                                }else{
                                    value = new DecimalFormat("0").format(cell.getNumericCellValue());
                                }
                                break;
                            case HSSFCell.CELL_TYPE_FORMULA:
                                //导入时如果为公式生成的数据则无值
                                if(!cell.getStringCellValue().equals("")){
                                    value = cell.getStringCellValue();
                                }else{
                                    value = cell.getNumericCellValue() + "";
                                }
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                value = "";
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                value = (cell.getBooleanCellValue() == true ? "Y":"N");
                                break;
                            default:
                                value = "";
                                break;
                        }
                    }
                    if(columnIndex  == 0 && value.trim().equals("")){
                        break;
                    }
                    values[columnIndex] = removeSpaceTrim(value);
                    hasValue = true;
                }
                if(hasValue){
                    result.add(values);
                }
            }
        }
        in.close();
        String[][] returnArray = new String[result.size()][rowSize];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = (String[]) result.get(i);
        }
        return returnArray;
    }

    /**
     * 去掉字符串右边的空格
     * @param 要处理的字符串
     * @return 处理后的结果
     */
    private static String removeSpaceTrim(String value) {
        /*if(StringHelper.isEmpty(value)){
            return "";
        }*/
        int length = value.length();
        for (int i = length - 1; i >= 0; i--) {
            if(value.charAt(i) != 0x20){
                break;
            }
            length--;
        }
        return value.substring(0, length);
    }
}
