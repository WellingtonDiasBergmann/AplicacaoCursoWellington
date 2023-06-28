package com.example.aplicacaocursos4atb.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aplicacaocursos4atb.R;
import com.example.aplicacaocursos4atb.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verificando se o usuário informou os dados
                if (!binding.etLoginUsuario.getText().toString().equals("")) {
                    if (!binding.etLoginSenha.getText().toString().equals("")) {
                        // obtendo as informações
                        String usuario = binding.etLoginUsuario.getText().toString();
                        String senha = binding.etLoginSenha.getText().toString();

                        // verificando se o usuario e senha conferem (SIMULAÇÃO)
                        if (usuario.equals("lorenzi") && senha.equals("12345")) {
                            // chamando o fragment de menu
                            Navigation.findNavController(view).navigate(R.id.acao_LoginFragment_MenuFragment);
                        } else {
                            Toast.makeText(getContext(), "Erro: usuário e senha inválidos.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        binding.etLoginSenha.setError("Erro: informe a senha");
                        binding.etLoginSenha.requestFocus();
                    }
                } else {
                    binding.etLoginUsuario.setError("Erro: informe o usuário.");
                    binding.etLoginUsuario.requestFocus();
                }
            }
        });

        binding.bLoginCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });
    }

    public void limpaCampos() {
        binding.etLoginUsuario.setText("");
        binding.etLoginSenha.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}