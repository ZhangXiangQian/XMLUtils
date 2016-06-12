package amap.zxq.github.com.xmlutils;

import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.List;

/**
 * Created by zhang on 2016/6/12.
 */
public class SaxParser implements BookParser{
    @Override
    public List<Book> parser(InputStream is) {

        return null;
    }

    private class ParserHandler extends DefaultHandler{


    }
}
