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
 * Representa um ingresso para um evento.
 * Um ingresso possui informações sobre o evento, preço, assento e estado (ativo ou inativo).
 */
public class Ingresso {
    private Evento evento;
    private double preco;
    private String assento;
    private boolean ativo;

    /**
     * Constrói uma nova instância de Ingresso com as informações fornecidas.
     *
     * @param evento O evento associado ao ingresso.
     * @param preco O preço do ingresso.
     * @param assento O assento atribuído ao ingresso.
     */
    public Ingresso(Evento evento, double preco, String assento){
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        this.ativo = true;
    }

    /**
     * Verifica se o ingresso está ativo.
     *
     * @return true se o ingresso estiver ativo, false caso contrário.
     */
    public boolean isAtivo(){
        return ativo;
    }

    /**
     * Cancela o ingresso se a data do evento for após uma data específica.
     * Neste caso, a data é 8 de setembro de 2024.
     *
     * @return true se o cancelamento for bem-sucedido, false caso contrário.
     */
    public boolean cancelar(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 8);
        Date data = calendar.getTime();
        
        if (evento.getData().after(data)){
            ativo = false;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Reativa o ingresso, se estiver cancelado.
     *
     * @return true se a reativação for bem-sucedida, false se o ingresso já estiver ativo.
     */
    public boolean reativar(){
        if (ativo == false){
            ativo = true;
            return ativo;
        }
        else{
            return false;
        }

    }

    //Getters são declarados

    /**
     * Obtém o evento associado ao ingresso.
     *
     * @return O evento associado ao ingresso.
     */
    public Evento getEvento(){
        return evento;
    }

    /**
     * Obtém o preço do ingresso.
     *
     * @return O preço do ingresso.
     */
    public double getPreco(){
        return preco;
    }

    /**
     * Obtém o assento atribuído ao ingresso.
     *
     * @return O assento atribuído ao ingresso.
     */
    public String getAssento(){
        return assento;
    }

    /**
     * Compara este ingresso com outro objeto para verificar se são iguais.
     *
     * @param object O objeto com o qual comparar.
     * @return true se os dois objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object object){
        if (object == this){
            return true;
        }
        if (object.getClass() != this.getClass()){
            return false;
        }
        //Cria-se instância de objeto Ingresso a ser comparado
        Ingresso ingressoComparado = (Ingresso) object;
        //É feita a comparação entre cada atributo e retornado valor booleano da verificação
        //Os atributos preco e ativo são comparados de forma direta por serem de tipos primitivos (double, boolean)
        return Objects.equals(evento, ingressoComparado.evento) && Objects.equals(assento, ingressoComparado.assento) &&
        preco == ingressoComparado.preco && ativo == ingressoComparado.ativo;
    }

    /**
     * Gera um código hash para o ingresso com base em seus atributos.
     *
     * @return O código hash gerado.
     */
    @Override
    public int hashCode(){
        return Objects.hash(evento, preco, assento, ativo);
    }

}
