package amap.zxq.github.com.xmlutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String xml = " <?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
            " <books> \n" +
            "   <book id=\"001\"> \n" +
            "      <title>Harry Potter</title> \n" +
            "      <author>J K. Rowling</author> \n" +
            "   </book> \n" +
            "   <book id=\"002\"> \n" +
            "      <title>Learning XML</title> \n" +
            "      <author>Erik T. Ray</author> \n" +
            "   </book> \n" +
            " </books>";

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.txtContent)).setText(xml);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    public void xml(View v){
        switch (v.getId()){
            case R.id.txtDom:
                try {
                    List<Book> list =  XMLUtils.saxXml(getResources().getAssets().open("books.xml"),Book.class);
                    String result = "";
                    for(Book b:list){
                        result += b.toString();
                    }
                    txtResult.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.txtSax:
                break;
        }
    }
}
