package com.izycki.moviedatabase.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private static final String url =
        "jdbc:mysql://localhost:3306/moviedatabase";
    private static final String user = "usuario";
    private static final String password = "senha123";

    //                             //
    //MÉTODOS QUE GERENCIAM OS FILMES
    //                             //

    public void inserir(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o diretor do filme: ");
        String diretor = scanner.nextLine();
        System.out.print("Digite o ano de lançamento do filme: ");
        int ano = scanner.nextInt();

        try{
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );


            String update = String.format("INSERT INTO filmes (titulo, ano, diretor) VALUES ('%s', %d, '%s');", titulo, ano, diretor);

            //serve para mandar comandos SQL para o banco de dados.
            Statement statement = connection.createStatement();
            int resultado = statement.executeUpdate(update);

            System.out.print("\nFilme inserido com sucesso!\n");
        } catch (SQLException e){
            System.out.println("Ocorreu um erro ao tentar inserir o filme, certifique-se que os detalhes estão corretos.");
            e.printStackTrace();
        }
    }


    public void modificar(){
        Scanner scanner = new Scanner(System.in);
        String update = "";

        //vai printar os filmes, e pedir o id do filme para modificar
        System.out.println(queryFilmes());
        System.out.print("Digite o id do filme que você deseja modificar: ");
        int idFilme = scanner.nextInt();
        scanner.nextLine();

        System.out.print("1 - Título;\n2 - Ano de lançamento;\n3 - Diretor;\nDigite o que você quer modificar: ");
        int mod = scanner.nextInt();
        scanner.nextLine(); //pra não dar problema com nextLine

        if(mod == 1){
            System.out.println("Digite o novo Título: ");
            String titulo = scanner.nextLine();
            update = String.format("UPDATE filmes SET titulo = \"%s\" WHERE id = %d;", titulo, idFilme);
        }
        if(mod == 2){
            System.out.println("Digite o novo ano de lançamento: ");
            int ano = scanner.nextInt();
            scanner.nextLine();
            update = String.format("UPDATE filmes SET ano = %d WHERE id = %d;", ano, idFilme);
        }
        if(mod == 3){
            System.out.println("Digite o novo Diretor: ");
            String diretor = scanner.nextLine();
            update = String.format("UPDATE filmes SET diretor = \"%s\" WHERE id = %d;", diretor, idFilme);
        }

        try{
            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //mandar comando pro banco de dados
            Statement statement = connection.createStatement();
            int resultado = statement.executeUpdate(update);


        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao modificar registro, por favor, tente novamente");
        }


    }

    public void excluir(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(queryFilmes());
        System.out.println("Digite o id do filme que você deseja excluir: ");
        int idFilme = scanner.nextInt();
        scanner.nextLine();

        String sql = String.format("DELETE FROM filmes WHERE id = %d", idFilme);


        try{
            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //mandar comando pro banco de dados
            Statement statement = connection.createStatement();
            int resultado = statement.executeUpdate(sql);


        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao excluir registro, por favor, tente novamente");
        }
    }

    //                              //
    //FIM MÉTODOS QUE GERENCIAM FILMES
    //                              //


    //                               //
    //MÉTODOS QUE GERENCIAM OS USUÁRIOS
    //                               //

    public void registrar(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        String update = String.format("INSERT INTO usuarios (username, senha, tipo_user_id) VALUES ('%s', '%s', %d);", username, senha , 1);

        try{
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );


            //serve para mandar comandos SQL para o banco de dados.
            Statement statement = connection.createStatement();
            int resultado = statement.executeUpdate(update);

            System.out.print("\nUsuário registrado com sucesso!\n");
        } catch (SQLException e){
            System.out.println("Ocorreu um erro ao tentar registrar, certifique-se que os detalhes estão corretos.");
            e.printStackTrace();
        }

    }

    public void modificarUser(){
        Scanner scanner = new Scanner(System.in);
        String update = "";

        System.out.println(queryUsuarios());
        System.out.println("Digite o id do usuário que você quer modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o que você quer modificar: ");
        System.out.print("1 - Username\n2 - Senha\n3 - Tipo do usuário\n");
        int opcao = scanner.nextInt();
        scanner.nextLine();


        if(opcao == 1){
            System.out.println("Digite o novo username: ");
            String username = scanner.nextLine();
            update = String.format("UPDATE usuarios SET username = \"%s\" WHERE id = %d;", username, id);
        }
        if(opcao == 2){
            System.out.println("Digite a nova senha: ");
            String senha = scanner.nextLine();
            update = String.format("UPDATE usuarios SET senha = \"%s\" WHERE id = %d;", senha, id);
        }
        if(opcao == 3){
            System.out.println("Digite o tipo do usuário do usuário(1 - Administrador, 2 - Usuários comum): ");
            int tipo_user_id = scanner.nextInt();
            update = String.format("UPDATE usuarios SET tipo_user_id = %d WHERE id = %d;", tipo_user_id, id);
        }

        try {
            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //Executando a query no banco de dados
            Statement statement = connection.createStatement();
            int resultado = statement.executeUpdate(update);

            System.out.print("\nModificação feita com sucesso!\n");

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao modificar o usuário, por favor, tente novamente.");
        }
    }

    public void excluirUser(){

        Scanner scanner = new Scanner(System.in);

        System.out.println(queryUsuarios());
        System.out.println("Digite o id do usuário que você quer excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = String.format("DELETE FROM usuarios WHERE id = %d;", id);

        try {
            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //Executando a query no banco de dados
            Statement statement = connection.createStatement();
            int resultado = statement.executeUpdate(sql);

            System.out.print("\nUsuário excluido com sucesso!\n");

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao excluir o usuário, por favor, tente novamente.");
        }

    }

    //                                //
    //FIM MÉTODOS QUE GERENCIAM USUÁRIOS
    //                                //


    //               //
    //MÉTODOS DE QUERY
    //               //

    public List<Filme> queryFilmes() {

        List<Filme> filmes = new ArrayList<>();

        try {

            String query = "SELECT * FROM filmes";

            //criar a array list de objetos Filme

            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //serve para mandar comandos SQL para o banco de dados.
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            //criação dos objetos Filme
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int ano = resultSet.getInt("ano");
                String titulo = resultSet.getString("titulo");
                String diretor = resultSet.getString("diretor");

                Filme filme = new Filme(id, titulo, diretor, ano);
                filmes.add(filme);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }

    public List<Usuario> queryUsuarios(){

        List<Usuario> usuarios = new ArrayList<>();
        try {

            //pegar os usuários do db
            String query = "SELECT * FROM usuarios";


            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //Executando a query no banco de dados
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                int tipo_user_id = resultSet.getInt("tipo_user_id");
                String senha = resultSet.getString("senha");

                Usuario usuario = new Usuario(id, username, senha, tipo_user_id);
                usuarios.add(usuario);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    public List<tipo_usuario> queryTipo_usuario(){

        List<tipo_usuario> tipo_usuario = new ArrayList<>();
        try {

            //pegar os tipos de usuário do db
            String query = "SELECT * FROM tipo_usuario";


            //estabelecendo conexão:
            Connection connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            //Executando a query no banco de dados
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                String descricao = resultSet.getString("descricao");

                tipo_usuario tipos = new tipo_usuario(id, tipo, descricao);
                tipo_usuario.add(tipos);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tipo_usuario;
    }














}
