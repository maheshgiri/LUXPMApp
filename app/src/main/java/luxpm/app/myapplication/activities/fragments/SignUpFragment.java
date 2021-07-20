package luxpm.app.myapplication.activities.fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;

import luxpm.app.myapplication.R;
import luxpm.app.myapplication.databinding.FragmentSignupBinding;
import luxpm.app.myapplication.utils.Validator;
/*
SignUp Fragment
 */


public class SignUpFragment extends Fragment {

private FragmentSignupBinding binding;

boolean isValidEmail=false;
boolean isValidPassword=false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentSignupBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String signincontent=getString(R.string.lbl_signuporlogin);
        SpannableString content = new SpannableString(signincontent);
        content.setSpan(new UnderlineSpan(), signincontent.length()-4, signincontent.length(), 0);
        binding.txtSignin.setText(content);

        binding.txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SignUpFragment.this).navigate(R.id.action_SignUpFragment_to_LoginFragment);
            }
        });


        Drawable doneitem= ContextCompat.getDrawable(getContext(), R.drawable.item_done);
        Drawable notdoneitem=ContextCompat.getDrawable(getContext(),R.drawable.item_undone);
        String validEmailError=getString(R.string.labl_validateemailstring);
        binding.edttxtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("NewApi")
            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()){
                   Validator.checkPasswordStrength(editable.toString());


                    if (Validator.isDigit) {
                        binding.txtvAtleastonenumber.setCompoundDrawablesRelativeWithIntrinsicBounds(doneitem, null, null, null);
                    } else {
                        binding.txtvAtleastonenumber.setCompoundDrawablesRelativeWithIntrinsicBounds(notdoneitem, null, null, null);
                    }

                    if (Validator.isUpper) {
                        binding.txtvAtleastoneuppercase.setCompoundDrawablesRelativeWithIntrinsicBounds(doneitem, null, null, null);
                    } else {
                        binding.txtvAtleastoneuppercase.setCompoundDrawablesRelativeWithIntrinsicBounds(notdoneitem, null, null, null);
                    }

                    if (Validator.isSpecial) {
                        binding.txtvAtleastonespecial.setCompoundDrawablesRelativeWithIntrinsicBounds(doneitem, null, null, null);
                    } else {
                        binding.txtvAtleastonespecial.setCompoundDrawablesRelativeWithIntrinsicBounds(notdoneitem, null, null, null);
                    }

                    if (Validator.isRequiredLengthMatch) {
                        binding.txtvAtleasteightcharector.setCompoundDrawablesRelativeWithIntrinsicBounds(doneitem, null, null, null);
                    } else {
                        binding.txtvAtleasteightcharector.setCompoundDrawablesRelativeWithIntrinsicBounds(notdoneitem, null, null, null);
                    }



                }else{

                }
            }
        });

        binding.edttxtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    if(Validator.checkEmailValidation(editable.toString().trim())){
                        binding.edttxtEmail.setError(null);
                    }else{
                        binding.edttxtEmail.setError(validEmailError);
                    }

            }
        });

        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= binding.edttxtName.getText().toString();
                String email=binding.edttxtEmail.getText().toString();
                String dateofbirth=binding.edttxtDateofbirth.getText().toString();
                String mobileno=binding.edttxtPhonenumber.getText().toString();
                String password=binding.edttxtPassword.getText().toString();
                String confirmPassword=binding.edttxtConfirmpassword.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(getContext(),R.string.labl_validateemailstring,Toast.LENGTH_SHORT).show();
                }
                if(Validator.checkPasswordStrength(password)){
                    //Password Validated
                }

            }
        });

    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding.edttxtEmail.addTextChangedListener(null);
        binding.edttxtPassword.addTextChangedListener(null);
        binding = null;

    }

}