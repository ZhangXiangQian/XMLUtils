package amap.zxq.github.com.xmlutils;

import java.io.InputStream;
import java.util.List;

/**
 * Created by zhang on 2016/6/12.
 */
public interface BookParser {

    public List<Book> parser(InputStream is);
}
