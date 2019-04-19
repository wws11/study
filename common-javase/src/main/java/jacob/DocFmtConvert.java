/*
package jacob;

*/
/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/19 17:26
 *//*

*/
/*import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;*//*

// 格式大全:前缀对应以下方法的fmt值
// 0:Microsoft Word 97 - 2003 文档 (.doc)
// 1:Microsoft Word 97 - 2003 模板 (.dot)
// 2:文本文档 (.txt)
// 3:文本文档 (.txt)
// 4:文本文档 (.txt)
// 5:文本文档 (.txt)
// 6:RTF 格式 (.rtf)
// 7:文本文档 (.txt)
// 8:HTML 文档 (.htm)(带文件夹)
// 9:MHTML 文档 (.mht)(单文件)
// 10:MHTML 文档 (.mht)(单文件)
// 11:XML 文档 (.xml)
// 12:Microsoft Word 文档 (.docx)
// 13:Microsoft Word 启用宏的文档 (.docm)
// 14:Microsoft Word 模板 (.dotx)
// 15:Microsoft Word 启用宏的模板 (.dotm)
// 16:Microsoft Word 文档 (.docx)
// 17:PDF 文件 (.pdf)
// 18:XPS 文档 (.xps)
// 19:XML 文档 (.xml)
// 20:XML 文档 (.xml)
// 21:XML 文档 (.xml)
// 22:XML 文档 (.xml)
// 23:OpenDocument 文本 (.odt)
// 24:WTF 文件 (.wtf)

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

*/
/**
 * 使用jacob进行Word文档格式互转(例:doc2docx、docx2doc)
 *
 * @author Harley Hong
 * @created 2017 /08/09 16:09:32
 *//*

public class DocFmtConvert {


    private static final int DOC_FMT = 0;

    private static final int DOCX_FMT = 12;

    public static void main(String[] args) {
        DocFmtConvert dfc = new DocFmtConvert();
        String srcDocPath = "C:\\Users\\DELL\\Desktop\\80-1.wps、";
        String descDocPath = "C:\\Users\\DELL\\Desktop\\a.pdf";
        try {
            dfc.convertDocFmt(srcDocPath, descDocPath, DOC_FMT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public File convertDocFmt(String srcPath, String descPath, int fmt) throws Exception {
        // 实例化ComThread线程与ActiveXComponent
        ComThread.InitSTA();
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        try {
// 文档隐藏时进行应用操作
            app.setProperty("Visible", new Variant(false));
// 实例化模板Document对象
            Dispatch document = app.getProperty("Documents").toDispatch();
// 打开Document进行另存为操作
            Dispatch doc = Dispatch.invoke(document, "Open", Dispatch.Method,
                    new Object[] { srcPath, new Variant(true), new Variant(true) }, new int[1]).toDispatch();
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] { descPath, new Variant(fmt) }, new int[1]);
            Dispatch.call(doc, "Close", new Variant(false));
            return new File(descPath);
        } catch (Exception e) {
            throw e;
        } finally {
// 释放线程与ActiveXComponent
            app.invoke("Quit", new Variant[] {});
            ComThread.Release();
        }
    }
}
*/
