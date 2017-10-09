package com.droidlibs.spinnersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import com.droidlibs.spinneradapter.CustomDropdownAdapter;
import com.droidlibs.spinneradapter.CustomSpinnerAdapter;
import com.droidlibs.spinneradapter.SpinnerUtil;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private Spinner spinner;
  private static final String CONSTANT_OS = "OS ";
  private static final int SPINNER_HEIGHT = 300;
  private Spinner spinnerDropdown;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    spinner = (Spinner) findViewById(R.id.sampleSpinner);
    spinnerDropdown = (Spinner) findViewById(R.id.sampleDropdownSpinner);
    setSpinnerAdapter();
  }

  private void setSpinnerAdapter() {
    List<String> dropdownElements = new ArrayList<>();
    dropdownElements.add("KitKat");
    dropdownElements.add("Lollipop");
    dropdownElements.add("Marshmallow");
    dropdownElements.add("Nougat");
    dropdownElements.add("Oreo");

    List<String> displayItems = new ArrayList<>();
    displayItems.add(CONSTANT_OS + "4.4");
    displayItems.add(CONSTANT_OS + "5.0");
    displayItems.add(CONSTANT_OS + "6.0");
    displayItems.add(CONSTANT_OS + "7.0");
    displayItems.add(CONSTANT_OS + "8.0");

    CustomSpinnerAdapter spinnerAdapter =
        new CustomSpinnerAdapter(this, R.layout.custom_spinner_adapter, R.id.text1, dropdownElements);
    spinner.setAdapter(spinnerAdapter);

    CustomDropdownAdapter dropdownAdapter =
        new CustomDropdownAdapter(this, R.layout.custom_spinner_adapter,
            R.layout.custom_spinner_dropdown,
            dropdownElements, displayItems);

    spinnerDropdown.setAdapter(dropdownAdapter);
    SpinnerUtil.setDropdownHeight(spinnerDropdown, SPINNER_HEIGHT);
  }
}
