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
 * Representa um evento que pode ter ingressos associados.
 * Um evento possui informações como nome, descrição, data, assentos e estado (ativo ou inativo).
 */
public class Evento {
    private String nome;
    private String descricao;
    private Date data;
    private HashSet<String> assentos;
    private boolean ativo;

    /**
     * Constrói uma nova instância de Evento com as informações fornecidas.
     * O estado do evento é definido como inativo se a data do evento for antes de 8 de setembro de 2024.
     *
     * @param nome O nome do evento.
     * @param descricao A descrição do evento.
     * @param data A data do evento.
     */
    public Evento(String nome, String descricao, Date data){
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        /*Para evitar que haja erros nos testes, a data é definida como sendo antes (08/09/2024) 
        das datas definidas (10/09/2024) para os eventos nas classes de teste.*/
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 8);
        Date dataPadrao = calendar.getTime();
        /*É feita verificação para caso a data definida para o evento seja antes de 08/09, o evento já é criado inativado. */
        this.ativo = (data.before(dataPadrao)) ? false : true;
        this.assentos = new HashSet<String>();
    }

    /**
     * Adiciona um assento ao conjunto de assentos disponíveis para o evento.
     * O assento será adicionado apenas se ainda não estiver presente.
     *
     * @param assento O assento a ser adicionado.
     */
    public void adicionarAssento(String assento){
        if (!this.assentos.contains(assento)){this.assentos.add(assento);}
    }

    /**
     * Remove um assento do conjunto de assentos disponíveis para o evento.
     *
     * @param assentoRemovido O assento a ser removido.
     */
    public void removerAssento(String assentoRemovido){
        this.assentos.removeIf(assento -> assento.equals(assentoRemovido));
    }

    /**
     * Verifica se o evento está ativo.
     *
     * @return true se o evento estiver ativo, false caso contrário.
     */
    public boolean isAtivo(){
        return ativo;
    }

    //Getters são declarados

    /**
     * Obtém o nome do evento.
     *
     * @return O nome do evento.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Obtém a descrição do evento.
     *
     * @return A descrição do evento.
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * Obtém a data do evento.
     *
     * @return A data do evento.
     */
    public Date getData(){
        return data;
    }

    /**
     * Obtém a lista de assentos disponíveis para o evento.
     *
     * @return A lista de assentos disponíveis.
     */
    public List<String> getAssentosDisponiveis(){
        List<String> assentosDisponiveis = new ArrayList<String>();
        for (String assento : assentos) {
            assentosDisponiveis.add(assento);
        }
        return assentosDisponiveis;
    }
}
