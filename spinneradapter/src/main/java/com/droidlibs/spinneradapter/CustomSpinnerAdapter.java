package com.droidlibs.spinneradapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Custom Spinner adapter uses custom layout for user selection and drop-down view.
 */
public class CustomSpinnerAdapter extends ArrayAdapter<String> {
  private final int textViewResId;
  private final int resourceId;

  public CustomSpinnerAdapter(@NonNull Context context, @LayoutRes int layoutResId,
      int textViewResId, @NonNull List<String> adapterElements) {
    super(context, layoutResId, adapterElements);
    this.resourceId = layoutResId;
    this.textViewResId = textViewResId;
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    super.getView(position, convertView, parent);
    return getCustomView(convertView, position, parent);
  }

  @Override
  public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    super.getDropDownView(position, convertView, parent);
    return getCustomView(convertView, position, parent);
  }

  private View getCustomView(View convertView, int position, ViewGroup parent) {
    String element = getItem(position);
    ViewHolder viewHolder;
    View view = convertView;
    if (view == null) {
      viewHolder = new ViewHolder();
      LayoutInflater flater =
          (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      view =
          flater.inflate(resourceId, null,
              false);
      viewHolder.textView = (TextView) view.findViewById(textViewResId);
      view.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) view.getTag();
    }
    if (element != null) {
      viewHolder.textView.setText(element);
    }
    return view;
  }

  private class ViewHolder {
    TextView textView;
  }
}