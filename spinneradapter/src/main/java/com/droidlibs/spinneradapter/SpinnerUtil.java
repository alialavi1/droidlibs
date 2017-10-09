package com.droidlibs.spinneradapter;

import android.widget.Spinner;
import java.lang.reflect.Field;

/**
 * Utility class to modify Spinner dimensions.
 */
public class SpinnerUtil {

  /**
   * Set the Dropdown Height of the Spinner
   * @param spinner Spinner object
   * @param dropdownHeight dropdown height in pixels.
   */
  public static void setDropdownHeight(Spinner spinner, int dropdownHeight) {
    try {
      Field popup = Spinner.class.getDeclaredField("mPopup");
      popup.setAccessible(true);

      // Get private mPopup member variable and try cast to ListPopupWindow
      android.widget.ListPopupWindow popupWindow =
          (android.widget.ListPopupWindow) popup.get(spinner);

      popupWindow.setHeight(dropdownHeight);
    } catch (NoClassDefFoundError | ClassCastException | NoSuchFieldException | IllegalAccessException e) {

    }
  }

}
