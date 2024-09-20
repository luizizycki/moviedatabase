package com.izycki.moviedatabase;

import com.izycki.moviedatabase.model.Database;
import com.izycki.moviedatabase.model.Database.*;
import com.izycki.moviedatabase.model.Usuario;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Database db = new Database();
        db.queryUsuarios();
        db.queryTipo_usuario();
        db.queryFilmes();

        //lista da query de usuarios
        List<Usuario> usuarios = db.queryUsuarios();
        int idprimeroUser = usuarios.get(0).getId();

        System.out.print("\nBem vindo ao sistema, o que você deseja fazer hoje?\n1 - Login\n2 - Cadastro\nDigite a sua opção: ");
        int login = scanner.nextInt();
        scanner.nextLine();

        if (login == 2){
            db.registrar();
        }
        if (login == 1){

            System.out.print("Digite seu nome de usuário: ");
            String usernameout = scanner.nextLine();


            //login no sistema
            int acesso = 0;
            int count = 0;
            for (Usuario usuario : usuarios) {
                count = count + 1;
                if(usuario.getUsername().equals(usernameout)){
                    System.out.print("Digite a sua senha:");
                    String senha = scanner.nextLine();
                    if(usuario.getSenha().equals(senha)){
                        System.out.println("Acesso garantido ao sistema!");
                        if(usuario.getTipo_user_id() == 2){
                            acesso = 2;
                        }else {
                            acesso = 1;
                        }
                    }else{
                        System.out.println("A senha digitada está incorreta. Por favor, verifique e tente novamente.");
                    }
                } else if(count == usuarios.size()){
                    System.out.println("O nome de usuário fornecido não foi encontrado. Verifique se você digitou o nome corretamente e tente novamente.");
                }
            }
            if (acesso == 2){
                System.out.printf("\n\nBem vindo %s, o que gostaria de fazer hoje?", usernameout);
                int opcao = 0;
                while (opcao != 5){

                    System.out.printf("\n1 - Inserir um novo filme;\n2 - Listar os filmes cadastrados;\n3 - Modificar um filme cadastrado;\n4 - Sair;\nDigite a sua opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao){
                        case 1: db.inserir();
                            break;
                        case 2: System.out.println(db.queryFilmes());
                            break;
                        case 3: db.modificar();
                            break;
                    }
                }

            }
            if(acesso == 1){

                System.out.printf("\n\nBem vindo %s, o que gostaria de fazer hoje?\n", usernameout);
                int opcao = 0;
                while (opcao != 8){
                    System.out.println("------------Painel de Administrador------------");
                    System.out.printf("\n1 - Inserir um novo filme;\n2 - Listar os filmes cadastrados;\n3 - Modificar um filme cadastrado;\n4 - Excluir um filme;\n5 - Registrar um usuário;\n6 - Modificar um usuário;\n7 - Excluir um usuário\n8 - Sair;\nDigite a sua opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao){
                        case 1: db.inserir();
                            break;
                        case 2: System.out.println(db.queryFilmes());
                            break;
                        case 3: db.modificar();
                            break;
                        case 4: db.excluir();
                            break;
                        case 5: db.registrar();
                            break;
                        case 6: db.modificarUser();
                            break;
                        case 7:; db.excluirUser();
                    }
                }
            }

        }
        System.out.println("Obrigado por usar o sistema!\n");
    }
}
