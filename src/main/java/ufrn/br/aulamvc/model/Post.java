package ufrn.br.aulamvc.model;

public class Post {
    Integer id;
    String mensagem;
    String autor;

    public Post() {
    }

    public Post(String mensagem, String autor) {
        this.mensagem = mensagem;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", mensagem='" + mensagem + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
