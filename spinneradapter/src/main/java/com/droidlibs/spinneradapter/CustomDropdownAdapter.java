package com.droidlibs.spinneradapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Custom ArrayAdapter to set CountryNames and CountryCodes for PhoneCountryCode Spinner.
 */
public class CustomDropdownAdapter extends ArrayAdapter {
  private final List<String> dropDownItems;
  private final List<String> displayItems;
  private final String BRACES_OPEN = "(";
  private final String BRACES_CLOSED = ")";
  int mainResourceId;
  int dropDownResourceId;
  Context context;

  /**
   * Constructor for CustomArrayAdapter. Provides different layout mode for Spinner display and
   * Dropdown view.
   *
   * @param mainResource resourced ID for Spinner selection view
   * @param dropDownResource resource ID for Spinner drop down view
   * @param dropDownItems list of dropDownItems to populate spinner drop down
   * @param displayItems list of displayItems to populate spinner selection
   */
  public CustomDropdownAdapter(@NonNull Context context, @LayoutRes int mainResource,
      int dropDownResource,
      @NonNull List<String> dropDownItems, List<String> displayItems) {
    super(context, mainResource, dropDownItems);
    this.context = context;
    this.mainResourceId = mainResource;
    this.dropDownResourceId = dropDownResource;
    this.dropDownItems = dropDownItems;
    this.displayItems = displayItems;
  }

  @Override public View getDropDownView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    TextView row = (TextView) inflater.inflate(dropDownResourceId, parent, false);
    row.setText(dropDownItems.get(position));
    return row;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    return getCustomView(position, parent);
  }

  private View getCustomView(int position, ViewGroup parent) {
    LayoutInflater inflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    TextView row = (TextView) inflater.inflate(mainResourceId, parent, false);
    row.setText(BRACES_OPEN + displayItems.get(position) + BRACES_CLOSED);
    return row;
  }
}
