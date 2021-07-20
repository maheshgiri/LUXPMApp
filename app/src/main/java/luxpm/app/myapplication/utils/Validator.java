package luxpm.app.myapplication.utils;

import android.text.TextUtils;
import android.util.Patterns;

public class Validator {
    public  static boolean isUpper = false;
    public  static boolean isLower = false;
    public  static boolean isDigit = false;
    public   static boolean isSpecial = false;
    public   static boolean isRequiredLengthMatch = false;

    static final int REQUIRED_LENGTH=8;
//Validation function to check Password
  public static boolean checkPasswordStrength(String passwordtext) {
       isUpper = false;
      isLower = false;
      isDigit = false;
      isSpecial = false;
      isRequiredLengthMatch = false;
      for (int i = 0; i < passwordtext.length(); i++) {
          char c = passwordtext.charAt(i);

          if (!isSpecial && !Character.isLetterOrDigit(c)) {
              isSpecial = true;
          } else {
              if (!isDigit && Character.isDigit(c)) {
                  isDigit = true;
              } else {
                  if (!isUpper || !isLower) {
                      if (Character.isUpperCase(c))
                          isUpper = true;
                      else
                          isLower = true;
                  }
              }
          }
      }

      if (passwordtext.length() >= REQUIRED_LENGTH) {
          isRequiredLengthMatch = true;
      }

      return (isSpecial&&isDigit&&isLower&&isRequiredLengthMatch&&isUpper);
  }
//Validation Function to check Email Validation
    public static boolean checkEmailValidation(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

}
