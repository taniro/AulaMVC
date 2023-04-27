package ufrn.br.aulamvc.repository;

import org.springframework.stereotype.Repository;
import ufrn.br.aulamvc.model.Post;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PostRepository {

    List<Post> posts = new ArrayList<>();

    public List<Post> listAll(){
        return posts;
    }

    public void save(Post p ){
        posts.add(p);
    }
}
