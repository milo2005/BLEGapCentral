package unicauca.movil.blecentral.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unicauca.movil.blecentral.R;

/**
 * Created by Dario Chamorro on 3/10/2016.
 */

public class DeviceAdapter extends BaseAdapter {
    Context context;
    List<BleItem> data;

    public DeviceAdapter(Context context, List<BleItem> data) {
        this.context = context;
        this.data = data;
    }

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

        BleItem item = (BleItem) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.title);
        txt.setText(item.getTitle());

        txt = (TextView) v.findViewById(R.id.subtitle);
        txt.setText(item.getSubtitle());

        return v;
    }

    public class BleItem{

        public static final int TYPE_DEVICE=0;
        public static final int TYPE_SERVICE=1;
        public static final int TYPE_CHARACTERISTIC=2;

        String title, subtitle;
        int type;

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
