package luxpm.app.myapplication.activities.fragments;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import luxpm.app.myapplication.R;
import luxpm.app.myapplication.databinding.FragmentLoginBinding;
import luxpm.app.myapplication.utils.Validator;

/*
LoginFragment
 */
public class LoginFragment extends Fragment {

private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentLoginBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String signupcontent=getString(R.string.lbl_signupuser);
        SpannableString content = new SpannableString(signupcontent);
        content.setSpan(new UnderlineSpan(), signupcontent.length()-5, signupcontent.length(), 0);
        binding.txtSignup.setText(content);

        binding.txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_LoginFragment_to_SignUpFragment);
            }
        });

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailId=binding.edttxtEmail.getText().toString();
                String password=binding.edttxtPassword.getText().toString();

                if(Validator.checkEmailValidation(emailId)&&!password.isEmpty()){
                    if(emailId.trim().equals("test@luxpmsoft.com")&&password.trim().equals("test1234!")){
                        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginToHomeFragment);
                    }else{
                        Toast.makeText(getContext(),R.string.errormessage_login,Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(),R.string.errormessage_login,Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}