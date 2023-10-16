package resources;

import entity.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.BookService;

import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResources {
    private final BookService bookService;

    public BookResources(BookService bookService){
        this.bookService = bookService;
    }

    @GET
    public Response findAll(){
        List<Book> books = bookService.findAll();
        return Response.ok(books).build();
    }

    @GET
    @Path("/author/{authorName}")
    public Response findAllByAuthorName(@PathParam("authorName")String authorName){
        List<Book> books = bookService.findAllByAuthorName(authorName);
        return Response.ok(books).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")Long id){
        Book book = bookService.findById(id);
        return Response.ok(book).build();
    }

    @POST
    public Response add(Book book){
        Book addedBook = bookService.add(book);
        return Response.ok(addedBook).status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id")Long id){
        String isDeleted = bookService.deleteById(id);
        return Response.ok(isDeleted).status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id")Long id, Book book){
        Book bookToUpdate = bookService.update(id, book);
        return Response.ok(bookToUpdate).status(Response.Status.ACCEPTED).build();
    }
}
