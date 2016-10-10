package unicauca.movil.blecentral.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.blecentral.R;

/**
 * Created by Dario Chamorro on 3/10/2016.
 */

public class DeviceAdapter extends BaseAdapter {
    Context context;
    List<DeviceItem> data;

    public DeviceAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    //region Adapter Methods
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;

        if(convertView == null)
            v =  View.inflate(context, R.layout.template_device, null);
        else
            v = convertView;

        DeviceItem item = (DeviceItem) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.title);
        txt.setText(item.getTitle());

        txt = (TextView) v.findViewById(R.id.subtitle);
        txt.setText(item.getSubtitle());

        return v;
    }
    //endregion

    public void addItem(DeviceItem item){
        data.add(item);
        notifyDataSetChanged();
    }

    public class DeviceItem{

        String title, subtitle;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
    }

}
