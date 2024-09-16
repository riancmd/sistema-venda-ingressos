/*
Autor: Rian da Silva Santos
Matrícula: 23211315
Componente Curricular: EXA 863 - MI - Programação
ConcluÍdo em: 15/09/2024
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package vendaingressos;
import java.util.*;

/**
 * Controla a interação entre usuários e eventos.
 * A classe Controller permite cadastrar usuários e eventos, adicionar assentos a eventos,
 * buscar eventos, comprar ingressos, cancelar compras e listar eventos e ingressos.
 */
public class Controller {

    /** Lista de eventos gerenciados pelo controlador. */
    public ArrayList<Evento> eventos;

    /** Lista de usuários registrados no sistema. */
    public ArrayList<Usuario> usuarios;

    /**
     * Constrói uma nova instância de Controller.
     * Inicializa as listas de eventos e usuários.
     */
    public Controller(){
        this.eventos = new ArrayList<Evento>();
        this.usuarios = new ArrayList<Usuario>();
    }

    /**
     * Cadastra um novo usuário no sistema.
     *
     * @param user O login do usuário.
     * @param senha A senha do usuário.
     * @param nome O nome completo do usuário.
     * @param cpf O CPF do usuário.
     * @param email O e-mail do usuário.
     * @param admin Indica se o usuário deve ter privilégios de administrador.
     * @return O usuário cadastrado.
     */
    public Usuario cadastrarUsuario(String user, String senha, String nome, String cpf, String email, boolean admin){
        Usuario usuario = new Usuario(user, senha, nome, cpf, email, admin);
        usuarios.add(usuario);
        return usuario;
    }

    /**
     * Cadastra um novo evento no sistema, se o usuário for um administrador.
     *
     * @param user O usuário que está cadastrando o evento.
     * @param nome O nome do evento.
     * @param descricao A descrição do evento.
     * @param data A data do evento.
     * @return O evento cadastrado.
     * @throws SecurityException Se o usuário não for um administrador.
     */
    public Evento cadastrarEvento(Usuario user, String nome, String descricao, Date data){
        //O evento só pode ser cadastrado caso user.isAdmin() retorne valor verdadeiro.
        Evento evento = (user.isAdmin()) ? new Evento(nome, descricao, data) : null;
        if (evento != null) {eventos.add(evento); return evento;}
        else{throw new SecurityException("Somente administradores podem cadastrar eventos.");}
    }

    /**
     * Adiciona um assento a um evento existente.
     *
     * @param nomeEvento O nome do evento ao qual o assento será adicionado.
     * @param assento O assento a ser adicionado.
     */
    public void adicionarAssentoEvento(String nomeEvento, String assento){
        for (Evento evento : eventos){
            if (evento.getNome() == nomeEvento){evento.adicionarAssento(assento);}
        }
    }

    /**
     * Busca um evento pelo nome.
     *
     * @param nomeEvento O nome do evento a ser buscado.
     * @return O evento correspondente ao nome fornecido ou null se não encontrado.
     */
    public Evento buscarEvento(String nomeEvento){
        for (Evento evento : eventos){
            if (evento.getNome().equalsIgnoreCase(nomeEvento)){
                return evento;
            }
        }
        System.out.println("Nulo");
        return null;
    }

    /**
     * Permite a compra de um ingresso para um evento.
     *
     * @param usuario O usuário que está comprando o ingresso.
     * @param nomeEvento O nome do evento para o qual o ingresso será comprado.
     * @param assento O assento do ingresso.
     * @return O ingresso comprado.
     * @throws NullPointerException Se o evento não existir.
     */
    public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String assento){
        Evento esteEvento = buscarEvento(nomeEvento);

        if (esteEvento != null){
            Ingresso ingresso = new Ingresso(esteEvento, 0.0, assento);
            usuario.ingressos.add(ingresso);
            return ingresso;
        }else{
            throw new NullPointerException("Este evento não existe");
        }
    }

    /**
     * Cancela a compra de um ingresso.
     *
     * @param user O usuário que comprou o ingresso.
     * @param ingresso O ingresso a ser cancelado.
     * @return true se o cancelamento for bem-sucedido, false caso contrário.
     */
    public boolean cancelarCompra(Usuario user, Ingresso ingresso){
        user.ingressos.remove(ingresso);
        return ingresso.cancelar();
    }

    /**
     * Lista todos os eventos disponíveis.
     *
     * @return A lista de eventos disponíveis.
     */
    public List<Evento> listarEventosDisponiveis(){
        return eventos;
    }

    /**
     * Lista todos os ingressos comprados por um usuário.
     *
     * @param usuario O usuário cujos ingressos serão listados.
     * @return A lista de ingressos comprados pelo usuário.
     */
    public List<Ingresso> listarIngressosComprados(Usuario usuario){
        return usuario.getIngressos();
    }
}
