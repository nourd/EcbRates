package au.example.ecbrates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ListView currenciesList;
    ArrayList<Currency> currencyItems = new ArrayList<Currency>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            XmlPullParser xpp = getResources().getXml(R.xml.ecb);
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType() == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("Cube")) {
                        if(xpp.getAttributeCount() == 2) {
                            currencyItems.add(new Currency(
                                    xpp.getAttributeValue(0),
                                    Double.valueOf(xpp.getAttributeValue(1))));
                        }
                    }
                }
                xpp.next();
            }
        } catch (Throwable t) {
            Toast.makeText(this, "Request failed: " + t.toString(),
                    Toast.LENGTH_LONG).show();
        }

        currenciesList = findViewById(R.id.currencieslist);
        CurrencyAdapter currencyAdapter = new CurrencyAdapter(this, R.layout.list_item, currencyItems);
        currenciesList.setAdapter(currencyAdapter);

    }

}