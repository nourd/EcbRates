package au.example.ecbrates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends ArrayAdapter<Currency> {

    private LayoutInflater inflater;
    private int layout;
    private List<Currency> currencies;

    public CurrencyAdapter(Context context, int resource, List<Currency> currencies) {
        super(context, resource, currencies);
        this.currencies = currencies;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView currencyNameView = view.findViewById(R.id.currencyName);
        TextView rateView = view.findViewById(R.id.rate);

        Currency currency = currencies.get(position);

        currencyNameView.setText(currency.getCurrencyName());
        rateView.setText(String.valueOf(currency.getRate()));

        return view;
    }
}
