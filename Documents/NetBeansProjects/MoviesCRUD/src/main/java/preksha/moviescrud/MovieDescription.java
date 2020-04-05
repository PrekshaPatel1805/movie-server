/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preksha.moviescrud;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import preksha.moviescrud.entities.AssignmentMovie;
import preksha.moviescrud.exceptions.NonexistentEntityException;

/**
 *
 * @author Preksha
 */
@WebService(serviceName = "MovieDescription")
public class MovieDescription {
    public AssignmentMovie searchRecord(int id) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("my_persistence_unit");
        AssignmentMovieJpaController movieRepo = new AssignmentMovieJpaController(enf);
        AssignmentMovie movies = movieRepo.findAssignmentMovie(id);

        return movies;
    }
    public int insertRecord(int id, String title, String director, String category, byte[] poster) {
        poster = "default_image.png".getBytes();
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("my_persistence_unit");
        AssignmentMovieJpaController movieRepo = new AssignmentMovieJpaController(enf);
        AssignmentMovie movies = new AssignmentMovie();
        movies.setId(id);
        movies.setTitle(title);
        movies.setDirector(director);
        movies.setCategory(category);
        movies.setPoster(poster);
        try {
            movieRepo.create(movies);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public int updateRecord(int id, String title, String director, String category, byte[] poster) throws Exception {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("my_persistence_unit");
        AssignmentMovieJpaController movieRepo = new AssignmentMovieJpaController(enf);
        AssignmentMovie movies = new AssignmentMovie();
        poster = "default_image.png".getBytes();
        movies.setId(id);
        movies.setId(id);
        movies.setTitle(title);
        movies.setDirector(director);
        movies.setCategory(category);
        movies.setPoster(poster);
        try {
            movieRepo.edit(movies);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public List<AssignmentMovie> getAllRecords() {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("my_persistence_unit");
        AssignmentMovieJpaController movieRepo = new AssignmentMovieJpaController(enf);
        List<AssignmentMovie> movies = movieRepo.findAssignmentMovieEntities();
        return movies;
    }
    
    public int deleteRecord(int id) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("my_persistence_unit");
        AssignmentMovieJpaController movieRepo = new AssignmentMovieJpaController(enf);
        try {
            movieRepo.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
