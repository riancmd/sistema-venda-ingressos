/*
Autor: Rian da Silva Santos
Matrícula: 23211315
Componente Curricular: EXA 863 - MI - Programação
ConcluÍdo em: 16/09/2024
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package vendaingressos;
import java.util.*;

/**
 * Representa um usuário do sistema de ingressos.
 * Um usuário possui informações de login, credenciais e ingressos associados.
 */
public class Usuario{
    private String login;
    private String senha;
    private String nome;
    private String CPF;
    private String email;
    private boolean admin;
    public ArrayList<Ingresso> ingressos;

    /**
     * Constrói uma nova instância de Usuario com as informações fornecidas.
     *
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @param nome O nome completo do usuário.
     * @param CPF O CPF do usuário.
     * @param email O e-mail do usuário.
     * @param admin Indica se o usuário possui privilégios de administrador.
     */
    public Usuario(String login, String senha, String nome, String CPF, String email, boolean admin){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.admin = admin;

        this.ingressos = new ArrayList<Ingresso>();
    }

    /**
     * Verifica se o usuário é um administrador.
     *
     * @return true se o usuário for um administrador, false caso contrário.
     */
    public boolean isAdmin(){
        return admin;
    }

    /**
     * Tenta realizar o login do usuário com as credenciais fornecidas.
     *
     * @param login O login fornecido para autenticação.
     * @param senha A senha fornecida para autenticação.
     * @return true se o login for bem-sucedido, false caso contrário.
     */
    public boolean login(String login, String senha){
        boolean succesfulLogin = (this.login == login && this.senha == senha) ? true : false;
        return succesfulLogin;
    }

    //Setters são declarados

    /**
     * Define o nome do usuário.
     *
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A nova senha do usuário.
     */
    public void setSenha(String senha){
        this.senha = senha;
    }

    /**
     * Define o CPF do usuário.
     *
     * @param CPF O novo CPF do usuário.
     */
    public void setCpf(String CPF){
        this.CPF = CPF;
    }

    /**
     * Define o e-mail do usuário.
     *
     * @param email O novo e-mail do usuário.
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    //Getters são declarados

    /**
     * Obtém o login do usuário.
     *
     * @return O login do usuário.
     */
    public String getLogin(){
        return login;
    }

     /**
     * Obtém o nome do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Obtém o CPF do usuário.
     *
     * @return O CPF do usuário.
     */
    public String getCpf(){
        return CPF;
    }

    /**
     * Obtém o e-mail do usuário.
     *
     * @return O e-mail do usuário.
     */
    public String getEmail(){
        return email;
    }

    /**
     * Obtém a lista de ingressos associados ao usuário.
     *
     * @return A lista de ingressos do usuário.
     */
    public List<Ingresso> getIngressos(){
        return ingressos;
    }
    
    /**
     * Compara este usuário com outro objeto para verificar se são iguais.
     *
     * @param object O objeto com o qual comparar.
     * @return true se os dois objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object object){
        //Verifica se object é ele mesmo
        if (object == this){
            return true;
        }
        //Verifica se object é da mesma classe que o objeto atual
        if (object.getClass() != this.getClass()){
            return false;
        }
        //Cria-se instância de objeto Usuario a ser comparado
        Usuario usuarioComparado = (Usuario) object;
        //É feita a comparação entre cada atributo e retornado valor booleano da verificação
        //O atributo admin é comparado de forma direta por ser um tipo primitivo
        return Objects.equals(login, usuarioComparado.login) && Objects.equals(nome, usuarioComparado.nome) 
        && Objects.equals(CPF, usuarioComparado.CPF) && Objects.equals(email, usuarioComparado.email) 
        && admin == usuarioComparado.admin && Objects.equals(ingressos, usuarioComparado.ingressos);
    }

    /**
     * Gera um código hash para o usuário com base em seus atributos.
     *
     * @return O código hash gerado.
     */
    @Override
    public int hashCode(){
        return Objects.hash(login, senha, nome, CPF, email, admin);
    }
}