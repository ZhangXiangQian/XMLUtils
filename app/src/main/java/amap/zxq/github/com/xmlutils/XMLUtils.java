package amap.zxq.github.com.xmlutils;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by zhang on 2016/6/12.
 */
public class XMLUtils {

    public static List<Book> saxXml(InputStream is,Class<?> entityType) {
        Log.i("Dom_Xml","开始解析");
        List<Book> bookList = null;
        DocumentBuilderFactory mDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = mDocumentBuilderFactory.newDocumentBuilder();
            try {
                bookList = new ArrayList<>();
                Document document = builder.parse(is);
                Element element = document.getDocumentElement();
                NodeList nodeList = element.getElementsByTagName(entityType. getSimpleName().toLowerCase());
                Log.i("Dom_Xml","className:" + entityType.getSimpleName().toLowerCase());
                Log.i("Dom_Xml","size:" + nodeList.getLength());
                for(int i = 0;i < nodeList.getLength();i++){
                    Book book = new Book();
                    Element ee = (Element) nodeList.item(i);
                    NodeList nl = ee.getChildNodes();
                    for(int j = 0;j < nl.getLength();j ++){
                        if(nl.item(j).getNodeType() == Node.ELEMENT_NODE){
                            Element e = (Element) nl.item(j);
                            if("id".equals(e.getNodeName())){
                                book.setId(e.getFirstChild().getNodeValue());
                            }
                            if("name".equals(e.getNodeName())){
                                book.setName(e.getFirstChild().getNodeValue());
                            }
                            if("price".equals(e.getNodeName())){
                                book.setPrice(e.getFirstChild().getNodeValue());
                            }
                        }
                    }
                    Log.i("Dom_Xml",book.toString());
                    bookList.add(book);
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Log.i("Dom_Xml","解析完成");
        return bookList;
    }

}
