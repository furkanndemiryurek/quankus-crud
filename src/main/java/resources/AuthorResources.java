package resources;

import entity.Author;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.AuthorService;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResources {

    private final AuthorService authorService;

    public AuthorResources(AuthorService authorService){
        this.authorService = authorService;
    }

    @GET
    public Response findAll(){
        List<Author> authors = authorService.findAll();
        return Response.ok(authors).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        Author author = authorService.findById(id);
        return Response.ok(author).build();
    }

    @POST
    public Response add(Author author){
        Author addedAuthor = authorService.add(author);
        return Response.ok(addedAuthor).status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id")Long id){
        String isDeleted = authorService.deleteById(id);
        return Response.ok(isDeleted).status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id")Long id, Author author){
        Author authorToUpdate = authorService.update(id, author);
        return Response.ok(authorToUpdate).status(Response.Status.ACCEPTED).build();
    }
}
