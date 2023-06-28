package com.example.aplicacaocursos4atb.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aplicacaocursos4atb.R;
import com.example.aplicacaocursos4atb.databinding.FragmentCadastroBinding;
import com.example.aplicacaocursos4atb.modelDominio.Curso;


public class CadastroFragment extends Fragment {

    FragmentCadastroBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cadastro, container, false);
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.bSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // verificando se o usuário informou os dados
            if (!binding.etCadastroNome.getText().toString().equals("")){
                if (!binding.etCadastroCargaHoraria.getText().toString().equals("")){
                    if (!binding.etCadastroConceito.getText().toString().equals("")){
                        if (!binding.rbCadastroTecnologo.isChecked() || binding.rbCadastroBacharelado.isChecked() || binding.rbCadastroLiceciatura.isChecked()){
                            String nome = binding.etCadastroNome.getText().toString();
                            float cargaHoraria = Float.parseFloat(binding.etCadastroCargaHoraria.getText().toString());
                            int conceito = Integer.parseInt(binding.etCadastroConceito.getText().toString());
                            int tipo;
                            if (binding.rbCadastroTecnologo.isChecked()){
                                tipo = 1;
                            }else if(binding.rbCadastroBacharelado.isChecked()){
                                tipo = 2;
                            }else{
                                tipo = 3;
                            }

                            // criando o objeto da classe
                            Curso meuCurso = new Curso (nome, cargaHoraria, conceito, tipo);

                            // Adicionando o objeto da lista
                            // ...
                            Toast.makeText(getContext(), "Curso Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                            limpaCampos();
                        }else{
                            Toast.makeText(getContext(), "Erro: Informe o tipo.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        binding.etCadastroConceito.setError("Erro: Informe o conceito");
                        binding.etCadastroConceito.requestFocus();
                    }
                }else{
                    binding.etCadastroCargaHoraria.setError("Erro: Informe a carga horária.");
                    binding.etCadastroCargaHoraria.requestFocus();
                }
            }else{
                binding.etCadastroNome.setError("Erro: Informe o nome.");
                binding.etCadastroNome.requestFocus();
            }
            }
        });
        binding.bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            limpaCampos();
            }
        });
    }
    public void limpaCampos(){
        binding.etCadastroNome.setText("");
        binding.etCadastroCargaHoraria.setText("");
        binding.etCadastroConceito.setText("");
        binding.rbCadastroTipo.clearCheck();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}